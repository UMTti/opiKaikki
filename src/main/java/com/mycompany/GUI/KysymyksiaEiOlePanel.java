package com.mycompany.GUI;

import java.awt.Container;
import java.awt.GridLayout;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import com.mycompany.olioluokat.Moduuli;

public class KysymyksiaEiOlePanel extends JPanel {
    private Container container;
    
    public KysymyksiaEiOlePanel(Container container) {
        super(new GridLayout(1, 3));
        this.container = container;
        luoKomponentit();
    }

    private void luoKomponentit() {
        BoxLayout layout = new BoxLayout(container, BoxLayout.Y_AXIS);
        container.setLayout(layout);
        
        
        JButton backNappi = new JButton("Takaisin päävalikkoon");
        BackNappiKuuntelija bäkkikuuntelija = new BackNappiKuuntelija(container);
        backNappi.addActionListener(bäkkikuuntelija);
        
        container.add(new JLabel("Kysymyksiä ei ole! Palaa päävalikkoon."));
        
        container.add(new JLabel("\n"));
        container.add(backNappi);
    }
    
}
