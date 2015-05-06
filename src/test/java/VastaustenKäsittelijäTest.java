/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import com.mycompany.käsittelijät.KysymystenKäsittelijä;
import com.mycompany.käsittelijät.VastaustenKäsittelijä;
import com.mycompany.olioluokat.Vastaus;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author pihla
 */
public class VastaustenKäsittelijäTest {
    
    public VastaustenKäsittelijäTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }
    
    @Test
    public void lisaaVastaus(){
        KysymystenKäsittelijä k = new KysymystenKäsittelijä("src/tmoduuli.txt");
        k.lisääKysymys(1, "kysymys", "T");
        VastaustenKäsittelijä v = new VastaustenKäsittelijä("src/tmoduulivastaukset.txt", k);
        v.lisääVastaus(1, "E");
        boolean onko = false;
        for(Vastaus va: v.getVastaukset()){
            if(va.getKysymys().getId() == 1){
                onko = true;
            } 
        }
        assertTrue(onko);
    }

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    // @Test
    // public void hello() {}
}
