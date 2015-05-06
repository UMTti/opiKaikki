/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.opikaikki;

/**
 *
 * @author pihla
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        KysymystenKäsittelijä k = new KysymystenKäsittelijä("src/tmoduuli.txt");
        k.tulostaKysymykset();
    }
    
}
