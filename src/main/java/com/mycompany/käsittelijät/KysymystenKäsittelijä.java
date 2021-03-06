/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.käsittelijät;

import com.mycompany.DAO.KysymysDAO;
import com.mycompany.olioluokat.Kysymys;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author pihla
 */
public class KysymystenKäsittelijä {
    HashMap<Integer, Kysymys> kysymykset;
    private int max_id;
    private String tiedostonimi;
    
    public KysymystenKäsittelijä(String tiedostonimi){
        this.kysymykset = new HashMap<Integer, Kysymys>();
        this.max_id = 0;
        this.tiedostonimi = tiedostonimi;
        KysymysDAO.lataaKysymykset(this);
    }
    
    public String getTiedostonimi(){
        return this.tiedostonimi;
    }
    
    public HashMap<Integer, Kysymys> getKysymykset(){
        return this.kysymykset;
    }
    
    /**
     * Kun lisätään kysymys, tallennetaan sen id ja itse kysymys. 
     * @param kuvaus
     * @param oikeavastaus
     * @param aihepiiri
     */
    public void lisääKysymys(String kuvaus, String oikeavastaus, String aihepiiri){
        Kysymys uusi = new Kysymys(this.max_id + 1, kuvaus, oikeavastaus, aihepiiri);
        this.kysymykset.put(uusi.getId(), uusi);
        this.max_id++;
    }
    
    public void poistaKysymys(int id){
    	this.kysymykset.remove(id);
    	this.tallennaKysymykset();
    }
    
    public void muokkaaKysymystä(int id, String uusi){
    	this.kysymykset.get(id).setKuvaus(uusi);
    	this.tallennaKysymykset();
    }
    
    public void muokkaaVastausta(int id, String uusi){
    	this.kysymykset.get(id).setOikeaVastaus(uusi);
    	this.tallennaKysymykset();
    }
    
    public void lisääKysymys(int id, String kuvaus, String oikeavastaus, String aihepiiri){
        Kysymys uusi = new Kysymys(id, kuvaus, oikeavastaus, aihepiiri);
        this.kysymykset.put(uusi.getId(), uusi);
        this.max_id = Math.max(this.max_id, uusi.getId());
    }
    
    public void tulostaKysymykset(){
        for (int i : this.kysymykset.keySet()) {
            System.out.println(this.kysymykset.get(i).getId() + " " + this.kysymykset.get(i).getKuvaus());
        }
    }
    
    public void tallennaKysymykset(){
        KysymysDAO.tallennaKysymykset(this);
    }
    
    public int getMax_id(){
        return this.max_id;
    }
}
