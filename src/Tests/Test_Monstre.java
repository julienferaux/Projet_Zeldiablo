package Tests;

import static org.junit.Assert.*;

import MoteurPhysique.MonstreBasique;
import org.junit.Test;

import MoteurPhysique.Hero;

public class Test_Monstre {

	@Test
	public void Test_Monstre() {
		MonstreBasique m1 = new MonstreBasique("bobie",5,25,20,5);
		assertEquals("test du constructeur le personnage devrais etre  ", "bobie" , m1.getNom());
		assertEquals("test des points de vie " , 5 , m1.getPv(),0);
		assertEquals("test des coordonnees X", 25, m1.getX());
		assertEquals("test des coordonnees Y", 20, m1.getY());
	}

	/**
	 * test de la methode infligerDegat avec verification  de la baisse de vie et de la mort du hero
	 */
	@Test
	public void test_subirDegat() {
		MonstreBasique m1 = new MonstreBasique("Bili",10, 25 ,25, 5);
		m1.subirDegat(9);
		assertEquals("test de la vie", 1, m1.getPv(),0);
		m1.subirDegat(9);
		assertEquals("test mort", true, m1.getMort());		
	}
	
	/**
	 * test de la methode attaquer avec verification de la perte de point de vie et de la mort si les points de vie sont negatif 
	 */
	@Test
	public void test_attaquer() {
		MonstreBasique m1 = new MonstreBasique("Bili",10, 25, 25, 5);
		Hero h1 = new  Hero("Bili",6, 25 ,25, 2);
		m1.attaquer(h1);
		assertEquals("la vie du hero est de 1", 1.0, h1.getPv(),0);
		m1.attaquer(h1);
		assertEquals("le hero est mort", true, h1.getMort());
	}
	
	@Test
	public void test_deplacer() {
		MonstreBasique m1 = new MonstreBasique("Bili",10, 25, 25, 5);
		String res = ""+ m1.deplacer(0,0);
		assertEquals("le monstre revoit h,b,g ou d", true, (res.equals("h"))||(res.equals("g"))||(res.equals("d"))||(res.equals("b")));
	}
}
