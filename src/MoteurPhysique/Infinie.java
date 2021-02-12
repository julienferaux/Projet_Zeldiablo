package MoteurPhysique;

public class Infinie implements Effet{

    @Override
    public void degat(Personnage p) {
        p.subirDegat(20);
    }
}
