package MoteurPhysique;

public abstract class Monstre extends Personnage{
	/**
	 * Constructeur d'un Monstre
	 * @param n nom du Monstre
	 */
	public Monstre(String n,int Pv, int Y, int X, double Attaque) {
		super(n,Pv, Y, X, Attaque);
	}

	public double getPv() {
		return super.getPv();
	}
	
	public boolean getMort(){
		return super.getMort();
	}
	
	public abstract char deplacer(int Y, int X);
		
	public double getAttaque() {
		return super.getAttaque();
	} 
}
