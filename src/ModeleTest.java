import static org.junit.Assert.*;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;


public class ModeleTest {

	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void testConnexion() {
		Assert.assertTrue("echec", Modele.connexion());	
	}

}
