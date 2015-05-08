/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import com.mycompany.DAO.SessioDAO;
import com.mycompany.käsittelijät.KysymystenKäsittelijä;
import com.mycompany.olioluokat.Moduuli;
import com.mycompany.olioluokat.Sessio;
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
public class SessioDAOTest {
    
    public SessioDAOTest() {
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
    public void testaaTallennusJaLataus(){
        String kysymystiedosto = "src/tmoduuli.txt";
        String vastaustiedosto = "src/tmoduulivastaukset.txt";
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

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    // @Test
    // public void hello() {}
}
