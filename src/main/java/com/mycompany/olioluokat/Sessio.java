/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.olioluokat;

import com.mycompany.käsittelijät.KysymystenKäsittelijä;
import com.mycompany.käsittelijät.VastaustenKäsittelijä;
import java.util.ArrayList;

/**
 *
 * @author pihla
 */
public class Sessio {
    
    private VastaustenKäsittelijä v;
    private KysymystenKäsittelijä k;
    private ArrayList<Vastaus> vastaukset;
    
    public Sessio(String vastaustiedosto, KysymystenKäsittelijä k){
        this.k = k;
        this.vastaukset = new ArrayList<Vastaus>();
        this.v = new VastaustenKäsittelijä(vastaustiedosto, k);        
    }
    
    public void lisääVastaus(int kysymysId, String vastaus){
        System.out.println("Lisätään vastausta: " + kysymysId + " " + vastaus);
        Kysymys ky = k.getKysymykset().get(kysymysId);
        if(ky == null){
            System.out.println("Vastaukselle ei ole kysymystä");
            return;
        }
        Vastaus uusi = new Vastaus(vastaus, ky);
        this.vastaukset.add(uusi);
    }
    
    public ArrayList<Vastaus> getVastaukset(){
        return this.vastaukset;
    }
     
}
