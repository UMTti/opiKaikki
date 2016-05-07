/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import com.mycompany.käsittelijät.KysymystenKäsittelijä;
import com.mycompany.olioluokat.Kysymys;
import com.mycompany.olioluokat.Moduuli;
import com.mycompany.olioluokat.Sessio;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
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
public class SessioTest {
    
    public SessioTest() {
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
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }
    
    @Test
    public void lisääVastausJolleEiKysymystä(){
        String kysymystiedosto = "src/txttiedostot/tmoduuli.txt";
        String vastaustiedosto = "src/txttiedostot/tmoduulivastaukset.txt";
        Moduuli K = new Moduuli("K-moduuli", kysymystiedosto, vastaustiedosto);
        Sessio uusi = new Sessio(K, vastaustiedosto, new KysymystenKäsittelijä(kysymystiedosto));
        uusi.lisääVastaus(9000, "UusiVastaus");
        assertTrue(outContent.toString().contains("Kysymystä ei ole enää olemassa."));
    }
    
    /*@Test
    public void lisääKysymyksetHuomioiVäärinmenneet(){
        String kysymystiedosto = "src/txttiedostot/t2moduuli.txt";
        String vastaustiedosto = "src/txttiedostot/testimoduulivastaukset.txt";
        Moduuli K = new Moduuli("K-moduuli", kysymystiedosto, vastaustiedosto);
        Sessio uusi = new Sessio(K, vastaustiedosto, new KysymystenKäsittelijä(kysymystiedosto));
        ArrayList<Kysymys> kysymykset = uusi.annaKysymyksetAlussa();
        assertEquals(3, kysymykset.size());
    }*/
    
    @Test
    public void lisääKysymyksetTyhjästäTiedostosta(){
        String kysymystiedosto = "src/txttiedostot/t2moduuli.txt";
        String vastaustiedosto = "src/txttiedostot/tyhjavastaukset.txt";
        Moduuli K = new Moduuli("K-moduuli", kysymystiedosto, vastaustiedosto);
        Sessio uusi = new Sessio(K, vastaustiedosto, new KysymystenKäsittelijä(kysymystiedosto));
        ArrayList<Kysymys> kysymykset = uusi.annaKysymyksetAlussa();
        assertEquals(3, kysymykset.size());
    }

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    // @Test
    // public void hello() {}
}
