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
    
    public void lisääKysymys(String kuvaus, String oikeavastaus){
        Kysymys uusi = new Kysymys(this.max_id + 1, kuvaus, oikeavastaus);
        this.kysymykset.put(uusi.getId(), uusi);
        this.max_id++;
    }
    
    public void lisääKysymys(int id, String kuvaus, String oikeavastaus){
        Kysymys uusi = new Kysymys(id, kuvaus, oikeavastaus);
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
}
