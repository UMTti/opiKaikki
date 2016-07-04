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
import java.util.Iterator;
import javax.swing.JTextField;

/**
 *
 * @author pihla
 */
public class KierroksenAloitusKuuntelija implements ActionListener {

    
    private Moduuli m;
    private Container container;

    public KierroksenAloitusKuuntelija(Moduuli m, Container container) {
        this.m = m;
        this.container = container;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Sessio uusi = new Sessio(this.m, this.m.getVastausTiedostonnimi(), this.m.getKysymystenKäsittelijä());
        ArrayList<Kysymys> kysymykset = uusi.annaKysymyksetAlussa();
        container.removeAll();
        if(kysymykset.size() != 0){
        	 container.add(new KysymysPanel(uusi, this.container, kysymykset, 0), BorderLayout.SOUTH);
        } else {
        	container.add(new KysymyksiaEiOlePanel(this.container), BorderLayout.SOUTH);
        }
        container.validate();
        container.repaint();
    }
}
