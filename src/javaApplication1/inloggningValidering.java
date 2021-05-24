/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaApplication1;

/**
 *
 * @author Marcu
 */
public class inloggningValidering {

    private String namn;
    private int id;
    private String losenord;

    public void inloggadAnvandare(String namnInloggad, int idInloggad) {

        namn = namnInloggad;
        id = idInloggad;
        this.losenord ="";
    }

    public void setNamn(String nyttNamn) {
        this.namn = nyttNamn;
    }

    public String getNamn() {
        return namn;
    }

    public int getId() {
        return id;
    }
    
    public void setId(int nyttId) {
        id = nyttId;
    }
    
    public String getLosenord(){
    return losenord;
    }
    public void setNyttLosenord(String nyttLosenord){
    losenord = nyttLosenord;
    }

}
