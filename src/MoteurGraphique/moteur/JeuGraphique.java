package MoteurGraphique.moteur;

import MoteurPhysique.*;

import java.awt.event.KeyEvent;
import java.util.ArrayList;

public class JeuGraphique implements JeuAbstract {

	private int sx;
	private int sy;

	public String mode;
	
	public JeuPlay jeuP;
	
	public JeuGraphique() throws ExeceptionLabyrintheTropGrand {
		this.mode = "Play";
		this.jeuP = new JeuPlay();
	}
	
	@Override
	public String evoluer(CClavier clavier, CSouris souris) {
		this.sx = souris.getX();
		this.sy = souris.getY();
		return null;
	}

	@Override
	public boolean etreFini() {
		return false;
	}

}
