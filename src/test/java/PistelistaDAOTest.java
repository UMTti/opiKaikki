import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.HashMap;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import com.mycompany.DAO.PistelistaDAO;
import com.mycompany.DAO.SessioDAO;
import com.mycompany.käsittelijät.KysymystenKäsittelijä;
import com.mycompany.olioluokat.Moduuli;
import com.mycompany.olioluokat.Sessio;


public class PistelistaDAOTest {
	 public PistelistaDAOTest() {
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
	        String tiedosto = "txttiedostot/pistelistatesti.txt";
	        HashMap<String, Integer> pisteet = PistelistaDAO.lataaPisteet(tiedosto);
	        pisteet.put("Pelaaja", 2);
	        PistelistaDAO.tallennaPisteet(pisteet, tiedosto);
	        HashMap<String, Integer> pisteet2 = PistelistaDAO.lataaPisteet(tiedosto);
	        assertTrue(pisteet2.containsKey("Pelaaja"));
	    }

	    @Test
	    public void testaaVirheellinenLataus() {
	        String tiedosto = "src/ömh.txt";
	        PistelistaDAO.lataaPisteet(tiedosto);
	        
	        assertTrue(outContent.toString().contains("Tiedostoa ei löytynyt"));
	    }
}
