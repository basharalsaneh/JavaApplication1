
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
    
    public Admin_Inloggning(InfDB idb){ 
    // När man väl försöker logga in som Admin tar konstruktorn in den angivna kopplingen till databasen samt 
    // Skapar ett nytt "objekt" (den som är inloggad) som följer med så länge respektive Admin är inloggad.
        initComponents();
        this.setLocationRelativeTo(null);
        this.idb = idb;
        this.vemArInloggad = new Validering();
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

        jLabel2.setText("Agent ID");

        jLabel3.setText("Lösenord");

        txtPassword.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtPasswordKeyPressed(evt);
            }
        });

        jLabel6.setFont(new java.awt.Font("Rockwell", 1, 36)); // NOI18N
        jLabel6.setText("MIB Admin");

        jButton1.setText("Gå tillbaka");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(38, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jButton1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(buttonLogin))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(jLabel3))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtPassword)
                            .addComponent(txtUser, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(jLabel6, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 206, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(5, 5, 5)
                .addComponent(jLabel1)
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
                        .addGap(37, 37, 37)
                        .addComponent(jLabel6)
                        .addGap(32, 32, 32)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtUser, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3)
                            .addComponent(txtPassword, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(buttonLogin, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(83, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void buttonLoginActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonLoginActionPerformed

                loggaInSomAdmin();
    }
        
    
    private void loggaInSomAdmin(){
            if(Validering.personFinns(txtUser) && Validering.finnsLosenord(txtPassword)){ 
// Hänvisar till Valideringsklassen och kollar om textrutorna är tomma eller inte.
        boolean godkandUser = false;
        boolean godkandLosenord = false;
        boolean godkandAdmin = false;
       
          
        String user = txtUser.getText();
        String password = txtPassword.getText();
        System.out.println("Lösenordet inskrivet i rutan: " + password);
        try{
        String fraga1 = "SELECT Namn FROM agent where Namn like '"+user+"';"; 
           String giltigUser = idb.fetchSingle(fraga1); 
           // Vid hämtning av fraga1 från databasuppkopplingen (idb) och med metoden: fetchSingle() så hämtar vi ett enstaka värde 
           //och ger agentens namn ett nytt stringvärde vars namn är giltigUser.
           String fraga2 = "SELECT Losenord FROM agent where Namn like '" + giltigUser + "';";
           String giltigLosenord = idb.fetchSingle(fraga2);
           String fraga3 = "SELECT Administrator FROM agent where Namn like '" + giltigUser + "';";
           String befogenhet = idb.fetchSingle(fraga3); 
           // Fortsättning med fetchSingle-metoder för att hämta Lösenord samt AdministratorStatus.
           String admin = "J";
           // If-satserna nedan kollar om det inskrivna användarnamnet, lösenordet samt om en administratörstatus finns för "vald" agent.
           // Om de krav uppfylls ges en booleansk variabel för repsektive uppfyllt krav.
             if(user.equals(giltigUser)){
                 godkandUser = true;
                 if(password.equals(giltigLosenord)){
                  godkandLosenord = true;
                  if(befogenhet.equals(admin)){
                  godkandAdmin = true;
                  }
                  else{
                  JOptionPane.showMessageDialog(null, "Du har ej befogenhet till denna att logga in.");
                  }
                }
                else {
                JOptionPane.showMessageDialog(null, "Lösenord är felaktigt för valt id");
                }
            }
            else{
                 JOptionPane.showMessageDialog(null, "Agent ej hittat.");
             }
             if(godkandUser && godkandLosenord && godkandAdmin){
                 JOptionPane.showMessageDialog(this, "Du kommer nu loggas in som " + giltigUser);
             String fraga4 = "SELECT Agent_ID from agent where Namn like '" + giltigUser+ "';";
                 String userID = idb.fetchSingle(fraga4);
                 int giltigtID = Integer.parseInt(userID);
 // Med koden nedanför hänvisar vi till vår inloggningValiderings-klassen och fyller i vem som är inloggad med 
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

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        this.dispose();
        new Start(idb).setVisible(true);
    }//GEN-LAST:event_jButton1ActionPerformed

    private void txtPasswordKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtPasswordKeyPressed
        // TODO add your handling code here:
        if(evt.getKeyCode()==KeyEvent.VK_ENTER){
// Vid Enter-tryck så körs den privata metoden loggaInSomAdmin(), om kraven uppfylls.

            loggaInSomAdmin();}
    }//GEN-LAST:event_txtPasswordKeyPressed

    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton buttonLogin;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPasswordField txtPassword;
    private javax.swing.JTextField txtUser;
    // End of variables declaration//GEN-END:variables
}
