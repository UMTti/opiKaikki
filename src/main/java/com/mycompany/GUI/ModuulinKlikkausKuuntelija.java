/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.GUI;

import com.mycompany.olioluokat.Kysymys;
import com.mycompany.olioluokat.Moduuli;
import java.awt.BorderLayout;
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
public class ModuulinKlikkausKuuntelija implements ActionListener {

    private Moduuli m;
    private Container container;

    public ModuulinKlikkausKuuntelija(Moduuli m, Container container) {
        this.m = m;
        this.container = container;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        container.removeAll();
        container.add(new ModuuliPanel(this.m, this.container), BorderLayout.SOUTH);

        container.validate();
        container.repaint();
    }
}
