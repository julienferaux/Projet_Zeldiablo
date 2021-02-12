package MoteurPhysique;

public abstract class Case {
	public boolean occupe ;
	public int y,x;
	
	public Case( int dy, int dx) {
		this.occupe = false;
		x = dx;
		y = dy;
	}
	
	public int getX() {
		return x;
	}
	public int getY() {
		return y;
	}
	public abstract String getSpriteString();
}
