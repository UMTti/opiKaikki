/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.DAO;

import com.mycompany.olioluokat.Vastaus;
import com.mycompany.käsittelijät.VastaustenKäsittelijä;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

/**
 *
 * @author pihla
 */
public class VastausDAO {
    
    public static void lataaVastaukset(VastaustenKäsittelijä v){
        Scanner lukija;
        try {
            System.out.println(v.getTiedostonimi());
            lukija = new Scanner(new File(v.getTiedostonimi()));
        } catch (FileNotFoundException ex) {
            System.out.println("Tiedostoa ei löytynyt");
            return;
        }
        while(lukija.hasNextLine()){
            String rivi = lukija.nextLine();
            String[] tiedot = rivi.split(";");
            v.lisääVastaus(Integer.parseInt(tiedot[0]), tiedot[1]);
        }
    }
    
    public static void tallennaVastaukset(VastaustenKäsittelijä v){
        FileWriter kirjoittaja;
        try {
            kirjoittaja = new FileWriter(v.getTiedostonimi());
            for(Vastaus va: v.getVastaukset()){
                kirjoittaja.write(va.getKysymys().getId() + ";" + va.getVastaus() + "\n");
            }
            kirjoittaja.close();
        } catch (IOException ex) {
            System.out.println("Kirjoitus epäonnistui. " + ex);
        }
        
    }
}
