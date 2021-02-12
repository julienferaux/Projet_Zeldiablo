package Tests;

import static org.junit.Assert.*;

import org.junit.Test;

import MoteurPhysique.*;

import javax.swing.*;

public class Test_Case {

	@Test
	public void test_Case() {
		Case c = new CaseVide(3,2);
		assertEquals("La coordonnee de la case en X est 0 " ,c.getX(), 3);
		assertEquals("La coordonnee de la case en Y est 0 " ,c.getY(), 2);
		
	}

}
