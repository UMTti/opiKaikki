package com.mycompany.GUI;

import java.awt.Container;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.HashMap;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JTextField;

import com.mycompany.olioluokat.Kysymys;
import com.mycompany.olioluokat.Moduuli;

public class KysymyksenPoistoNäkymäKuuntelija implements ActionListener {

	   private Moduuli m;
	   private Container container;

	    public KysymyksenPoistoNäkymäKuuntelija(Moduuli m, Container container) {
	        this.m = m;
	        this.container = container;
	    }

	    @Override
	    public void actionPerformed(ActionEvent e) {
	        container.removeAll();
	        BoxLayout layout = new BoxLayout(container, BoxLayout.Y_AXIS);
	        container.setLayout(layout);
	        JLabel esittely = new JLabel("Poista kysymys moduulista " + m.getNimi());
	        container.add(esittely);
	        
	        HashMap<Integer, JCheckBox> lista = new HashMap<Integer, JCheckBox>();
	        for(int k: m.getKysymystenKäsittelijä().getKysymykset().keySet()){
	        	Kysymys kysymys = m.getKysymystenKäsittelijä().getKysymykset().get(k);
	        	JCheckBox checkbox = new JCheckBox(kysymys.getKuvaus() + ", oikea vastaus: " + kysymys.getOikeavastaus());
	        	container.add(checkbox);
	        	lista.put(kysymys.getId(), checkbox);
	        }
	        
	        if(m.getKysymystenKäsittelijä().getKysymykset().size() > 0){
	        	JButton poistaNappi = new JButton("Poista valitut kysymykset!");
	 	        KysymyksenPoistoKuuntelija kuuntelija = new KysymyksenPoistoKuuntelija(m, container, lista);
	 	        poistaNappi.addActionListener(kuuntelija);
	 	        container.add(poistaNappi);
	        } else {
	        	JLabel info = new JLabel("Moduulissa ei ole yhtään kysymystä.");
		        container.add(info);
	        }
	        
	        container.add(new JLabel("\n"));
	        
	        JButton backNappi = new JButton("Takaisin päävalikkoon");
	        BackNappiKuuntelija bäkkikuuntelija = new BackNappiKuuntelija(container);
	        backNappi.addActionListener(bäkkikuuntelija);
	        container.add(backNappi);
	        
	        container.validate();
	        container.repaint();
	    }
	    
}
