package Tests;

import static org.junit.Assert.*;

import MoteurGraphique.moteur.JeuGraphique;
import MoteurPhysique.ExeceptionLabyrintheTropGrand;
import MoteurPhysique.Hero;
import MoteurPhysique.Labyrinthe;

import MoteurPhysique.Partie;
import org.junit.Test;

import MoteurGraphique.moteur.JeuGraphique;

public class Test_Partie {

	/**
	 * Test du constructeur de Partie
	 * @throws ExeceptionLabyrintheTropGrand 
	 */
	@Test
	public void test_Partie() throws ExeceptionLabyrintheTropGrand {
		Partie j = new Partie();
		assertEquals("La liste de monstre devrait contenir aucun element",true,j.getListeMonstre().isEmpty());
		assertEquals("Le nom du hero doit etre Bili" ,"Bili",j.getHero().getNom());
	}

	/**
	 * Test de la methode qui gere les colisions
	 * @throws ExeceptionLabyrintheTropGrand 
	 */
	@Test
	public void test_ColisionsVraie() throws ExeceptionLabyrintheTropGrand {
		Partie j = new Partie();
		j.getHero().setX(1);
		j.getHero().setY(1);
		assertEquals("I devrait y avoir une colision" ,true,j.gererColision(j.getHero(),'h'));
	
	}
}
