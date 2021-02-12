package MoteurPhysique;

public class CaseSpawnMonstre extends Case {
    public CaseSpawnMonstre(int dy, int dx) {
        super(dy, dx);
    }

    @Override
    public String getSpriteString() {
        return "sprite_2_1"; // sprite du spawn
    }
}
