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
import javax.swing.BoxLayout;
import javax.swing.JButton;
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
        JButton nappi = new JButton("Lisää kysymys moduuliin");
        KysymyksenLisäysnäkymäKuuntelija kuuntelija = new KysymyksenLisäysnäkymäKuuntelija(m, container);
        nappi.addActionListener(kuuntelija);
        container.add(nappi);
    }
}
