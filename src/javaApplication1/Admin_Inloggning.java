package javaApplication1;

import java.awt.event.KeyEvent;
import javax.swing.JOptionPane;
import java.util.logging.Level;
import java.util.logging.Logger;
import oru.inf.InfDB;
import oru.inf.InfException;

public class Admin_Inloggning extends javax.swing.JFrame {

    InfDB idb;
    Validering vemArInloggad;

    public Admin_Inloggning(InfDB idb) {
        // När man väl försöker logga in som Admin tar konstruktorn in den angivna kopplingen till databasen samt 
        // Skapar ett nytt "objekt" (den som är inloggad) som följer med så länge respektive Admin är inloggad.
        initComponents();
        this.setLocationRelativeTo(null);
        this.idb = idb;
        this.vemArInloggad = new Validering(); // Vid körning av denna frame skapas ett nytt valideringsobjekt kopplad till klassen validering.
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        buttonLogin = new javax.swing.JButton();
        txtUser = new javax.swing.JTextField();
        lblAdminNamn = new javax.swing.JLabel();
        lblAdminLosenord = new javax.swing.JLabel();
        txtPassword = new javax.swing.JPasswordField();
        lblAdmin = new javax.swing.JLabel();
        btnTillbaka = new javax.swing.JButton();

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

        lblAdminNamn.setText("Agent ID:");

        lblAdminLosenord.setText("Lösenord:");

        txtPassword.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtPasswordKeyPressed(evt);
            }
        });

        lblAdmin.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        lblAdmin.setText("  MIB Admin");

        btnTillbaka.setText("Gå tillbaka");
        btnTillbaka.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTillbakaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(35, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblAdminNamn)
                            .addComponent(lblAdminLosenord))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtPassword)
                            .addComponent(txtUser, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnTillbaka)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(buttonLogin)))
                .addGap(5, 5, 5)
                .addComponent(jLabel1)
                .addGap(28, 28, 28))
            .addGroup(layout.createSequentialGroup()
                .addGap(56, 56, 56)
                .addComponent(lblAdmin, javax.swing.GroupLayout.PREFERRED_SIZE, 174, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(118, 118, 118)
                        .addComponent(jLabel1))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(37, 37, 37)
                        .addComponent(lblAdmin)
                        .addGap(32, 32, 32)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtUser, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblAdminNamn))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblAdminLosenord)
                            .addComponent(txtPassword, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(63, 63, 63)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(buttonLogin)
                    .addComponent(btnTillbaka))
                .addContainerGap(42, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void buttonLoginActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonLoginActionPerformed

        loggaInSomAdmin();
    }

    private void loggaInSomAdmin() {
        if (Validering.personFinns(txtUser) && Validering.finnsLosenord(txtPassword)) {
// Hänvisar till Valideringsklassen och kollar om text/password-rutorna är tomma eller inte.
            boolean godkandUser = false;
            boolean godkandLosenord = false;
            boolean godkandAdmin = false;
            // Lokala variabler av typen boolean, där syftet är att kolla upp så att, 
            // om det inskrivna i textrutorna matchar användarens befogenhet, lösenord, id så loggas man in.
            String user = txtUser.getText();
            String password = txtPassword.getText();
            try {
                String fraga1 = "SELECT Agent_ID FROM agent where Agent_ID like '" + user + "';";
                String giltigUser = idb.fetchSingle(fraga1);
                // Vid hämtning av fraga1 från databasuppkopplingen (idb) och med metoden: fetchSingle() så hämtar vi ett enstaka värde 
                //och ger agentens namn ett nytt stringvärde vars namn är giltigUser.
                String fraga2 = "SELECT Losenord FROM agent where Agent_ID like '" + giltigUser + "';";
                String giltigLosenord = idb.fetchSingle(fraga2);
                
                String fraga3 = "SELECT Administrator FROM agent where Agent_ID like '" + giltigUser + "';";
                String befogenhet = idb.fetchSingle(fraga3);
                // Fortsättning med fetchSingle-metoder för att hämta Lösenord samt AdministratorStatus.
                String admin = "J";
                // If-satserna nedan kollar om det inskrivna användarnamnet, lösenordet samt om en administratörstatus finns för "vald" agent.
                // Om de krav uppfylls ges en booleansk variabel för respektive uppfyllt krav.
                if (user.equals(giltigUser)) {
                    godkandUser = true;
                    if (password.equals(giltigLosenord)) {
                        godkandLosenord = true;
                        if (befogenhet.equals(admin)) {
                            godkandAdmin = true;
                        } else {
                            JOptionPane.showMessageDialog(null, "Du har ej befogenhet till denna att logga in.");
                        }
                    } else {
                        JOptionPane.showMessageDialog(null, "Lösenord är felaktigt för valt id");
                    }
                } else {
                    JOptionPane.showMessageDialog(null, "Agent ej hittad.");
                }
                if (godkandUser && godkandLosenord && godkandAdmin) {
//  ta bort då vi redan har ID             String fraga4 = "SELECT Agent_ID from agent where Agent_ID like '" + giltigUser + "';";
//  ta bort då vi redan har ID             String userID = idb.fetchSingle(fraga4);
                    int giltigtID = Integer.parseInt(giltigUser);
                    // Med koden nedanför hänvisar vi till vår Valideringsklass och fyller i vem som är inloggad med 
                    // hjälp av metoden inloggadSom(). Där fylls relevant information (namn, id, lösenord) för möjlighet att se 
                    // den inloggades uppgifter i inloggningValideringsklassen.
                    vemArInloggad.inloggadSom(giltigUser, giltigtID, giltigLosenord);
                    this.dispose();
                    new Admin(idb, vemArInloggad).setVisible(true);
// När alla krav är uppfyllda så startas Admin-sidan där databasuppkopplingen samt den inloggades uppgifter följs med.
                }

            } catch (InfException ex) {
                Logger.getLogger(Admin_Inloggning.class.getName()).log(Level.SEVERE, null, ex);
                JOptionPane.showMessageDialog(this, ex);
            }
        }

    }//GEN-LAST:event_buttonLoginActionPerformed

    private void btnTillbakaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTillbakaActionPerformed
        // TODO add your handling code here:
        this.dispose();
        new Start(idb).setVisible(true);
    }//GEN-LAST:event_btnTillbakaActionPerformed

    private void txtPasswordKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtPasswordKeyPressed
        // TODO add your handling code here:
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
// Vid Enter-tryck så körs den privata metoden loggaInSomAdmin(), om kraven uppfylls.

            loggaInSomAdmin();
        }
    }//GEN-LAST:event_txtPasswordKeyPressed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnTillbaka;
    private javax.swing.JButton buttonLogin;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel lblAdmin;
    private javax.swing.JLabel lblAdminLosenord;
    private javax.swing.JLabel lblAdminNamn;
    private javax.swing.JPasswordField txtPassword;
    private javax.swing.JTextField txtUser;
    // End of variables declaration//GEN-END:variables
}
