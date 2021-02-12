package MoteurPhysique;

public class Arme {
	
	private int puissance;
	private int num;

	/**
	 * Constructeur de la classe arme qui cree une arem avec un nom est une puissance
	 * @param p
	 * @param n
	 */
	public Arme(int p, int n ) {
		this.puissance = p;
		this.num = n;

	}

	/**
	 * Getteur qui renvoie la puissance de l'arme
	 * @return puissance
	 */
	public int getPuissance() {
		return puissance;
	}

	/**
	 * Getteur qui renvoie le nom de l'arme
	 * @return nom
	 */
	public int getNum() {
		return num;
	}
}
