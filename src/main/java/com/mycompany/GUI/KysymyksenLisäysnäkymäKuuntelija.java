/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.GUI;

import com.mycompany.olioluokat.Kysymys;
import com.mycompany.olioluokat.Moduuli;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextField;

/**
 *
 * @author pihla
 */
public class KysymyksenLisäysnäkymäKuuntelija implements ActionListener {

    private Moduuli m;
    private Container container;

    public KysymyksenLisäysnäkymäKuuntelija(Moduuli m, Container container) {
        this.m = m;
        this.container = container;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        container.removeAll();
        BoxLayout layout = new BoxLayout(container, BoxLayout.Y_AXIS);
        container.setLayout(layout);
        JLabel esittely = new JLabel("Lisää kysymys moduuliin " + m.getNimi());
        JLabel kysymysTeksti = new JLabel("Anna kysymys: ");
        JTextField kysymysKentta = new JTextField();
        kysymysKentta.setSize(new Dimension(5, 5));
        JLabel oikeavastausTeksti = new JLabel("Oikea vastaus (E / T) ");
        JTextField oikeavastausKentta = new JTextField();
        JButton lisaaNappi = new JButton("Lisää kysymys!");
        KysymyksenLisäysKuuntelija kuuntelija = new KysymyksenLisäysKuuntelija(m, oikeavastausKentta, kysymysKentta, container);
        lisaaNappi.addActionListener(kuuntelija);
        container.add(esittely);
        container.add(kysymysTeksti);
        container.add(kysymysKentta);
        container.add(oikeavastausTeksti);
        container.add(oikeavastausKentta);
        container.add(lisaaNappi);
        container.validate();
        container.repaint();
    }
}
