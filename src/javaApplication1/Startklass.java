package javaApplication1;

import java.util.logging.Level;
import java.util.logging.Logger;
import oru.inf.InfDB;
import oru.inf.InfException;

public class Startklass {
    
    

    private static InfDB idb;
    static inloggningValidering vemArInloggad;
    
    
    public static void main(String[] args){
        
        try {
            idb = new InfDB("mibdb", "3306", "mibdba", "mibkey");
            System.out.println("Koppling established");
            new Start(idb, vemArInloggad).setVisible(true);

        }   catch (InfException ex){
            Logger.getLogger(Startklass.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
        
        
    }
}