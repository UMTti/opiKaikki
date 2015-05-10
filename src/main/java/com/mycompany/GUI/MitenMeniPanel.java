package com.mycompany.GUI;

/**
 *
 * @author pihla
 */
import com.mycompany.olioluokat.Kysymys;
import com.mycompany.olioluokat.Moduuli;
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
        
        ArrayList<String> aihepiirikoonnit = koontiAihepiireistä();
        for(String aihepiirikoonti: aihepiirikoonnit){
            
            JLabel koontiTeksti = new JLabel(aihepiirikoonti);
            container.add(koontiTeksti);
            container.add(new JLabel("\n"));
        }
        
        JButton backNappi = new JButton("Takaisin päävalikkoon");
        BackNappiKuuntelija bäkkikuuntelija = new BackNappiKuuntelija(container);
        backNappi.addActionListener(bäkkikuuntelija);
        
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
