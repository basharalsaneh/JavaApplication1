
package javaApplication1;



import java.awt.event.KeyEvent;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.PreparedStatement;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.sql.ResultSet;
import java.sql.DriverManager;
import javax.swing.JOptionPane;



public class Inloggningssidan extends javax.swing.JFrame {

    ResultSet resultat = null;
    Statement statement = null;
    PreparedStatement prepStatement = null;
    Connection connection1 = null;
   
    public Inloggningssidan() throws Exception {
        initComponents();
        getConnection();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        buttonLogin = new javax.swing.JButton();
        txtUser = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        txtPassword = new javax.swing.JPasswordField();
        jLabel6 = new javax.swing.JLabel();
        labelAndraLosen = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();

        jLabel4.setText("jLabel4");

        jLabel5.setText("jLabel5");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        buttonLogin.setText("Logga in");
        buttonLogin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonLoginActionPerformed(evt);
            }
        });

        txtUser.setColumns(6);

        jLabel2.setText("Användarnamn");

        jLabel3.setText("Lösenord");

        txtPassword.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtPasswordActionPerformed(evt);
            }
        });
        txtPassword.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtPasswordKeyPressed(evt);
            }
        });

        jLabel6.setFont(new java.awt.Font("Rockwell", 1, 36)); // NOI18N
        jLabel6.setText("MIB");

        labelAndraLosen.setText("Ändra ditt lösenord");
        labelAndraLosen.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                labelAndraLosenFocusGained(evt);
            }
        });
        labelAndraLosen.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                labelAndraLosenMouseClicked(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                labelAndraLosenMouseExited(evt);
            }
        });

        jButton1.setText("Logga ");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(112, 112, 112)
                .addComponent(jLabel6)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(40, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButton1)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(buttonLogin)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(labelAndraLosen, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(layout.createSequentialGroup()
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel2)
                                .addComponent(jLabel3))
                            .addGap(18, 18, 18)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(txtPassword)
                                .addComponent(txtUser, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(jLabel1))))
                .addGap(28, 28, 28))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(132, 132, 132)
                        .addComponent(jLabel1))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(39, 39, 39)
                        .addComponent(jLabel6)
                        .addGap(53, 53, 53)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtUser, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2))))
                .addGap(12, 12, 12)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtPassword, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3))
                .addGap(44, 44, 44)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(buttonLogin)
                    .addComponent(labelAndraLosen, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(28, 28, 28)
                .addComponent(jButton1)
                .addContainerGap(134, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

     public final void getConnection() throws Exception{
        try{
        Class.forName("com.mysql.cj.jdbc.Driver"); // Tror den hämtar mysql driver och gör det möjligt att koppla upp till databasen.
             connection1 = DriverManager.getConnection("jdbc:mysql://localhost:3306/mibdb", "mibdba", "mibkey"); // Denna ska också på något sätt
             // koppa upp till databasen. Ingen kod är "röd" men osäker på om projektet inte funkar pga att jag är "disconnected" från databasen eller inte.
             System.out.println("Databasen kopplad till projektet, lyckats!");
            
        }
        catch(ClassNotFoundException e){
            System.out.println(e);
        }
     }
    
  
     
    private void buttonLoginActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonLoginActionPerformed
      
        String ID = txtUser.getText();
        String password = txtPassword.getText(); 
        // boolean okejPassword = false;
        // boolean okejID = false;
        ResultSet resultat1;
        try{
           statement = connection1.createStatement();
           String fraga = "SELECT Alien_ID, Losenord FROM alien where "
                   + "Alien_ID = '"+ID+"' and Losenord = '"+password+"';";
           
         
                resultat1 = statement.executeQuery(fraga);
                
                
            if(resultat1.next()){
                    dispose();
                    Registrering registrering = new Registrering();
                    registrering.show();
            }
            else{
                JOptionPane.showMessageDialog(null, "ID / lösenord är felaktigt");
                txtUser.setText("");
                txtPassword.setText("");
                txtUser.requestFocus();
            }                  
        } catch (SQLException ex) {
            Logger.getLogger(Inloggningssidan.class.getName()).log(Level.SEVERE, null, ex);
        } catch (Exception ex) {
            Logger.getLogger(Inloggningssidan.class.getName()).log(Level.SEVERE, null, ex);
        }
    
     
    }//GEN-LAST:event_buttonLoginActionPerformed

    private void txtPasswordActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtPasswordActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtPasswordActionPerformed

    private void labelAndraLosenMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_labelAndraLosenMouseClicked
        try {
            // TODO add your handling code here:
            
            dispose();
            BytaLosenord bytLosen = new BytaLosenord();
            bytLosen.setVisible(true);
        } catch (Exception ex) {
            Logger.getLogger(Inloggningssidan.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_labelAndraLosenMouseClicked

    private void labelAndraLosenFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_labelAndraLosenFocusGained
        // TODO add your handling code here:
        
       
    }//GEN-LAST:event_labelAndraLosenFocusGained

    private void labelAndraLosenMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_labelAndraLosenMouseExited
        // TODO add your handling code here:
        
    }//GEN-LAST:event_labelAndraLosenMouseExited

    private void txtPasswordKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtPasswordKeyPressed
        // TODO add your handling code here:
        if(evt.getKeyCode()==KeyEvent.VK_ENTER){
        
        String ID = txtUser.getText();
        String password = txtPassword.getText(); 
        // boolean okejPassword = false;
        // boolean okejID = false;
        ResultSet resultat1;
        try{
           statement = connection1.createStatement();
           String fraga = "SELECT Alien_ID, Losenord FROM alien where "
                   + "Alien_ID = '"+ID+"' and Losenord = '"+password+"';";
           
         
                resultat1 = statement.executeQuery(fraga);
                
                
            if(resultat1.next()){
                    dispose();
                    Registrering registrering = new Registrering();
                    registrering.show();
            }
            else{
                JOptionPane.showMessageDialog(null, "ID / lösenord är felaktigt");
                txtUser.setText("");
                txtPassword.setText("");
                txtUser.requestFocus();
            }                  
        } catch (SQLException ex) {
            Logger.getLogger(Inloggningssidan.class.getName()).log(Level.SEVERE, null, ex);
        } catch (Exception ex) {
            Logger.getLogger(Inloggningssidan.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
        
        }
    }//GEN-LAST:event_txtPasswordKeyPressed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        try{
            var query = "SELECT * FROM 'agent' WHERE User = ? and Losenord = ?";
            connection1 = DriverManager.getConnection("jdbc:mysql://localhost:3306/mibdb","mibdba","mibkey");
            prepStatement = connection1.prepareStatement(query);
            prepStatement.setString(1, txtUser.getText());
            prepStatement.setString(2, txtPassword.getText());
            resultat = prepStatement.executeQuery();
            if(resultat.next()){
            JOptionPane.showMessageDialog(this, "Inloggning lyckad");}
            else{
            JOptionPane.showMessageDialog(this, "Användarnamn och Lösenord matchar inte");}         
            }
        catch(Exception ex) {
        Logger.getLogger(Inloggningssidan.class.getName()).log(Level.SEVERE, null, ex);}
    }//GEN-LAST:event_jButton1ActionPerformed

   
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
            java.util.logging.Logger.getLogger(Inloggningssidan.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Inloggningssidan.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Inloggningssidan.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Inloggningssidan.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    new Inloggningssidan().setVisible(true);
                } catch (Exception ex) {
                    Logger.getLogger(Inloggningssidan.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton buttonLogin;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel labelAndraLosen;
    private javax.swing.JPasswordField txtPassword;
    private javax.swing.JTextField txtUser;
    // End of variables declaration//GEN-END:variables
}
