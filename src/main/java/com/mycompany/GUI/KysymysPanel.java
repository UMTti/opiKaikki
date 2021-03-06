/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.GUI;

/**
 *
 * @author pihla
 */
import com.mycompany.olioluokat.Kysymys;
import com.mycompany.olioluokat.Moduuli;
import com.mycompany.olioluokat.Sessio;
import java.awt.Container;
import java.awt.GridLayout;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import javax.swing.BoxLayout;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

public class KysymysPanel extends JPanel {

    private Container container;
    private Sessio s;
    private ArrayList<Kysymys> kysymykset;
    private int indeksi;

    public KysymysPanel(Sessio s, Container container, ArrayList<Kysymys> kysymykset, int i) {
        super(new GridLayout(1, 3));
        this.s = s;
        this.container = container;
        this.kysymykset = kysymykset;
        this.indeksi = i;
        luoKomponentit();
    }

    private void luoKomponentit() {
        BoxLayout layout = new BoxLayout(container, BoxLayout.Y_AXIS);
        container.setLayout(layout);
        Kysymys k = this.kysymykset.get(this.indeksi);
        JLabel kysymysKuvaus = new JLabel(k.getKuvaus());
        JLabel vastausTeksti = new JLabel("Anna vastaus (E / T) ");
        ButtonGroup group = new ButtonGroup();
        final JRadioButton epätosiNappi = new JRadioButton("E", true);
        final JRadioButton tosiNappi = new JRadioButton("T");
        group.add(epätosiNappi);
        group.add(tosiNappi);
        JButton lisaaNappi = new JButton("Vastaus valmis!");
        SeuraavaKysymysKuuntelija kuuntelija = new SeuraavaKysymysKuuntelija(this.s, container, this.kysymykset, this.indeksi, tosiNappi, epätosiNappi);
        lisaaNappi.addActionListener(kuuntelija);
        JLabel jäljellä = new JLabel("Jäljellä vielä " + (this.kysymykset.size() - indeksi - 1) + " kysymystä");
        this.container.add(kysymysKuvaus);
        this.container.add(vastausTeksti);
        this.container.add(epätosiNappi);
        this.container.add(tosiNappi);
        this.container.add(jäljellä);
        this.container.add(lisaaNappi);
    }
}
