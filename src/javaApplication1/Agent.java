package javaApplication1;

import java.util.Date;
import oru.inf.InfDB;
import oru.inf.InfException;
import java.util.Random;

public class Agent{ // Ska tas bort...!!!

private static InfDB idb;
private int agent_ID;
private String namn;
private String Telefon;
private String losenord;
private boolean administrator;
private Date anstallningsdatum;

public Agent(String namn, String Telefon, String losenord){
agent_ID = new Random().nextInt(10);
this.namn = namn;
this.Telefon = Telefon;
this.losenord = losenord;
administrator = false;
anstallningsdatum = new Date();
}

public int getAgentID(){
return agent_ID;
}

public String getNamn(){
return namn;
}

public String getTelefon(){
return Telefon;
}

public Date getAnstallningsdatum(){
return anstallningsdatum;
}

public void bytLosenord(String nyttLosenord){
nyttLosenord = losenord;
}

public boolean getAdministrator(){
return administrator;
}

public boolean becomeAdministrator(){
administrator = true;
return administrator;
}

public String getLosenord(){
return losenord;
}
}

 //*   public void listaAgenter(){
      
           ///for(int i = 0 ; i < agentLista.size() ; i++){
              //  String agent = agentLista.get(i).getNamn();
          
              //  System.out.println(agent);
              //  System.out.println("hej" + agent);
            
   // }
  /// }  private ArrayList<Agent> agentLista = new ArrayList<>(); i konstruktorn (?)
// agentLista.add (?)..
