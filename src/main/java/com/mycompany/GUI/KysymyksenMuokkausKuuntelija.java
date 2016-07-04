package com.mycompany.GUI;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;

import javax.swing.JCheckBox;
import javax.swing.JTextField;

import com.mycompany.olioluokat.Moduuli;

public class KysymyksenMuokkausKuuntelija implements ActionListener {
	
	 private Moduuli m;
	 private Container container;
	 private HashMap<Integer, JTextField[]> lista;

	  public KysymyksenMuokkausKuuntelija(Moduuli m, Container container, HashMap<Integer, JTextField[]> lista) {
	        this.m = m;
	        this.container = container;
	        this.lista = lista;
	  }


	@Override
	public void actionPerformed(ActionEvent e) {
		 for(int id: this.lista.keySet()){
	        	JTextField[] arvot = lista.get(id);
	        	String kysymyksenarvo = arvot[0].getText();
	        	String vastauksenarvo = arvot[1].getText();
	        	if(kysymyksenarvo != null && !kysymyksenarvo.equals("")){
	        		this.m.getKysymystenKäsittelijä().muokkaaKysymystä(id, kysymyksenarvo);
	        	}
	        	if(vastauksenarvo != null && !vastauksenarvo.equals("")){
	        		this.m.getKysymystenKäsittelijä().muokkaaVastausta(id, vastauksenarvo);
	        	}
	        }
	        container.removeAll();
	        container.add(new ModuuliPanel(this.m, this.container), BorderLayout.SOUTH);
	        container.validate();
	        container.repaint();
		
	}

}
