package javaApplication1;

import com.mysql.cj.jdbc.result.ResultSetMetaData;
import java.sql.Statement;
import java.sql.PreparedStatement;
import java.util.logging.Level;
import java.util.logging.Logger;
import oru.inf.InfException;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.DriverManager;
import javax.swing.JOptionPane;
import java.sql.ResultSet;
import java.util.Vector;
import javax.swing.table.DefaultTableModel;
import oru.inf.InfDB;

public class Registrering extends javax.swing.JFrame {
   
     private static InfDB idb;
        Connection connection1;
        PreparedStatement statement;
        Statement createStatement;
  
    public Registrering() throws Exception { // KÃ¶rs igÃ¥ng direkt.
        initComponents();
        getConnection();
        table_update();
         
    }

    final void getConnection() throws Exception{
        try{
        Class.forName("com.mysql.cj.jdbc.Driver"); // Tror den hÃ¤mtar mysql driver och gÃ¶r det mÃ¶jligt att koppla upp till databasen.
             connection1 = DriverManager.getConnection("jdbc:mysql://localhost:3306/mibdb", "mibdba", "mibkey"); // Denna ska ocksÃ¥ pÃ¥ nÃ¥got sÃ¤tt
             // koppa upp till databasen. Ingen kod Ã¤r "rÃ¶d" men osÃ¤ker pÃ¥ om projektet inte funkar pga att jag Ã¤r "disconnected" frÃ¥n databasen eller inte.
             System.out.println("Databasen kopplad till projektet, lyckats!");
             
        }
        catch(ClassNotFoundException | SQLException e){
            System.out.println(e);
        }
       
           
        
       
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        txtAlienID = new javax.swing.JTextField();
        txtAlienNamn = new javax.swing.JTextField();
        txtAlienTelefon = new javax.swing.JTextField();
        buttonAdd = new javax.swing.JButton();
        buttonEdit = new javax.swing.JButton();
        buttonDelete = new javax.swing.JButton();
        txtAlienPlats = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        txtAlienAnsvarig = new javax.swing.JTextField();
        buttonRensaData = new javax.swing.JButton();
        buttonListaAll = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        txtPlatsID = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        buttonListaAliens = new javax.swing.JButton();
        jLabel8 = new javax.swing.JLabel();
        txtUtrustning = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel1.setText("Registrering");

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Registrering", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 14))); // NOI18N

        jLabel2.setText("AlienID");

        jLabel3.setText("Namn");

        jLabel4.setText("Telefon");

        txtAlienID.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtAlienIDActionPerformed(evt);
            }
        });

        buttonAdd.setText("Add");
        buttonAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonAddActionPerformed(evt);
            }
        });

        buttonEdit.setText("Edit");
        buttonEdit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonEditActionPerformed(evt);
            }
        });

        buttonDelete.setText("Delete");
        buttonDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonDeleteActionPerformed(evt);
            }
        });

        jLabel5.setText("Plats");

        jLabel6.setText("Ansvarig");

        buttonRensaData.setText("Rensa fälten");
        buttonRensaData.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonRensaDataActionPerformed(evt);
            }
        });

        buttonListaAll.setText("Lista en alien");
        buttonListaAll.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonListaAllActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(31, 31, 31)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(7, 7, 7)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.LEADING))
                            .addComponent(jLabel6))
                        .addGap(22, 22, 22)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtAlienNamn)
                            .addComponent(txtAlienTelefon, javax.swing.GroupLayout.DEFAULT_SIZE, 171, Short.MAX_VALUE)
                            .addComponent(txtAlienID)
                            .addComponent(txtAlienPlats)
                            .addComponent(txtAlienAnsvarig)))
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addGroup(jPanel2Layout.createSequentialGroup()
                            .addComponent(buttonRensaData)
                            .addGap(51, 51, 51)
                            .addComponent(buttonListaAll))
                        .addGroup(jPanel2Layout.createSequentialGroup()
                            .addComponent(buttonAdd, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addComponent(buttonEdit, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(buttonDelete, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(20, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtAlienID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtAlienNamn, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3))
                .addGap(12, 12, 12)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(txtAlienTelefon, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtAlienPlats, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(txtAlienAnsvarig, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(buttonRensaData)
                    .addComponent(buttonListaAll))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 15, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(buttonAdd)
                    .addComponent(buttonEdit)
                    .addComponent(buttonDelete))
                .addContainerGap())
        );

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "AlienID", "Namn", "Telefon", "Plats", "Ansvarig"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTable1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable1MouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTable1);

        txtPlatsID.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtPlatsIDActionPerformed(evt);
            }
        });

        jLabel7.setText("Lista aliens på plats:");

        buttonListaAliens.setText("Lista nu");
        buttonListaAliens.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonListaAliensActionPerformed(evt);
            }
        });

        jLabel8.setText("Ta bort utrustning med id;");

        jButton1.setText("Ta bort");
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
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 470, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(jLabel7)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(txtPlatsID, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(buttonListaAliens, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(jLabel8)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(txtUtrustning, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                    .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(156, 156, 156)
                        .addComponent(jLabel1)))
                .addContainerGap(49, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(41, 41, 41)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 185, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtPlatsID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel7)
                            .addComponent(buttonListaAliens))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel8)
                            .addComponent(txtUtrustning, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButton1))))
                .addGap(0, 71, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void table_update(){
        int kolumn;
        try{
        statement = connection1.prepareStatement("SELECT * FROM alien");
        ResultSet rs = statement.executeQuery();
        ResultSetMetaData rss = (ResultSetMetaData) rs.getMetaData();
        kolumn = rss.getColumnCount();
        DefaultTableModel df = (DefaultTableModel) jTable1.getModel();
        df.setRowCount(0);
        while(rs.next()) // Listar alla aliens
        {
        Vector v1 = new Vector(); // Vektor med varje alien-individs vÃ¤rden.
        
        for(int i=1 ; i<=kolumn ; i++){ 
        v1.add(rs.getString("Alien_ID")); // HÃ¤mtar fÃ¶rsta aliensID och sen 2:a osv.
        v1.add(rs.getString("Namn"));
        v1.add(rs.getString("Telefon"));
        v1.add(rs.getString("Plats"));
        v1.add(rs.getString("Ansvarig_Agent"));
        }
        
        df.addRow(v1); // Adderar/Listar varje alien-individs vÃ¤rde i tabellen
        
        }
        
        }
       
             catch (SQLException ex) {
                Logger.getLogger(Registrering.class.getName()).log(Level.SEVERE, null, ex);
            }
            
            
        }
    
     public void listaAliensBaseratPaNamn(String alienNamn){
     try {
              
           String Namn = txtAlienNamn.getText();
           
            String fraga1 = "SELECT Alien_ID, Namn from alien where Namn like '%?%'"; 
           statement = connection1.prepareStatement(fraga1);
            statement.setString(1, Namn);
            ResultSet rs = statement.executeQuery();
            
            JOptionPane.showMessageDialog(this, "listar nu:");
             if(rs.next() == false){
                 System.out.println("Inga Aliens på vald plats");
             }
             do{
               int ID = rs.getInt("Alien_ID");
                String Namn1 = rs.getString("Namn");
                JOptionPane.showMessageDialog(this, ID + " " + Namn1 );
                }
             while(rs.next());
             }
                catch (SQLException ex) {
             Logger.getLogger(Registrering.class.getName()).log(Level.SEVERE, null, ex);
             System.out.println("något har blivit fel");
                 }
          
    }
    
    public void listaAliensBaseratPaID(int alienID){
             try {
               String id = txtAlienID.getText();
            int intID = Integer.parseInt(id);
           
            String fraga1 = "SELECT * from alien where Alien_ID = ?"; 
            
            statement = connection1.prepareStatement(fraga1);
            statement.setInt(1, intID);
            ResultSet rs = statement.executeQuery();
            
            JOptionPane.showMessageDialog(this, "listar nu:");
             if(rs.next() == false){
                 System.out.println("Inga Aliens på vald plats");
             }
             do{
                 
                int ID = rs.getInt("Alien_ID");
                String alienNamn = rs.getString("Namn");
                JOptionPane.showMessageDialog(this, ID + " " + alienNamn );
                }
             while(rs.next());
             }
                catch (SQLException ex) {
             Logger.getLogger(Registrering.class.getName()).log(Level.SEVERE, null, ex);
             System.out.println("något har blivit fel");
                 }
          
    }

 
    
    private void buttonAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonAddActionPerformed
   
        try {
            String StringID = txtAlienID.getText();// FÃ¥r ej vara null
            int id = Integer.parseInt(StringID);
            String telefon = txtAlienTelefon.getText();
            String plats = txtAlienPlats.getText(); // FÃ¥r ej vara null
            String namn = txtAlienNamn.getText(); 
            String ansvarig = txtAlienAnsvarig.getText(); // FÃ¥r ej vara null
            String fraga = "INSERT INTO alien (Alien_ID, Namn, Telefon, Plats, Ansvarig_Agent) VALUES (?,?,?,?,?)";
            
            
            statement = connection1.prepareStatement(fraga);
            statement.setInt(1, id);
            statement.setString(2, namn);
            statement.setString(3, telefon);
            statement.setString(4, plats);
            statement.setString(5, ansvarig);
            statement.execute();
            JOptionPane.showMessageDialog(this, "Alien added");
            table_update();
           
          
         
             } catch (SQLException ex) {
                Logger.getLogger(Registrering.class.getName()).log(Level.SEVERE, null, ex);
            }
             //
             

       
    }//GEN-LAST:event_buttonAddActionPerformed

    private void txtAlienIDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtAlienIDActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtAlienIDActionPerformed

    private void buttonListaAllActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonListaAllActionPerformed
     String alienID = txtAlienID.getText();
       int intID = Integer.parseInt(alienID);
       String alienNamn = txtAlienNamn.getText();
        
        if(!alienID.equals("")){
        listaAliensBaseratPaID(intID);
       }
        
       

//          Om alienIDtextFältet är tomt ska ett felmeddelande komma upp.
//        if(alienID.equals("")){
//        JOptionPane.showMessageDialog(this, "Var god välj ett ID/Namn att lista");
//        }
    }//GEN-LAST:event_buttonListaAllActionPerformed
    
    private void buttonDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonDeleteActionPerformed
        // Delete en alien vars alien man trycker pÃ¥ i tabellen.
        DefaultTableModel df = (DefaultTableModel) jTable1.getModel();
        int selectedIndex = jTable1.getSelectedRow();
         try {
             int id = Integer.parseInt(df.getValueAt(selectedIndex, 0).toString());
             int villDuDelete = JOptionPane.showConfirmDialog(null, "Vill du ta bort vald alien?", 
                     "Warning", JOptionPane.YES_NO_OPTION);
             if(villDuDelete == JOptionPane.YES_OPTION){
             String taBortAlien = "delete from alien where Alien_ID = ?";
             statement = connection1.prepareStatement(taBortAlien);
             statement.setInt(1, id);
             statement.executeUpdate();
             JOptionPane.showMessageDialog(this, "Alien Ã¤ndrad");
             table_update(); // Uppdaterar flÃ¶det. Kolla vad metoden gÃ¶r.
             txtAlienID.setText("");
             txtAlienNamn.setText("");
             txtAlienTelefon.setText("");
             txtAlienPlats.setText("");
             txtAlienAnsvarig.setText("");
             txtAlienID.requestFocus(); // Fokus pÃ¥ vald textruta.
             } 
             if(villDuDelete == JOptionPane.NO_OPTION){
             JOptionPane.showMessageDialog(this, "Alien INTE Ã¤ndrad");
             }
              
           
         } catch (SQLException ex) {
             Logger.getLogger(Registrering.class.getName()).log(Level.SEVERE, null, ex);
         }
         
    }//GEN-LAST:event_buttonDeleteActionPerformed

    private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseClicked
        // TODO add your handling code here:
        DefaultTableModel df = (DefaultTableModel) jTable1.getModel();
        int selectedIndex = jTable1.getSelectedRow();
        
        
        txtAlienID.setText(df.getValueAt(selectedIndex, 0).toString());
        txtAlienNamn.setText(df.getValueAt(selectedIndex, 1).toString());
        txtAlienTelefon.setText(df.getValueAt(selectedIndex, 2).toString());
        txtAlienPlats.setText(df.getValueAt(selectedIndex, 3).toString());
        txtAlienAnsvarig.setText(df.getValueAt(selectedIndex, 4).toString());
        
    }//GEN-LAST:event_jTable1MouseClicked

    private void buttonEditActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonEditActionPerformed
        // TODO add your handling code here:
        DefaultTableModel df = (DefaultTableModel) jTable1.getModel();
        int selectedIndex = jTable1.getSelectedRow();
        String alienID = df.getValueAt(selectedIndex, 0).toString();
        if(!txtAlienID.getText().equals(alienID)){ //Om ID:t Ã¤r annat Ã¤n det angivna sÃ¥ kÃ¶rs detta:
        JOptionPane.showMessageDialog(this, "Du fÃ¥r inte Ã¤ndra pÃ¥ ID:t, ID:t byts nu tillbaks!");
        txtAlienID.setText(alienID); // ID:t sÃ¤tts tillbaka till det fÃ¶rvalda.
        }
        else
        {
         try {
             
            int id = Integer.parseInt(df.getValueAt(selectedIndex, 0).toString());
            String namn = txtAlienNamn.getText();
            String telefon = txtAlienTelefon.getText();
            String plats = txtAlienPlats.getText(); // FÃ¥r ej vara null
            String ansvarig = txtAlienAnsvarig.getText(); // FÃ¥r ej vara null
            String fraga = "UPDATE alien SET Namn = ?, Telefon = ?, "
                    + "Plats = ?, Ansvarig_Agent = ? where Alien_ID = ? ";
            statement = connection1.prepareStatement(fraga);
           //  
            statement.setString(1, namn);
            statement.setString(2, telefon);
            statement.setString(3, plats);
            statement.setString(4, ansvarig);
            statement.setInt(5, id);
            statement.executeUpdate();
            JOptionPane.showMessageDialog(this, "Alien CHANGED");
            table_update();
           
           
            txtAlienID.setText("");
            txtAlienNamn.setText("");
            txtAlienTelefon.setText("");
            txtAlienPlats.setText("");
            txtAlienAnsvarig.setText("");
            txtAlienID.requestFocus();
            
         
             } catch (SQLException ex) {
                Logger.getLogger(Registrering.class.getName()).log(Level.SEVERE, null, ex);
            }
        
        }
    }//GEN-LAST:event_buttonEditActionPerformed

    private void buttonRensaDataActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonRensaDataActionPerformed
        // TODO add your handling code here:
          txtAlienID.setText("");
            txtAlienNamn.setText("");
            txtAlienTelefon.setText("");
            txtAlienPlats.setText("");
            txtAlienAnsvarig.setText("");
            txtAlienID.requestFocus();
        
    }//GEN-LAST:event_buttonRensaDataActionPerformed

    private void buttonListaAliensActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonListaAliensActionPerformed
        // TODO add your handling code here:
        
        // Skippar en rad när koden körs. Måste komma förbi det på något sätt. Får fortsätta.. 
        // Borde man göra en tillfällig arraylist för att kunna loopa igenom den?
            try {
             
            String platsID = txtPlatsID.getText();
            String listaAliens = ("select Namn, Plats, Benamning from alien join plats on Plats_ID where Plats = ? group by Namn");

            statement = connection1.prepareStatement(listaAliens);
            statement.setString(1, platsID);
            statement.executeQuery();
            ResultSet rs = statement.executeQuery();
            JOptionPane.showMessageDialog(this, "listar nu:");
   
             if(rs.next() == false){
                 System.out.println("Inga Aliens på vald plats");
             }
             while(rs.next()){
                 
                String alienNamn = rs.getString("Namn");
                String alienPlats = rs.getString("Plats");
                String alienPlatsNamn = rs.getString("Benamning");
                JOptionPane.showMessageDialog(this, alienNamn + " " + alienPlats + " " + alienPlatsNamn);
                }
             }
                catch (SQLException ex) {
             Logger.getLogger(Registrering.class.getName()).log(Level.SEVERE, null, ex);
                 }
          
    }//GEN-LAST:event_buttonListaAliensActionPerformed

    private void txtPlatsIDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtPlatsIDActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtPlatsIDActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        String utrustningsID = txtUtrustning.getText();
        int villDuDelete = JOptionPane.showConfirmDialog(null, "Vill du ta bort vald utrustning?", 
                     "Warning", JOptionPane.YES_NO_OPTION);
             if(villDuDelete == JOptionPane.YES_OPTION){
             String taBortAlien = "delete from alien where Utrustnings_ID = ?";
             statement = connection1.prepareStatement(taBortAlien);
             statement.setInt(1, id);
             statement.executeUpdate();
             JOptionPane.showMessageDialog(this, "Alien Ã¤ndrad");
        
    }//GEN-LAST:event_jButton1ActionPerformed
       
    public static void main(String args[]) {
       
        java.awt.EventQueue.invokeLater(new Runnable() {
                public void run() {
                try {
                    new Registrering().setVisible(true);
                } catch (Exception ex) {
                    Logger.getLogger(Registrering.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton buttonAdd;
    private javax.swing.JButton buttonDelete;
    private javax.swing.JButton buttonEdit;
    private javax.swing.JButton buttonListaAliens;
    private javax.swing.JButton buttonListaAll;
    private javax.swing.JButton buttonRensaData;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField txtAlienAnsvarig;
    private javax.swing.JTextField txtAlienID;
    private javax.swing.JTextField txtAlienNamn;
    private javax.swing.JTextField txtAlienPlats;
    private javax.swing.JTextField txtAlienTelefon;
    private javax.swing.JTextField txtPlatsID;
    private javax.swing.JTextField txtUtrustning;
    // End of variables declaration//GEN-END:variables
}
