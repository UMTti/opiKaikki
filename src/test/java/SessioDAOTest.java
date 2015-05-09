/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import com.mycompany.DAO.SessioDAO;
import com.mycompany.käsittelijät.KysymystenKäsittelijä;
import com.mycompany.olioluokat.Moduuli;
import com.mycompany.olioluokat.Sessio;
import java.io.ByteArrayOutputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintStream;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Rule;

/**
 *
 * @author pihla
 */
public class SessioDAOTest {

    public SessioDAOTest() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
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
    public void testaaTallennusJaLataus() {
        String kysymystiedosto = "src/txttiedostot/tmoduuli.txt";
        String vastaustiedosto = "src/txttiedostot/tmoduulivastaukset.txt";
        Moduuli K = new Moduuli("K-moduuli", kysymystiedosto, vastaustiedosto);
        Sessio uusi = new Sessio(K, vastaustiedosto, new KysymystenKäsittelijä(kysymystiedosto));
        uusi.lisääVastaus(1, "UusiVastaus");
        K.lisääSessio(uusi);
        int sessioita = K.getSessiot().size();
        System.out.println("Sessioita: " + sessioita);
        K.tallennaSessiot();
        K.tyhjennäSessiot();

        SessioDAO.lataaSessiot(K);
        int sessioitanyt = K.getSessiot().size();
        System.out.println("Sessioita nyt");
        assertEquals(sessioita, sessioitanyt);
    }

    @Test
    public void testaaVirheellinenLataus() {
        String kysymystiedosto = "src/ömh.txt";
        String vastaustiedosto = "src/ömhvastaukset.txt";
        Moduuli K = new Moduuli("K-moduuli", kysymystiedosto, vastaustiedosto);
        assertTrue(outContent.toString().contains("Tiedostoa ei löytynyt"));
    }

    /*@Test
    public void testaaVirheellinenTallennus() {
        String kysymystiedosto = "src/ömh.txt";
        String vastaustiedosto = "src/ömhvastaukset.txt";
        Moduuli K = new Moduuli("K-moduuli", kysymystiedosto, vastaustiedosto);
        K.tallennaSessiot();
        assertTrue(outContent.toString().contains("Kirjoitus epäonnistui."));
    }*/

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    // @Test
    // public void hello() {}
}
