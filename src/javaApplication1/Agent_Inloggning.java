/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaApplication1;

import java.awt.event.KeyEvent;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import oru.inf.InfDB;
import oru.inf.InfException;
/**
 *
 * @author Marcu
 */
public class Agent_Inloggning extends javax.swing.JFrame {

    
    InfDB idb;
    Validering vemArInloggad;
    /**
     * Creates new form Agent_Inloggning
     * @param idb
     */
    public Agent_Inloggning(InfDB idb){
        initComponents();
        this.setLocationRelativeTo(null);
        this.idb = idb;
        vemArInloggad = new Validering();
        }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btnLogin = new javax.swing.JButton();
        txtPassword = new javax.swing.JPasswordField();
        txtUser = new javax.swing.JTextField();
        lblAgentNamn = new javax.swing.JLabel();
        lblAgentLosenord = new javax.swing.JLabel();
        lblAgent = new javax.swing.JLabel();
        btnTillbaka = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setLocation(new java.awt.Point(500, 100));

        btnLogin.setText("Logga in");
        btnLogin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLoginActionPerformed(evt);
            }
        });

        txtPassword.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtPasswordKeyPressed(evt);
            }
        });

        lblAgentNamn.setText("Användarnamn");

        lblAgentLosenord.setText("Lösenord");

        lblAgent.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        lblAgent.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblAgent.setText("Agent inloggning");

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
                .addGap(60, 60, 60)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnTillbaka)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnLogin))
                    .addComponent(lblAgent, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblAgentLosenord)
                            .addComponent(lblAgentNamn, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 49, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtPassword, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtUser, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(94, 94, 94))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(32, 32, 32)
                .addComponent(lblAgent, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 26, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblAgentNamn, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtUser, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtPassword, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblAgentLosenord))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnLogin)
                    .addComponent(btnTillbaka))
                .addGap(102, 102, 102))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void loggaInSomAgent(){
             if(Validering.personFinns(txtUser) && Validering.finnsLosenord(txtPassword)){
 // Kollar upp om textBoxarna är tomma eller inte med hjälp av valideringsklassen.
        boolean godkandUser = false;
        boolean godkandLosenord = false;
          
        String user = txtUser.getText();
        String password = txtPassword.getText();
        
        try{
        String fraga1 = "SELECT Namn FROM agent where Namn like '"+user+"';";
           String giltigUser = idb.fetchSingle(fraga1);
           String fraga2 = "SELECT Losenord FROM agent where Namn like '" + giltigUser + "';";
           String giltigLosenord = idb.fetchSingle(fraga2);
// Vi kör sql-frågor mot databasen och hämtar ett värde med hjälp av fetchSingle()-metoden.
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
                 JOptionPane.showMessageDialog(null, "Agent ej hittat.");
             }

             if(godkandUser && godkandLosenord){
                  // Om true så körs följande nedan.                 
             String fraga3 = "SELECT Agent_ID from agent where Namn like '" + giltigUser+ "';";
                 String userID = idb.fetchSingle(fraga3);
                 int giltigtID = Integer.parseInt(userID);
       // Med koden nedanför hänvisar vi till vår inloggningValiderings-klassen och fyller i vem som är inloggad med 
 // hjälp av metoden inloggadSom(). Där fylls relevant information (namn, id, lösenord) för möjlighet att se 
 // den inloggades uppgifter i inloggningValideringsklassen. 
                vemArInloggad.inloggadSom(giltigUser, giltigtID, giltigLosenord);
                this.dispose();
                new Agent(idb, vemArInloggad).setVisible(true);
 // Här följer databasens uppkoppling samt de inlagda uppgifter angående personens inloggning från metoden ovanför (inloggadSom()). 
             }
        
            
        } catch (InfException ex) {
            Logger.getLogger(Agent_Inloggning.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(this, ex);
        }
        }
    }
    
    private void btnLoginActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLoginActionPerformed
        // TODO add your handling code here:
        this.dispose();
        loggaInSomAgent();
    }//GEN-LAST:event_btnLoginActionPerformed

    private void btnTillbakaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTillbakaActionPerformed
        // TODO add your handling code here:
        this.dispose();
        new Start(idb).setVisible(true);
    }//GEN-LAST:event_btnTillbakaActionPerformed

    private void txtPasswordKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtPasswordKeyPressed
        // TODO add your handling code here:
        if(evt.getKeyCode()==KeyEvent.VK_ENTER){
            
         // Vid tryck på enter så körs metoden, loggaInSomAgen().
            
            loggaInSomAgent();
            
        }
    }//GEN-LAST:event_txtPasswordKeyPressed

    /**
     * @param args the command line arguments
     */
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnLogin;
    private javax.swing.JButton btnTillbaka;
    private javax.swing.JLabel lblAgent;
    private javax.swing.JLabel lblAgentLosenord;
    private javax.swing.JLabel lblAgentNamn;
    private javax.swing.JPasswordField txtPassword;
    private javax.swing.JTextField txtUser;
    // End of variables declaration//GEN-END:variables
}
