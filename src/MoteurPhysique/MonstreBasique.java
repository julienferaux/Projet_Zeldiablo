package MoteurPhysique;

public class MonstreBasique extends Monstre {
    /**
     * Constructeur d'un Monstre
     *
     * @param n nom du Monstre
     * @param X
     * @param Y
     */
    public MonstreBasique(String n,int Pv, int Y, int X, double Attaque) {
        super(n, Pv, Y, X, Attaque);
    }
    
    public double getPv() {
		return super.getPv();
	}
    
	@Override
	public char deplacer(int Y, int X) {
		char res ='a';
    	int randomm =(int)(Math.random() * (4));
    	switch (randomm) {
    	case 3 :
    		res = 'd';
			break;
		case 1 :
			res = 'g';
			break;
		case 2:
			res = 'b';
			break;
		case 0:
			res = 'h';
			break;	
    	}
    	return res;
	}
	
	public boolean getMort(){
		return super.getMort();
	}
}
