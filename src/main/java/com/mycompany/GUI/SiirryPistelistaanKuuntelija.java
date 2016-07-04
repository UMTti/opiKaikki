package com.mycompany.GUI;

import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextField;

import com.mycompany.olioluokat.Pistelista;

public class SiirryPistelistaanKuuntelija implements ActionListener {
	
	Container container;
	Pistelista plista;
	JTextField pelaaja;
	int pisteet;
	public SiirryPistelistaanKuuntelija(Container container, Pistelista plista, JTextField pelaaja, int uudetpisteet){
		this.container = container;
		this.plista = plista;
		this.pelaaja = pelaaja;
		this.pisteet = uudetpisteet;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		plista.lisääPiste(pelaaja.getText(), pisteet);
	    container.removeAll();
		
		BoxLayout layout = new BoxLayout(container, BoxLayout.Y_AXIS);
        container.setLayout(layout);
        
		container.add(new JLabel("Pistelista"));
		
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
