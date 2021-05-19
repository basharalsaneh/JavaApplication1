/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaApplication1;
import javax.swing.JLabel;

/**
 *
 * @author kristofffer
 */
public class Validering {
    
    
    public static boolean alienAnvandare(JLabel txtAnvandarTyp){
        
        boolean alien = false;
      
               
        
        
        
        if("Som Alien".equals(txtAnvandarTyp.getText())){
            
            alien = true;
            System.out.println("Loggar in som alien!");
            
        }
        
        return alien;
       
    }
    public static boolean adminAnvandare(JLabel txtAnvandarTyp){
        
        boolean admin = false;
      
               
        
        
        
        if("Som Admin".equals(txtAnvandarTyp.getText())){
            
            admin = true;
            System.out.println("Loggar in som admin!");
        }
        
        return admin;
       
    }
    
    public static boolean agentAnvandare(JLabel txtAnvandarTyp){
        
        boolean agent = false;
      
               
        
        
        
        if("Som Agent".equals(txtAnvandarTyp.getText())){
            
            agent = true;
            System.out.println("Loggar in som agent!");
        }
        
        return agent;
       
    }
    
    
    
    
}
