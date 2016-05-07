package com.mycompany.GUI;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.HashMap;

import javax.swing.JCheckBox;

import javax.swing.JTextField;

import com.mycompany.olioluokat.Moduuli;

public class KysymyksenPoistoKuuntelija implements ActionListener{
	
	  private Moduuli m;
	  private Container container;
	  private HashMap<Integer, JCheckBox> lista;

	  public KysymyksenPoistoKuuntelija(Moduuli m, Container container, HashMap<Integer, JCheckBox> lista) {
	        this.m = m;
	        this.container = container;
	        this.lista = lista;
	  }

	  @Override
	  public void actionPerformed(ActionEvent e) {
	        for(int id: this.lista.keySet()){
	        	JCheckBox checkbox = lista.get(id);
	        	if(checkbox.isSelected()){
	        		System.out.println("poistettiin");
	        		this.m.getKysymystenKäsittelijä().poistaKysymys(id);
	        	}
	        }
	        container.removeAll();
	        container.add(new ModuuliPanel(this.m, this.container), BorderLayout.SOUTH);
	        container.validate();
	        container.repaint();
	  }
}
