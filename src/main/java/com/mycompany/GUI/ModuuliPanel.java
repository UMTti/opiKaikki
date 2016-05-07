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
import com.mycompany.olioluokat.Moduuli;
import java.awt.Container;
import java.awt.GridLayout;
import java.util.ArrayList;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class ModuuliPanel extends JPanel {

    private Moduuli m;
    private Container container;
    
    public ModuuliPanel(Moduuli m, Container container) {
        super(new GridLayout(1, 3));
        this.m = m;
        this.container = container;
        luoKomponentit();
    }

    private void luoKomponentit() {
        BoxLayout layout = new BoxLayout(container, BoxLayout.Y_AXIS);
        container.setLayout(layout);
        JLabel moduulinNimi = new JLabel(this.m.getNimi());
        
        JButton nappi = new JButton("Lisää kysymys moduuliin");
        KysymyksenLisäysnäkymäKuuntelija kuuntelija = new KysymyksenLisäysnäkymäKuuntelija(m, container);
        nappi.addActionListener(kuuntelija);
        
        JButton poistoNappi = new JButton("Poista kysymyksiä moduulista");
        KysymyksenPoistoNäkymäKuuntelija poistokuuntelija = new KysymyksenPoistoNäkymäKuuntelija(m, container);
        poistoNappi.addActionListener(poistokuuntelija);
        
        JButton aloitusNappi = new JButton("Aloita kierros");
        KierroksenAloitusKuuntelija aloituskuuntelija = new KierroksenAloitusKuuntelija(m, container);
        aloitusNappi.addActionListener(aloituskuuntelija);
        
        JButton backNappi = new JButton("Takaisin päävalikkoon");
        BackNappiKuuntelija bäkkikuuntelija = new BackNappiKuuntelija(container);
        backNappi.addActionListener(bäkkikuuntelija);
        
        container.add(moduulinNimi);
        container.add(new JLabel("\n"));
        container.add(nappi);
        container.add(new JLabel("\n"));
        container.add(poistoNappi);
        container.add(new JLabel("\n"));
        container.add(aloitusNappi);
        container.add(new JLabel("\n"));
        container.add(backNappi);
    }
    
}
