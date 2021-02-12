package MoteurGraphique.moteur;
import java.awt.Graphics;

import MoteurGraphique.sprite.Sprites;
import MoteurPhysique.ExeceptionLabyrintheTropGrand;
import MoteurPhysique.Labyrinthe;

public class Main {

	public static void main(String[] args) throws ExeceptionLabyrintheTropGrand {

		for (int i = 1 ; i == 1; i++) {
		}
		JeuPlay notreJeu = new JeuPlay();
		Dessin notreDessin = new Dessin(notreJeu);
		MoteurGraphique moteurPrincipal = new MoteurGraphique(notreJeu, notreDessin);
		moteurPrincipal.lancerJeu(704, 704, 60);

	}
}
