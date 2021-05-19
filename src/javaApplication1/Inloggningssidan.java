/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaApplication1;

import oru.inf.InfDB;

/**
 *
 * @author kristofffer
 */
public class Inloggningssidan extends javax.swing.JFrame {
    
    InfDB idb;

    /**
     * Creates new form Inloggningssidan
     */
    public Inloggningssidan(InfDB idb) {
        initComponents();
        this.idb = idb;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        anvandarnamn = new javax.swing.JLabel();
        password = new javax.swing.JLabel();
        txtAnvandarnamn = new javax.swing.JTextField();
        txtPassword = new javax.swing.JPasswordField();
        loggaIn = new javax.swing.JToggleButton();
        gaTillbaka = new javax.swing.JToggleButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        anvandarnamn.setText("Användarnamn");

        password.setText("Lösenord");

        txtAnvandarnamn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtAnvandarnamnActionPerformed(evt);
            }
        });

        txtPassword.setText("jPasswordField1");

        loggaIn.setText("Logga in");

        gaTillbaka.setText("Gå tillbaka");
        gaTillbaka.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                gaTillbakaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(39, 39, 39)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(gaTillbaka)
                    .addComponent(loggaIn)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(anvandarnamn)
                            .addComponent(password))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtPassword, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtAnvandarnamn, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(121, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(81, 81, 81)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(anvandarnamn)
                    .addComponent(txtAnvandarnamn, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(password)
                    .addComponent(txtPassword, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(loggaIn)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(gaTillbaka)
                .addContainerGap(73, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtAnvandarnamnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtAnvandarnamnActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtAnvandarnamnActionPerformed

    private void gaTillbakaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_gaTillbakaActionPerformed
        // TODO add your handling code here:
        
        this.dispose();
        new Start(idb).setVisible(true);
       
    }//GEN-LAST:event_gaTillbakaActionPerformed

    /**
     * @param args the command line arguments
     */
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel anvandarnamn;
    private javax.swing.JToggleButton gaTillbaka;
    private javax.swing.JToggleButton loggaIn;
    private javax.swing.JLabel password;
    private javax.swing.JTextField txtAnvandarnamn;
    private javax.swing.JPasswordField txtPassword;
    // End of variables declaration//GEN-END:variables
}
