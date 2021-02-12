package MoteurGraphique.moteur;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

import MoteurGraphique.sprite.Sprites;
import MoteurPhysique.*;

public class DessinPlay implements DessinAbstract {

	JeuPlay jeu;
	String playerSprite;

	public DessinPlay(JeuPlay j) {
		this.jeu = j;
		Sprites.chargerFeuille("sprite", "src/Sprites/Sprites.png", 4, 5);
		this.playerSprite = "sprite_2_0";
	}

	private void dessinerLab(Graphics2D g){
		Labyrinthe lab = jeu.getPartie().getLabyrinthe();
		int x = 0;
		int y = 0;
		for (int i = 0; i < lab.get_tailleX(); i++) {
			for (int j = 0; j < lab.get_tailleY(); j++) {
				Sprites.dessiner(g,lab.getCase(i, j).getSpriteString(),x,y);
				x+=32;
			}
			y+=32;
			x = 0;
		}
	}

	private void dessinerMonstre(Graphics2D g) {
		for (int i = 0; i < jeu.getPartie().getListeMonstre().size(); i++) {
			if(jeu.getPartie().getListeMonstre().get(i) instanceof MonstreBasique) {
				int y = jeu.getPartie().getListeMonstre().get(i).getY()*32;
				int x = jeu.getPartie().getListeMonstre().get(i).getX()*32;
				Sprites.dessiner(g,"sprite_1_0",x,y);
			} else {
			    int y = jeu.getPartie().getListeMonstre().get(i).getY()*32;
				int x = jeu.getPartie().getListeMonstre().get(i).getX()*32;
				Sprites.dessiner(g,"sprite_2_2",x,y);
			}
			
			
		}
	}
	
	private void dessinerJoueur(Graphics2D g){
		Hero hero = jeu.getPartie().getHero();
		int x = hero.getX()*32;
		int y = hero.getY()*32;
		Sprites.dessiner(g,this.playerSprite,x,y);
	}

	private void overlayLife(Graphics2D g, int width){
		switch (this.jeu.getPartie().getLife()){
			case 1:	Sprites.dessiner(g,"sprite_0_2",width-35,10);
					break;
			case 2:	Sprites.dessiner(g,"sprite_0_2",width-35,10);
					Sprites.dessiner(g,"sprite_0_2",width-(35+32+2),10);
					break;
			case 3:	Sprites.dessiner(g,"sprite_0_2",width-35,10);
					Sprites.dessiner(g,"sprite_0_2",width-(35+32+2),10);
					Sprites.dessiner(g,"sprite_0_2",width-(35+64+4),10);
					break;
		}
	}
	private void overlayPV(Graphics2D g, int width){
		Hero h = this.jeu.getPartie().getHero();
		int diff = (int)((h.getPv()/h.getPvBase())*100)+5;
		if(h.getPv() > 20){
			g.setColor(Color.GREEN);
		}
		else {
			g.setColor(Color.RED);
		}
		g.fillRect(width-diff, 50, diff, 15);
	}
	private void overlayArme(Graphics2D g, int width){
		ArrayList<Arme> lArme = this.jeu.getPartie().getHero().getlArme();
		for (int i = 0; i < lArme.size(); i++) {
			Arme a = lArme.get(i);
			switch (a.getNum()){
				case 0:	Sprites.dessiner(g, "sprite_2_3", 10, 10);
					break;
				case 1:	Sprites.dessiner(g, "sprite_3_3", 10+32+2, 10);
					break;
				case 2:	Sprites.dessiner(g, "sprite_0_4", 10+64+2, 10);
					break;
			}
		}
	}

	private void overlayScore(Graphics2D g, int width){
		g.setColor(Color.white);
		g.setFont(new Font("Courier New", Font.BOLD, 25));
		String s = "Score:"+this.jeu.getPartie().getHero().getScore();
		g.drawString(s, width-s.length()*15, 100);
	}

	@Override
	public void dessiner(BufferedImage image) {
		Graphics2D g =(Graphics2D)image.getGraphics();
		dessinerLab(g);
		dessinerJoueur(g);
		dessinerMonstre(g);
		overlayLife(g, image.getWidth());
		overlayPV(g, image.getWidth());
		overlayArme(g, image.getWidth());
		overlayScore(g, image.getWidth());
		g.dispose();
	}

}
