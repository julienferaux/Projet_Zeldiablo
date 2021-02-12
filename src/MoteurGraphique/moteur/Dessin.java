package MoteurGraphique.moteur;

import java.awt.Graphics;
import java.awt.image.BufferedImage;

public class Dessin implements DessinAbstract {

	public JeuPlay jeu;
	
	public DessinPlay play;

	public DessinGameOver gameOver;
	public DessinFinGame finGame;
	
	public Dessin(JeuAbstract j) {
		this.jeu = (JeuPlay) j;
		this.play = new DessinPlay(this.jeu);
		this.gameOver = new DessinGameOver();
		this.finGame = new DessinFinGame();
	}
	
	@Override
	public void dessiner(BufferedImage image) {
	
		if(JeuPlay.mode.equals("Play")) {
			this.play.dessiner(image);
		}
		else if(JeuPlay.mode.equals("GameOver")){
			this.gameOver.dessiner(image);
		}
		else if(JeuPlay.mode.equals("Fin")){
			this.finGame.dessiner(image);
		}
	}

}
