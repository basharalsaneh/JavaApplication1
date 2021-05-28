package javaApplication1;


import java.awt.event.KeyEvent;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import oru.inf.InfDB;
import oru.inf.InfException;



public class Alien_Inloggning extends javax.swing.JFrame {
    
    InfDB idb;
    inloggningValidering vemArInloggad;
   
    public Alien_Inloggning(InfDB idb){
        initComponents();
        this.idb = idb;
        this.vemArInloggad = new inloggningValidering();
        
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
        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel6.setText("Alien inloggning");

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
                .addContainerGap(64, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel6, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jButton1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(buttonLogin))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                        .addComponent(jLabel2)
                                        .addGap(80, 80, 80))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                        .addComponent(jLabel3)
                                        .addGap(109, 109, 109)))
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtPassword, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtUser, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGap(14, 14, 14)))
                .addGap(82, 82, 82))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(132, 132, 132)
                        .addComponent(jLabel1))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(40, 40, 40)
                        .addComponent(jLabel6)
                        .addGap(55, 55, 55)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(txtUser, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3)
                    .addComponent(txtPassword, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(27, 27, 27)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(buttonLogin, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(193, Short.MAX_VALUE))
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
        System.out.println("Lösenordet inskrivet i rutan: " + password);
        try{
        String fraga1 = "SELECT Namn FROM alien where Namn like '"+user+"';";
           String giltigUser = idb.fetchSingle(fraga1);
           String fraga2 = "SELECT Losenord FROM alien where Namn like '" + giltigUser + "';";
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
                 JOptionPane.showMessageDialog(null, "Användare ej hittat.");
             }
             if(godkandUser && godkandLosenord){
                 // Om true så körs följande nedan.
                 JOptionPane.showMessageDialog(this, "Du kommer nu loggas in som " + giltigUser);
                 String fraga3 = "SELECT Alien_ID from alien where Namn like '" + giltigUser+ "';";
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

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        this.dispose();
        new Start(idb).setVisible(true);
    }//GEN-LAST:event_jButton1ActionPerformed

    

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
