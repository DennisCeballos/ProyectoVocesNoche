package proyectovocesnoche;

import javax.swing.Timer;

/**
 * @author daceb
 */
public class FrameGrabadora extends javax.swing.JFrame implements GrabadoraStateListener {
    
    private GrabadoraNocturna grabadoraNocturna;
    private Timer timer;
    /**
     * Creates new form FrameGrabadora
     */
    public FrameGrabadora() {
        initComponents();
        
        grabadoraNocturna = new GrabadoraNocturna();
        grabadoraNocturna.setChangeListener(this);
        grabadoraNocturna.iniciarMonitoreoMicrofono();
    }
    
    @Override
    public void cambioVolumen(double volumen) {
        jLabel_Volumen.setText(String.format("%.2f", volumen));
    }

    @Override
    public void cambioEstado(String state){
        jTextArea_Log.append("\n" + state);
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel_TituloVolumen = new javax.swing.JLabel();
        jLabel_Volumen = new javax.swing.JLabel();
        jButton_IniciarNoche = new javax.swing.JButton();
        jButton_DetenerNoche = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jLabel_Log = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jTextField_DireccionArchivos = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTextArea_Log = new javax.swing.JTextArea();
        jLabel_TituloThreshold = new javax.swing.JLabel();
        jTextField_Threshold = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Grabadora");
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                detenerMicrofono(evt);
            }
        });

        jLabel_TituloVolumen.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel_TituloVolumen.setText("Nivel de Volumen");

        jLabel_Volumen.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel_Volumen.setText("-volumen-");
        jLabel_Volumen.setToolTipText("");

        jButton_IniciarNoche.setText("Iniciar Noche");
        jButton_IniciarNoche.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_IniciarNocheActionPerformed(evt);
            }
        });

        jButton_DetenerNoche.setText("Detener Noche");
        jButton_DetenerNoche.setEnabled(false);
        jButton_DetenerNoche.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_DetenerNocheActionPerformed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Malgun Gothic", 1, 18)); // NOI18N
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("Grabadora Nocturna");

        jLabel_Log.setText("Log:");

        jLabel1.setText("Direccion Archivos:");

        jTextField_DireccionArchivos.setText("./audios/");

        jTextArea_Log.setColumns(20);
        jTextArea_Log.setRows(5);
        jScrollPane1.setViewportView(jTextArea_Log);

        jLabel_TituloThreshold.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel_TituloThreshold.setText("Threshold Volumen");

        jTextField_Threshold.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextField_Threshold.setText("50");
        jTextField_Threshold.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField_ThresholdActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addGap(51, 51, 51)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel_Log, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jButton_DetenerNoche, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jButton_IniciarNoche, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addGap(38, 38, 38)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(layout.createSequentialGroup()
                                                .addComponent(jLabel_TituloThreshold, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addGap(18, 18, 18))
                                            .addGroup(layout.createSequentialGroup()
                                                .addGap(33, 33, 33)
                                                .addComponent(jTextField_Threshold, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 44, Short.MAX_VALUE)))
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(jLabel_TituloVolumen, javax.swing.GroupLayout.DEFAULT_SIZE, 130, Short.MAX_VALUE)
                                            .addComponent(jLabel_Volumen, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                                    .addComponent(jTextField_DireccionArchivos))))
                        .addGap(50, 50, 50))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(35, 35, 35)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton_IniciarNoche, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel_TituloVolumen, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel_TituloThreshold, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jButton_DetenerNoche, javax.swing.GroupLayout.DEFAULT_SIZE, 50, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel_Volumen, javax.swing.GroupLayout.DEFAULT_SIZE, 50, Short.MAX_VALUE)
                        .addComponent(jTextField_Threshold, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField_DireccionArchivos, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel_Log, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(115, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void detenerMicrofono(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_detenerMicrofono
        // TODO add your handling code here:
        
    }//GEN-LAST:event_detenerMicrofono

    private void jButton_IniciarNocheActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_IniciarNocheActionPerformed
        //Revisar los datos del formulario
        double inputNivel;
        try {
            inputNivel = Double.parseDouble( jTextField_Threshold.getText());
            grabadoraNocturna.setThreshold(inputNivel);
        } catch (NumberFormatException e) {
            jTextArea_Log.append("\n" + "ERROR: TIPO DE DATO INCORRECTO Threshold");
            return;
        }
        //Todo? ponerle verificacion?
        grabadoraNocturna.setPathFile( jTextField_DireccionArchivos.getText() );
        
        //Iniciar la noche para la clase
        grabadoraNocturna.iniciarNoche();
        
        jButton_IniciarNoche.setEnabled(false);
        jTextField_DireccionArchivos.setEnabled(false);
        jTextField_Threshold.setEnabled(false);
        jButton_DetenerNoche.setEnabled(true);
    }//GEN-LAST:event_jButton_IniciarNocheActionPerformed

    private void jButton_DetenerNocheActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_DetenerNocheActionPerformed
        grabadoraNocturna.detenerNoche();
        
        jButton_IniciarNoche.setEnabled(true);
        jTextField_DireccionArchivos.setEnabled(true);
        jTextField_Threshold.setEnabled(true);
        jButton_DetenerNoche.setEnabled(true);
    }//GEN-LAST:event_jButton_DetenerNocheActionPerformed

    private void jTextField_ThresholdActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField_ThresholdActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField_ThresholdActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(FrameGrabadora.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FrameGrabadora.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FrameGrabadora.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FrameGrabadora.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FrameGrabadora().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton_DetenerNoche;
    private javax.swing.JButton jButton_IniciarNoche;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel_Log;
    private javax.swing.JLabel jLabel_TituloThreshold;
    private javax.swing.JLabel jLabel_TituloVolumen;
    private javax.swing.JLabel jLabel_Volumen;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextArea jTextArea_Log;
    private javax.swing.JTextField jTextField_DireccionArchivos;
    private javax.swing.JTextField jTextField_Threshold;
    // End of variables declaration//GEN-END:variables
}