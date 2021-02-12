package MoteurPhysique;

public class MonstreInteligent extends Monstre {

	public MonstreInteligent(String n, int Pv, int Y, int X, double Attaque) {
		super(n, Pv, Y, X, Attaque);
	}

	public char deplacer(int Y, int X) {
		char res = 'a';
		int randomm = (int)(Math.random() * 2);
		int Mx = super.getX();
		int My = super.getY();
		if (randomm == 1) {
			if(X >= Mx) { 
				res = 'd';
			}
			else 
			{ res = 'g';
			}
		}
		else {
			if(Y >= My) { 
				res = 'b';
			}
			else 
			{ res = 'h';
			}
		}
		return res;
	}

	public boolean getMort(){
		return super.getMort();
	}
	
	public double getAttaque() {
		return super.getAttaque();
	} 
	
	public double getPv() {
		return super.getPv();
	}
}
