package javaApplication1;

//import com.mysql.cj.jdbc.result.ResultSetMetaData;
//import java.sql.Statement;
//import java.sql.PreparedStatement;
import java.util.logging.Level;
import java.util.logging.Logger;
import oru.inf.InfException;
//import java.sql.Connection;
//import java.sql.SQLException;
//import java.sql.DriverManager;
//import javax.swing.JOptionPane;
//import java.sql.ResultSet;
import java.util.ArrayList;
//import java.util.Date;
import java.util.HashMap;
//import java.util.Vector;
//import javax.swing.table.DefaultTableModel;
import oru.inf.InfDB;

public class Hantera_Aliens extends javax.swing.JFrame {
   
     private static InfDB idb;
//        Connection connection1;
//        PreparedStatement statement;
//        Statement createStatement;
        static inloggningValidering vemArInloggad;
  
    public Hantera_Aliens(InfDB idb, inloggningValidering vemArInloggad){
        initComponents();
//        table_update();
        this.idb = idb;
        this.vemArInloggad = vemArInloggad;
         
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
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        txtAlienLosenord = new javax.swing.JTextField();
        txtAlienRegDatum = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        txtPlatsID = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        buttonListaAliens = new javax.swing.JButton();
        jLabel8 = new javax.swing.JLabel();
        txtUtrustning = new javax.swing.JTextField();
        buttonTaBortUtrustning = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jLabel11 = new javax.swing.JLabel();
        txtDatum1 = new javax.swing.JTextField();
        txtDatum2 = new javax.swing.JTextField();
        jLabel13 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        txtListaAliens = new javax.swing.JTextArea();
        btnListaAliens = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel1.setText("Hantera aliens");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addContainerGap(44, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1))
        );

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Hantering", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 14))); // NOI18N

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

        jLabel9.setText("Lösenord");

        jLabel10.setText("Reg.datum");

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
                            .addComponent(jLabel6)
                            .addComponent(jLabel9)
                            .addComponent(jLabel10))
                        .addGap(14, 14, 14)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtAlienNamn)
                            .addComponent(txtAlienTelefon, javax.swing.GroupLayout.DEFAULT_SIZE, 171, Short.MAX_VALUE)
                            .addComponent(txtAlienID)
                            .addComponent(txtAlienPlats)
                            .addComponent(txtAlienAnsvarig)
                            .addComponent(txtAlienLosenord)
                            .addComponent(txtAlienRegDatum)))
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
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(txtAlienLosenord, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel10)
                    .addComponent(txtAlienRegDatum, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 10, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(buttonRensaData)
                    .addComponent(buttonListaAll))
                .addGap(18, 18, 18)
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
                "AlienID", "Namn", "Telefon", "Plats", "Ansvarig", "Lösenord", "Reg.datum"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false
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

        jLabel7.setText("Lista aliens på plats, T.ex. Örebro, västerås:");

        buttonListaAliens.setText("Lista nu");
        buttonListaAliens.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonListaAliensActionPerformed(evt);
            }
        });

        jLabel8.setText("Ta bort utrustning med id:");

        buttonTaBortUtrustning.setText("Ta bort");
        buttonTaBortUtrustning.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonTaBortUtrustningActionPerformed(evt);
            }
        });

        jButton2.setText("Lista aliens");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jLabel11.setText("Aliens mellan datum:");

        jLabel13.setText("Ska ju såklart inte vara här.");

        txtListaAliens.setColumns(20);
        txtListaAliens.setRows(5);
        jScrollPane2.setViewportView(txtListaAliens);

        btnListaAliens.setText("Lista aliens");
        btnListaAliens.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnListaAliensActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 470, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel8)
                                        .addGap(14, 14, 14)
                                        .addComponent(txtUtrustning, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(buttonTaBortUtrustning, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(jLabel13))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel11)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(txtDatum1, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(txtDatum2, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jButton2))))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(19, 19, 19)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 260, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel7)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(txtPlatsID, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(btnListaAliens, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(buttonListaAliens, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(92, 92, 92)))))
                .addContainerGap(45, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(14, 14, 14)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 287, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(43, 43, 43)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(buttonTaBortUtrustning)
                                .addComponent(txtUtrustning, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel8))
                            .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel11)
                    .addComponent(txtDatum1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtDatum2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(28, 28, 28)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel7)
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnListaAliens, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtPlatsID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(buttonListaAliens))))
                .addGap(0, 147, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

//    private void table_update(){
//        int kolumn;
//        try{
//        statement = connection1.prepareStatement("SELECT * FROM alien");
//        ResultSet rs = statement.executeQuery();
//        ResultSetMetaData rss = (ResultSetMetaData) rs.getMetaData();
//        kolumn = rss.getColumnCount();
//        DefaultTableModel df = (DefaultTableModel) jTable1.getModel();
//        df.setRowCount(0);
//        while(rs.next()) // Listar alla aliens
//        {
//        Vector v1 = new Vector(); // Vektor med varje alien-individs vÃ¤rden.
//        
//        for(int i=1 ; i<=kolumn ; i++){ 
//        v1.add(rs.getString("Alien_ID")); 
//        v1.add(rs.getString("Namn"));
//        v1.add(rs.getString("Telefon"));
//        v1.add(rs.getString("Plats"));
//        v1.add(rs.getString("Ansvarig_Agent"));
//        v1.add(rs.getString("Losenord"));
//        v1.add(rs.getString("Registreringsdatum"));
//        }
//        
//        df.addRow(v1); // Adderar/Listar varje alien-individs vÃ¤rde i tabellen
//        
//        }
//        
//        }
//       
//             catch (SQLException ex) {
//                Logger.getLogger(Hantera_Aliens.class.getName()).log(Level.SEVERE, null, ex);
//            }
//            
//            
//        }
////    
////     public void listaAliensBaseratPaNamn(String alienNamn){
////     try {
////              
////           String Namn = txtAlienNamn.getText();
////           
////            String fraga1 = "SELECT Alien_ID, Namn from alien where Namn like '%?%'"; 
////           statement = connection1.prepareStatement(fraga1);
////            statement.setString(1, Namn);
////            ResultSet rs = statement.executeQuery();
////            
////            JOptionPane.showMessageDialog(this, "listar nu:");
////             if(rs.next() == false){
////                 System.out.println("Inga Aliens på vald plats");
////             }
////             do{
////               int ID = rs.getInt("Alien_ID");
////                String Namn1 = rs.getString("Namn");
////                JOptionPane.showMessageDialog(this, ID + " " + Namn1 );
////                }
////             while(rs.next());
////             }
////                catch (SQLException ex) {
////             Logger.getLogger(Hantera_Aliens.class.getName()).log(Level.SEVERE, null, ex);
////             System.out.println("något har blivit fel");
////                 }
////          
////    }
////     
////    public void listaAliensBaseratPaID(int alienID){
////             try {
////               String id = txtAlienID.getText();
////            int intID = Integer.parseInt(id);
////           
////            String fraga1 = "SELECT * from alien where Alien_ID = ?"; 
////            
////            statement = connection1.prepareStatement(fraga1);
////            statement.setInt(1, intID);
////            ResultSet rs = statement.executeQuery();
////            
////            JOptionPane.showMessageDialog(this, "listar nu:");
////             if(rs.next() == false){
////                 System.out.println("Inga Aliens på vald plats");
////             }
////             do{
////                 
////                int ID = rs.getInt("Alien_ID");
////                String alienNamn = rs.getString("Namn");
////                JOptionPane.showMessageDialog(this, ID + " " + alienNamn );
////                }
////             while(rs.next());
////             }
////                catch (SQLException ex) {
////             Logger.getLogger(Hantera_Aliens.class.getName()).log(Level.SEVERE, null, ex);
////             System.out.println("något har blivit fel");
////                 }
////          
////    }
////
    private void buttonAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonAddActionPerformed
//   
//        try {
//            String StringID = txtAlienID.getText();// FÃ¥r ej vara null
//            int id = Integer.parseInt(StringID);
//            String telefon = txtAlienTelefon.getText();
//            String plats = txtAlienPlats.getText(); // FÃ¥r ej vara null
//            String namn = txtAlienNamn.getText(); 
//            String ansvarig = txtAlienAnsvarig.getText(); // FÃ¥r ej vara null
//            String fraga = "INSERT INTO alien (Alien_ID, Namn, Telefon, Plats, Ansvarig_Agent) VALUES (?,?,?,?,?)";
//            
//            
//            statement = connection1.prepareStatement(fraga);
//            statement.setInt(1, id);
//            statement.setString(2, namn);
//            statement.setString(3, telefon);
//            statement.setString(4, plats);
//            statement.setString(5, ansvarig);
//            statement.execute();
//            JOptionPane.showMessageDialog(this, "Alien added");
//            table_update();
//           
//          
//         
//             } catch (SQLException ex) {
//                Logger.getLogger(Hantera_Aliens.class.getName()).log(Level.SEVERE, null, ex);
//            }
//             //
//             //
//             //
//             //
//             

       
    }//GEN-LAST:event_buttonAddActionPerformed

    private void txtAlienIDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtAlienIDActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtAlienIDActionPerformed

    private void buttonListaAllActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonListaAllActionPerformed
//     String alienID = txtAlienID.getText();
//       int intID = Integer.parseInt(alienID);
//       String alienNamn = txtAlienNamn.getText();
//        
//        if(!alienID.equals("")){
//        listaAliensBaseratPaID(intID);
//       }
//        
//       

//          Om alienIDtextFältet är tomt ska ett felmeddelande komma upp.
//        if(alienID.equals("")){
//        JOptionPane.showMessageDialog(this, "Var god välj ett ID/Namn att lista");
//        }
    }//GEN-LAST:event_buttonListaAllActionPerformed
    
    private void buttonDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonDeleteActionPerformed
//        // Delete en alien vars alien man trycker pÃ¥ i tabellen.
//        DefaultTableModel df = (DefaultTableModel) jTable1.getModel();
//        int selectedIndex = jTable1.getSelectedRow();
//         try {
//             int id = Integer.parseInt(df.getValueAt(selectedIndex, 0).toString());
//             int villDuDelete = JOptionPane.showConfirmDialog(null, "Vill du ta bort vald alien?", 
//                     "Warning", JOptionPane.YES_NO_OPTION);
//             if(villDuDelete == JOptionPane.YES_OPTION){
//             String taBortAlien = "delete from alien where Alien_ID = ?";
//             statement = connection1.prepareStatement(taBortAlien);
//             statement.setInt(1, id);
//             statement.executeUpdate();
//             JOptionPane.showMessageDialog(this, "Alien ändrad");
//             table_update(); // Uppdaterar flÃ¶det. Kolla vad metoden gÃ¶r.
//             txtAlienID.setText("");
//             txtAlienNamn.setText("");
//             txtAlienTelefon.setText("");
//             txtAlienPlats.setText("");
//             txtAlienAnsvarig.setText("");
//             txtAlienLosenord.setText("");
//             txtAlienRegDatum.setText("");
//             txtAlienID.requestFocus(); // Fokus pÃ¥ vald textruta.
//             } 
//             if(villDuDelete == JOptionPane.NO_OPTION){
//             JOptionPane.showMessageDialog(this, "Alien INTE ändrad");
//             }
//              
//           
//         } catch (SQLException ex) {
//             Logger.getLogger(Hantera_Aliens.class.getName()).log(Level.SEVERE, null, ex);
//         }
//         
    }//GEN-LAST:event_buttonDeleteActionPerformed

    private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseClicked
//        // TODO add your handling code here:
//        DefaultTableModel df = (DefaultTableModel) jTable1.getModel();
//        int selectedIndex = jTable1.getSelectedRow();
//        
//        
//        txtAlienID.setText(df.getValueAt(selectedIndex, 0).toString());
//        txtAlienNamn.setText(df.getValueAt(selectedIndex, 1).toString());
//        txtAlienTelefon.setText(df.getValueAt(selectedIndex, 2).toString());
//        txtAlienPlats.setText(df.getValueAt(selectedIndex, 3).toString());
//        txtAlienAnsvarig.setText(df.getValueAt(selectedIndex, 4).toString());
//        txtAlienLosenord.setText(df.getValueAt(selectedIndex, 5).toString());
//        txtAlienRegDatum.setText(df.getValueAt(selectedIndex, 6).toString());
//        
    }//GEN-LAST:event_jTable1MouseClicked

    private void buttonEditActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonEditActionPerformed
        // TODO add your handling code here:
//        DefaultTableModel df = (DefaultTableModel) jTable1.getModel();
//        int selectedIndex = jTable1.getSelectedRow();
//        String alienID = df.getValueAt(selectedIndex, 0).toString();
//        if(txtAlienID.getText().equals(alienID)){ 
//        JOptionPane.showMessageDialog(this, "Du får ej ändra på ID:t, det ändras nu tillbaka.");
//        txtAlienID.setText(alienID); // 
//        }
//        else
//        {
//         try {
//             
//            int id = Integer.parseInt(df.getValueAt(selectedIndex, 0).toString());
//            String namn = txtAlienNamn.getText();
//            String telefon = txtAlienTelefon.getText();
//            String plats = txtAlienPlats.getText(); 
//            String ansvarig = txtAlienAnsvarig.getText(); 
//            String losenord = txtAlienLosenord.getText();
//            String reg_datum = txtAlienRegDatum.getText();
//            String fraga = "UPDATE alien SET Namn = ?, Telefon = ?, "
//                    + "Plats = ?, Ansvarig_Agent = ?, Losenord = ?, Registreringsdatum = ? where Alien_ID = ? ";
//            statement = connection1.prepareStatement(fraga);
//           //  
//            statement.setString(1, namn);
//            statement.setString(2, telefon);
//            statement.setString(3, plats);
//            statement.setString(4, ansvarig);
//            statement.setString(5, losenord);
//            statement.setString(6, reg_datum);
//            statement.setInt(7, id);
//            statement.executeUpdate();
//            JOptionPane.showMessageDialog(this, "Alien CHANGED");
//            table_update();
//           
//            txtAlienID.setText("");
//            txtAlienNamn.setText("");
//            txtAlienTelefon.setText("");
//            txtAlienPlats.setText("");
//            txtAlienAnsvarig.setText("");
//            txtAlienLosenord.setText("");
//            txtAlienRegDatum.setText("");
//            txtAlienID.requestFocus();
//            
//         
//             } catch (SQLException ex) {
//                Logger.getLogger(Hantera_Aliens.class.getName()).log(Level.SEVERE, null, ex);
//            }
//        
//        }
    }//GEN-LAST:event_buttonEditActionPerformed

    private void buttonRensaDataActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonRensaDataActionPerformed
        // TODO add your handling code here:
          txtAlienID.setText("");
            txtAlienNamn.setText("");
            txtAlienTelefon.setText("");
            txtAlienPlats.setText("");
            txtAlienAnsvarig.setText("");
            txtAlienLosenord.setText("");
            txtAlienRegDatum.setText("");
            txtAlienID.requestFocus();
        
    }//GEN-LAST:event_buttonRensaDataActionPerformed

    private void buttonListaAliensActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonListaAliensActionPerformed
//        
//            try {
//             
//            String platsID = txtPlatsID.getText();
//            String listaAliens = ("select Namn, Plats, Benamning from alien join plats on Plats_ID where Plats = ? group by Namn");
//
//            statement = connection1.prepareStatement(listaAliens);
//            statement.setString(1, platsID);
//            statement.executeQuery();
//            ResultSet rs = statement.executeQuery();
//            JOptionPane.showMessageDialog(this, "listar nu:");
//   
//             if(rs.next() == false){
//                 System.out.println("Inga Aliens på vald plats");
//             }
//             do{
//                 
//                String alienNamn = rs.getString("Namn");
//                String alienPlats = rs.getString("Plats");
//                String alienPlatsNamn = rs.getString("Benamning");
//                JOptionPane.showMessageDialog(this, alienNamn + " " + alienPlats + " " + alienPlatsNamn);
//                }
//             while(rs.next());
//             
//             }
//                catch (SQLException ex) {
//             Logger.getLogger(Hantera_Aliens.class.getName()).log(Level.SEVERE, null, ex);
//                 }
          
    }//GEN-LAST:event_buttonListaAliensActionPerformed

    private void txtPlatsIDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtPlatsIDActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtPlatsIDActionPerformed

    private void buttonTaBortUtrustningActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonTaBortUtrustningActionPerformed
        // TODO add your handling code here:
       
//            try {
//                 String utrustningsID = txtUtrustning.getText();
//        int villDuDelete = JOptionPane.showConfirmDialog(null, "Vill du ta bort vald utrustning?", 
//                     "Warning", JOptionPane.YES_NO_OPTION);
//             if(villDuDelete == JOptionPane.YES_OPTION){
//                String fraga = "delete from alien where Utrustnings_ID = ?";
//                statement = connection1.prepareStatement(fraga);
//                statement.setString(1, utrustningsID);
//                statement.executeUpdate();
//                JOptionPane.showMessageDialog(this, "Utrustning borttagen.");
//                
//                if(villDuDelete == JOptionPane.NO_OPTION){
//             JOptionPane.showMessageDialog(this, "Utrustning INTE borttagen.");
//             }}}
//             catch (SQLException ex) {
//                Logger.getLogger(Hantera_Aliens.class.getName()).log(Level.SEVERE, null, ex);
//            }
//        
    }//GEN-LAST:event_buttonTaBortUtrustningActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
//        // TODO add your handling code here:
//        
//        try {
//             
//            String datum1 = txtDatum1.getText();
//            String datum2 = txtDatum2.getText();
//            String fraga = "Select Namn from alien where Registreringsdatum between ? and ?";
//            statement = connection1.prepareStatement(fraga);
//            statement.setString(1, datum1);
//            statement.setString(2, datum2);
//            statement.executeQuery();
//            ResultSet rs = statement.executeQuery();
//            JOptionPane.showMessageDialog(this, "listar nu:");
//   
//             if(rs.next() == false){
//                 System.out.println("Inga Aliens mellan " + datum1 + "-" + datum2);
//             }
//             do{
//                 
//                String alienNamn = rs.getString("Namn");
//                JOptionPane.showMessageDialog(this, alienNamn);
//                }
//             while(rs.next());
//             
//             } catch (SQLException ex) {
//             Logger.getLogger(Hantera_Aliens.class.getName()).log(Level.SEVERE, null, ex);
//         }
//        
    }//GEN-LAST:event_jButton2ActionPerformed

    private void btnListaAliensActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnListaAliensActionPerformed
        // TODO add your handling code here:
        
        txtListaAliens.setText("Här ska alien listas.");

        ArrayList<HashMap<String, String>> hittaAliens;

        try {
            String platsBenamning = txtPlatsID.getText();
            String fraga = "SELECT Namn FROM alien where plats = (SELECT Plats_ID from plats where Benamning = '" + platsBenamning + "')";
            hittaAliens = idb.fetchRows(fraga);

            for (HashMap<String, String> enAlien : hittaAliens) {
                txtListaAliens.append(enAlien.get("Namn") + "\n");

                if (hittaAliens == null || hittaAliens.contains(null)) {
                    txtListaAliens.setText("Inga aliens på platsen!");
                }
            }} catch (InfException ex) {
             Logger.getLogger(Hantera_Aliens.class.getName()).log(Level.SEVERE, null, ex);
         }
    }//GEN-LAST:event_btnListaAliensActionPerformed
       
   

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnListaAliens;
    private javax.swing.JButton buttonAdd;
    private javax.swing.JButton buttonDelete;
    private javax.swing.JButton buttonEdit;
    private javax.swing.JButton buttonListaAliens;
    private javax.swing.JButton buttonListaAll;
    private javax.swing.JButton buttonRensaData;
    private javax.swing.JButton buttonTaBortUtrustning;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField txtAlienAnsvarig;
    private javax.swing.JTextField txtAlienID;
    private javax.swing.JTextField txtAlienLosenord;
    private javax.swing.JTextField txtAlienNamn;
    private javax.swing.JTextField txtAlienPlats;
    private javax.swing.JTextField txtAlienRegDatum;
    private javax.swing.JTextField txtAlienTelefon;
    private javax.swing.JTextField txtDatum1;
    private javax.swing.JTextField txtDatum2;
    private javax.swing.JTextArea txtListaAliens;
    private javax.swing.JTextField txtPlatsID;
    private javax.swing.JTextField txtUtrustning;
    // End of variables declaration//GEN-END:variables
}
