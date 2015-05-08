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
import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.GridLayout;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class PääValikkoPanel extends JPanel {

    private Container container;
    private ArrayList<Moduuli> moduulit;
    
    public PääValikkoPanel(Container container) {
        super(new BorderLayout());
        this.container = container;
        this.moduulit = luoModuulit();
        luoKomponentit();
    }

    private void luoKomponentit() {
        int i = 0;
        for(Moduuli m: moduulit){
            JButton nappi = new JButton(m.getNimi());
            ModuulinKlikkausKuuntelija kuuntelija = new ModuulinKlikkausKuuntelija(m, container);
            nappi.addActionListener(kuuntelija);
            if(i == 0){
                container.add(nappi, BorderLayout.WEST);
                i++;
            } else if(i == 1){
                container.add(nappi, BorderLayout.CENTER);
                i++;
            } else if(i == 2){
                container.add(nappi, BorderLayout.EAST);
            }   
        }
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
