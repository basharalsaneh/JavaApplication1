package javaApplication1;

import java.awt.Color;
import java.util.logging.Level;
import java.util.logging.Logger;
import oru.inf.InfException;
import java.util.ArrayList;
import java.util.HashMap;
import javax.swing.JOptionPane;
import oru.inf.InfDB;

public class Hantera_Aliens1 extends javax.swing.JFrame {

    private static InfDB idb;
    static inloggningValidering vemArInloggad;

    public Hantera_Aliens1(InfDB idb, inloggningValidering vemArInloggad) {
        initComponents();
        this.idb = idb;
        this.vemArInloggad = vemArInloggad;
        hamtaOmradesNamn();
        VisaAllaAliens();
        hamtaAgentssNamn();
        fyllValjaAlienID();

    }
    
    private void rensaAllaFält(){
        txtAlienNamn.setText(null);
        txtAlienTelefon.setText(null);
        txtAlienLosenord.setText(null);
        txtAlienRegDatum.setText(null);
        jOmrade.setSelectedIndex(0);
        jAgent.setSelectedIndex(0);
        jRas.setSelectedIndex(0);
        jAlienID.setSelectedIndex(0);
    }
    

            private void updateraAnsvarigAgent(String alienId) {
        try {
            

            String qAgent = "Update alien SET ansvarig_agent  ='" + jAgent.getSelectedItem() + "' WHERE alien_id = '" + alienId + "'";
            idb.update(qAgent);
            JOptionPane.showMessageDialog(null, "Din Ansvarig agent har ändrats!");

        } catch (InfException ex) {
                System.out.println("fel i systemet" + ex.getMessage());
            }

    }
    
    private void updateraOmrade(String alienId) {
        try {
            String fraga1 = "SElECT plats_id from plats WHERE benamning = '" + jOmrade.getSelectedItem() + "'";
            String OmradeID = idb.fetchSingle(fraga1);

            String fraga2 = "Update alien SET plats ='" + OmradeID + "' WHERE alien_id = '" + alienId + "'";
            idb.update(fraga2);
            JOptionPane.showMessageDialog(null, "Ditt ömråde har ändrats!");

        } catch (InfException ex) {
                System.out.println("fel i systemet" + ex.getMessage());
            }

    }
    
      private void UpdateraLosenord(String alienId) {
        try {
            
                String fraga = "UPDATE alien SET losenord = '" + txtAlienLosenord.getText() + "' WHERE alien_id = '" + alienId + "'";
                idb.update(fraga);
                JOptionPane.showMessageDialog(null, "Ditt lösenord har ändrats!");
            
        } catch (InfException ex) {
                System.out.println("fel i systemet" + ex.getMessage());
            }
    }
      
        private void updateraTelefon(String alienId) {
        try {
             
                String fraga = "UPDATE alien SET telefon = '" + txtAlienTelefon.getText() + "' WHERE alien_id = '" + alienId + "'";
                idb.update(fraga);
                JOptionPane.showMessageDialog(null, "Ditt telefonnummer har ändrats!");

                
        } catch (InfException ex) {
                System.out.println("fel i systemet" + ex.getMessage());
            }
    }
        
        private void UppdateraAliensNamn(String alienId) {

        try {
           
                String qName = "UPDATE alien SET namn = '" + txtAlienNamn.getText() + "' WHERE alien_id = '" + alienId + "'";
                idb.update(qName);
                JOptionPane.showMessageDialog(null, "Aliensnamn har ändrats!");

        } catch (InfException ex) {
                System.out.println("fel i systemet" + ex.getMessage());
            }
    }

        private void fyllValjaAlienID() {
        String fraga = "SELECT alien_id from alien order by alien_id";

        ArrayList<String> allaAliensID;

        try {

            allaAliensID = idb.fetchColumn(fraga);

            for (String namn : allaAliensID) {
                jAlienID.addItem(namn);
            }

        } catch (InfException ex) {
                System.out.println("fel i systemet" + ex.getMessage());
            }

    }
        
    public static String hamtaRas(String alienId) {

        String ras = "";
        try {
            String SquidFraga = "SELECT alien_id FROM squid WHERE alien_id = '" + alienId + "'";
            String Squid = idb.fetchSingle(SquidFraga);

            String BogloditeFraga = "SELECT alien_id FROM boglodite WHERE alien_id = '" + alienId + "'";
            String Boglodite = idb.fetchSingle(BogloditeFraga);

            String WormFraga = "SELECT alien_id FROM worm WHERE alien_id = '" + alienId + "'";
            String Worm = idb.fetchSingle(WormFraga);

            if (Squid != null) {
                ras = "Squid";
            } else if (Worm != null) {
                ras = "Worm";
            } else if (Boglodite != null) {
                ras = "Boglodite";
            }

        } catch (InfException ex) {
                System.out.println("fel i systemet" + ex.getMessage());
            }
        return ras;
    }

    private void hamtaOmradesNamn() {
        String fraga = "SELECT Benamning from omrade";

        ArrayList<String> allaAliensID;

        try {

            allaAliensID = idb.fetchColumn(fraga);

            for (String namn : allaAliensID) {
                jOmrade.addItem(namn);
            }

        } catch (InfException ex) {
                System.out.println("fel i systemet" + ex.getMessage());
            }

    }

    private void hamtaAgentssNamn() {
        String fraga = "SELECT namn from agent";

        ArrayList<String> allaAgentsNamn;

        try {

            allaAgentsNamn = idb.fetchColumn(fraga);

            for (String namn : allaAgentsNamn) {
                jAgent.addItem(namn);
            }

        } catch (InfException ex) {
                System.out.println("fel i systemet" + ex.getMessage());
            }

    }

    private String hamtaAgentsID() {
        String areaId = "";
        Object getListItem = jAgent.getSelectedItem();
        String Omrade = String.valueOf(getListItem);
        String fraga = "SELECT agent_id FROM agent WHERE namn = " + "'" + Omrade + "'";

        try {
            String getAreaId = idb.fetchSingle(fraga);
            areaId = getAreaId;

        } catch (InfException ex) {
                System.out.println("fel i systemet" + ex.getMessage());
            }
        return areaId;
    }

    private String hamtaOmradesID() {
        String OmradeID = "";
        Object hamtaValdeOmrade = jOmrade.getSelectedItem();
        String Omrade = String.valueOf(hamtaValdeOmrade);
        String fraga = "SELECT omrades_id FROM omrade WHERE benamning = " + "'" + Omrade + "'";

        try {
            String hamtaOmradeID = idb.fetchSingle(fraga);
            OmradeID = hamtaOmradeID;

        } catch (InfException ex) {
                System.out.println("fel i systemet" + ex.getMessage());
            }
        return OmradeID;
    }

    private void VisaAllaAliens() {

        ArrayList<HashMap<String, String>> allaAliens;

        try {
            String fraga = "SELECT * FROM alien order by alien_id";
            allaAliens = idb.fetchRows(fraga);

            for (HashMap<String, String> Alien : allaAliens) {
                
                jTextArea1.append(Alien.get("Alien_ID") + "\t");
                jTextArea1.append(" " + Alien.get("Namn") + "\t");
                jTextArea1.append(" " + Alien.get("Telefon") + "\t");
                jTextArea1.append(" " + Alien.get("Registreringsdatum") + "\t");
                jTextArea1.append(" " + Alien.get("Ansvarig_Agent") + "\t");
                jTextArea1.append(" " + Alien.get("Losenord") + "\t");
                jTextArea1.append(" " + Alien.get("Plats") + "\n");

            }
        } catch (InfException ex) {
                System.out.println("fel i systemet" + ex.getMessage());
            }

    }

    private int kollaVardet() {
        int hitta = 0;
        try {
            String qAlienId = "SELECT alien_id FROM alien WHERE alien_id = '" + txtAlien.getText() + "'";
            ArrayList<String> alienID = idb.fetchColumn(qAlienId);

            for (String element : alienID) {
                hitta++;
            }
        } catch (InfException ex) {
                System.out.println("fel i systemet" + ex.getMessage());
            }
        return hitta;

    }

    private String hamtaNyAliensID() {
        int sistaID = 0;
        String nyID = "";

        try {
            String fraga = "SELECT Alien_ID FROM Alien";
            ArrayList<String> result = idb.fetchColumn(fraga);
            int[] integerResultat = new int[result.size()];

            for (int i = 0; i < result.size(); i++) {
                integerResultat[i] = Integer.parseInt(result.get(i));
            }
            for (int objekt : integerResultat) {
                if (objekt >= sistaID) {
                    sistaID = objekt;
                }
            }
            int newIdInt = sistaID + 1;
            nyID = String.valueOf(newIdInt);

        } catch (InfException ex) {
                System.out.println("fel i systemet" + ex.getMessage());
            }
        return nyID;
    }

    private String hamtaOmradeID() {
        String platsID = "";
        Object hamtaListaObjekt = jOmrade.getSelectedItem();

        String omrade = String.valueOf(hamtaListaObjekt);
        String fraga = "SELECT omrades_id FROM omrade WHERE benamning = " + "'" + omrade + "'";
        try {
            String omradeID = idb.fetchSingle(fraga);
            platsID = omradeID;

        } catch (InfException ex) {
                System.out.println("fel i systemet" + ex.getMessage());
            }
        return platsID;
    }

    private String hamtaAlienID() {
        String alienId = "";
        try {
            String qAlienId = "SELECT alien_id FROM alien WHERE  alien_id = '" + txtAlien.getText() + "'";
            String AlienID = idb.fetchSingle(qAlienId);
            if (AlienID != null) {
                alienId = AlienID;
            }

        } catch (InfException ex) {
            System.out.println("Internt felmeddelande" + ex.getMessage());
        } catch (Exception ex) {
            System.out.println("fel i systemet" + ex.getMessage());
        }
        return alienId;
    }

    private void TaBortBoglodite() {
        String alienID = hamtaAlienID();
        try {
            String fraga1 = "DELETE FROM alien WHERE alien_id = '" + alienID + "'";
            idb.delete(fraga1);
            String fraga2 = "DELETE FROM boglodite WHERE alien_id = '" + alienID + "'";
            idb.delete(fraga2);

        } catch (InfException ex) {
            System.out.println("Internt felmeddelande" + ex.getMessage());
        } catch (Exception ex) {
            System.out.println("fel i systemet" + ex.getMessage());
        }
    }

    private void TaBortSquid() {
        String alienID = hamtaAlienID();
        try {
            String fraga1 = "DELETE FROM alien WHERE alien_id = '" + alienID + "'";
            idb.delete(fraga1);
            String fraga2 = "DELETE FROM squid WHERE alien_id = '" + alienID + "'";
            idb.delete(fraga2);

        } catch (InfException ex) {
                System.out.println("fel i systemet" + ex.getMessage());
            }
    }

    private void TaBortWorm() {
        String alienId = hamtaAlienID();
        try {
            String fraga1 = "DELETE FROM alien WHERE alien_id = '" + alienId + "'";
            idb.delete(fraga1);
            String fraga2 = "DELETE FROM worm WHERE alien_id = '" + alienId + "'";
            idb.delete(fraga2);

        } catch (InfException ex) {
                System.out.println("fel i systemet" + ex.getMessage());
            }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        txtAlienNamn = new javax.swing.JTextField();
        txtAlienTelefon = new javax.swing.JTextField();
        buttonEdit = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        buttonRensaData = new javax.swing.JButton();
        buttonListaAll = new javax.swing.JButton();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        txtAlienLosenord = new javax.swing.JTextField();
        txtAlienRegDatum = new javax.swing.JTextField();
        jOmrade = new javax.swing.JComboBox<>();
        jAgent = new javax.swing.JComboBox<>();
        jAlienID = new javax.swing.JComboBox<>();
        jLabel2 = new javax.swing.JLabel();
        jRas = new javax.swing.JComboBox<>();
        jLabel13 = new javax.swing.JLabel();
        txtPlatsID = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        buttonListaAliens = new javax.swing.JButton();
        jLabel8 = new javax.swing.JLabel();
        txtAlien = new javax.swing.JTextField();
        buttonTaBortUtrustning = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jLabel11 = new javax.swing.JLabel();
        txtDatum1 = new javax.swing.JTextField();
        txtDatum2 = new javax.swing.JTextField();
        jScrollPane2 = new javax.swing.JScrollPane();
        txtListaAliens = new javax.swing.JTextArea();
        btnListaAliens = new javax.swing.JButton();
        jLabel12 = new javax.swing.JLabel();
        jAlienID1 = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jScrollPane5 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jScrollPane6 = new javax.swing.JScrollPane();
        AlienInfo = new javax.swing.JTextArea();

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

        jLabel3.setText("Namn");

        jLabel4.setText("Telefon");

        buttonEdit.setText("Uppdatera");
        buttonEdit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonEditActionPerformed(evt);
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

        buttonListaAll.setText("Lägga till");
        buttonListaAll.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonListaAllActionPerformed(evt);
            }
        });

        jLabel9.setText("Lösenord");

        jLabel10.setText("Reg.datum");

        jOmrade.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Välja" }));
        jOmrade.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jOmradeActionPerformed(evt);
            }
        });

        jAgent.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Välja" }));
        jAgent.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jAgentActionPerformed(evt);
            }
        });

        jAlienID.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Ny" }));
        jAlienID.addPopupMenuListener(new javax.swing.event.PopupMenuListener() {
            public void popupMenuCanceled(javax.swing.event.PopupMenuEvent evt) {
            }
            public void popupMenuWillBecomeInvisible(javax.swing.event.PopupMenuEvent evt) {
                jAlienIDPopupMenuWillBecomeInvisible(evt);
            }
            public void popupMenuWillBecomeVisible(javax.swing.event.PopupMenuEvent evt) {
            }
        });
        jAlienID.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jAlienIDActionPerformed(evt);
            }
        });

        jLabel2.setText("Alien ID");

        jRas.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Okänd", "Worm", "Squid", "Boglodite", " " }));

        jLabel13.setText("Ras:");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(buttonRensaData)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(buttonEdit, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(buttonListaAll))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(38, 38, 38)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addComponent(jLabel6)
                            .addComponent(jLabel9)
                            .addComponent(jLabel10)
                            .addComponent(jLabel2)
                            .addComponent(jLabel13))
                        .addGap(14, 14, 14)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jRas, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jAlienID, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(txtAlienNamn)
                            .addComponent(txtAlienTelefon, javax.swing.GroupLayout.DEFAULT_SIZE, 171, Short.MAX_VALUE)
                            .addComponent(txtAlienLosenord)
                            .addComponent(txtAlienRegDatum)
                            .addComponent(jOmrade, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jAgent, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(11, 11, 11)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jAlienID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtAlienNamn, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3))
                .addGap(12, 12, 12)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(txtAlienTelefon, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jOmrade, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(jAgent, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(2, 2, 2)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jRas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel13))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
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
                    .addComponent(buttonListaAll)
                    .addComponent(buttonEdit))
                .addGap(21, 21, 21))
        );

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

        jLabel8.setText("Ta bort alien med ID:");

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

        txtListaAliens.setColumns(20);
        txtListaAliens.setRows(5);
        jScrollPane2.setViewportView(txtListaAliens);

        btnListaAliens.setText("Lista aliens");
        btnListaAliens.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnListaAliensActionPerformed(evt);
            }
        });

        jLabel12.setText("Visa upp alien med ID:");

        jButton1.setText("Visa");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jTextArea1.setColumns(20);
        jTextArea1.setRows(5);
        jScrollPane5.setViewportView(jTextArea1);

        AlienInfo.setColumns(20);
        AlienInfo.setRows(5);
        jScrollPane6.setViewportView(AlienInfo);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addGroup(layout.createSequentialGroup()
                            .addGap(19, 19, 19)
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 260, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(buttonListaAliens, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGroup(layout.createSequentialGroup()
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jLabel7)
                                        .addGroup(layout.createSequentialGroup()
                                            .addComponent(txtPlatsID, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                            .addComponent(btnListaAliens, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                    .addGap(0, 0, Short.MAX_VALUE))))
                        .addGroup(layout.createSequentialGroup()
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(layout.createSequentialGroup()
                                    .addGap(368, 368, 368)
                                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(layout.createSequentialGroup()
                                    .addGap(12, 12, 12)
                                    .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(layout.createSequentialGroup()
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                            .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 458, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                            .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGroup(layout.createSequentialGroup()
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addGroup(layout.createSequentialGroup()
                                                    .addComponent(jLabel8)
                                                    .addGap(38, 38, 38)
                                                    .addComponent(txtAlien, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                    .addGap(33, 33, 33)
                                                    .addComponent(buttonTaBortUtrustning, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                                    .addComponent(jScrollPane6, javax.swing.GroupLayout.Alignment.LEADING)
                                                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                                        .addComponent(jLabel12)
                                                        .addGap(29, 29, 29)
                                                        .addComponent(jAlienID1, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                        .addComponent(jButton1))))))))
                            .addGap(427, 427, 427)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(27, 27, 27)
                        .addComponent(jLabel11)
                        .addGap(18, 18, 18)
                        .addComponent(txtDatum1, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(txtDatum2, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jButton2)))
                .addContainerGap(263, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 195, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel8)
                                    .addComponent(txtAlien, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(buttonTaBortUtrustning)))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(43, 43, 43)
                                .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane6, javax.swing.GroupLayout.PREFERRED_SIZE, 168, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel12)
                    .addComponent(jAlienID1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton1))
                .addGap(77, 77, 77)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtDatum1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel11)
                    .addComponent(txtDatum2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jLabel7)
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtPlatsID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnListaAliens, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(8, 8, 8)
                        .addComponent(buttonListaAliens)))
                .addGap(4, 4, 4))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents


    private void buttonListaAllActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonListaAllActionPerformed

jTextArea1.setText("");


        if (Validering.personFinns(txtAlienNamn)
                && Validering.kontrollForComboBox(jOmrade, "Ange område")) {

            HashMap<String, String> nyregistreradAlien;

            try {
                String namn = txtAlienNamn.getText(); // FÃ¥r ej vara null
                String telefon = txtAlienTelefon.getText();
                String datum = txtAlienRegDatum.getText();    // FÃ¥r ej vara null
                String losenord = txtAlienLosenord.getText();
                String nyAlien = "INSERT INTO alien (alien_id, namn, telefon, registreringsdatum, Ansvarig_Agent,losenord, plats)\n"
                        + "VALUES (" + hamtaNyAliensID() + ", "
                        + "'" + namn + "'" + ", "
                        + "'" + telefon + "'" + ", "
                        + "'" + datum + "'" + ", "
                        + "'" + hamtaAgentsID() + "'" + ", "
                        + "'" + losenord + "'" + ", "
                        + "'" + hamtaOmradeID() + "'" + ")";

                idb.insert(nyAlien);

                JOptionPane.showMessageDialog(this, "Alien registrerad");
                jTextArea1.setText("");
               
                //VisaAllaAliens();

            } catch (InfException ex) {
                System.out.println("fel i systemet" + ex.getMessage());
            }
        }

    }//GEN-LAST:event_buttonListaAllActionPerformed

    private void buttonEditActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonEditActionPerformed
        int hitta = 0;

        if (Validering.kontrollForComboBox(jAlienID)) {
            if (txtAlienNamn.getText().isEmpty() && txtAlienTelefon.getText().isEmpty()
                    && txtAlienLosenord.getText().isEmpty()
                    && jOmrade.getSelectedItem().equals("Välja")
                    && jAgent.getSelectedItem().equals("Välja")){
                JOptionPane.showMessageDialog(null, "Du glömde fylla alla rutor");
            } else {
                //Lägg till metodanrop som hämtar id och gör kollen för "flera med samma namn" istället. 
                try {
                    String qAlienId = "SELECT alien_id FROM alien WHERE alien_id = '" + jAlienID.getSelectedItem() + "'";
                    ArrayList<String> AllaAlienID = idb.fetchColumn(qAlienId);
                    String alienId = idb.fetchSingle(qAlienId);

                    for (String element : AllaAlienID) {
                        hitta++;
                    }

                    if (alienId == null) {
                        JOptionPane.showMessageDialog(null, "Alien namnet finns inte registrerat");

                    } else {

                        if (!txtAlienNamn.getText().isEmpty()) {
                            UppdateraAliensNamn(alienId);
                        }
                        if (!txtAlienTelefon.getText().isEmpty()) {
                            updateraTelefon(alienId);
                        }
                        if (!txtAlienLosenord.getText().isEmpty()) {
                            UpdateraLosenord(alienId);
                        }
                        if (!jOmrade.getSelectedItem().equals("Välja")) {
                            updateraOmrade(alienId);
                        }
                        if (!jAgent.getSelectedItem().equals("Välja")) {
                            updateraAnsvarigAgent(alienId);
                        }
                        
                       
                        AlienInfo.setText(alienId);
                    }

                } catch (InfException ex) {
                System.out.println("fel i systemet" + ex.getMessage());
            }

            }
        }
    }//GEN-LAST:event_buttonEditActionPerformed

    private void buttonRensaDataActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonRensaDataActionPerformed
    rensaAllaFält();
    }//GEN-LAST:event_buttonRensaDataActionPerformed

    private void buttonListaAliensActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonListaAliensActionPerformed


    }//GEN-LAST:event_buttonListaAliensActionPerformed

    private void txtPlatsIDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtPlatsIDActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtPlatsIDActionPerformed

    private void buttonTaBortUtrustningActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonTaBortUtrustningActionPerformed
        // TODO add your handling code here:
        if (Validering.personFinns(txtAlien, "Du glömde ange alien ID")) {
            if (hamtaAlienID().equals("")) {
                JOptionPane.showMessageDialog(null, "Den finns inte i listan! Vänligen välja ett annat ID!");

            } else {
                String ras = hamtaRas(hamtaAlienID());
                if (ras.equals("Squid")) {
                    TaBortSquid();
                } else if (ras.equals("Worm")) {
                    TaBortWorm();
                } else if (ras.equals("Boglodite")) {
                    TaBortBoglodite();
                }

                JOptionPane.showMessageDialog(null, "Alien har tagits bort från listan!");
            }
        }

    }//GEN-LAST:event_buttonTaBortUtrustningActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed

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
            }
        } catch (InfException ex) {
                System.out.println("fel i systemet" + ex.getMessage());
            }
    }//GEN-LAST:event_btnListaAliensActionPerformed

    private void jAgentActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jAgentActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jAgentActionPerformed

    private void jOmradeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jOmradeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jOmradeActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
    AlienInfo.setText("");
   if (Validering.personFinns(jAlienID1, "Du glömde ange alien id")) {
            try {
                String fraga1 = "SELECT alien_id FROM alien WHERE alien_ID = '" + jAlienID1.getText() + "'";
                String alienId = idb.fetchSingle(fraga1);
                
                if (alienId == null) {
                    JOptionPane.showMessageDialog(null, "Alien id finns inte!");
                } else {
                    AlienInfo.append("Alien ID: " + alienId + "\n");

                    String fraga2 = "SELECT namn, telefon, registreringsdatum FROM alien WHERE alien_id = '" + alienId + "'";
                    HashMap<String, String> alienInfo = idb.fetchRow(fraga2);
                    AlienInfo.append("Namnet: " + alienInfo.get("namn") + "\n");
                    AlienInfo.append("Telefonnummer: " + alienInfo.get("telefon") + "\n");
                    AlienInfo.append("Regestreringsdatum: " + alienInfo.get("registreringsdatum") + "\n");

                    String fraga3 = "SELECT benamning FROM plats "
                                       + "JOIN alien ON plats.plats_id = alien.plats "
                                       + "WHERE alien_id = '" + alienId + "'";
                    String alienPlats = idb.fetchSingle(fraga3);
                    
                    String fraga4 = "SELECT omrade.benamning FROM omrade "
                                        + "JOIN plats ON omrade.omrades_id = plats.finns_i "
                                        + "WHERE plats.benamning = '" + alienPlats + "'";
                    String alienOmrade = idb.fetchSingle(fraga4);
                    
                    AlienInfo.append("Finns i: " + alienPlats + " (" + alienOmrade + ")" + "\n");

                    String fraga5 = "SELECT agent.namn FROM agent "
                                          + "JOIN alien ON agent.agent_id = alien.ansvarig_agent "
                                          + "WHERE alien_id = '" + alienId + "'";
                    String fraga6 = idb.fetchSingle(fraga5);
                    AlienInfo.append("Ansvarig Agent är: " + fraga6 + "\n");

                }
                    
            } catch (InfException ex) {
                System.out.println("fel i systemet" + ex.getMessage());
            }
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jAlienIDPopupMenuWillBecomeInvisible(javax.swing.event.PopupMenuEvent evt) {//GEN-FIRST:event_jAlienIDPopupMenuWillBecomeInvisible
        // TODO add your handling code here:
    
    try{
                    String fraga2 = "SELECT namn, telefon, registreringsdatum, losenord FROM alien WHERE alien_id = '" + jAlienID.getSelectedItem() + "'";
                    HashMap<String, String> alienInfo = idb.fetchRow(fraga2);
                    txtAlienNamn.setText(alienInfo.get("namn"));
                    txtAlienTelefon.setText(alienInfo.get("telefon"));
                    txtAlienRegDatum.setText(alienInfo.get("registreringsdatum"));  
                    txtAlienLosenord.setText(alienInfo.get("losenord"));

    } catch (InfException ex) {
                System.out.println("fel i systemet" + ex.getMessage());
            }
    
    
    }//GEN-LAST:event_jAlienIDPopupMenuWillBecomeInvisible

    private void jAlienIDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jAlienIDActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jAlienIDActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextArea AlienInfo;
    private javax.swing.JButton btnListaAliens;
    private javax.swing.JButton buttonEdit;
    private javax.swing.JButton buttonListaAliens;
    private javax.swing.JButton buttonListaAll;
    private javax.swing.JButton buttonRensaData;
    private javax.swing.JButton buttonTaBortUtrustning;
    private javax.swing.JComboBox<String> jAgent;
    private javax.swing.JComboBox<String> jAlienID;
    private javax.swing.JTextField jAlienID1;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JComboBox<String> jOmrade;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JComboBox<String> jRas;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTable jTable2;
    private javax.swing.JTextArea jTextArea1;
    private javax.swing.JTextField txtAlien;
    private javax.swing.JTextField txtAlienLosenord;
    private javax.swing.JTextField txtAlienNamn;
    private javax.swing.JTextField txtAlienRegDatum;
    private javax.swing.JTextField txtAlienTelefon;
    private javax.swing.JTextField txtDatum1;
    private javax.swing.JTextField txtDatum2;
    private javax.swing.JTextArea txtListaAliens;
    private javax.swing.JTextField txtPlatsID;
    // End of variables declaration//GEN-END:variables
}
