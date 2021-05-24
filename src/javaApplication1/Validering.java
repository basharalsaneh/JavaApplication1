
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
    private static InfDB idb;
    
     public static boolean textFaltHarVarde(JTextField rutaAttKolla) {
        resultat = true;

        if (rutaAttKolla.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Inmatningsrutan är tom!");

            resultat = false;
            rutaAttKolla.requestFocus();
        }
        return resultat;
     }
     
     public static boolean losenordHarVarde(JPasswordField rutaAttKolla) {
        resultat = true;

        if (rutaAttKolla.getPassword().length == 0) {
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
        