package javaApplication1;

import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import oru.inf.InfDB;

/**
 *
 * @author Marcu
 */
public class Validering {
    // Valideringsklass där vi kollar om eventuella textboxar, comboboxar, password-fält är tomma eller inte.
    //Innehåller även validering för inloggningssidorna.

    static boolean resultat = false;
    private String namn = "";
    private int id = 0;
    private String losenord = "";

    public static boolean personFinns(JTextField enPerson) {
        resultat = true;

        if (enPerson.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Ingen användare inskrivet");
            resultat = false;
        }
        return resultat;
    }
    
         public static boolean baraIntTecken(JTextField txtRuta) {
        resultat = true;
        
        try{
        String rutan = txtRuta.getText();
        Integer.parseInt(rutan);
        }
        catch(NumberFormatException e)
         {
             JOptionPane.showMessageDialog(null, "Endast siffror möjligt");
            resultat = false;
        }
        return resultat;
    }
    
    
     public static boolean max10Siffror(JTextField txtRuta) {
        resultat = true;

        if (txtRuta.getText().length() > 10) {
            JOptionPane.showMessageDialog(null, "Max 10 siffror tillåtet");
            resultat = false;
        }
        return resultat;
    }
     
          public static boolean max20Tecken(JTextField txtRuta) {
        resultat = true;

        if (txtRuta.getText().length() > 20) {
            JOptionPane.showMessageDialog(null, "Max 20 tecken tillåtet");
            resultat = false;
        }
        return resultat;
    }

    public static boolean personFinns(JTextField enPerson, String meddelandetext) {
        resultat = true;

        if (enPerson.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Ingen användare inskrivet");
            resultat = false;
        }
        return resultat;
     }
          
          


    public static boolean finnsLosenord(JPasswordField ettLosenord) {
        resultat = true;

        if (ettLosenord.getPassword().length == 0) {
            JOptionPane.showMessageDialog(null, "En lösenordsruta tom");
            resultat = false;
        }

        return resultat;
    }

        public static boolean losenordMaxTecken(JPasswordField ettLosenord) {
        resultat = true;

        if (ettLosenord.getPassword().length >6) {
            JOptionPane.showMessageDialog(null, "Max 6 tecken tillåtet");
            resultat = false;
        }
        
        return resultat;
    }
    
    public static boolean txtKontroll(JTextField text) {
        boolean result = true;
        if (text.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "En ruta är tom");
            result = false;
            text.requestFocus();
        }
        return result;
    }

    public static boolean kontrollForComboBox(JComboBox text) {
        boolean result = true;
        if (text.getSelectedItem().equals("Välja")) {
            JOptionPane.showMessageDialog(null, "Välj en typ av utrustning!");
            result = false;
            text.requestFocus();
        }
        return result;
    }
    

    public static boolean kontrollForComboBox(JComboBox text, String messageText) {
        boolean result = true;
        if (text.getSelectedItem().equals("Välja")) {
            JOptionPane.showMessageDialog(null, messageText);
            result = false;
            text.requestFocus();
           
        }
        return result;
    }
        
           public static boolean losenMaxAntal(JTextField ruta){
      
        if(ruta.getText().length() > 6){
            JOptionPane.showMessageDialog(null, "Lösenordet får vara max 6 tecken långt!");
            ruta.requestFocus();
            return false;
        }
        else{
            return true;
        }
    
    }
           
               public static boolean SiffrorKontroll(JTextField fieldToValidate, String messageText) {
        boolean result = false;
        if (fieldToValidate.getText().matches("[0-9]+")) {

            result = true;

        } else {
             JOptionPane.showMessageDialog(null, (messageText));
            fieldToValidate.requestFocus();

        }
        return result;
    }
           
       public static boolean TelefonKontroll(JTextField fieldToValidate) {
        boolean result = false;
        if (fieldToValidate.getText().matches("[+() [0-9]-]+") || fieldToValidate.getText().matches("")) {

            result = true;

        } else {
            JOptionPane.showMessageDialog(null, "Telefonnumret har fel format!");
            fieldToValidate.requestFocus();
        }
        return result;
    }
          
       public static boolean DatumKontroll(JTextField fieldToValidate) {
        boolean result = true;
        String Datum = fieldToValidate.getText();

        if (Datum.length() != 10) {
            JOptionPane.showMessageDialog(null,"Datumet är felaktigt!");
            result = false;
        } else {
            String år = Datum.substring(0, 4);
            String månad = Datum.substring(5, 7);
            String dag = Datum.substring(8, 10);
            String bindeStreck1 = Datum.substring(4, 5);
            String bindeStreck2 = Datum.substring(7, 8);

            String regex = "\\d+"; //Kontrollerar att talet är positiv

            Boolean årTest = år.matches(regex);
            Boolean månadTest = månad.matches(regex);
            Boolean dagTest = dag.matches(regex);

            if (årTest && månadTest && dagTest
                    && bindeStreck1.equals("-") && bindeStreck2.equals("-")
                    && Integer.parseInt(månad) >= 1 && Integer.parseInt(månad) <= 12
                    && Integer.parseInt(dag) >= 1 && Integer.parseInt(dag) <= 31) {
            } else {
                result = false;
                 JOptionPane.showMessageDialog(null, "Datumet är felaktigt!");
                fieldToValidate.requestFocus();
            }
        }
        return result;
    }
            
            

    public void inloggadSom(String namnInloggad, int idInloggad, String angettLosenord) {
        namn = namnInloggad;
        id = idInloggad;
        losenord = angettLosenord;
    }

    public void setNamn(String nyttNamn) {
        this.namn = nyttNamn;
    }

    public String getNamn() {
        return namn;
    }

    public String getNamn2() {
        return this.namn;
    }

    public int getId() {
        return id;
    }

    public void setId(int nyttId) {
        id = nyttId;
    }

    public String getLosenord() {
        return losenord;
    }

    public void setNyttLosenord(String nyttLosenord) {
        losenord = nyttLosenord;
    }

//     public static boolean arAgent(){
//     resultat = true;
//     return resultat;
//     }
//      public static boolean arAdmin(){
//     resultat = true;
//     return resultat;
//     }
//       public static boolean arAlien(){
//     resultat = true;
//     return resultat;
//     }
}
