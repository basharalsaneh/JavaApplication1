package javaApplication1;

import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
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

    public static boolean kontrollForComboBox(JComboBox text, String meddelandeText) {
        boolean result = true;
        if (text.getSelectedItem().equals("")) {
            result = false;
            text.requestFocus();
           
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
