package MoteurPhysique;

public class CaseEpee extends Case {

    public CaseEpee(int dy, int dx) {
        super(dx, dy);
    }

    @Override
    public String getSpriteString() {
        return "sprite_0_3";
    }
}
