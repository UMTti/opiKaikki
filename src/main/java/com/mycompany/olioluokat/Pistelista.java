package com.mycompany.olioluokat;

import java.util.HashMap;

import com.mycompany.DAO.PistelistaDAO;

public class Pistelista {
	
	HashMap<String, Integer> pisteet;
	String tiedosto;
	static Pistelista instanssi;
	
	public static Pistelista getInstanssi(){
		if(instanssi == null){
			instanssi = new Pistelista();
			instanssi.tiedosto = "txttiedostot/pistelista.txt";
			instanssi.pisteet = PistelistaDAO.lataaPisteet(instanssi.tiedosto);
		}
		return instanssi;
	}
	
	public String getTiedosto(){
		return instanssi.tiedosto;
	}
	
	public void lisääPiste(String pelaaja, int uudetpisteet){
		if(this.pisteet.containsKey(pelaaja)){
			int nykyisetpisteet = this.pisteet.get(pelaaja);
			if(nykyisetpisteet > uudetpisteet){
				return;
			}
		}
		this.pisteet.put(pelaaja, uudetpisteet);
		PistelistaDAO.tallennaPisteet(pisteet, this.tiedosto);
	}
	
	public HashMap<String, Integer> getPisteet(){
		return this.pisteet;
	}
	
}
