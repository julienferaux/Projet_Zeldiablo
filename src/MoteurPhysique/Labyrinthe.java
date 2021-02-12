package MoteurPhysique;

import java.util.ArrayList;

public class Labyrinthe {

	/**
	 * Parametre de class
	 * tailleX = taille du labyrinthe en abscisse
	 * tailleY = taille du labyrinthe en ordonne
	 * tableauCase = tableau de case du labyrinthe
	 */

	private int tailleX, tailleY;
	private Case[][] tableauCase;
	private CaseSpawn spawn;
	private ArrayList<CaseSpawnMonstre> listSpawn;

	public Labyrinthe(int[][] tabLabyrinthe, int width, int height) throws ExeceptionLabyrintheTropGrand {

		if (height > 22 || width > 22) {
			throw new ExeceptionLabyrintheTropGrand();
		}

		this.tailleX = width;
		this.tailleY = height;
		this.listSpawn = new ArrayList<CaseSpawnMonstre>();
		this.tableauCase = new Case[this.tailleY][this.tailleX];

		for (int y = 0; y < this.tailleY; y++) {
			for (int x = 0; x < this.tailleX; x++) {
				switch (tabLabyrinthe[y][x]) {
				case 0:
					this.tableauCase[y][x] = new CaseVide(y, x);
					break;
				case 1:
					this.tableauCase[y][x] = new CaseMur(y, x);
					break;
				case 2:
					this.spawn = new CaseSpawn(y, x);
					this.tableauCase[y][x] = this.spawn;
					break;
				case 3:
					if(genererAlea() == 0) {
						this.tableauCase[y][x] = new CasePiegeExplosif(y, x);
					} else {
						this.tableauCase[y][x] = new CasePiegePoison(y, x);
					}
					break;
				case 4:
					CaseSpawnMonstre cm = new CaseSpawnMonstre(y, x);
					this.listSpawn.add(cm);
					this.tableauCase[y][x] = cm;
					break;
				case 5:
					this.tableauCase[y][x] = new CaseBaton(y, x);
					break;
				case 6:
					this.tableauCase[y][x] = new CaseEpee(y, x);
					break;
				case 7:
					this.tableauCase[y][x] = new CaseGant(y, x);
					break;
				case 8:
					this.tableauCase[y][x] = new CaseFin(y, x);
					break;
				}
			}
		}
	}
	public int genererAlea() {
		return (int)(Math.random() * (2));
	}

	/**
	 * methode qui retourne la taille X du labyrinthe
	 *
	 * @return tailleX
	 */
	public int get_tailleX() {
		return this.tailleX;
	}

	/**
	 * methode qui retourne la taille Y du labyrinthe
	 *
	 * @return tailleY
	 */
	public int get_tailleY() {
		return this.tailleY;
	}

	/**
	 * @return
	 */
	public ArrayList<CaseSpawnMonstre> getlisteSpawn() {
		return this.listSpawn;
	}

	/**
	 * Methode qui retourne une case du labyrinthe
	 *
	 * @param x
	 * @param y
	 * @return tableauCase[x][y]
	 */
	public Case getCase(int x, int y) {
		Case res = new CaseVide(0, 0);
		if (x >= 0 && x < tailleX && y >= 0 && y < tailleY) {
			res = tableauCase[x][y];
		}
		return res;
	}
	public void setCase(Case c, int x, int y){
		this.tableauCase[x][y] = c;
	}

	public CaseSpawn getSpawn() {
		return this.spawn;
	}


}

