package proyectovocesnoche;

import java.io.File;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;
import javax.sound.sampled.*;

/**
 *
 * @author daceb
 */
public class ProyectoVocesNoche {

    private static volatile boolean running = true;

    public static void main(String[] args) {
        
        File directory = new File("/hola/hola2");
        
        System.out.println(directory);

        if (!directory.exists()) {
            if (directory.mkdirs()) {
                System.out.println("Directory created successfully.");
            } else {
                System.out.println("Failed to create directory.");
            }
        } else {
            System.out.println("Directory already exists.");
        }
        // Base de codigo cooperado con chat-gpt
        /*
        // Iniciar hilo que esperara la entrada de texto constantemente
        new Thread(() -> {
            // Lectura de entrada de texto, esperando la tecla "q"
            Scanner scanner = new Scanner(System.in);
            while (running) {
                String input = scanner.nextLine();
                if (input.equalsIgnoreCase("q")) {
                    running = false;
                }
            }
            scanner.close();
        }).start(); //Inicia el hilo

        try {
            // Definir el formato del audio de entrada
            AudioFormat format = new AudioFormat(44100, 16, 1, true, true);
            DataLine.Info info = new DataLine.Info(TargetDataLine.class, format);

            // Comprobar que se pueda usar la entrada de audio
            if (!AudioSystem.isLineSupported(info)) {
                System.out.println("Line not supported");
                return;
            }

            // Asignar el microfono como entrada de audio(?)
            TargetDataLine line = (TargetDataLine) AudioSystem.getLine(info);
            line.open(format);
            line.start();

            byte[] buffer = new byte[1024];
            int bytesRead;

            while (running) {
                // Para siempre, leer la entrada del microfono a un buffer
                bytesRead = line.read(buffer, 0, buffer.length);

                // Calcular RMS de la entrada de audio (Root Mean Square) (?)
                double rms = 0.0;
                for (int i = 0; i < bytesRead; i += 2) {
                    int sample = buffer[i] | (buffer[i + 1] << 8);
                    rms += sample * sample;
                }
                rms = Math.sqrt(rms / (bytesRead / 2));

                // Convertir la medida RMS en decibeles
                double db = 20 * Math.log10(rms);

                // Imprimir el nivel del audio
                System.out.println("probandoVolume: " + db + " dB");
            }

            // Cerrar la linea de entrada
            line.stop();
            line.close();
        } catch (LineUnavailableException ex) {
            ex.printStackTrace();
        }
        System.out.println("Program terminated.");
        */
    }

}
