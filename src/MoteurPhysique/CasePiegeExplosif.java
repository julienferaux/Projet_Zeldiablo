package MoteurPhysique;

public class CasePiegeExplosif extends CasePiege {

	public CasePiegeExplosif(int dx, int dy) {
		super(dx, dy, "sprite_1_2");
	}

	private double degat = 25;

	public void infligerDegat(Hero hero) {

		hero.subirDegat(this.degat);
	}


}
