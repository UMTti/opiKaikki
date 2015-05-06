/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.opikaikki;

/**
 *
 * @author pihla
 */
public class Kysymys {
    
    private int id;
    private String kuvaus;
    private String oikeavastaus;
    
    public Kysymys(int id, String kuvaus, String oikeavastaus){
        this.id = id;
        this.kuvaus = kuvaus;
        this.oikeavastaus = oikeavastaus;
    }
    
    public int getId(){
        return this.id;
    }
    
    public String getKuvaus(){
        return this.kuvaus;
    }
}
