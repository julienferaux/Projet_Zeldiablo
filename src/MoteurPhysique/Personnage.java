package MoteurPhysique;

public abstract class Personnage  {
	
	/**
	 * Parametre de class 
	 * nom = nom du personnage
	 * pv = point de vie du personnage 
	 */
	private String nom; 
	private int y,x,pvBase;
	private double attaque;
	private double pv;
	private boolean mort;

	/**
	 * Constructeur d'un personnage
	 * @param n nom du personnage
	 */
	public Personnage(String n,int Pv, int Y, int X, double Attaque ) {
		this.nom = n; 
		this.pv = Pv;
		this.pvBase = Pv;
		this.x = X;
		this.y = Y;
		this.attaque = Attaque;
		this.mort = false ;
	}
	
	/**
	 * Methode de recuperation du nom du personnage 
	 */
	public String getNom() {
		return this.nom;
	}
	
	/**
	 * Methode de recuperation des point du vie du personnage
	 */
	public double getPv() {
		return this.pv;
	}
	
	public void setPv(double pv) {
		this.pv = pv;
	}

	public int getPvBase() {
		return pvBase;
	}

	public int getX() {
		return this.x;
	}
	
	public int getY() {
		return this.y;
	}
	
	public void setX(int X) {
		this.x = X;
	}
	
	public void setY(int Y) {
		this.y = Y;
	}

	public double getAttaque() {
		return attaque;
	}

	public void setAttaque(double d){
		this.attaque = d;
	}

	public void attaquer(Personnage adv) {
		adv.subirDegat(this.attaque);
	}
	
	public boolean getMort() {
		return this.mort;
	}
	
	public void setMort(boolean mort) {
		this.mort = mort;
	}

	public void setVivant(boolean vivant) {
		this.mort = vivant;
	}
	
	public void subirDegat(double deg) { 
		if (!mort) {
			this.pv -= deg;
			if (this.pv <= 0) {
				this.mort = true;
			}
		}
	}
	
}
