/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import com.mycompany.DAO.KysymysDAO;
import com.mycompany.käsittelijät.KysymystenKäsittelijä;
import com.mycompany.olioluokat.Kysymys;
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
public class KysymysDAOTest {
    
    public KysymysDAOTest() {
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
    public void testaaLataus(){
        
    }
    
    @Test
    public void testaaTallennusjaLataus(){
        KysymystenKäsittelijä k = new KysymystenKäsittelijä("src/txttiedostot/tmoduuli.txt");
        HashMap<Integer, Kysymys> alussa = k.getKysymykset();
        k.tallennaKysymykset();
        k = new KysymystenKäsittelijä("src/txttiedostot/tmoduuli.txt");
        HashMap<Integer, Kysymys> lopussa = k.getKysymykset();
        assertEquals(lopussa.size(), alussa.size());
    }

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    // @Test
    // public void hello() {}
}
