
package javaApplication1;

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
    private InfDB idb;
    
     public static boolean personFinns(JTextField enPerson) {
        resultat = true;

        if (enPerson.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "person fel");
            resultat = false;    
        }
        return resultat;
     }
     
     public static boolean finnsLosenord(JPasswordField ettLosenord) {
        resultat = true;

        if (ettLosenord.getPassword().length == 0) {
            JOptionPane.showMessageDialog(null, "Rutan är tom!");
            resultat = false;
        }
        System.out.println(resultat);
        return resultat;
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
        