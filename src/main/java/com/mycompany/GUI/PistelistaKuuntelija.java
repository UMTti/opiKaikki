package com.mycompany.GUI;

import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;

import com.mycompany.olioluokat.Pistelista;

public class PistelistaKuuntelija implements ActionListener {
	
	Container container;
	Pistelista plista;
	public PistelistaKuuntelija(Container container, Pistelista plista){
		this.container = container;
		this.plista = plista;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		container.removeAll();
		
		BoxLayout layout = new BoxLayout(container, BoxLayout.Y_AXIS);
        container.setLayout(layout);
        
		container.add(new JLabel("Pistelista näyttää onnistumisprosentin vastattuihin kysymyksiin \n \n"));
		
		for(String pelaaja: plista.getPisteet().keySet()){
			container.add(new JLabel(pelaaja + " " + plista.getPisteet().get(pelaaja) + "\n"));
		}
		
	    JButton backNappi = new JButton("Takaisin päävalikkoon");
	    BackNappiKuuntelija bäkkikuuntelija = new BackNappiKuuntelija(container);
	    backNappi.addActionListener(bäkkikuuntelija);
	    
        container.add(backNappi);
        container.validate();
        container.repaint();
		
	}

}
