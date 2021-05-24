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

    public void inloggadAnvandare(String nyttNamn, int nyttId) {

        namn = nyttNamn;
        id = nyttId;
    }

    public void setNamn(String nn) {
        this.namn = nn;
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

}
