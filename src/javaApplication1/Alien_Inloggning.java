package javaApplication1;


import java.awt.event.KeyEvent;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import oru.inf.InfDB;
import oru.inf.InfException;



public class Alien_Inloggning extends javax.swing.JFrame {
    
    InfDB idb;
    Validering vemArInloggad;
   
    public Alien_Inloggning(InfDB idb){
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
        lblAlienNamn = new javax.swing.JLabel();
        lblAlienLosenord = new javax.swing.JLabel();
        txtPassword = new javax.swing.JPasswordField();
        lblAlien = new javax.swing.JLabel();
        btnTillbaka = new javax.swing.JButton();

        jLabel4.setText("jLabel4");

        jLabel5.setText("jLabel5");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setLocation(new java.awt.Point(0, 0));

        buttonLogin.setText("Logga in");
        buttonLogin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonLoginActionPerformed(evt);
            }
        });

        txtUser.setColumns(6);

        lblAlienNamn.setText("Alien ID:");

        lblAlienLosenord.setText("Lösenord:");

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

        lblAlien.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        lblAlien.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblAlien.setText("Alien inloggning");

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
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(47, 47, 47)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblAlienLosenord)
                            .addComponent(lblAlienNamn))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(txtUser)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jLabel1))
                            .addComponent(txtPassword)))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(lblAlien)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addGap(82, 82, 82))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnTillbaka)
                .addGap(32, 32, 32)
                .addComponent(buttonLogin)
                .addGap(56, 56, 56))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(42, 42, 42)
                .addComponent(lblAlien)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(61, 61, 61)
                        .addComponent(jLabel1)
                        .addGap(109, 109, 109))
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblAlienNamn)
                            .addComponent(txtUser, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblAlienLosenord)
                            .addComponent(txtPassword, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(47, 47, 47)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(buttonLogin)
                    .addComponent(btnTillbaka))
                .addGap(39, 39, 39))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void buttonLoginActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonLoginActionPerformed
            loggaInSomAlien();
    }
    
    
    private void loggaInSomAlien(){
        if(Validering.personFinns(txtUser) && Validering.finnsLosenord(txtPassword)){
      // Kollar upp om textBoxarna är tomma eller inte med hjälp av valideringsklassen.
        boolean godkandUser = false;
        boolean godkandLosenord = false;
          
        String user = txtUser.getText();
        String password = txtPassword.getText();
        try{
        String fraga1 = "SELECT Alien_ID FROM alien where Alien_ID = '"+user+"';";
           String giltigUser = idb.fetchSingle(fraga1);
           String fraga2 = "SELECT Losenord FROM alien where Alien_ID = '" + giltigUser + "';";
           String giltigLosenord = idb.fetchSingle(fraga2);
// Vi kör sql-frågor mot databasen över, och hämtar ett värde med hjälp av fetchSingle()-metoden.
// Med koden nedan dubbelkollar vi så att rätt namn är inskrivet mot databasen, samt även det rätta lösenordet för det valda namnet.
// Om så är fallet så ges de lokala booleanska variablerna godkandUser och godkandLosenord värdet true.
             if(user.equals(giltigUser)){
                 godkandUser = true;
                 if(password.equals(giltigLosenord)){
                  godkandLosenord = true;
                }
                else {
                JOptionPane.showMessageDialog(null, "Lösenord är felaktigt för valt id");
                }
            }
            else{
                 JOptionPane.showMessageDialog(null, "Användare ej hittad.");
             }
             if(godkandUser && godkandLosenord){
                 // Om true så körs följande nedan.                 
                 String fraga3 = "SELECT Alien_ID, Namn from alien where Alien_ID like '" + giltigUser+ "';";
                 String userID = idb.fetchSingle(fraga3);
                 int giltigtID = Integer.parseInt(userID);
 // Med koden nedanför hänvisar vi till vår inloggningValiderings-klassen och fyller i vem som är inloggad med 
 // hjälp av metoden inloggadSom(). Där fylls relevant information (namn, id, lösenord) för möjlighet att se 
 // den inloggades uppgifter i inloggningValideringsklassen. 
                vemArInloggad.inloggadSom(giltigUser, giltigtID, giltigLosenord);
                this.dispose();
                new Alien(idb, vemArInloggad).setVisible(true);
             }
        
            
        } catch (InfException ex) {
            Logger.getLogger(Alien_Inloggning.class.getName()).log(Level.SEVERE, null, ex);
        }
        }
    }//GEN-LAST:event_buttonLoginActionPerformed

    private void txtPasswordActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtPasswordActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtPasswordActionPerformed

    private void txtPasswordKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtPasswordKeyPressed
        // TODO add your handling code here:
       if(evt.getKeyCode()==KeyEvent.VK_ENTER){

            loggaInSomAlien();
       }
    }//GEN-LAST:event_txtPasswordKeyPressed

    private void btnTillbakaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTillbakaActionPerformed
        // TODO add your handling code here:
        this.dispose();
        new Start(idb).setVisible(true);
    }//GEN-LAST:event_btnTillbakaActionPerformed

    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnTillbaka;
    private javax.swing.JButton buttonLogin;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel lblAlien;
    private javax.swing.JLabel lblAlienLosenord;
    private javax.swing.JLabel lblAlienNamn;
    private javax.swing.JPasswordField txtPassword;
    private javax.swing.JTextField txtUser;
    // End of variables declaration//GEN-END:variables
}
