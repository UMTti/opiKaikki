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
    
    public KysymystenKäsittelijä getKysymystenKäsittelijä(){
        return this.k;
    }
    
    public ArrayList<Kysymys> annaKysymyksetAlussa(){
        if(this.m.getSessiot().size() == 0){
            return lisääKysymykset();
        }
        
        return lisääKysymyksetHuomioidenVäärät();
    }
    
    public ArrayList<Kysymys> lisääKysymyksetHuomioidenVäärät(){
        Sessio viimeisin = this.m.getSessiot().get(this.m.getSessiot().size() - 1);
        ArrayList<Integer> viimeisimmänVäärät = viimeisin.kerroVäärinMenneet();
        ArrayList<Kysymys> kysymykset = new ArrayList<Kysymys>();
        return haeKysymykset(kysymykset, viimeisimmänVäärät);
    }
    
    public ArrayList<Kysymys> haeKysymykset(ArrayList<Kysymys> kysymykset, ArrayList<Integer> viimeisimmänVäärät){
        for(int i: this.m.getKysymystenKäsittelijä().getKysymykset().keySet()){
            Kysymys k = this.m.getKysymystenKäsittelijä().getKysymykset().get(i);
            kysymykset.add(k);
            if(viimeisimmänVäärät.contains(k.getId())){
                kysymykset.add(k);    // Jos viimeisimmässä sessiossa on vastattu tähän kysymykseen väärin, laitetaan se kahdesti mukaan
            }
        }
        return kysymykset;
    }
    
    public ArrayList<Kysymys> lisääKysymykset(){
        ArrayList<Kysymys> kysymykset = new ArrayList<Kysymys>();
        for(int i: this.m.getKysymystenKäsittelijä().getKysymykset().keySet()){
            Kysymys k = this.m.getKysymystenKäsittelijä().getKysymykset().get(i);
            kysymykset.add(k);
        }
        return kysymykset;
    }
    
    public ArrayList<Integer> kerroVäärinMenneet(){
        ArrayList<Integer> väärinmenneet = new ArrayList<Integer>();
        for(Vastaus v: this.vastaukset){
            Kysymys k = v.getKysymys();
            if(!v.getVastaus().equals(k.getOikeavastaus())){
                väärinmenneet.add(k.getId());
            }
        }
        return väärinmenneet;
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
    
    public ArrayList<Vastaus> getVastaukset(){
        return this.vastaukset;
    }
    
    public void tallennaSessio(){
        this.m.tallennaSessiot();
    }
     
}
