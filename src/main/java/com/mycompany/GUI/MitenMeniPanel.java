package com.mycompany.GUI;

/**
 *
 * @author pihla
 */
import com.mycompany.olioluokat.Kysymys;
import com.mycompany.olioluokat.Moduuli;
import com.mycompany.olioluokat.Sessio;
import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.GridLayout;
import java.util.ArrayList;
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
        
        JButton backNappi = new JButton("Takaisin päävalikkoon");
        BackNappiKuuntelija bäkkikuuntelija = new BackNappiKuuntelija(container);
        backNappi.addActionListener(bäkkikuuntelija);
        
        container.add(backNappi);
    }
    
    private int montakoOikein(){
        return this.kysymykset.size() - this.s.kerroVäärinMenneet().size();
    }
    
}
