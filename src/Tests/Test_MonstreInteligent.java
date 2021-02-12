package Tests;

import static org.junit.Assert.*;

import MoteurPhysique.MonstreBasique;
import org.junit.Test;

import MoteurPhysique.Hero;

public class Test_MonstreInteligent {
	
	@Test
	public void test_deplacer() {
		MonstreBasique m1 = new MonstreBasique("Bili",10, 25, 25, 5);
		String res = ""+ m1.deplacer(0,0);
		assertEquals("le monstre revoit h,b,g ou d", true, (res.equals("h"))||(res.equals("g"))||(res.equals("d"))||(res.equals("b")));
	}

}
