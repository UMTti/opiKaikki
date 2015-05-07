/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.DAO;

import com.mycompany.olioluokat.Moduuli;
import com.mycompany.olioluokat.Sessio;
import com.mycompany.olioluokat.Vastaus;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

/**
 *
 * @author pihla
 */
public class SessioDAO {
    
    public static void lataaSessiot(Moduuli m){
        Scanner lukija;
        try {
            System.out.println(m.getVastausTiedostonnimi());
            lukija = new Scanner(new File(m.getVastausTiedostonnimi()));
        } catch (FileNotFoundException ex) {
            System.out.println("Tiedostoa ei löytynyt");
            return;
        }
        Sessio uusi = new Sessio(m.getVastausTiedostonnimi(), m.getKysymystenKäsittelijä());
        while(lukija.hasNextLine()){
            String rivi = lukija.nextLine();
            if(rivi.contains("...")){
                m.lisääSessio(uusi);
                uusi = new Sessio(m.getVastausTiedostonnimi(), m.getKysymystenKäsittelijä());
                continue;
            }
            String[] tiedot = rivi.split(";");
            uusi.lisääVastaus(Integer.parseInt(tiedot[0]), tiedot[1]);
        }
    }
    
    public static void tallennaSessiot(Moduuli m){
        FileWriter kirjoittaja;
        try {
            kirjoittaja = new FileWriter(m.getVastausTiedostonnimi());
            for(Sessio s: m.getSessiot()){
                for(Vastaus va: s.getVastaukset()){
                    kirjoittaja.write(va.getKysymys().getId() + ";" + va.getVastaus() + "\n");
                }
                kirjoittaja.write("..." + "\n");
            }
            kirjoittaja.close();
        } catch (IOException ex) {
            System.out.println("Kirjoitus epäonnistui. " + ex);
        }
    }
}
