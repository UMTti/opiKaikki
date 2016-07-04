import static org.junit.Assert.*;

import org.junit.Test;

import com.mycompany.olioluokat.Moduuli;


public class ModuuliTest {

	@Test
	public void testaaGetNimi(){
		Moduuli m = new Moduuli("Moduuli", "txttiedostot/testimoduuli.txt", "txttiedostot/testimoduulivastaukset.txt");
		assertEquals(m.getNimi(), "Moduuli");
	}
	
	@Test
	public void testaaLisääKysymys(){
		Moduuli m = new Moduuli("Moduuli", "txttiedostot/testimoduuli.txt", "txttiedostot/testimoduulivastaukset.txt");
	    int koko = m.getKysymystenKäsittelijä().getKysymykset().size();
		m.lisääKysymys("Kuvaus", "kysymys");
		assertEquals(m.getKysymystenKäsittelijä().getKysymykset().size(), koko+1);
	}
}
