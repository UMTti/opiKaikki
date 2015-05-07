/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.olioluokat;

import com.mycompany.DAO.SessioDAO;
import com.mycompany.käsittelijät.KysymystenKäsittelijä;
import java.util.ArrayList;

/**
 *
 * @author pihla
 */
public class Sessio {
    
    private KysymystenKäsittelijä k;
    private ArrayList<Vastaus> vastaukset;
    private Moduuli m;
    
    public Sessio(Moduuli m, String vastaustiedosto, KysymystenKäsittelijä k){
        this.k = k;
        this.m = m;
        this.vastaukset = new ArrayList<Vastaus>();    
    }
    
    public Moduuli getModuuli(){
        return this.m;
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
    
    public void tallennaSessio(){
        System.out.println();
        SessioDAO.tallennaSessiot(m);
    }
     
}
