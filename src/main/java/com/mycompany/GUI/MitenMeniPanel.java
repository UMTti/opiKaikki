package com.mycompany.GUI;

/**
 *
 * @author pihla
 */
import com.mycompany.olioluokat.Kysymys;
import com.mycompany.olioluokat.Moduuli;
import com.mycompany.olioluokat.Pistelista;
import com.mycompany.olioluokat.Sessio;
import com.mycompany.olioluokat.Vastaus;
import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.GridLayout;
import java.util.ArrayList;
import java.util.HashMap;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class MitenMeniPanel extends JPanel {

    private Moduuli m;
    private Container container;
    private Sessio s;
    private ArrayList<Kysymys> kysymykset;
    
    public MitenMeniPanel(Sessio s, Moduuli m, Container container, ArrayList<Kysymys> kysymykset) {
        super(new GridLayout(1, 3));
        this.m = m;
        this.container = container;
        this.s = s;
        this.kysymykset = kysymykset;
        luoKomponentit();
    }

    private void luoKomponentit() {
        BoxLayout layout = new BoxLayout(container, BoxLayout.Y_AXIS);
        container.setLayout(layout);
        
        JLabel koonti = new JLabel("Koonti");
        JLabel oikein = new JLabel("Vastasit oikein " + montakoOikein() + " kysymykseen " + this.kysymykset.size() + ":sta kysymyksestä");
        container.add(koonti);
        container.add(oikein);
        
        container.add(new JLabel("Anna nimesi pistelistaa varten: "));
        JTextField nimikenttä = new JTextField(20);
        container.add(nimikenttä);
        Pistelista.getInstanssi().lisääPiste("pelaaja", 10);
        
        ArrayList<String> oikeinMenneet = vastasitOikeinNäihinKysymyksiin();
        container.add(new JLabel("Vastasit oikein kysymyksiin: \n"));
        for(String kysymys: oikeinMenneet){
            
            JLabel koontiTeksti = new JLabel(kysymys);
            container.add(koontiTeksti);
            container.add(new JLabel("\n"));
        }
        
        ArrayList<String> aihepiirikoonnit = koontiAihepiireistä();
        for(String aihepiirikoonti: aihepiirikoonnit){
            
            JLabel koontiTeksti = new JLabel(aihepiirikoonti);
            container.add(koontiTeksti);
            container.add(new JLabel("\n"));
        }
        
        JButton backNappi = new JButton("Lisää pisteet pistelistaan");
        double prosent = (double) montakoOikein() / (double) this.kysymykset.size();
        System.out.println(prosent);
        int prosentti = (int) Math.round(prosent * 100);
        System.out.println(prosentti);
        SiirryPistelistaanKuuntelija pistelistakuuntelija = new SiirryPistelistaanKuuntelija(container, Pistelista.getInstanssi(), nimikenttä, prosentti);
        backNappi.addActionListener(pistelistakuuntelija);
        
        container.add(backNappi);
    }
    
    private int montakoOikein(){
        return this.kysymykset.size() - this.s.kerroVäärinMenneet().size();
    }
    
    private ArrayList<String> koontiAihepiireistä(){
        HashMap<String, int[]> aihepiirit = luoAihepiiriHashmap();
        ArrayList<String> palautus = new ArrayList<String>();
        
        for(String piiri : aihepiirit.keySet()){
            int[] määrät = aihepiirit.get(piiri);
            int prosentit = (int) Math.floor(((double) määrät[0] / (double) määrät[1]) * 100);
            String koonti = "Aihepiiristä " + piiri + " sait " + prosentit + " prosenttia oikein";
            palautus.add(koonti);
        }
        return palautus;
    }
    
    private ArrayList<String> vastasitOikeinNäihinKysymyksiin(){
        ArrayList<String> oikeinMenneet = new ArrayList<String>();
        for(Vastaus v: this.s.getVastaukset()){
            if(v.getVastaus().equals(v.getKysymys().getOikeavastaus())){
                oikeinMenneet.add(v.getKysymys().getKuvaus());
            }
        }
        return oikeinMenneet;
    }
    
    private HashMap<String, int[]> luoAihepiiriHashmap(){
        HashMap<String, int[]> aihepiirit = new HashMap<String, int[]>();
        for(Vastaus v: this.s.getVastaukset()){
            String kysymyksenaihepiiri = v.getKysymys().getAihepiiri();
            if(aihepiirit.get(kysymyksenaihepiiri) == null){
                aihepiirit.put(kysymyksenaihepiiri, new int[2]);
            }
            int[] määrät = aihepiirit.get(kysymyksenaihepiiri);
            määrät[1]++;
            if(v.getVastaus().equals(v.getKysymys().getOikeavastaus())){
                määrät[0]++;
            }
        }
        return aihepiirit;
    }
    
}
