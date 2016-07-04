package com.mycompany.GUI;

import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JTextField;

import com.mycompany.olioluokat.Kysymys;
import com.mycompany.olioluokat.Moduuli;

public class KysymyksenMuokkausNäkymäKuuntelija implements ActionListener {
	
	private Moduuli m;
	   private Container container;

	    public KysymyksenMuokkausNäkymäKuuntelija(Moduuli m, Container container) {
	        this.m = m;
	        this.container = container;
	    }

	@Override
	public void actionPerformed(ActionEvent e) {
		    container.removeAll();
	        BoxLayout layout = new BoxLayout(container, BoxLayout.Y_AXIS);
	        container.setLayout(layout);
	        JLabel esittely = new JLabel("Muokkaa kysymyksiä moduulista " + m.getNimi());
	        container.add(esittely);
	        
	        HashMap<Integer, JTextField[]> lista = new HashMap<Integer, JTextField[]>();
	        for(int k: m.getKysymystenKäsittelijä().getKysymykset().keySet()){
	        	Kysymys kysymys = m.getKysymystenKäsittelijä().getKysymykset().get(k);
	        	
	        	container.add(new JLabel(kysymys.getKuvaus()));
	        	JTextField kysymyksenmuokkaus = new JTextField(1);
	        	container.add(kysymyksenmuokkaus);
	        	container.add(new JLabel(kysymys.getOikeavastaus()));
	        	JTextField vastauksenmuokkaus = new JTextField(2);
	        	container.add(vastauksenmuokkaus);
	        	
	        	JTextField[] muokkaukset = new JTextField[2];
	        	muokkaukset[0] = kysymyksenmuokkaus;
	        	muokkaukset[1] = vastauksenmuokkaus;
	        	lista.put(kysymys.getId(), muokkaukset);
	        }
	        
	        if(m.getKysymystenKäsittelijä().getKysymykset().size() > 0){
	        	JButton teeMuokkauksetNappi = new JButton("Tee muokkaukset!");
	 	        KysymyksenMuokkausKuuntelija kuuntelija = new KysymyksenMuokkausKuuntelija(m, container, lista);
	 	        teeMuokkauksetNappi.addActionListener(kuuntelija);
	 	        container.add(teeMuokkauksetNappi);
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
