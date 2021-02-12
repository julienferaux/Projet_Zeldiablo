package MoteurPhysique;

import java.util.ArrayList;

public class Partie {
	private Labyrinthe labyrinthe;
	private Hero hero;
	private ArrayList<Monstre> listeMonstre;
	private int life = 3;

	public Partie() throws ExeceptionLabyrintheTropGrand {
		/*
		 * pour le model du lab un 0 represente une case vide, un 1 un mur, un 2 le spawn et un 3 un piege,4 monstre,5arme
		 */
		int[][] tabLab = {
				{1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1},
				{1,0,0,0,0,1,1,1,0,0,0,0,0,0,1,1,1,3,1,1,1,1},
				{1,0,2,0,0,1,3,1,1,1,0,1,0,3,1,1,0,0,0,1,1,1},
				{1,0,0,0,0,1,0,0,0,4,0,1,1,1,1,1,1,1,0,0,1,1},
				{1,0,0,1,0,0,0,0,0,0,0,0,0,0,0,0,3,1,0,1,1,1},
				{1,1,1,1,1,0,1,1,0,1,1,1,1,1,0,1,1,1,0,1,5,1},
				{1,1,3,1,1,1,1,0,0,1,0,0,0,1,0,0,0,4,0,1,0,1},
				{1,0,0,1,1,0,0,0,1,1,0,8,0,1,1,1,0,0,0,0,0,1},
				{1,0,0,1,0,0,1,1,1,0,0,4,0,0,3,1,1,0,1,0,3,1},
				{1,0,1,1,0,1,1,1,1,4,0,3,0,4,0,0,1,0,1,1,0,1},
				{1,0,1,1,0,1,0,3,0,0,0,7,0,0,0,0,1,0,0,1,1,1},
				{1,0,0,1,0,1,0,0,4,0,0,0,0,0,0,0,1,0,0,0,1,1},
				{1,1,0,4,0,1,1,0,0,3,0,0,0,4,3,1,1,0,1,0,0,1},
				{1,1,3,1,0,0,1,1,1,0,0,4,0,0,0,1,3,0,1,1,0,1},
				{1,1,1,1,0,0,0,3,1,0,0,3,0,1,1,1,0,1,1,0,0,1},
				{1,1,0,1,0,1,1,1,1,1,0,0,0,1,0,0,0,0,1,4,0,1},
				{1,3,0,1,0,0,0,1,3,1,1,0,1,1,0,1,0,0,0,0,0,1},
				{1,0,4,0,0,1,0,4,0,0,0,0,0,0,0,1,0,1,1,1,0,1},
				{1,1,0,0,0,1,0,1,1,1,1,1,0,1,1,1,0,0,0,1,1,1},
				{1,1,1,1,1,1,0,1,3,1,0,0,0,1,1,0,0,1,0,1,1,1},
				{1,1,1,0,0,0,0,0,0,1,3,1,1,1,1,1,1,1,0,6,1,1},
				{1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1},
		};
		this.labyrinthe = new Labyrinthe(tabLab, 22, 22);
		this.hero = new Hero("Bili",100,25,10,10.0);
		this.listeMonstre = new ArrayList<Monstre>();
		genererMonstre();
	}

	public void genererMonstre() {
		for (int i = 0; i < labyrinthe.getlisteSpawn().size(); i++) {
			if(labyrinthe.genererAlea() == 1) {
				this.listeMonstre.add(new MonstreBasique("Slime", 100,labyrinthe.getlisteSpawn().get(i).getY() , labyrinthe.getlisteSpawn().get(i).getX(), 5.0));
			} else {
				this.listeMonstre.add(new MonstreInteligent("Purple Slime", 100,labyrinthe.getlisteSpawn().get(i).getY() , labyrinthe.getlisteSpawn().get(i).getX(), 5.0));
			}
		}
	}
	/**
	 *
	 * @return le labyrinthe
	 */
	public Labyrinthe getLabyrinthe() {
		return labyrinthe;
	}
	/**
	 *
	 * @return le hero
	 */
	public Hero getHero() {
		return hero;
	}
	/**
	 *
	 * @return une liste de monstre
	 */
	public ArrayList<Monstre> getListeMonstre() {
		return listeMonstre;
	}

	/**
	 * 
	 * @param perso le personnage qui ce deplace 
	 * @param direction la direction donner par le clavier 
	 * @return faux si il y a une colision et empeche le deplacement
	 */
	public boolean gererColision(Personnage perso, char direction) {
		boolean col = false;
		int ord = perso.getY();
		int abs = perso.getX();
		switch (direction) {
		case 'h':
			if(labyrinthe.getCase(ord - 1,abs) instanceof CaseMur) {
				col = true;
			}
			break;
		case 'b':
			if(labyrinthe.getCase(ord + 1,abs) instanceof CaseMur) {
				col = true;
			}
			break;
		case 'g':
			if(labyrinthe.getCase(ord,abs - 1) instanceof CaseMur) {
				col = true;
			}
			break;
		case 'd':
			if(labyrinthe.getCase(ord,abs + 1) instanceof CaseMur) {
				col = true;
			}
			break;
		}
		return col;
	}

	public int getLife(){
		return this.life;
	}
	public void substractLife(){
		this.life--;
	}
	public void addLife(){
		this.life++;
	}
}
