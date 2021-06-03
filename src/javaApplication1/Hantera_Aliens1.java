package javaApplication1;

import com.mysql.cj.util.StringUtils;
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
    static Validering vemArInloggad;

    public Hantera_Aliens1(InfDB idb, Validering vemArInloggad) {
        initComponents();
        this.setLocationRelativeTo(null);
        this.idb = idb;
        this.vemArInloggad = vemArInloggad;
        VisaAllaAliens();
        hamtaAgentssNamn();
        fyllValjaAlienID();
        listaRas();
        txtRaceSpecial.setVisible(false);
        lblRaceSpecial.setVisible(false);
        hamtaAliensPlatser();
    }

    private int visaKontroll() {
        int hitta = 0;
        try {
            String fraga = "SELECT alien_id FROM alien WHERE namn = '" + jAlienID1.getText() + "' OR alien_id = '" + jAlienID1.getText() + "'";
            ArrayList<String> alienIdList = idb.fetchColumn(fraga);

            for (String element : alienIdList) {
                hitta++;
            }
        } catch (InfException ex) {
            System.out.println("fel i databas" + ex.getMessage());
        }
        return hitta;

    }

    private void hanteraBoglodite(String alienId) {

        String valdeRas = hamtaRas(alienId);
        try {
            lblRaceSpecial.setText("Ange antal boogies: ");
            if (txtRaceSpecial.getText().isEmpty()) {
                JOptionPane.showMessageDialog(null, "Du glömde ange antal boogies!");

            } else {
                if (valdeRas != "Välja") {
                    String fraga1 = "DELETE FROM " + valdeRas + " WHERE alien_id = '" + alienId + "'";
                    idb.delete(fraga1);
                }
                if (Validering.SiffrorKontroll(txtRaceSpecial, "Antal boogies måste anges i siffror!")) {
                    String fraga2 = "INSERT INTO Boglodite VALUES (" + alienId + "," + txtRaceSpecial.getText() + ")";
                    idb.insert(fraga2);
                }
            }

        } catch (InfException ex) {
            System.out.println("fel i databas" + ex.getMessage());
        }
    }

    private void hanteraSquid(String alienId) {
        String valdeRas = hamtaRas(alienId);
        try {

            lblRaceSpecial.setText("Ange antal armar: ");
            if (txtRaceSpecial.getText().isEmpty()) {
                JOptionPane.showMessageDialog(null, "Du glömde ange antal armar!");

            } else {
                if (valdeRas != "Välja") {
                    String fraga1 = "DELETE FROM " + valdeRas + " WHERE alien_id = '" + alienId + "'";
                    idb.delete(fraga1);
                }
                if (Validering.SiffrorKontroll(txtRaceSpecial, "Antal armar måste anges i siffror!")) {
                    String fraga2 = "INSERT INTO Squid VALUES (" + alienId + "," + txtRaceSpecial.getText() + ")";
                    idb.insert(fraga2);
                }
            }

        } catch (InfException ex) {
            System.out.println("fel i databas" + ex.getMessage());
        }
    }

    private void hanteraWorm(String alienId) {
        String valdeRas = hamtaRas(alienId);
        try {

            if (valdeRas != "Välja") {
                String fraga1 = "DELETE FROM " + valdeRas + " WHERE alien_id = '" + alienId + "'";
                idb.delete(fraga1);
            }
            String fraga2 = "INSERT INTO Worm VALUES (" + alienId + ")";
            idb.insert(fraga2);

        } catch (InfException ex) {
            System.out.println("fel i databas" + ex.getMessage());
        }
    }

    private void rensaAllaFält() {
        txtAlienNamn.setText(null);
        txtAlienTelefon.setText(null);
        txtAlienLosenord.setText(null);
        txtAlienRegDatum.setText(null);
        jPlats.setSelectedIndex(0);
        jAgent.setSelectedIndex(0);
        jRas.setSelectedIndex(0);
        jAlienID.setSelectedIndex(0);
    }

    private void updateraAnsvarigAgent(String alienId) {
        try {
            String fraga1 = "SElECT agent_id from agent WHERE namn = '" + jAgent.getSelectedItem() + "'";
            String agent = idb.fetchSingle(fraga1);

            String qAgent = "Update alien SET ansvarig_agent  ='" + agent + "' WHERE alien_id = '" + alienId + "'";
            idb.update(qAgent);
            JOptionPane.showMessageDialog(null, "Din Ansvarig agent har ändrats!");

        } catch (InfException ex) {
            System.out.println("fel i databas" + ex.getMessage());
        }

    }

    private void updateraPlats(String alienId) {
        try {
            String fraga1 = "SElECT plats_id from plats WHERE benamning = '" + jPlats.getSelectedItem() + "'";
            String OmradeID = idb.fetchSingle(fraga1);

            String fraga2 = "Update alien SET plats ='" + OmradeID + "' WHERE alien_id = '" + alienId + "'";
            idb.update(fraga2);
            JOptionPane.showMessageDialog(null, "Ditt ömråde har ändrats!");

        } catch (InfException ex) {
            System.out.println("fel i databas" + ex.getMessage());
        }

    }

    private void UpdateraLosenord(String alienId) {
        try {

            String fraga = "UPDATE alien SET losenord = '" + txtAlienLosenord.getText() + "' WHERE alien_id = '" + alienId + "'";
            idb.update(fraga);
            JOptionPane.showMessageDialog(null, "Ditt lösenord har ändrats!");

        } catch (InfException ex) {
            System.out.println("fel i databas" + ex.getMessage());
        }
    }

    private void updateraTelefon(String alienId) {
        try {

            String fraga = "UPDATE alien SET telefon = '" + txtAlienTelefon.getText() + "' WHERE alien_id = '" + alienId + "'";
            idb.update(fraga);
            JOptionPane.showMessageDialog(null, "Ditt telefonnummer har ändrats!");

        } catch (InfException ex) {
            System.out.println("fel i databas" + ex.getMessage());
        }
    }

    private void UppdateraAliensNamn(String alienId) {

        try {

            String qName = "UPDATE alien SET namn = '" + txtAlienNamn.getText() + "' WHERE alien_id = '" + alienId + "'";
            idb.update(qName);
            JOptionPane.showMessageDialog(null, "Aliensnamn har ändrats!");

        } catch (InfException ex) {
            System.out.println("fel i databas" + ex.getMessage());
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
            System.out.println("fel i databas" + ex.getMessage());
        }

    }

    private void listaRas() {

        ArrayList<String> Raslista = new ArrayList<String>();
        Raslista.add("Välja");
        Raslista.add("Boglodite");
        Raslista.add("Worm");
        Raslista.add("Squid");

        for (String element : Raslista) {
            jRas.addItem(element);
            //jListaRas.addItem(element);
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
            System.out.println("fel i databas" + ex.getMessage());
        }
        return ras;
    }

    private void hamtaAliensPlatser() {

        try {
            String query = "SELECT benamning FROM plats";
            ArrayList<String> listLocations = idb.fetchColumn(query);

            for (String element : listLocations) {

                jAlienPlats.addItem(element);
                jPlats.addItem(element);

            }
        } catch (InfException ex) {
            System.out.println("fel i databas" + ex.getMessage());
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
            System.out.println("fel i databas" + ex.getMessage());
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
            System.out.println("fel i databas" + ex.getMessage());
        }
        return areaId;
    }

    private String hamtaRasSpecifikation() {
        String raceSpecial = txtRaceSpecial.getText();

        return raceSpecial;
    }

    private void VisaAllaAliens() {

        ArrayList<HashMap<String, String>> allaAliens;

        try {
            String fraga = "SELECT * FROM alien "
                    + "order by alien_id ";
            allaAliens = idb.fetchRows(fraga);

            jTextArea1.append("ID \t Namn \t Telefon\t Reg.datum\t Ans_Agent\t Losenord\t Plats\n "
                    + "--\t-----\t----------\t----------\t----------\t--------\t-----\n");

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
            System.out.println("fel i databas" + ex.getMessage());
        }

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
            System.out.println("fel i databas" + ex.getMessage());
        }
        return nyID;
    }

    private String hamtaplatsID() {
        String platsID = "";
        Object hamtaListaObjekt = jPlats.getSelectedItem();
        String plats = String.valueOf(hamtaListaObjekt);

        String fraga = "SELECT plats_id FROM plats WHERE benamning = " + "'" + plats + "'";
        try {
            String omradeID = idb.fetchSingle(fraga);
            platsID = omradeID;

        } catch (InfException ex) {
            System.out.println("fel i databas" + ex.getMessage());
        }
        return platsID;
    }

    private String hamtaAlienID() {
        String alienId = "";
        try {
            String fraga = "SELECT alien_id FROM alien WHERE namn = '" + txtAlien.getText() + "' OR alien_id = '" + txtAlien.getText() + "'";
            String resultAlienId = idb.fetchSingle(fraga);
            if (resultAlienId != null) {
                alienId = resultAlienId;
            }

        } catch (InfException ex) {
            System.out.println("fel i databas" + ex.getMessage());
        } catch (Exception ex) {
            System.out.println("Random fel" + ex.getMessage());
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
            System.out.println("fel i databas" + ex.getMessage());
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
            System.out.println("fel i databas" + ex.getMessage());
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
            System.out.println("fel i databas" + ex.getMessage());
        }
    }

    private int kontrolleraNamnochID() {
        int hitta = 0;
        try {
            String fraga = "SELECT alien_id FROM alien WHERE namn = '" + txtAlien.getText() + "' OR alien_id = '" + txtAlien.getText() + "'";
            ArrayList<String> alienIdList = idb.fetchColumn(fraga);

            for (String element : alienIdList) {
                hitta++;
            }
        } catch (InfException ex) {
            System.out.println("fel i databas" + ex.getMessage());
        }
        return hitta;

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
        jPlats = new javax.swing.JComboBox<>();
        jAgent = new javax.swing.JComboBox<>();
        jAlienID = new javax.swing.JComboBox<>();
        jLabel2 = new javax.swing.JLabel();
        jRas = new javax.swing.JComboBox<>();
        jLabel13 = new javax.swing.JLabel();
        lblRaceSpecial = new javax.swing.JLabel();
        txtRaceSpecial = new javax.swing.JTextField();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        txtAlien = new javax.swing.JTextField();
        buttonTaBortUtrustning = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jLabel11 = new javax.swing.JLabel();
        txtDatum1 = new javax.swing.JTextField();
        txtDatum2 = new javax.swing.JTextField();
        jScrollPane2 = new javax.swing.JScrollPane();
        txtListaAliens = new javax.swing.JTextArea();
        jLabel12 = new javax.swing.JLabel();
        jAlienID1 = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jScrollPane5 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jScrollPane6 = new javax.swing.JScrollPane();
        AlienInfo = new javax.swing.JTextArea();
        jButton3 = new javax.swing.JButton();
        jLabel17 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        jAlienPlats = new javax.swing.JComboBox<>();
        jLabel19 = new javax.swing.JLabel();
        jListaRas = new javax.swing.JComboBox<>();

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

        jLabel3.setText("Namn:");

        jLabel4.setText("Telefon:");

        buttonEdit.setText("Uppdatera");
        buttonEdit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonEditActionPerformed(evt);
            }
        });

        jLabel5.setText("Plats:");

        jLabel6.setText("Ansvarig:");

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

        jLabel9.setText("Lösenord:");

        jLabel10.setText("Reg.datum:");

        txtAlienLosenord.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtAlienLosenordActionPerformed(evt);
            }
        });

        jPlats.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Välja" }));
        jPlats.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jPlatsActionPerformed(evt);
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

        jLabel2.setText("Alien ID:");

        jRas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRasActionPerformed(evt);
            }
        });

        jLabel13.setText("Ras:");

        jLabel15.setFont(new java.awt.Font("Lucida Grande", 0, 8)); // NOI18N
        jLabel15.setText("ÅÅÅÅ-MM-DD");

        jLabel16.setFont(new java.awt.Font("Lucida Grande", 0, 8)); // NOI18N
        jLabel16.setText("Max 6 tecken");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(36, 36, 36)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
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
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel2Layout.createSequentialGroup()
                                        .addGap(14, 14, 14)
                                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(jRas, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(jAlienID, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(txtAlienNamn)
                                            .addComponent(txtAlienTelefon, javax.swing.GroupLayout.DEFAULT_SIZE, 171, Short.MAX_VALUE)
                                            .addComponent(jPlats, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(jAgent, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                                    .addGroup(jPanel2Layout.createSequentialGroup()
                                        .addGap(47, 47, 47)
                                        .addComponent(txtAlienRegDatum, javax.swing.GroupLayout.PREFERRED_SIZE, 138, javax.swing.GroupLayout.PREFERRED_SIZE))))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(lblRaceSpecial, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel15)
                                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(txtRaceSpecial, javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addComponent(txtAlienLosenord, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 138, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(jLabel16, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(buttonRensaData)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(buttonEdit, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(buttonListaAll)))
                .addContainerGap())
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(35, 35, 35)
                .addComponent(jLabel14, javax.swing.GroupLayout.PREFERRED_SIZE, 261, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
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
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, 56, Short.MAX_VALUE)
                    .addComponent(jPlats, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(jAgent, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(2, 2, 2)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jRas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel13))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtRaceSpecial, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblRaceSpecial, javax.swing.GroupLayout.PREFERRED_SIZE, 18, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(txtAlienLosenord, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel16)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel10)
                    .addComponent(txtAlienRegDatum, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(2, 2, 2)
                .addComponent(jLabel15)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(buttonRensaData)
                    .addComponent(buttonListaAll)
                    .addComponent(buttonEdit))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel14, javax.swing.GroupLayout.PREFERRED_SIZE, 15, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jLabel7.setText("Lista aliens på plats:");

        jLabel8.setText("Ta bort alien med ID/Namn:");

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

        jLabel12.setText("Visa upp alien med ID/Namn:");

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

        jButton3.setText("Gå tillbaka");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jLabel17.setFont(new java.awt.Font("Lucida Grande", 0, 8)); // NOI18N
        jLabel17.setText("ÅÅÅÅ-MM-DD");

        jLabel18.setFont(new java.awt.Font("Lucida Grande", 0, 8)); // NOI18N
        jLabel18.setText("ÅÅÅÅ-MM-DD");

        jAlienPlats.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Välja" }));
        jAlienPlats.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jAlienPlatsActionPerformed(evt);
            }
        });

        jLabel19.setText("Välja en ras:");

        jListaRas.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Välja", "Boglodite", "Worm", "Squid" }));
        jListaRas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jListaRasActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(368, 368, 368)
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(12, 12, 12)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButton3))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane6, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(jScrollPane5)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel8)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(txtAlien, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(buttonTaBortUtrustning, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel12)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jAlienID1, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jButton1))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(19, 19, 19)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel11)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtDatum1, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(6, 6, 6)
                                        .addComponent(jLabel17)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(txtDatum2, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(jButton2))
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(6, 6, 6)
                                        .addComponent(jLabel18))))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 307, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel7)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jAlienPlats, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel19)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(jListaRas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 195, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel8)
                                    .addComponent(txtAlien, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(buttonTaBortUtrustning)))
                            .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane6, javax.swing.GroupLayout.PREFERRED_SIZE, 168, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, 0)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel12)
                            .addComponent(jAlienID1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButton1)))
                    .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 19, Short.MAX_VALUE)
                .addComponent(jButton3)
                .addGap(35, 35, 35)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel11)
                    .addComponent(txtDatum1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtDatum2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(36, 36, 36)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jAlienPlats, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel19)
                            .addComponent(jListaRas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel17)
                            .addComponent(jLabel18))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(4, 4, 4))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents


    private void buttonListaAllActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonListaAllActionPerformed
        jTextArea1.setText("");
        hamtaplatsID();

        String RasSpecifaktion = lblRaceSpecial.getText();

        if (Validering.TelefonKontroll(txtAlienTelefon)
                && Validering.personFinns(txtAlienNamn, "Ange namn!")
                && Validering.losenordMaxAntal(txtAlienLosenord)
                && Validering.DatumKontroll(txtAlienRegDatum)
                && Validering.losenordMaxAntal(txtAlienLosenord)
                && Validering.kontrollForComboBox(jPlats, "Ange plats!")
                && Validering.kontrollForComboBox(jRas, "Ange Ras!")
                && Validering.kontrollForComboBox(jAgent, "Ange ansvarig agent!")) {

            if (txtRaceSpecial.isShowing() == true) {
                if (!Validering.SiffrorKontroll(txtRaceSpecial, RasSpecifaktion.substring(0, RasSpecifaktion.length() - 1) + " måste vara en siffra")) {

                    return;
                }
            }

            try {
                String alienId = hamtaNyAliensID();

                String namn = txtAlienNamn.getText();
                String telefon = txtAlienTelefon.getText();
                String datum = txtAlienRegDatum.getText();
                String losenord = txtAlienLosenord.getText();

                Object ValjaRas = jRas.getSelectedItem();
                String Ras = ValjaRas.toString();
                String nyAlien = "INSERT INTO alien (alien_id, namn, telefon, registreringsdatum, Ansvarig_Agent,losenord, plats)\n"
                        + "VALUES (" + hamtaNyAliensID() + ", "
                        + "'" + namn + "'" + ", "
                        + "'" + telefon + "'" + ", "
                        + "'" + datum + "'" + ", "
                        + "'" + hamtaAgentsID() + "'" + ", "
                        + "'" + losenord + "'" + ", "
                        + "'" + hamtaplatsID() + "'" + ")";

                String alienSquid = "INSERT INTO squid (alien_id, antal_armar)\n"
                        + "VALUES (" + alienId + ", " + "'" + hamtaRasSpecifikation() + "'" + ")";
                String alienBoglodite = "INSERT INTO boglodite (alien_id, antal_boogies)\n"
                        + "VALUES (" + alienId + ", " + "'" + hamtaRasSpecifikation() + "'" + ")";
                String alienWorm = "INSERT INTO worm (alien_id)\n"
                        + "VALUES (" + alienId + ")";

                idb.insert(nyAlien);

                switch (Ras) {
                    case "Squid":
                        idb.insert(alienSquid);
                        break;
                    case "Boglodite":
                        idb.insert(alienBoglodite);
                        break;
                    case "Worm":
                        idb.insert(alienWorm);
                        break;
                }

                JOptionPane.showMessageDialog(this, "Alien registrerad");
                AlienInfo.setText("Alien har registrerat\n"
                        + "--------------------------------\n"
                        + "ID: " + alienId + "\n"
                        + "Namn: " + namn + "\n"
                        + "Lösenord: " + losenord + "\n"
                        + "Ras: " + Ras + "\n"
                        + lblRaceSpecial.getText()+ " " + hamtaRasSpecifikation() + "\n"
                        + "Telefon: " + telefon + "\n"
                        + "Plats: " + jPlats.getSelectedItem() + "\n"
                        + "Ansvarig agent: " + jAgent.getSelectedItem().toString());

                VisaAllaAliens();
                fyllValjaAlienID();

            } catch (InfException ex) {
                System.out.println("fel i databas" + ex.getMessage());
            }
        }

    }//GEN-LAST:event_buttonListaAllActionPerformed

    private void buttonEditActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonEditActionPerformed
        int hitta = 0;
        jTextArea1.setText("");

        if (Validering.kontrollForComboBox(jAlienID)) {
            if (txtAlienNamn.getText().isEmpty() && txtAlienTelefon.getText().isEmpty()
                    && txtAlienLosenord.getText().isEmpty()
                    && jPlats.getSelectedItem().equals("Välja")
                    && jAgent.getSelectedItem().equals("Välja")) {
                JOptionPane.showMessageDialog(null, "Du glömde fylla alla rutor");
            } else {
                try {
                    String fraga = "SELECT alien_id FROM alien WHERE alien_id = '" + jAlienID.getSelectedItem() + "' OR namn = '" + txtAlien.getText() + "'";
                    ArrayList<String> AllaAlienID = idb.fetchColumn(fraga);
                    String alienId = idb.fetchSingle(fraga);

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
                        if (!jPlats.getSelectedItem().equals("Välja")) {
                            updateraPlats(alienId);
                        }
                        if (!jAgent.getSelectedItem().equals("Välja")) {
                            updateraAnsvarigAgent(alienId);
                        }
                        if (!jRas.getSelectedItem().equals("Välja")) {

                            String nuvarandeRas = hamtaRas(alienId);

                            if (nuvarandeRas.equals(jRas.getSelectedItem())) {
                                JOptionPane.showMessageDialog(null, "Alien är redan registrerad som den här rasen.");
                            } else {

                                if (jRas.getSelectedItem().equals("Boglodite")) {
                                    hanteraBoglodite(alienId);
                                } else if (jRas.getSelectedItem().equals("Squid")) {
                                    hanteraSquid(alienId);
                                } else if (jRas.getSelectedItem().equals("Worm")) {
                                    hanteraWorm(alienId);
                                }
                            }
                        }
                        String namn = txtAlienNamn.getText();
                        String telefon = txtAlienTelefon.getText();
                        String datum = txtAlienRegDatum.getText();
                        String losenord = txtAlienLosenord.getText();

                        Object ValjaRas = jRas.getSelectedItem();
                        String Ras = ValjaRas.toString();

                        AlienInfo.setText("Aliens uppgifter har ändrats!\n"
                                + "-------------------------------------\n"
                                + "ID: " + alienId + "\n"
                                + "Namn: " + namn + "\n"
                                + "Lösenord: " + losenord + "\n"
                                + "Ras: " + Ras + "\n"
                                + lblRaceSpecial.getText() + " " + hamtaRasSpecifikation() + "\n"
                                + "Telefon: " + telefon + "\n"
                                + "Plats: " + jPlats.getSelectedItem() + "\n"
                                + "Registreringsdatum: " + datum + "\n"
                                + "Ansvarig agent: " + jAgent.getSelectedItem().toString());

                        VisaAllaAliens();
                        fyllValjaAlienID();
                    }

                } catch (InfException ex) {
                    System.out.println("fel i databas" + ex.getMessage());
                }

            }
        }
    }//GEN-LAST:event_buttonEditActionPerformed

    private void buttonRensaDataActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonRensaDataActionPerformed
        rensaAllaFält();
    }//GEN-LAST:event_buttonRensaDataActionPerformed

    private void buttonTaBortUtrustningActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonTaBortUtrustningActionPerformed
        // TODO add your handling code here:
        jTextArea1.setText("");

        if (Validering.personFinns(txtAlien, "Du glömde ange aliennamn eller ID")) {
            if (kontrolleraNamnochID() > 1) {
                JOptionPane.showMessageDialog(null, "Det är många aliens som har samma namn, försök med aliens ID!");
                VisaAllaAliens();

            } else if (hamtaAlienID().equals("")) {
                JOptionPane.showMessageDialog(null, "Du skrev fel namn eller ID");
                VisaAllaAliens();

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
                VisaAllaAliens();
            }
        }

    }//GEN-LAST:event_buttonTaBortUtrustningActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        txtListaAliens.setText("");

        ArrayList<HashMap<String, String>> soktaDatum;
        if (Validering.txtKontroll(txtDatum1)
                && Validering.txtKontroll(txtDatum2)
                && Validering.DatumKontroll(txtDatum1)
                && Validering.DatumKontroll(txtDatum2)) {
            try {
                String forstaSokDatumRuta = txtDatum1.getText();
                String andraSokDatumRuta = txtDatum2.getText();

                String fraga = "SELECT * FROM alien WHERE Registreringsdatum BETWEEN '" + forstaSokDatumRuta
                        + "' AND '" + andraSokDatumRuta + "'";
                soktaDatum = idb.fetchRows(fraga);

                txtListaAliens.append("ID \t Namn \t Registreringsdatum \n"
                        + "--\t-----\t------------\n");

                for (HashMap<String, String> alien : soktaDatum) {
                    txtListaAliens.append(alien.get("Alien_ID") + "\t");
                    txtListaAliens.append(" " + alien.get("Namn") + "\t");
                    txtListaAliens.append(" " + alien.get("Registreringsdatum") + "\n");
                }

            } catch (InfException e) {
                JOptionPane.showMessageDialog(null, "Något gick fel. "
                        + e.getMessage());
            }
        }

    }//GEN-LAST:event_jButton2ActionPerformed

    private void jAgentActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jAgentActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jAgentActionPerformed

    private void jPlatsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jPlatsActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jPlatsActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        AlienInfo.setText("");
        jTextArea1.setText("");

        if (Validering.personFinns(jAlienID1, "Du glömde ange alien id")) {
            try {
                String fraga1 = "SELECT alien_id FROM alien WHERE alien_ID = '" + jAlienID1.getText() + "' OR namn = '" + jAlienID1.getText() + "'";
                String alienId = idb.fetchSingle(fraga1);

                if (visaKontroll() > 1) {
                    JOptionPane.showMessageDialog(null, "Det är många aliens som har samma namn, försök med aliens ID!");
                    VisaAllaAliens();
                } else if (alienId == null) {
                    JOptionPane.showMessageDialog(null, "Alien id finns inte!");
                    VisaAllaAliens();

                } else {
                    AlienInfo.setText("Aliens uppgifter!\n"
                            + "--------------------------\n");
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
                    VisaAllaAliens();

                }

            } catch (InfException ex) {
                System.out.println("fel i databas" + ex.getMessage());
            }
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jAlienIDPopupMenuWillBecomeInvisible(javax.swing.event.PopupMenuEvent evt) {//GEN-FIRST:event_jAlienIDPopupMenuWillBecomeInvisible
        // TODO add your handling code here:

        try {
            String fraga2 = "SELECT namn, telefon, registreringsdatum, losenord FROM alien WHERE alien_id = '" + jAlienID.getSelectedItem() + "'";
            HashMap<String, String> alienInfo = idb.fetchRow(fraga2);
            txtAlienNamn.setText(alienInfo.get("namn"));
            txtAlienTelefon.setText(alienInfo.get("telefon"));
            txtAlienRegDatum.setText(alienInfo.get("registreringsdatum"));
            txtAlienLosenord.setText(alienInfo.get("losenord"));

            String fraga3 = "SELECT benamning FROM plats "
                    + "JOIN alien ON plats.plats_id = alien.plats "
                    + "WHERE alien_id = '" + jAlienID.getSelectedItem() + "'";
            String alienPlats = idb.fetchSingle(fraga3);
            jPlats.setSelectedItem(alienPlats);

            String fraga5 = "SELECT agent.namn FROM agent "
                    + "JOIN alien ON agent.agent_id = alien.ansvarig_agent "
                    + "WHERE alien_id = '" + jAlienID.getSelectedItem() + "'";
            String AnsvarigAgent = idb.fetchSingle(fraga5);
            jAgent.setSelectedItem(AnsvarigAgent);

        } catch (InfException ex) {
            System.out.println("fel i databas" + ex.getMessage());
        }


    }//GEN-LAST:event_jAlienIDPopupMenuWillBecomeInvisible

    private void jAlienIDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jAlienIDActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jAlienIDActionPerformed

    private void jRasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRasActionPerformed
        // TODO add your handling code here:
        if (jRas.getSelectedItem().equals("Squid") || jRas.getSelectedItem().equals("Boglodite")) {
            txtRaceSpecial.setVisible(true);
            lblRaceSpecial.setVisible(true);

            if (jRas.getSelectedItem().equals("Boglodite")) {
                lblRaceSpecial.setText("Antal boogies:");
            }
            if (jRas.getSelectedItem().equals("Squid")) {
                lblRaceSpecial.setText("Antal armar:");
            }

        } else {
            txtRaceSpecial.setVisible(false);
            lblRaceSpecial.setVisible(false);
        }
    }//GEN-LAST:event_jRasActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:
        this.dispose();
        new Agent(idb, vemArInloggad).setVisible(true);
    }//GEN-LAST:event_jButton3ActionPerformed

    private void txtAlienLosenordActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtAlienLosenordActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtAlienLosenordActionPerformed

    private void jAlienPlatsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jAlienPlatsActionPerformed
        // TODO add your handling code here:
        txtListaAliens.setText("");

        try {
            String valdBenamning = jAlienPlats.getSelectedItem().toString();
            String fraga = "SELECT * from Alien where Plats ="
                    + "(Select Plats_ID from Plats where Benamning = '" + valdBenamning + "') "
                    + "Order by Alien_ID";

            ArrayList<HashMap<String, String>> alienInfo = idb.fetchRows(fraga);

            txtListaAliens.append("ID \t Namn \t Telefon\t Reg.datum\t Plats\n"
                    + "--\t-----\t---------\t----------\t--------\n");

            for (HashMap<String, String> alien : alienInfo) {
                txtListaAliens.append(" " + alien.get("Alien_ID") + "\t");
                txtListaAliens.append(alien.get("Namn") + "\t");
                txtListaAliens.append(" " + alien.get("Telefon") + "\t");
                txtListaAliens.append(" " + alien.get("Registreringsdatum") + "\t");
                txtListaAliens.append(" " + alien.get("Plats") + "\n");
            }
        } catch (InfException e) {
            JOptionPane.showMessageDialog(null, "fel i databas!");
            System.out.println("Internt felmeddelande" + e.getMessage());
        }
    }//GEN-LAST:event_jAlienPlatsActionPerformed

    private void jListaRasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jListaRasActionPerformed
        // TODO add your handling code here:
        txtListaAliens.setText("");

        try {
            String fraga = "SELECT alien_id FROM alien order by alien_id";
            ArrayList<String> listAlienId = idb.fetchColumn(fraga);

            txtListaAliens.append(" ID\t Namn\n "
                    + "----\t-------\n");

            for (String alienID : listAlienId) {
                String ras = hamtaRas(alienID);
                String qAlienName = "SELECT namn FROM alien WHERE alien_id = '" + alienID + "'";
                String alienNamn = idb.fetchSingle(qAlienName);

                if (jListaRas.getSelectedItem().equals(ras)) {
                    txtListaAliens.append(" " + alienID + "\t" + alienNamn + "\n");
                }
            }
        } catch (InfException ex) {
            JOptionPane.showMessageDialog(null, "fel i databas!");
            System.out.println("Internt felmeddelande" + ex.getMessage());
        }
    }//GEN-LAST:event_jListaRasActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextArea AlienInfo;
    private javax.swing.JButton buttonEdit;
    private javax.swing.JButton buttonListaAll;
    private javax.swing.JButton buttonRensaData;
    private javax.swing.JButton buttonTaBortUtrustning;
    private javax.swing.JComboBox<String> jAgent;
    private javax.swing.JComboBox<String> jAlienID;
    private javax.swing.JTextField jAlienID1;
    private javax.swing.JComboBox<String> jAlienPlats;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JComboBox<String> jListaRas;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JComboBox<String> jPlats;
    private javax.swing.JComboBox<String> jRas;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTextArea jTextArea1;
    private javax.swing.JLabel lblRaceSpecial;
    private javax.swing.JTextField txtAlien;
    private javax.swing.JTextField txtAlienLosenord;
    private javax.swing.JTextField txtAlienNamn;
    private javax.swing.JTextField txtAlienRegDatum;
    private javax.swing.JTextField txtAlienTelefon;
    private javax.swing.JTextField txtDatum1;
    private javax.swing.JTextField txtDatum2;
    private javax.swing.JTextArea txtListaAliens;
    private javax.swing.JTextField txtRaceSpecial;
    // End of variables declaration//GEN-END:variables
}
