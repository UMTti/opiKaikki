package com.mycompany.DAO;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.util.HashMap;
import java.util.Scanner;

import com.mycompany.olioluokat.Moduuli;
import com.mycompany.olioluokat.Pistelista;
import com.mycompany.olioluokat.Sessio;
import com.mycompany.olioluokat.Vastaus;

public class PistelistaDAO {
	
	public static HashMap<String, Integer> lataaPisteet(String tiedosto){
		 Scanner lukija;
	        try {
	            lukija = new Scanner(new File(tiedosto));
	        } catch (FileNotFoundException ex) {
	            System.out.println("Tiedostoa ei löytynyt");
	            return null;
	        }
	        return luePisteet(lukija);
	}
	
	private static HashMap<String, Integer> luePisteet(Scanner lukija){
	      HashMap<String, Integer> pisteet = new HashMap<String, Integer>();
		  while (lukija.hasNextLine()) {
	            String rivi = lukija.nextLine();
	            String[] tiedot = rivi.split(",");
	            pisteet.put(tiedot[0], Integer.parseInt(tiedot[1])); // pelaajan nimi, pelaajan pisteet
	      }
	      lukija.close();
	      return pisteet;
	}
	
	public static void tallennaPisteet(HashMap<String, Integer> pisteet, String tiedosto){
		        FileWriter kirjoittaja;
		        try {
		            kirjoittaja = new FileWriter(tiedosto);
		            for (String pelaaja : pisteet.keySet()) {
		                kirjoittaja.write(pelaaja + "," + pisteet.get(pelaaja) + "\n");
		            }
		            kirjoittaja.close();
		        } catch (Exception ex) {
		            System.out.println("Kirjoitus epäonnistui.");
		        }
	}
}
