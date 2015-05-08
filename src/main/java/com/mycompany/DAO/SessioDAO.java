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

    public static void lataaSessiot(Moduuli m) {
        Scanner lukija;
        try {
            System.out.println(m.getVastausTiedostonnimi());
            lukija = new Scanner(new File(m.getVastausTiedostonnimi()));
        } catch (FileNotFoundException ex) {
            System.out.println("Tiedostoa ei löytynyt");
            return;
        }
        lueSessiot(lukija, m);
    }

    public static void lueSessiot(Scanner lukija, Moduuli m) {
        Sessio uusi = new Sessio(m, m.getVastausTiedostonnimi(), m.getKysymystenKäsittelijä());
        while (lukija.hasNextLine()) {
            String rivi = lukija.nextLine();
            System.out.println("Rivi: " + rivi);
            if (rivi.contains("...")) {
                m.lisääSessio(uusi);
                uusi = new Sessio(m, m.getVastausTiedostonnimi(), m.getKysymystenKäsittelijä());
            } else {
                String[] tiedot = rivi.split(";");
                uusi.lisääVastaus(Integer.parseInt(tiedot[0]), tiedot[1]);
            }
            System.out.println(lukija.hasNextLine());
        }
        lukija.close();
    }

    public static void tallennaSessiot(Moduuli m) {
        FileWriter kirjoittaja;
        try {
            kirjoittaja = new FileWriter(m.getVastausTiedostonnimi());
            for (Sessio s : m.getSessiot()) {
                for (Vastaus va : s.getVastaukset()) {
                    kirjoittaja.write(va.getKysymys().getId() + ";" + va.getVastaus() + "\n");
                }
                kirjoittaja.write("..." + "\n");
            }
            kirjoittaja.close();
        } catch (Exception ex) {
            System.out.println("Kirjoitus epäonnistui.");
        }
    }

}
