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
  
    public Registrering() throws Exception { // Körs igång direkt.
        initComponents();
        getConnection();
         
    }

    void getConnection() throws Exception{
        try{
        Class.forName("com.mysql.cj.jdbc.Driver"); // Tror den hämtar mysql driver och gör det möjligt att koppla upp till databasen.
             connection1 = DriverManager.getConnection("jdbc:mysql://localhost:3306/mibdb", "mibdba", "mibkey"); // Denna ska också på något sätt
             // koppa upp till databasen. Ingen kod är "röd" men osäker på om projektet inte funkar pga att jag är "disconnected" från databasen eller inte.
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
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        buttonListaAll = new javax.swing.JButton();

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

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(31, 31, 31)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(buttonAdd, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(buttonEdit, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(buttonDelete, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel6)
                            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel2)
                                .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                        .addGap(29, 29, 29)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtAlienNamn)
                            .addComponent(txtAlienTelefon, javax.swing.GroupLayout.DEFAULT_SIZE, 171, Short.MAX_VALUE)
                            .addComponent(txtAlienID)
                            .addComponent(txtAlienPlats)
                            .addComponent(txtAlienAnsvarig))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
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
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 49, Short.MAX_VALUE)
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

        buttonListaAll.setText("Lista alla aliens");
        buttonListaAll.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonListaAllActionPerformed(evt);
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
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(buttonListaAll, javax.swing.GroupLayout.PREFERRED_SIZE, 186, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 470, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(156, 156, 156)
                        .addComponent(jLabel1)))
                .addContainerGap(67, Short.MAX_VALUE))
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
                        .addGap(36, 36, 36)
                        .addComponent(buttonListaAll, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)))
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
        Vector v1 = new Vector(); // Vektor med varje alien-individs värden.
        
        for(int i=1 ; i<=kolumn ; i++){ 
        v1.add(rs.getString("Alien_ID")); // Hämtar första aliensID och sen 2:a osv.
        v1.add(rs.getString("Namn"));
        v1.add(rs.getString("Telefon"));
        v1.add(rs.getString("Plats"));
        v1.add(rs.getString("Ansvarig_Agent"));
        }
        
        df.addRow(v1); // Adderar/Listar varje alien-individs värde i tabellen
        
        }
        
        }
       
             catch (SQLException ex) {
                Logger.getLogger(Registrering.class.getName()).log(Level.SEVERE, null, ex);
            }
            
            
        }
 
    
    private void buttonAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonAddActionPerformed

        try {
            String StringID = txtAlienID.getText();// Får ej vara null
            int id = Integer.parseInt(StringID);
            String telefon = txtAlienTelefon.getText();
            String plats = txtAlienPlats.getText(); // Får ej vara null
            String namn = txtAlienNamn.getText(); 
            String ansvarig = txtAlienAnsvarig.getText(); // Får ej vara null
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
        // LISTA ALLA ALIENS (Bara namn) I LISTAN!!
        // Finns uppgifter om att lista aliens baserat på datum, plats mm.
        // Kanske kan fixas in här. att det dyker upp en ny ruta och man får välja
        // Hur man vill lista aliens.
        String listaAliens = "SELECT Namn from alien";
         try {
             createStatement = connection1.createStatement();
             ResultSet rs = createStatement.executeQuery(listaAliens);
             if(rs.next() == false){
                 System.out.println("Inga Aliens i listan.");
             }
             while(rs.next()){
                 
                String alienNamn = rs.getString("Namn");
                 System.out.println(alienNamn); 
            }
             }
         
         
             catch (SQLException ex) {
             Logger.getLogger(Registrering.class.getName()).log(Level.SEVERE, null, ex);
                 }
          
    }//GEN-LAST:event_buttonListaAllActionPerformed

    private void buttonDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonDeleteActionPerformed
        // Delete en alien vars id = ..
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
             JOptionPane.showMessageDialog(this, "Alien ändrad");
             table_update(); // Uppdaterar flödet. Kolla vad metoden gör.
             txtAlienID.setText("");
             txtAlienNamn.setText("");
             txtAlienTelefon.setText("");
             txtAlienPlats.setText("");
             txtAlienAnsvarig.setText("");
             txtAlienID.requestFocus(); // Fokus på vald textruta.
             } 
             if(villDuDelete == JOptionPane.NO_OPTION){
             JOptionPane.showMessageDialog(this, "Alien INTE ändrad");
             }
              
           
         } catch (SQLException ex) {
             Logger.getLogger(Registrering.class.getName()).log(Level.SEVERE, null, ex);
         }
         
    }//GEN-LAST:event_buttonDeleteActionPerformed

    private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseClicked
        // TODO add your handling code here:
        DefaultTableModel df = (DefaultTableModel) jTable1.getModel();
        int selectedIndex = jTable1.getSelectedRow();
        // Går för tillfället att ändra datan i Tabellen. Ska kolla upp
        // så att det inte är möjligt.
        
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
        if(!txtAlienID.getText().equals(alienID)){ //Om ID:t är annat än det angivna så körs detta:
        JOptionPane.showMessageDialog(this, "Du får inte ändra på ID:t, ID:t byts nu tillbaks!");
        txtAlienID.setText(alienID); // ID:t sätts tillbaka till det förvalda.
        }
        else
        {
         try {
             
            int id = Integer.parseInt(df.getValueAt(selectedIndex, 0).toString());
            String namn = txtAlienNamn.getText();
            String telefon = txtAlienTelefon.getText();
            String plats = txtAlienPlats.getText(); // Får ej vara null
            String ansvarig = txtAlienAnsvarig.getText(); // Får ej vara null
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
    private javax.swing.JButton buttonListaAll;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField txtAlienAnsvarig;
    private javax.swing.JTextField txtAlienID;
    private javax.swing.JTextField txtAlienNamn;
    private javax.swing.JTextField txtAlienPlats;
    private javax.swing.JTextField txtAlienTelefon;
    // End of variables declaration//GEN-END:variables
}
