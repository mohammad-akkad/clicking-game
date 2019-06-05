/*
 Muhammed Akkad
 13060160209
 */
package ClickingGame;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Polygon;
import java.awt.Shape;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Path2D;
import java.awt.geom.Point2D;
import java.awt.geom.Rectangle2D;
import java.io.IOException;
import static java.lang.Integer.parseInt;
import java.net.*;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 *
 * @author Muhammed
 */
public class ClientPanel extends javax.swing.JFrame implements FrameBehavior {

    public String myTakmaAd;
    private static InetAddress host;
    public Client server = null;
    private String score = "0";
    JTextField jTextField1 = new javax.swing.JTextField();
    // Her bir istemci için konuştuğu
    // Taraf sunucu olduğu için 
    // istemcide tek bir client nesnesi tutulur.    

    /**
     * Creates new form ClientPanel
     */
    public ClientPanel() {
        initComponents();

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jFrame1 = new javax.swing.JFrame();
        jLabel2 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
        jScrollPane3 = new javax.swing.JScrollPane();
        jTextPane1 = new javax.swing.JTextPane();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTextArea2 = new javax.swing.JTextArea();
        txtTakmaAd = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jButton2 = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();

        javax.swing.GroupLayout jFrame1Layout = new javax.swing.GroupLayout(jFrame1.getContentPane());
        jFrame1.getContentPane().setLayout(jFrame1Layout);
        jFrame1Layout.setHorizontalGroup(
            jFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        jFrame1Layout.setVerticalGroup(
            jFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jTextArea1.setEditable(false);
        jTextArea1.setColumns(20);
        jTextArea1.setRows(5);
        jScrollPane1.setViewportView(jTextArea1);

        jTextPane1.setEditable(false);
        jScrollPane3.setViewportView(jTextPane1);

        jTextArea2.setColumns(20);
        jTextArea2.setRows(5);
        jScrollPane2.setViewportView(jTextArea2);

        txtTakmaAd.setName(""); // NOI18N
        txtTakmaAd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtTakmaAdActionPerformed(evt);
            }
        });

        jLabel3.setText("Takma Adım:");

        jButton2.setText("send");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton1.setText("Connect");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(35, 35, 35)
                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(32, 32, 32)
                        .addComponent(txtTakmaAd, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButton1))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 323, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 323, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 25, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 273, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton2))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtTakmaAd, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton1))
                .addGap(45, 45, 45)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 268, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 268, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton2))
                .addContainerGap(87, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel2))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(13, 13, 13)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(340, 340, 340)
                        .addComponent(jLabel2)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtTakmaAdActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtTakmaAdActionPerformed

    }//GEN-LAST:event_txtTakmaAdActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        String message = jTextArea2.getText();
        server.myOutputMessages.add("Message:" + message);
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        init();
        txtTakmaAd.setEditable(false);
        jButton1.setEnabled(false);
        String TakmaAd = txtTakmaAd.getText();
        server.myOutputMessages.add("Start:Takma:" + TakmaAd + ":" + "Time:" + System.currentTimeMillis());
    }//GEN-LAST:event_jButton1ActionPerformed

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
            java.util.logging.Logger.getLogger(ClientPanel.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ClientPanel.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ClientPanel.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ClientPanel.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ClientPanel().setVisible(true);

            }
        });

    }

    /**
     * @param msg the message comming from server
     * @param sender the sender object
     */
    @Override
    public void makeAction(String msg, Client sender) {
        String[] protocolMsg = msg.split(":");

        if ("Players".equals(protocolMsg[0])) {
            printPlayers(msg);
        }
        if ("Message".equals(protocolMsg[0])) {
            printMessages(protocolMsg);
        }
        if ("Begin".equals(protocolMsg[0])) {
            server.myOutputMessages.add("Time:" + System.currentTimeMillis());
            initGameComponents(protocolMsg);
        }
        if ("Continue".equals(protocolMsg[0])) {

            initGameComponents(protocolMsg);
        }
        if ("update".equals(protocolMsg[0])) {

            this.score = protocolMsg[1];
            jTextField1.setText(score);

        }
        if ("finish".equals(protocolMsg[0])) {
            finishGame(protocolMsg[1], protocolMsg[2]);
        }
        repaint();
    }

    /**
     * make changes on the GUI to declare the winner
     *
     * @param winnerName
     * @param winnerScore
     */
    public void finishGame(String winnerName, String winnerScore) {
        jPanel2.removeAll();
        JLabel jLabel1 = new javax.swing.JLabel();
        jLabel1.setText("winner is:" + winnerName + " and the score is " + winnerScore);

        jPanel2.setLayout(new BoxLayout(jPanel2, BoxLayout.Y_AXIS));
        jPanel2.setPreferredSize(new Dimension(500, 500));
        jPanel2.add(Box.createRigidArea(new Dimension(0, 250)));
        jPanel2.add(jLabel1);
        jLabel1.setAlignmentX(Component.CENTER_ALIGNMENT);
        jLabel1.setAlignmentY(Component.BOTTOM_ALIGNMENT);
        pack();
    }

    /**
     * print all the players that joined the game on the client/gammer panel
     *
     * @param msg the message from server
     */
    public void printPlayers(String msg) {
        String[] protocolMsg = msg.split(";");
        String message = "";
        for (String line : protocolMsg) {
            message = message + line + "\n";
        }
        jTextPane1.setText(message);
    }

    /**
     * print a message on the client panel
     *
     * @param msg the message from server
     */
    public void printMessages(String[] msg) {
        jTextArea1.setText(jTextArea1.getText() + "\n" + msg[2] + ":" + msg[1]);
    }

    /**
     * initialize the game by connecting to the server
     */
    public void init() {
        try {
            host = InetAddress.getByName("127.0.0.1");
            Socket client = null;
            client = new Socket(host, 5005);
            server = new Client(client, this);
        } catch (UnknownHostException ex) {
            Logger.getLogger(ClientPanel.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(ClientPanel.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * change the window components to show the game
     *
     * @param message
     */
    private void initGameComponents(String[] message) {
        String[] objects = new String[parseInt(message[3])];

        for (int i = 7; i <= parseInt(message[3]) + 6; i++) {
            objects[i - 7] = message[i];
        }
        jPanel2.removeAll();
        jPanel2.setSize(new Dimension(parseInt(message[1]), parseInt(message[2])));
        JPanel panel = new JPanel();
        GridBagLayout layout = new GridBagLayout();
        jPanel2.setLayout(layout);
        GridBagConstraints gbc = new GridBagConstraints();

        CustomShape customShape = new CustomShape(objects, server, message[1], message[2]);
        JLabel jLabel1 = new javax.swing.JLabel();
        JLabel jLabel3 = new javax.swing.JLabel();
        JLabel jLabel4 = new javax.swing.JLabel();
        JLabel jLabel5 = new javax.swing.JLabel();
        JLabel jLabel6 = new javax.swing.JLabel();
        JLabel jLabel7 = new javax.swing.JLabel();
        JLabel jLabel8 = new javax.swing.JLabel();

        jLabel1.setText("circle:");
        jLabel3.setText(message[4]);
        jLabel4.setText("square:");
        jLabel5.setText(message[5]);
        jLabel6.setText("rectangle:");
        jLabel7.setText(message[6]);
        jLabel8.setText("score:");
        jTextField1.setText(score);
        jLabel1.setPreferredSize(new Dimension(75, 20));
        jLabel3.setPreferredSize(new Dimension(75, 20));
        jLabel4.setPreferredSize(new Dimension(75, 20));
        jLabel5.setPreferredSize(new Dimension(75, 20));
        jLabel6.setPreferredSize(new Dimension(75, 20));
        jLabel7.setPreferredSize(new Dimension(75, 20));
        jLabel8.setPreferredSize(new Dimension(75, 20));
        jTextField1.setPreferredSize(new Dimension(75, 30));

        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.gridx = 0;
        gbc.gridy = 0;
        jPanel2.add(jLabel1, gbc);

        gbc.gridx = 1;
        gbc.gridy = 0;
        jPanel2.add(jLabel3, gbc);

        gbc.gridx = 3;
        gbc.gridy = 0;
        jPanel2.add(jLabel4, gbc);

        gbc.gridx = 4;
        gbc.gridy = 0;
        jPanel2.add(jLabel5, gbc);

        gbc.gridx = 6;
        gbc.gridy = 0;
        jPanel2.add(jLabel6, gbc);

        gbc.gridx = 7;
        gbc.gridy = 0;
        jPanel2.add(jLabel7, gbc);

        gbc.gridx = 9;
        gbc.gridy = 0;
        jPanel2.add(jLabel8, gbc);

        gbc.gridx = 10;
        gbc.gridy = 0;
        jPanel2.add(jTextField1, gbc);

        gbc.gridx = 0;
        gbc.gridy = 2;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.gridwidth = 11;
        jPanel2.add(customShape, gbc);

        pack();

    }// </editor-fold>  

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JFrame jFrame1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTextArea jTextArea1;
    private javax.swing.JTextArea jTextArea2;
    private javax.swing.JTextPane jTextPane1;
    private javax.swing.JTextField txtTakmaAd;
    // End of variables declaration//GEN-END:variables
}