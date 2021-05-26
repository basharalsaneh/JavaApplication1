
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
    
    static boolean resultat = false;
    
     public static boolean personFinns(JTextField enPerson) {
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
            JOptionPane.showMessageDialog(null, "Inget lösenord inskrivet");
            resultat = false;
        }
        System.out.println(resultat);
        return resultat;
    }
    
    public static boolean txtKontroll(JTextField text) {
        boolean result = true;
        if (text.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "utrustningsnamn är tomt");
            result = false;
            text.requestFocus();
        }
        return result;
    }
    
    
        public static boolean kontrollForComboBox(JComboBox text) {
        boolean result = true;
        if (text.getSelectedItem().equals("Välja")) {
            JOptionPane.showMessageDialog(null, "Välja en typ av utrustning!");
            result = false;
            text.requestFocus();
        }
        return result;
    }
        
            
            
     public static boolean arAgent(){
     resultat = true;
     return resultat;
     }
      public static boolean arAdmin(){
     resultat = true;
     return resultat;
     }
       public static boolean arAlien(){
     resultat = true;
     return resultat;
     }
     }
        