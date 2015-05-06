/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.olioluokat;

import com.mycompany.olioluokat.Kysymys;

/**
 *
 * @author pihla
 */
public class Vastaus {
    private Kysymys kysymys;
    private String vastaus;
    
    public Vastaus(String vastaus, Kysymys k){
        this.kysymys = k;
        this.vastaus = vastaus;
    }
    
    public Kysymys getKysymys(){
        return this.kysymys;
    }
    
    public String getVastaus(){
        return this.vastaus;
    }
}
