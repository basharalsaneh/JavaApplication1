package javaApplication1;

import java.util.logging.Level;
import java.util.logging.Logger;
import oru.inf.InfDB;
import oru.inf.InfException;

public class JavaApplication1 {

    private static InfDB idb;

    public static void main(String[] args) throws InfException {
// kommentar här...!!!!!!!!!123123123123
        try {
            idb = new InfDB("mibdb", "3307", "mibdba", "mibkey");

        }   catch (InfException ex){
            Logger.getLogger(JavaApplication1.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
}