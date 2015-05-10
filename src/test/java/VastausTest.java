/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import com.mycompany.olioluokat.Kysymys;
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
public class VastausTest {
    
    public VastausTest() {
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
    public void luoVastaus(){
        Kysymys k = new Kysymys(1, "Tässäpä kysymys", "E", "");
        Vastaus v = new Vastaus("Tässäpä vastaus", k);
        assertEquals("Tässäpä vastaus", v.getVastaus());
    }

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    // @Test
    // public void hello() {}
}
