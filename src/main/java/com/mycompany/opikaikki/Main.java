/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.opikaikki;

import com.mycompany.GUI.Kayttoliittyma;
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
        Kayttoliittyma kayttoliittyma = new Kayttoliittyma();
        SwingUtilities.invokeLater(kayttoliittyma);
    }
    
}
