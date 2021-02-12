package MoteurPhysique;

import java.util.Timer;

public class Poison implements Effet {


    @Override
    public void degat(Personnage p) {

       p.setPv(p.getPv() - 0.01667);
    }


}
