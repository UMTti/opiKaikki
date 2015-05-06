/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.olioluokat;

import com.mycompany.käsittelijät.KysymystenKäsittelijä;
import com.mycompany.käsittelijät.VastaustenKäsittelijä;

/**
 *
 * @author pihla
 */
public class Moduuli {
    private KysymystenKäsittelijä k;
    private VastaustenKäsittelijä v;
    private String nimi;
    
    public Moduuli(String nimi, String kysymystiedosto, String vastaustiedosto){
        this.k = new KysymystenKäsittelijä(kysymystiedosto);
        this.v = new VastaustenKäsittelijä(vastaustiedosto, this.k);
        this.nimi = nimi;
    }
    
    public String getNimi(){
        return this.nimi;
    }
    
    public KysymystenKäsittelijä getKysymystenKäsittelijä(){
        return this.k;
    }
    
    public void lisääKysymys(String kuvaus, String oikeavastaus){
        k.lisääKysymys(kuvaus, oikeavastaus);
    }
    
    public void lisääKysymys(int kysymysId, String kuvaus, String oikeavastaus){
        k.lisääKysymys(kysymysId, kuvaus, oikeavastaus);
    }
    
}
