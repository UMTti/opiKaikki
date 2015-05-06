/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.käsittelijät;

import com.mycompany.käsittelijät.KysymystenKäsittelijä;
import com.mycompany.DAO.VastausDAO;
import com.mycompany.olioluokat.Kysymys;
import com.mycompany.olioluokat.Vastaus;
import java.util.ArrayList;

/**
 *
 * @author pihla
 */
public class VastaustenKäsittelijä {
    private ArrayList<Vastaus> vastaukset;
    private String tiedostonimi;
    private KysymystenKäsittelijä k;
    
    public VastaustenKäsittelijä(String tiedostonimi, KysymystenKäsittelijä k){
        this.tiedostonimi = tiedostonimi;
        this.k = k;
        this.vastaukset = new ArrayList<Vastaus>();
        VastausDAO.lataaVastaukset(this);
    }
    
    public void lisääVastaus(int kysymysId, String vastaus){
        Kysymys ky = k.getKysymykset().get(kysymysId);
        if(ky == null){
            System.out.println("Vastaukselle ei ole kysymystä");
            return;
        }
        Vastaus uusi = new Vastaus(vastaus, ky);
        this.vastaukset.add(uusi);
    }
    
    public String getTiedostonimi(){
        return this.tiedostonimi;
    }
    
    public ArrayList<Vastaus> getVastaukset(){
        return this.vastaukset;
    }
    
    public void tallennaVastaukset(){
        VastausDAO.tallennaVastaukset(this);
    }
}
