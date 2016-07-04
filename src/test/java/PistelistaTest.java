import static org.junit.Assert.*;

import org.junit.Test;

import com.mycompany.DAO.PistelistaDAO;
import com.mycompany.olioluokat.Pistelista;


public class PistelistaTest {

	@Test
	public void getInstanssiTest(){
		Pistelista lista = Pistelista.getInstanssi();
	}
	
	@Test
	public void testaaGetTiedosto(){
		assertEquals(Pistelista.getInstanssi().getTiedosto(), "txttiedostot/pistelista.txt");
	}
	
	@Test
	public void testaaLisääPiste(){
		Pistelista.getInstanssi().setTiedosto("txttiedostot/pistelistatesti.txt");
		int koko = Pistelista.getInstanssi().getPisteet().size();
		Pistelista.getInstanssi().lisääPiste("uusi", 90);
		Pistelista.getInstanssi().lisääPiste("uusi", 92);
		Pistelista.getInstanssi().lisääPiste("uusi", 91);
		assertEquals(Pistelista.getInstanssi().getPisteet().size(), koko+1);
		Pistelista.getInstanssi().getPisteet().remove("uusi");
		PistelistaDAO.tallennaPisteet(Pistelista.getInstanssi().getPisteet(), Pistelista.getInstanssi().getTiedosto());
	}
	
}
