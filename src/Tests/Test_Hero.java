package Tests;

import static org.junit.Assert.*;

import org.junit.Test;

import MoteurPhysique.Hero;
import MoteurPhysique.MonstreBasique;

public class Test_Hero {

	@Test
	public void test_Hero() {
		Hero h1 = new Hero("Jean",10 ,25 ,20 ,5);
		assertEquals("test du constructeur le personnage devrais etre  ", "Jean" , h1.getNom());
		assertEquals("test des points de vie " , 10 , h1.getPv(),0);
		assertEquals("test des coordonnees X", 25, h1.getX());
		assertEquals("test des coordonnees Y", 20, h1.getY());
	}
	
	@Test
	/**
	 * Test de la methode seDeplacer de hero
	 * en testant les 4 direction et en verifiant 
	 * qu'il ne bouge pas si on donne une mauvaise direction
	 */
	public void test_seDeplacer() {
		Hero h1 = new Hero("Bili",10, 25, 20,5);
		assertEquals("test des coordonnees X", 25, h1.getX());
		assertEquals("test des coordonnees Y", 20, h1.getY());
		h1.seDeplace('h');
		assertEquals("test des coordonnees Y", 19, h1.getY());
		h1.seDeplace('b');
		assertEquals("test des coordonnees Y", 20, h1.getY());
		h1.seDeplace('d');
		assertEquals("test des coordonnees X", 26, h1.getX());
		h1.seDeplace('g');
		assertEquals("test des coordonnees X", 25, h1.getX());
		h1.seDeplace('x');
		assertEquals("test des coordonnees X", 25, h1.getX());
		assertEquals("test des coordonnees Y", 20, h1.getY());
	}
	/**
	 * test de la methode infligerDegat avec verification  de la baisse de vie et de la mort du hero
	 */
	@Test
	public void test_subirDegat() {
		Hero h1 = new Hero("Bili",10, 25 ,25, 5);
		h1.subirDegat(9);
		assertEquals("test de la vie", 1, h1.getPv(),0);
		h1.subirDegat(9);
		assertEquals("test mort", true, h1.getMort());		
	}
	
	/**
	 * test de la methode attaquer avec verification de la perte de point de vie et de la mort si les points de vie sont negatif 
	 */
	@Test
	public void test_attaquer() {
		Hero h1 = new Hero("Bili",10, 25, 25, 5);
		MonstreBasique m1 = new  MonstreBasique("Greu",6, 25 ,25, 2);
		h1.attaquer(m1);
		assertEquals("la vie du monstre est de 1", 1, m1.getPv(),0);
		h1.attaquer(m1);
		assertEquals("le monstre est mort", true, m1.getMort());
		
	}
}
	
	

