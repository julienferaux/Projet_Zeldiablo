package MoteurPhysique;

public class CaseMur extends Case {
	
    public CaseMur(int dx, int dy) {
        super(dx, dy);
    }

    @Override
    public String getSpriteString() {
        return "sprite_0_1";
    }
}
