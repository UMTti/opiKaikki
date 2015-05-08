/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import com.mycompany.käsittelijät.KysymystenKäsittelijä;
import com.mycompany.olioluokat.Moduuli;
import com.mycompany.olioluokat.Sessio;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
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
        String kysymystiedosto = "src/tmoduuli.txt";
        String vastaustiedosto = "src/tmoduulivastaukset.txt";
        Moduuli K = new Moduuli("K-moduuli", kysymystiedosto, vastaustiedosto);
        Sessio uusi = new Sessio(K, vastaustiedosto, new KysymystenKäsittelijä(kysymystiedosto));
        uusi.lisääVastaus(9000, "UusiVastaus");
        assertTrue(outContent.toString().contains("Vastaukselle ei ole kysymystä"));
    }

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    // @Test
    // public void hello() {}
}
