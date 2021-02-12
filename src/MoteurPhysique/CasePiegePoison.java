package MoteurPhysique;

public class CasePiegePoison extends CasePiege {

	public CasePiegePoison(int dx, int dy) {
		super(dx, dy, "sprite_3_1");
	}

	private double degat = 3 ;

	@Override
	public void infligerDegat(Hero hero) {
		hero.subirDegat(degat);

	}
}
