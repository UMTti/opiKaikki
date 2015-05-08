/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.DAO;

import com.mycompany.olioluokat.Kysymys;
import com.mycompany.käsittelijät.KysymystenKäsittelijä;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

/**
 *
 * @author pihla
 */
public class KysymysDAO {
    
    public static void lataaKysymykset(KysymystenKäsittelijä k){
        Scanner lukija;
        try {
            System.out.println(k.getTiedostonimi());
            lukija = new Scanner(new File(k.getTiedostonimi()));
        } catch (FileNotFoundException ex) {
            System.out.println("Tiedostoa ei löytynyt");
            return;
        }
        lueRivit(k, lukija);
    }
    
    public static void lueRivit(KysymystenKäsittelijä k, Scanner lukija){
        while(lukija.hasNextLine()){
            String rivi = lukija.nextLine();
            String[] tiedot = rivi.split(";");
            k.lisääKysymys(Integer.parseInt(tiedot[0]), tiedot[1], tiedot[2]);
        }
    }
    
    public static void tallennaKysymykset(KysymystenKäsittelijä k){
        FileWriter kirjoittaja;
        try {
            kirjoittaja = new FileWriter(k.getTiedostonimi());
            for(int i: k.getKysymykset().keySet()){
                Kysymys ky = k.getKysymykset().get(i);
                kirjoittaja.write(ky.getId() + ";" + ky.getKuvaus() + ";" + ky.getOikeavastaus() + "\n");
            }
            kirjoittaja.close();
        } catch (IOException ex) {
            System.out.println("Kirjoitus epäonnistui. " + ex);
        }
        
    }
    
}
