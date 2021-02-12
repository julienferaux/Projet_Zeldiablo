package MoteurPhysique;

public class ExeceptionLabyrintheTropGrand extends Exception {
    public ExeceptionLabyrintheTropGrand() {
        super("Le Labyrinthe est trop grand (Max 45x45)");
    }
}
