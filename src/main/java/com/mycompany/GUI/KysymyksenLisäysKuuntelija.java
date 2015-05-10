/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.GUI;

import com.mycompany.olioluokat.Moduuli;
import java.awt.BorderLayout;
import java.awt.Container;
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
    private JTextField aihepiiriKentta;
    private Moduuli m;
    private Container container;

    public KysymyksenLisäysKuuntelija(Moduuli m, JTextField oikeavastausKentta, JTextField kysymysKentta, JTextField aihepiiriKentta, Container container) {
        this.m = m;
        this.container = container;
        this.oikeavastausKentta = oikeavastausKentta;
        this.aihepiiriKentta = aihepiiriKentta;
        this.kysymysKentta = kysymysKentta;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        this.m.getKysymystenKäsittelijä().lisääKysymys(kysymysKentta.getText(), oikeavastausKentta.getText(), aihepiiriKentta.getText());
        this.m.getKysymystenKäsittelijä().tallennaKysymykset();
        container.removeAll();
        container.add(new ModuuliPanel(this.m, this.container), BorderLayout.SOUTH);
        container.validate();
        container.repaint();
    }
}
