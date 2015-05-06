/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.GUI;

import com.mycompany.olioluokat.Moduuli;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JTextField;

/**
 *
 * @author pihla
 */
public class KysymyksenLisäysKuuntelija implements ActionListener {

    private JTextField kysymysKentta;
    private JTextField oikeavastausKentta;
    private Moduuli m;

    public KysymyksenLisäysKuuntelija(Moduuli m, JTextField oikeavastausKentta, JTextField kysymysKentta) {
        this.m = m;
        this.oikeavastausKentta = oikeavastausKentta;
        this.kysymysKentta = kysymysKentta;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        System.out.println(this.m.getKysymystenKäsittelijä().getKysymykset().size());
        this.m.getKysymystenKäsittelijä().lisääKysymys(oikeavastausKentta.getText(), kysymysKentta.getText());
        System.out.println(this.m.getKysymystenKäsittelijä().getKysymykset().size());
    }
}
