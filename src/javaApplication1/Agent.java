package TestDB123;

import java.util.Date;
import oru.inf.InfDB;
import oru.inf.InfException;
import java.util.Random;

public class Agent{

private static InfDB idb;
private int agent_ID;
private String namn;
private String Telefon;
private String losenord;
private boolean Administrator;
private Date anstallningsdatum;

public Agent(String namn, String Telefon, String losenord){
agent_ID = new Random().nextInt(10);
this.namn = namn;
this.Telefon = Telefon;
this.losenord = losenord;
Administrator = false;
anstallningsdatum = new Date();
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

public int getAgentID(){
return agent_ID;
}

public void bytLosenord(String nyttLosenord){
    if(nyttLosenord.equals(losenord)){
    System.out.println("Fel");
    }
    else{
System.out.println("Du har bytt losenord till: " + nyttLosenord);
System.out.println("Från: " + losenord);
losenord = nyttLosenord;
}}


}
