package javaApplication1;

import java.util.logging.Level;
import java.util.logging.Logger;
import oru.inf.InfDB;
import oru.inf.InfException;

public class JavaApplication1 {
    
    

    private static InfDB idb;
    private static Inloggningssidan inlogg;
    
    
    public static void main(String[] args) throws InfException {
        
        System.out.println("Hej Bashar!");
        System.out.println("Hej Kristoffer!");
        System.out.println("Hej hej");
        System.out.println("dqwdqw");
        
        
       
      
        try {
            idb = new InfDB("mibdb", "3306", "mibdba", "mibkey");

        }   catch (InfException ex){
            Logger.getLogger(JavaApplication1.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
    public JavaApplication1(){
         inlogg = new Inloggningssidan();
         inlogg.setVisible(true);
    }
    
    
    
}