/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.GUI;

import com.mycompany.olioluokat.Kysymys;
import com.mycompany.olioluokat.Moduuli;
import com.mycompany.olioluokat.Sessio;
import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import javax.swing.JTextField;
import java.util.Map.Entry;

/**
 *
 * @author pihla
 */
public class SeuraavaKysymysKuuntelija implements ActionListener {

    private Container container;
    private Sessio s;
    private ArrayList<Kysymys> kysymykset;
    private JTextField vastausKentta;
    private int indeksi;
    

    public SeuraavaKysymysKuuntelija(Sessio s, Container container, ArrayList<Kysymys> kysymykset, int indeksi, JTextField vastausKentta) {
        this.kysymykset = kysymykset;
        this.indeksi = indeksi;
        this.vastausKentta = vastausKentta;
        this.s = s;
        this.container = container;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Kysymys k = this.kysymykset.get(this.indeksi);
        this.s.lisääVastaus(k.getId(), vastausKentta.getText());
        container.removeAll();
        this.indeksi++;
        
        if(this.indeksi <= this.kysymykset.size() - 1){
            container.add(new KysymysPanel(this.s, this.container, this.kysymykset, this.indeksi), BorderLayout.SOUTH);
        } else {
            this.s.getModuuli().lisääSessio(this.s);
            this.s.tallennaSessio();
            container.add(new ModuuliPanel(this.s.getModuuli(), this.container), BorderLayout.SOUTH);
        }
        
        container.validate();
        container.repaint();
    }
}
