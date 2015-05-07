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
public class Moduuli {
    private KysymystenKäsittelijä k;
    private String nimi;
    private String vastaustiedosto;
    private ArrayList<Sessio> sessiot;
    
    public Moduuli(String nimi, String kysymystiedosto, String vastaustiedosto){
        this.k = new KysymystenKäsittelijä(kysymystiedosto);
        this.vastaustiedosto = vastaustiedosto;
        this.sessiot = new ArrayList<Sessio>();
        this.nimi = nimi;
        SessioDAO.lataaSessiot(this);
    }
    
    public void lisääSessio(Sessio s){
        this.sessiot.add(s);
        SessioDAO.tallennaSessiot(this);
    }
    
    public String getNimi(){
        return this.nimi;
    }
    
    public String getVastausTiedostonnimi(){
        return this.vastaustiedosto;
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
    
    public ArrayList<Sessio> getSessiot(){
        return this.sessiot;
    }
    
}
