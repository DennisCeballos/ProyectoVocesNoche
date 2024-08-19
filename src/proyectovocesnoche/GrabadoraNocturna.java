package proyectovocesnoche;

import java.io.ByteArrayInputStream;
import javax.sound.sampled.*;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

/**
 * @author daceb
 */
public class GrabadoraNocturna extends Thread {

    private GrabadoraStateListener changeListener;

    private TargetDataLine microphone;
    private boolean corriendo;
    private boolean escuchando;
    private boolean grabando;

    private double volumen = 0.0;
    private double threshold = 50.0; //Default cualquiera
    private final AudioFormat format;

    private ArrayList<ByteArrayOutputStream> listaOuts;
    private ArrayList<String> listaNombreOuts;

    private long lastAboveThresholdTime;
    private final SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss");

    private String pathFile;

    public GrabadoraNocturna() {
        pathFile = "./audios/";

        format = new AudioFormat(44100.0f, 16, 1, true, true);

        listaOuts = new ArrayList();
        listaNombreOuts = new ArrayList<>();
    }

    //
    //Setters y getters
    //
    public void setChangeListener(GrabadoraStateListener listener) {
        this.changeListener = listener;
    }

    public void setThreshold(double limite) {
        this.threshold = limite;
    }

    public void setPathFile(String _path) {
        //Por motivos de seguridad, en caso que se ingrese un path vacio,
        // se genera un . como path
        if (_path.trim().equals("")) {
            this.pathFile = "./";
        } else {
            this.pathFile = _path;
        }
    }

    //Funciones para usar la clase desde afuera
    public void iniciarMonitoreoMicrofono() {
        corriendo = true;
        cambiarEstado("Inicio de monitoreo de microfono");
        this.start();
    }

    public void iniciarNoche() {
        escuchando = true;
        cambiarEstado("NOCHE INICIADA");
    }

    // Detener la noche y guardar en archivo todos los buffer
    public void detenerNoche() {
        escuchando = false;
        cambiarEstado("NOCHE DETENIDA");

        //Crear la carpeta de archivos para almacenar los audios (de ser necesario)
        File directory = new File(pathFile);
        if (!directory.exists()) {
            directory.mkdirs();
        }

        System.out.println("Guardando la info de " + listaOuts.size() + " audios...");

        ByteArrayOutputStream outStream;
        
        for (int i = 0; i < listaOuts.size(); i++) {
            try {
                outStream = listaOuts.get(i);
                ByteArrayInputStream bais = new ByteArrayInputStream(outStream.toByteArray());
                AudioInputStream audioInputStream = new AudioInputStream(bais, format, outStream.size() / format.getFrameSize());

                File outputFile = new File(pathFile + listaNombreOuts.get(i) + ".wav");
                AudioSystem.write(audioInputStream, AudioFileFormat.Type.WAVE, outputFile);

            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        System.out.println("...Audios grabados satisfactoriamente");
    }

    @Override
    public void run() {
        //Iniciar variables esenciales para el _main loop_
        DataLine.Info info = new DataLine.Info(TargetDataLine.class, format);

        long currentTime;
        int nroGrabacion = 0;

        if (!AudioSystem.isLineSupported(info)) {
            System.out.println("Line not supported..");
            return;
        }

        //Parte del loop y gestion de microfono
        try {
            microphone = (TargetDataLine) AudioSystem.getLine(info);
            microphone.open(format);
            microphone.start();

            byte[] buffer = new byte[4096];
            int bytesRead;

            //Bucle de monitoreo
            while (corriendo) {
                // Read audio from the AudioLine (microphone)
                bytesRead = microphone.read(buffer, 0, buffer.length);

                // Calculate the RMS (Root Mean Square) to determine volume level
                double peakAmplitude = calculatePeakAmplitude(buffer, bytesRead);
                volumen = 20 * Math.log10(peakAmplitude);
                volumen = 100.00 + volumen;
                changeListener.cambioVolumen(volumen);

                // Obtener el tiempo actual
                currentTime = System.currentTimeMillis();

                if (!escuchando) {
                    //Si es que no se ha iniciado "la noche" entonces
                    //que se salte todo lo siguiente
                    continue;
                }

                // Grabar en buffer de audio en caso se este grabando
                if (grabando) {
                    listaOuts.get(nroGrabacion).write(buffer, 0, bytesRead);
                }

                // Determinar si iniciar/detener la grabacion
                if (volumen > threshold) { //Si se detecta ruido
                    if (!grabando) {
                        // Si no se esta grabando, iniciar la grabacion
                        grabando = true;
                        cambiarEstado("Iniciando grabacion nro " + nroGrabacion + "...");

                        // Generar un nuevo buffer para audio
                        listaOuts.add(new ByteArrayOutputStream());
                        // Generar nombre de archivo y guardarlo en la lista
                        String nombre = sdf.format(new Date(System.currentTimeMillis())).replace(':', '_');
                        listaNombreOuts.add(nombre);
                    }
                    // Guardar el ultimo momento de grabacion
                    lastAboveThresholdTime = currentTime;

                    //Si ha pasado mas de 5 segundos sin ruido, detener la grabacion
                } else if (grabando && currentTime - lastAboveThresholdTime >= 5000) {
                    grabando = false;
                    cambiarEstado("Deteniendo grabacion...");

                    //Aumenta en 1 el indice de la grabacion actual
                    nroGrabacion += 1;
                }

            }
        } catch (LineUnavailableException e) {
            e.printStackTrace();
        } finally {
            microphone.stop();
            microphone.close();
        }
    }

    // Peak Amplitude Calculation
    private double calculatePeakAmplitude(byte[] audioData, int length) {
        int maxAmplitude = 0;

        for (int i = 0; i < length; i += 2) {  // Assuming 16-bit samples
            int value = (audioData[i] << 8) | (audioData[i + 1] & 0xFF);
            if (Math.abs(value) > maxAmplitude) {
                maxAmplitude = Math.abs(value);
            }
        }

        double peakAmplitude = maxAmplitude / 32768.0; // Normalizing to a range of 0 to 1
        return peakAmplitude;
    }

    private void cambiarEstado(String msg) {
        String pre = sdf.format(new Date(System.currentTimeMillis())) + " - ";
        changeListener.cambioEstado(pre + msg);
    }
}
