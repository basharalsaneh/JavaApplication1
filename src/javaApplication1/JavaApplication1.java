package javaApplication1;

import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import oru.inf.InfDB;
import oru.inf.InfException;

public class JavaApplication1 {
    
    

    private static InfDB idb;
    static boolean resultat = false;
    
    
    public static void main(String[] args) throws InfException {
        
        try {
            idb = new InfDB("mibdb", "3306", "mibdba", "mibkey");
            System.out.println("Koppling established");

        }   catch (InfException ex){
            Logger.getLogger(JavaApplication1.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
        new Start(idb).setVisible(true);
        
    }
    
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
     
     
     
    public static boolean arAgent2(JTextField enAgent){
        resultat = false;
        try {

            String inmatning = enAgent.getText();
            Integer.parseInt(inmatning);
            enAgent.requestFocus();
            resultat = true;

        } catch (NumberFormatException e) {

            JOptionPane.showMessageDialog(null, "Ange en agent istället");
        }
        return resultat;

    }
    
        public static boolean arAlien2(JTextField enAlien){
        resultat = false;
        try {

            String inmatning = enAlien.getText();
            Integer.parseInt(inmatning);
            enAlien.requestFocus();
            resultat = true;

        } catch (NumberFormatException e) {

            JOptionPane.showMessageDialog(null, "Ange en alien istället.");
        }
        return resultat;

    }

            public static boolean arAdmin2(JTextField enAdmin){
        resultat = false;
        try {

            String inmatning = enAdmin.getText();
            Integer.parseInt(inmatning);
            enAdmin.requestFocus();
            resultat = true;

        } catch (NumberFormatException e) {

            JOptionPane.showMessageDialog(null, "Ange en administratör istället.");
        }
        return resultat;

    }
        


}