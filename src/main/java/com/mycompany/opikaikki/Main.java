/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.opikaikki;

import com.mycompany.GUI.Kayttoliittyma;
import com.mycompany.käsittelijät.VastaustenKäsittelijä;
import com.mycompany.käsittelijät.KysymystenKäsittelijä;
import com.mycompany.olioluokat.Moduuli;
import java.util.ArrayList;
import javax.swing.SwingUtilities;

/**
 *
 * @author pihla
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        /*KysymystenKäsittelijä k = new KysymystenKäsittelijä("src/tmoduuli.txt");
        k.tulostaKysymykset();
        k.lisääKysymys("neljas", "T");
        k.tallennaKysymykset();
        VastaustenKäsittelijä v = new VastaustenKäsittelijä("src/tmoduulivastaukset.txt", k);
        v.lisääVastaus(2, "T");
        v.tallennaVastaukset();*/
        Kayttoliittyma kayttoliittyma = new Kayttoliittyma();
        SwingUtilities.invokeLater(kayttoliittyma);
    }
    
}
