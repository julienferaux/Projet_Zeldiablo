package MoteurPhysique;

import java.util.ArrayList;

public class Hero extends Personnage {

	private ArrayList<Arme>lArme;
	private boolean etreEmpoisoner;
	private boolean avoirGant;
	public static int score;

	/**
	 * Constructeur d'un hero
	 * @param n nom du Hero
	 */
	public Hero(String n,int Pv, int Y, int X, double Attaque) {
		super(n,Pv , Y, X, Attaque);
		lArme = new ArrayList<>();
		this.etreEmpoisoner = false;
		Hero.score = 0;
	}

	/**
	 * Methode qui permet au hero de se deplacer dans 4 direction
	 * @param c qui indique la direction
	 */
	public void seDeplace(char c) {
		switch (c) {
		case 'h':
			super.setY(super.getY() - 1);
			break;
		case 'b':
			super.setY(super.getY() + 1);
			break;
		case 'g':
			super.setX(super.getX() - 1);
			break;
		case 'd':
			super.setX(super.getX() + 1);
			break;
		default:
			break;
		}

	}

	/**
	 * Methode qui applique l'attaque de l'arme a la puissance du hero
	 * @param a
	 */
	public void setPuissance(Arme a){
		super.setAttaque(a.getPuissance());
	}

	public void revive(){
		super.setPv(super.getPvBase());
		super.setMort(false);
	}

	public void setMort(boolean mort) {
		super.setMort(mort);
	}
	/**
	 * Getteur de la liste d'arme du hero
	 * @return
	 */
	public ArrayList<Arme> getlArme() {
		return lArme;
	}

	public boolean getMort(){
		return super.getMort();
	}

	public void ajouterPuissance() {
		if(this.lArme != null) {
			for (int i = 0; i < this.lArme.size(); i++) {
				this.setAttaque(this.lArme.get(i).getPuissance() + this.getAttaque()); 
			}
		}
	}
	/**
	 * Setteur de l'arme pour le hero
	 * @param a
	 */
	public void setArm(Arme a){
		this.lArme.add(a);
		System.out.println(this.lArme.get(0).getNum());
	}

	public boolean getEtreEmpoisoner() {
		return etreEmpoisoner;
	}
	public void setEtreEmpoisoner(boolean empoisoner){
		this.etreEmpoisoner = empoisoner;
	}
	public void ajouterScore(Monstre m){
		if(m instanceof MonstreBasique){
			this.score+=10;
		}
		else {
			this.score+=50;
		}
	}

	public int getScore() {
		return score;
	}

	public void setAvoirGant(boolean avoirGant) {
		this.avoirGant = avoirGant;
	}
	public boolean getAvoirGant(){
		return this.avoirGant;
	}
}

