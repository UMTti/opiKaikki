/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.olioluokat;

/**
 *
 * @author pihla
 */
public class Kysymys {
    
    private int id;
    private String kuvaus;
    private String oikeavastaus;
    private String aihepiiri;
    
    public Kysymys(int id, String kuvaus, String oikeavastaus, String aihepiiri){
        this.id = id;
        this.kuvaus = kuvaus;
        this.oikeavastaus = oikeavastaus;
        this.aihepiiri = aihepiiri;
    }
    
    public int getId(){
        return this.id;
    }
    
    public String getKuvaus(){
        return this.kuvaus;
    }
    
    public String getAihepiiri(){
        return this.aihepiiri;
    }
    
    public String getOikeavastaus(){
        return this.oikeavastaus;
    }
}
