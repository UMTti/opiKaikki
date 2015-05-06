/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import com.mycompany.käsittelijät.KysymystenKäsittelijä;
import com.mycompany.käsittelijät.VastaustenKäsittelijä;
import com.mycompany.olioluokat.Kysymys;
import com.mycompany.olioluokat.Vastaus;
import java.util.ArrayList;
import java.util.HashMap;
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
public class VastausDAOTest {
    
    public VastausDAOTest() {
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
    public void testaaTallennusjaLataus(){
        KysymystenKäsittelijä k = new KysymystenKäsittelijä("src/tmoduuli.txt");
        VastaustenKäsittelijä v = new VastaustenKäsittelijä("src/tmoduulivastaukset.txt", k);
        ArrayList<Vastaus> alussa = v.getVastaukset();
        v.tallennaVastaukset();
        k = new KysymystenKäsittelijä("src/tmoduuli.txt");
        ArrayList<Vastaus> lopussa = v.getVastaukset();
        assertEquals(lopussa.size(), alussa.size());
    }
}
