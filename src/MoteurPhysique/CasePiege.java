package MoteurPhysique;

public abstract class CasePiege extends Case {
	private boolean etreCacher;
	private String stringSprite;
	private String StringSpriteBase;

	public CasePiege(int dx, int dy, String spriteS) {
		super(dx, dy);
		this.stringSprite = "sprite_2_1";
		this.StringSpriteBase = spriteS;
		this.etreCacher = true;
	}

	private double degat ;

	public abstract void infligerDegat(Hero hero);

	public void setEtreCacher(boolean cacher){
		this.etreCacher = cacher;
		if(!cacher){
			setStringSprite(this.StringSpriteBase);
		}
		else {
			setStringSprite("sprite_2_1");
		}
	}

	@Override
	public String getSpriteString() {
		return this.stringSprite;
	}

	public void setStringSprite(String sprite){
		this.stringSprite = sprite;
	}


}
