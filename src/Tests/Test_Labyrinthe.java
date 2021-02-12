package Tests;

import static org.junit.Assert.*;

import MoteurPhysique.ExeceptionLabyrintheTropGrand;
import org.junit.Test;

import MoteurPhysique.Labyrinthe;

public class Test_Labyrinthe {

	@Test
	public void test_constructeur1() throws ExeceptionLabyrintheTropGrand {
		Labyrinthe l = new Labyrinthe(new int[3][3], 3, 3);
		assertEquals("teste tailleX " , 3 ,l.get_tailleX());
		assertEquals("teste tailleY " , 3 ,l.get_tailleY());
		
	}
	
	@Test
	public void test_getCase() throws ExeceptionLabyrintheTropGrand {
		Labyrinthe l = new Labyrinthe(new int[6][6], 6, 6);
		assertEquals("teste des coordonnees X " , 5 ,l.getCase(5,4).getX());
		assertEquals("teste des coordonnees Y " , 4 ,l.getCase(5,4).getY());
		
	}

}
