/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import com.mycompany.käsittelijät.KysymystenKäsittelijä;
import com.mycompany.olioluokat.Kysymys;
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
public class KysymystenKäsittelijäTest {
    
    public KysymystenKäsittelijäTest() {
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
    public void luoKäsittelijä(){
        KysymystenKäsittelijä k = new KysymystenKäsittelijä("src/tmoduuli.txt");
        assertEquals("src/tmoduuli.txt", k.getTiedostonimi());
    }
    
    @Test 
    public void lisaaKysymys(){
        KysymystenKäsittelijä k = new KysymystenKäsittelijä("src/tmoduuli.txt");
        int koko = k.getKysymykset().size();
        k.lisääKysymys("tässäpä kysymys", "T");
        assertEquals(koko+1, k.getKysymykset().size());
    }
    
    @Test
    public void lisaaKysymysKuormitettu(){
        KysymystenKäsittelijä k = new KysymystenKäsittelijä("src/tmoduuli.txt");
        k.lisääKysymys(3, "tässäpä kysymys", "T");
        assertEquals(3, k.getKysymykset().get(3).getId());
    }
    
    
}
