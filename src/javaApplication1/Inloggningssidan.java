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
import oru.inf.InfDB;



<<<<<<< HEAD:src/javaApplication1/Alien_Inloggning.java
<<<<<<< HEAD:src/javaApplication1/Alien_Inloggning.java
public class Alien_Inloggning extends javax.swing.JFrame {
=======
public class Alien_Inloggningssida extends javax.swing.JFrame {
>>>>>>> 79625bc68736428fd7f2b023d4f126dc0807b183:src/javaApplication1/Alien_Inloggningssida.java
=======
public class Inloggningssidan extends javax.swing.JFrame {
>>>>>>> parent of a26e50f (Mer uppdateringar.):src/javaApplication1/Inloggningssidan.java

    ResultSet resultat = null;
    Statement statement = null;
    PreparedStatement prepStatement = null;
    Connection connection1 = null;
    private static InfDB idb;
    inloggningValidering vemArInloggad;
   
<<<<<<< HEAD:src/javaApplication1/Alien_Inloggning.java
<<<<<<< HEAD:src/javaApplication1/Alien_Inloggning.java
    public Alien_Inloggning(InfDB idb) throws Exception {
=======
    public Alien_Inloggningssida(InfDB idb) throws Exception {
>>>>>>> 79625bc68736428fd7f2b023d4f126dc0807b183:src/javaApplication1/Alien_Inloggningssida.java
=======
    public Inloggningssidan(InfDB idb) throws Exception {
>>>>>>> parent of a26e50f (Mer uppdateringar.):src/javaApplication1/Inloggningssidan.java
        initComponents();
        getConnection();
        this.idb = idb;
        vemArInloggad = new inloggningValidering();
        
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
                        .addComponent(jLabel1)))
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
                .addContainerGap(185, Short.MAX_VALUE))
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
      
        
        // boolean okejPassword = false;
        // boolean okejID = false;
        
        try{
            String anv_namn = txtUser.getText();
            String password = txtPassword.getText(); 
           
           String fraga1 = ("SELECT Namn FROM alien where Namn like '"+anv_namn+"';");
           String kollaUppAnvandare = idb.fetchSingle(fraga1);
           String fraga2 = ("SELECT Losenord FROM alien where Namn like '" + kollaUppAnvandare + "';");
           String kollaUppLosenord = idb.fetchSingle(fraga2);
    
             if(anv_namn.equals(kollaUppAnvandare) && password.equals(kollaUppLosenord)){
                String fraga3 = ("SELECT Alien_ID from alien where Namn like '" + kollaUppAnvandare+ "';");
                 String anvandareIDString = idb.fetchSingle(fraga3);
                 int anvandareID = Integer.parseInt(anvandareIDString);
                vemArInloggad.inloggadSom(kollaUppAnvandare, anvandareID, kollaUppLosenord);
                JOptionPane.showMessageDialog(this, kollaUppAnvandare + " " + kollaUppLosenord + " " + anvandareID);
                    new Alien(idb, vemArInloggad).setVisible(true);
                    dispose();
                    
                    
            }
            else{
                JOptionPane.showMessageDialog(null, "Namn / lösenord är felaktigt");
                txtUser.setText("");
                txtPassword.setText("");
                txtUser.requestFocus();
            }                  
        } catch (SQLException ex) {
<<<<<<< HEAD:src/javaApplication1/Alien_Inloggning.java
<<<<<<< HEAD:src/javaApplication1/Alien_Inloggning.java
            Logger.getLogger(Alien_Inloggning.class.getName()).log(Level.SEVERE, null, ex);
        } catch (Exception ex) {
            Logger.getLogger(Alien_Inloggning.class.getName()).log(Level.SEVERE, null, ex);
=======
            Logger.getLogger(Alien_Inloggningssida.class.getName()).log(Level.SEVERE, null, ex);
        } catch (Exception ex) {
            Logger.getLogger(Alien_Inloggningssida.class.getName()).log(Level.SEVERE, null, ex);
>>>>>>> 79625bc68736428fd7f2b023d4f126dc0807b183:src/javaApplication1/Alien_Inloggningssida.java
=======
            Logger.getLogger(Inloggningssidan.class.getName()).log(Level.SEVERE, null, ex);
        } catch (Exception ex) {
            Logger.getLogger(Inloggningssidan.class.getName()).log(Level.SEVERE, null, ex);
>>>>>>> parent of a26e50f (Mer uppdateringar.):src/javaApplication1/Inloggningssidan.java
        }
    
     
    }//GEN-LAST:event_buttonLoginActionPerformed

    private void txtPasswordActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtPasswordActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtPasswordActionPerformed

    private void labelAndraLosenMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_labelAndraLosenMouseClicked
<<<<<<< HEAD:src/javaApplication1/Alien_Inloggning.java
<<<<<<< HEAD:src/javaApplication1/Alien_Inloggning.java
//        SKA TAS BORT? OCH ÄNDRA LÖSENORD SKA VARA MÖJLIGT FRÅN RESPEKTIVE INLOGGNINGSSIDA ???
//          try {
//            // TODO add your handling code here:
//            
//            dispose();
//            BytaLosenord bytLosen = new BytaLosenord(idb, vemArInloggad);
//            bytLosen.setVisible(true);
//        } catch (Exception ex) {
//            Logger.getLogger(Alien_Inloggning.class.getName()).log(Level.SEVERE, null, ex);
//        }
=======
=======
>>>>>>> parent of a26e50f (Mer uppdateringar.):src/javaApplication1/Inloggningssidan.java
        try {
            // TODO add your handling code here:
            
            dispose();
            BytaLosenord bytLosen = new BytaLosenord(idb);
            bytLosen.setVisible(true);
        } catch (Exception ex) {
<<<<<<< HEAD:src/javaApplication1/Alien_Inloggning.java
            Logger.getLogger(Alien_Inloggningssida.class.getName()).log(Level.SEVERE, null, ex);
        }
>>>>>>> 79625bc68736428fd7f2b023d4f126dc0807b183:src/javaApplication1/Alien_Inloggningssida.java
=======
            Logger.getLogger(Inloggningssidan.class.getName()).log(Level.SEVERE, null, ex);
        }
>>>>>>> parent of a26e50f (Mer uppdateringar.):src/javaApplication1/Inloggningssidan.java
    }//GEN-LAST:event_labelAndraLosenMouseClicked

    private void labelAndraLosenFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_labelAndraLosenFocusGained
        // TODO add your handling code here:
        
       
    }//GEN-LAST:event_labelAndraLosenFocusGained

    private void labelAndraLosenMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_labelAndraLosenMouseExited
        // TODO add your handling code here:
        
    }//GEN-LAST:event_labelAndraLosenMouseExited

    private void txtPasswordKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtPasswordKeyPressed
        // TODO add your handling code here:
       // Ingen kod här än. Lägg till metoden som loggar in vald person.
    }//GEN-LAST:event_txtPasswordKeyPressed

   
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
<<<<<<< HEAD:src/javaApplication1/Alien_Inloggning.java
<<<<<<< HEAD:src/javaApplication1/Alien_Inloggning.java
            java.util.logging.Logger.getLogger(Alien_Inloggning.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
=======
            java.util.logging.Logger.getLogger(Inloggningssidan.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
>>>>>>> parent of a26e50f (Mer uppdateringar.):src/javaApplication1/Inloggningssidan.java
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Inloggningssidan.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Inloggningssidan.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
<<<<<<< HEAD:src/javaApplication1/Alien_Inloggning.java
            java.util.logging.Logger.getLogger(Alien_Inloggning.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
=======
            java.util.logging.Logger.getLogger(Alien_Inloggningssida.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Alien_Inloggningssida.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Alien_Inloggningssida.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Alien_Inloggningssida.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
>>>>>>> 79625bc68736428fd7f2b023d4f126dc0807b183:src/javaApplication1/Alien_Inloggningssida.java
=======
            java.util.logging.Logger.getLogger(Inloggningssidan.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
>>>>>>> parent of a26e50f (Mer uppdateringar.):src/javaApplication1/Inloggningssidan.java
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
<<<<<<< HEAD:src/javaApplication1/Alien_Inloggning.java
<<<<<<< HEAD:src/javaApplication1/Alien_Inloggning.java
                    new Alien_Inloggning(idb).setVisible(true);
                } catch (Exception ex) {
                    Logger.getLogger(Alien_Inloggning.class.getName()).log(Level.SEVERE, null, ex);
=======
                    new Alien_Inloggningssida(idb).setVisible(true);
                } catch (Exception ex) {
                    Logger.getLogger(Alien_Inloggningssida.class.getName()).log(Level.SEVERE, null, ex);
>>>>>>> 79625bc68736428fd7f2b023d4f126dc0807b183:src/javaApplication1/Alien_Inloggningssida.java
=======
                    new Inloggningssidan(idb).setVisible(true);
                } catch (Exception ex) {
                    Logger.getLogger(Inloggningssidan.class.getName()).log(Level.SEVERE, null, ex);
>>>>>>> parent of a26e50f (Mer uppdateringar.):src/javaApplication1/Inloggningssidan.java
                }
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton buttonLogin;
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
