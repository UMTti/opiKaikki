/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

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
    
    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private final ByteArrayOutputStream errContent = new ByteArrayOutputStream();

    @Before
    public void setUpStreams() {
        System.setOut(new PrintStream(outContent));
        System.setErr(new PrintStream(errContent));
    }

    @After
    public void cleanUpStreams() {
        System.setOut(null);
        System.setErr(null);
    }
    
    @Test
    public void testaaTulostus(){
    	KysymystenKäsittelijä k = new KysymystenKäsittelijä("txttiedostot/testimoduuli.txt");
    	k.lisääKysymys(3, "tässäpä kysymys", "T", "");
    	k.tulostaKysymykset();
    	assertTrue(outContent.toString().contains("tässäpä kysymys"));
    	k.poistaKysymys(3);
    }
    
    @Test
    public void luoKäsittelijä(){
        KysymystenKäsittelijä k = new KysymystenKäsittelijä("txttiedostot/testimoduuli.txt");
        assertEquals("txttiedostot/testimoduuli.txt", k.getTiedostonimi());
    }
    
    @Test 
    public void lisaaKysymys(){
        KysymystenKäsittelijä k = new KysymystenKäsittelijä("txttiedostot/testimoduuli.txt");
        int koko = k.getKysymykset().size();
        k.lisääKysymys("tässäpä kysymys", "T", "");
        assertEquals(koko+1, k.getKysymykset().size());
        k.poistaKysymys(3);
    }
    
    @Test
    public void testaaMuokkaaKysymystä(){
    	KysymystenKäsittelijä k = new KysymystenKäsittelijä("txttiedostot/testimoduuli.txt");
    	k.lisääKysymys(3, "tässäpä kysymys", "T", "");
    	k.muokkaaKysymystä(3, "kysymys");
    	assertEquals(k.getKysymykset().get(3).getKuvaus(), "kysymys");
    	k.poistaKysymys(3);
    }
    
    @Test
    public void testaaMuokkaaVastausta(){
    	KysymystenKäsittelijä k = new KysymystenKäsittelijä("txttiedostot/testimoduuli.txt");
    	k.lisääKysymys(3, "tässäpä kysymys", "T", "");
    	k.muokkaaVastausta(3, "vastaus");
    	assertEquals(k.getKysymykset().get(3).getOikeavastaus(), "vastaus");
    	k.poistaKysymys(3);
    }
    
    @Test
    public void lisaaKysymysKuormitettu(){
        KysymystenKäsittelijä k = new KysymystenKäsittelijä("txttiedostot/testimoduuli.txt");
        k.lisääKysymys(3, "tässäpä kysymys", "T", "");
        assertEquals(3, k.getKysymykset().get(3).getId());
        k.poistaKysymys(3);
    }
    
    @Test
    public void poistaKysymys(){
        KysymystenKäsittelijä k = new KysymystenKäsittelijä("txttiedostot/testimoduuli.txt");
        k.lisääKysymys(3, "tässäpä kysymys", "T", "");
        k.poistaKysymys(3);
        assertEquals(null, k.getKysymykset().get(3));
    }
    
    
}
