/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.GUI;

import com.mycompany.olioluokat.Moduuli;
import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Dimension;
import java.util.ArrayList;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextArea;
import javax.swing.WindowConstants;

public class Kayttoliittyma implements Runnable {

    private JFrame frame;

    public Kayttoliittyma() {
    }

    @Override
    public void run() {
        frame = new JFrame("Otsikko");
        frame.setPreferredSize(new Dimension(400, 400));

        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        luoKomponentit(frame.getContentPane());

        frame.pack();
        frame.setVisible(true);
    }

    private void luoKomponentit(Container container) {
        BoxLayout layout = new BoxLayout(container, BoxLayout.Y_AXIS);
        container.setLayout(layout);

        ArrayList<Moduuli> moduulit = luoModuulit();
        for(Moduuli m: moduulit){
            JButton nappi = new JButton(m.getNimi());
            ModuulinKlikkausKuuntelija kuuntelija = new ModuulinKlikkausKuuntelija(m, container);
            nappi.addActionListener(kuuntelija);
            container.add(nappi);
            
        }
    }

    public JFrame getFrame() {
        return frame;
    }

    public static ArrayList<Moduuli> luoModuulit() {
        ArrayList<Moduuli> moduulit = new ArrayList<Moduuli>();
        Moduuli K = new Moduuli("K-moduuli", "src/k.txt", "src/kvastaukset.txt");
        moduulit.add(K);
        Moduuli t1 = new Moduuli("T1-moduuli", "src/tmoduuli.txt", "src/tmoduulivastaukset.txt");
        moduulit.add(t1);
        Moduuli t2 = new Moduuli("T2-moduuli", "src/t2moduuli.txt", "src/t2moduulivastaukset.txt");
        moduulit.add(t2);
        return moduulit;
    }

}
