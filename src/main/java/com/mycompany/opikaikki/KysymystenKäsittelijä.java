/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.opikaikki;

import java.io.File;
import java.io.FileNotFoundException;
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
        this.lataaKysymykset();
    }
    
    private void lataaKysymykset(){
        Scanner lukija;
        try {
            System.out.println(this.tiedostonimi);
            lukija = new Scanner(new File(this.tiedostonimi));
        } catch (FileNotFoundException ex) {
            System.out.println("Tiedostoa ei löytynyt");
            return;
        }
        while(lukija.hasNextLine()){
            String rivi = lukija.nextLine();
            String[] tiedot = rivi.split(";");
            lisaaKysymys(Integer.parseInt(tiedot[0]), tiedot[1], tiedot[2]);
        }
    }
    
    public void lisääKysymys(String kuvaus, String oikeavastaus){
        Kysymys uusi = new Kysymys(this.max_id + 1, kuvaus, oikeavastaus);
        this.kysymykset.put(uusi.getId(), uusi);
        this.max_id++;
    }
    
    public void lisaaKysymys(int id, String kuvaus, String oikeavastaus){
        Kysymys uusi = new Kysymys(id, kuvaus, oikeavastaus);
        this.kysymykset.put(uusi.getId(), uusi);
        this.max_id = Math.max(this.max_id, uusi.getId());
    }
    
    public void tulostaKysymykset(){
        for (int i : this.kysymykset.keySet()) {
            System.out.println(this.kysymykset.get(i).getKuvaus());
        }
    }
}
