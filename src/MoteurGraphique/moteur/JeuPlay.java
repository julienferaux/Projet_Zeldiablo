package MoteurGraphique.moteur;

import MoteurPhysique.*;

import java.awt.event.KeyEvent;
import java.util.ArrayList;

public class JeuPlay implements JeuAbstract {

    private char c;
    static String mode;
    private Partie partie;
    private int compteurFrame;
    private int compteurPoison = 0;
    private CasePiegePoison tempCasePoison;

    public JeuPlay() throws ExeceptionLabyrintheTropGrand {
        this.partie = new Partie();
        mode = "Play";
        setToSpawn();
    }

    @Override
    public String evoluer(CClavier clavier, CSouris souris) {
        int x;
        int y;
        Hero hero = this.partie.getHero();
        if (hero.getMort()) {
            if (this.partie.getLife() > 1) {
                this.partie.substractLife();
                hero.revive();
                setToSpawn();
                System.out.println(this.partie.getHero().getMort());
            } else {
                mode = "GameOver";
            }
        }
        // Gestion deplacement du hero au clavier
        boolean h = clavier.getTyped(KeyEvent.VK_Z);
        boolean b = clavier.getTyped(KeyEvent.VK_S);
        boolean d = clavier.getTyped(KeyEvent.VK_D);
        boolean g = clavier.getTyped(KeyEvent.VK_Q);
        boolean utiliser = clavier.getTyped(KeyEvent.VK_E);
        boolean attaque = clavier.getTyped(KeyEvent.VK_SPACE);

        //evenement qui permet de prendre une arme
        if (utiliser) {
            Case tempCase = this.partie.getLabyrinthe().getCase(this.getPartie().getHero().getY(), this.getPartie().getHero().getX());
            System.out.println(tempCase.getClass().getName());
            int xCase = this.getPartie().getHero().getY();
            int yCase = this.getPartie().getHero().getX();
            if (tempCase instanceof CaseBaton) {
                Arme baton = new Arme(5, 0);
                this.getPartie().getHero().setArm(baton);
                this.getPartie().getHero().ajouterPuissance();
                this.getPartie().getLabyrinthe().setCase(new CaseVide(xCase, yCase), xCase, yCase);
            } else if (tempCase instanceof CaseEpee) {
                Arme epee = new Arme(10, 1);
                this.getPartie().getHero().setArm(epee);
                this.getPartie().getHero().ajouterPuissance();
                this.getPartie().getLabyrinthe().setCase(new CaseVide(xCase, yCase), xCase, yCase);
            } else if (tempCase instanceof CaseGant) {
                Arme gant = new Arme(0, 2);
                this.getPartie().getHero().setArm(gant);
                this.getPartie().getHero().ajouterPuissance();
                this.getPartie().getLabyrinthe().setCase(new CaseVide(xCase, yCase), xCase, yCase);
                this.partie.getHero().setAvoirGant(true);
            } else if (tempCase instanceof CaseFin) {
                JeuPlay.mode = "Fin";
            }

        }
        //evenement d'attaque du heros
        if (attaque) {
            for (int i = 0; i < partie.getListeMonstre().size(); i++) {
                if (partie.getListeMonstre().get(i).getY() == partie.getHero().getY() + 1
                        && partie.getListeMonstre().get(i).getX() == partie.getHero().getX()) {
                    partie.getHero().attaquer(partie.getListeMonstre().get(i));
                    System.out.println(partie.getListeMonstre().get(i).getPv());
                }
                if (partie.getListeMonstre().get(i).getY() == partie.getHero().getY()
                        && partie.getListeMonstre().get(i).getX() == partie.getHero().getX() + 1) {
                    partie.getHero().attaquer(partie.getListeMonstre().get(i));
                    System.out.println(partie.getListeMonstre().get(i).getPv());
                }
                if (partie.getListeMonstre().get(i).getY() == partie.getHero().getY() - 1
                        && partie.getListeMonstre().get(i).getX() == partie.getHero().getX()) {
                    partie.getHero().attaquer(partie.getListeMonstre().get(i));
                    System.out.println(partie.getListeMonstre().get(i).getPv());
                }
                if (partie.getListeMonstre().get(i).getY() == partie.getHero().getY()
                        && partie.getListeMonstre().get(i).getX() == partie.getHero().getX() - 1) {
                    partie.getHero().attaquer(partie.getListeMonstre().get(i));
                    System.out.println(partie.getListeMonstre().get(i).getPv());
                }
                if (this.partie.getHero().getAvoirGant()) {
                    tuerMoitieMonstre();
                    this.partie.getHero().setMort(true);
                    if(this.partie.getLife() < 3){
                        JeuPlay.mode = "GameOver";
                    }
                    for (int j = 0; j < this.partie.getHero().getlArme().size(); j++) {
                        Arme tempArme = this.partie.getHero().getlArme().get(j);
                        if(tempArme.getNum() == 2){
                            this.partie.getHero().getlArme().remove(tempArme);
                        }
                    }
                    this.partie.getHero().setAvoirGant(false);
                }
                supprimerMonstreMort();
            }
        }
        //evenement de deplacement du heros
        if (h) {
            if (!this.partie.gererColision(this.partie.getHero(), 'h')) {
                this.partie.getHero().seDeplace('h');
            } else {
                x = this.getPartie().getHero().getX();
                y = this.getPartie().getHero().getY() + 1;
                System.out.println("Mur detecter en y = " + y + " x = " + x);
            }
        }

        if (b) {
            if (!this.partie.gererColision(this.partie.getHero(), 'b')) {
                this.partie.getHero().seDeplace('b');
            } else {
                x = this.getPartie().getHero().getX();
                y = this.getPartie().getHero().getY() - 1;
                System.out.println("Mur detecter en y = " + y + " x = " + x);
            }
        }

        if (d) {
            if (!this.partie.gererColision(this.partie.getHero(), 'd')) {
                this.partie.getHero().seDeplace('d');
            } else {
                x = this.getPartie().getHero().getX() + 1;
                y = this.getPartie().getHero().getY();
                System.out.println("Mur detecter en y = " + y + " x = " + x);
            }
        }

        if (g) {
            if (!this.partie.gererColision(this.partie.getHero(), 'g')) {
                this.partie.getHero().seDeplace('g');
            } else {
                x = this.getPartie().getHero().getX() - 1;
                y = this.getPartie().getHero().getY();
                System.out.println("Mur detecter en y = " + y + " x = " + x);
            }
        }


        //deplacement des monstres
        compteurFrame++;
        if (compteurFrame > 60) {


            for (int i = 0; i < partie.getListeMonstre().size(); i++) {
                int y2 = 0;
                int x2 = 0;
                c = partie.getListeMonstre().get(i).deplacer(partie.getHero().getY(), partie.getHero().getX());
                if (c == 'h') {
                    if (!this.partie.gererColision(this.partie.getListeMonstre().get(i), 'h')) {
                        partie.getListeMonstre().get(i).setY(partie.getListeMonstre().get(i).getY() - 1);
                        partie.getListeMonstre().get(i).setX(partie.getListeMonstre().get(i).getX());
                    }
                }
                if (c == 'b') {
                    if (!this.partie.gererColision(this.partie.getListeMonstre().get(i), 'b')) {
                        partie.getListeMonstre().get(i).setY(partie.getListeMonstre().get(i).getY() + 1);
                        partie.getListeMonstre().get(i).setX(partie.getListeMonstre().get(i).getX());
                    }
                }
                if (c == 'd') {
                    if (!this.partie.gererColision(this.partie.getListeMonstre().get(i), 'd')) {
                        partie.getListeMonstre().get(i).setY(partie.getListeMonstre().get(i).getY());
                        partie.getListeMonstre().get(i).setX(partie.getListeMonstre().get(i).getX() + 1);
                    }
                }
                if (c == 'g') {
                    if (!this.partie.gererColision(this.partie.getListeMonstre().get(i), 'g')) {
                        partie.getListeMonstre().get(i).setY(partie.getListeMonstre().get(i).getY());
                        partie.getListeMonstre().get(i).setX(partie.getListeMonstre().get(i).getX() - 1);
                    }
                }
            }

            //gestion des attaques des monstres

            for (int i = 0; i < partie.getListeMonstre().size(); i++) {
                if (partie.getHero().getY() == partie.getListeMonstre().get(i).getY() + 1
                        && partie.getHero().getY() == partie.getListeMonstre().get(i).getX()) {
                    partie.getListeMonstre().get(i).attaquer(partie.getHero());
                    System.out.println(partie.getListeMonstre().get(i).getPv());
                }
                if (partie.getHero().getY() == partie.getListeMonstre().get(i).getY()
                        && partie.getHero().getY() == partie.getListeMonstre().get(i).getX() + 1) {
                    partie.getListeMonstre().get(i).attaquer(partie.getHero());
                    System.out.println(partie.getListeMonstre().get(i).getPv());
                }
                if (partie.getHero().getY() == partie.getListeMonstre().get(i).getY() - 1
                        && partie.getHero().getY() == partie.getListeMonstre().get(i).getX()) {
                    partie.getListeMonstre().get(i).attaquer(partie.getHero());
                    System.out.println(partie.getListeMonstre().get(i).getPv());
                }
                if (partie.getHero().getY() == partie.getListeMonstre().get(i).getY()
                        && partie.getHero().getY() == partie.getListeMonstre().get(i).getX() - 1) {
                    partie.getListeMonstre().get(i).attaquer(partie.getHero());
                    System.out.println(partie.getListeMonstre().get(i).getPv());
                }
                supprimerMonstreMort();
            }

            //gestion des degats des pieges
            if (this.partie.getLabyrinthe().getCase(this.getPartie().getHero().getY(), this.getPartie().getHero().getX()) instanceof CasePiegePoison) {
                tempCasePoison = ((CasePiegePoison) this.partie.getLabyrinthe().getCase(this.getPartie().getHero().getY(), this.getPartie().getHero().getX()));
                tempCasePoison.setEtreCacher(false);
                tempCasePoison.infligerDegat(this.getPartie().getHero());
                this.partie.getHero().setEtreEmpoisoner(true);
            }

            if (this.partie.getLabyrinthe().getCase(this.getPartie().getHero().getY(), this.getPartie().getHero().getX()) instanceof CasePiegeExplosif) {
                CasePiegeExplosif tempCasePiegeExplo = ((CasePiegeExplosif) this.partie.getLabyrinthe().getCase(this.getPartie().getHero().getY(), this.getPartie().getHero().getX()));
                tempCasePiegeExplo.setEtreCacher(false);
                tempCasePiegeExplo.infligerDegat(this.getPartie().getHero());
            }

            if (this.partie.getHero().getEtreEmpoisoner()) {
                tempCasePoison.infligerDegat(this.getPartie().getHero());
                compteurPoison++;
                if (compteurPoison == 10) {
                    this.partie.getHero().setEtreEmpoisoner(false);
                }
            }

            compteurFrame = 0;
        }


        return null;
    }

    /**
     * Methode d'ajout d'arme a la liste d'arme
     *
     * @param p
     * @param n
     */
    public void AjouterArme(int p, int n) {
        partie.getHero().getlArme().add(new Arme(p, n));
    }

    @Override
    public boolean etreFini() {
        return false;
    }

    public Partie getPartie() {
        return partie;
    }

    public void setToSpawn() {
        CaseSpawn spawn = this.partie.getLabyrinthe().getSpawn();
        if (spawn != null) {
            Hero h = this.partie.getHero();
            h.setX(spawn.y);
            h.setY(spawn.x);
        }
    }

    public void supprimerMonstreMort() {
        ArrayList<Monstre> lMonstre = this.getPartie().getListeMonstre();
        for (int i = 0; i < lMonstre.size(); i++) {
            Monstre tempMonstre = lMonstre.get(i);
            if (tempMonstre.getMort()) {
                this.partie.getHero().ajouterScore(tempMonstre);
                lMonstre.remove(tempMonstre);
            }
        }
    }

    public void tuerMoitieMonstre() {
        ArrayList<Monstre> lMonstre = this.getPartie().getListeMonstre();
        for (int i = 0; i < lMonstre.size()/2-2; i++) {
            Monstre tempMonstre = lMonstre.get(i);
            this.partie.getHero().ajouterScore(tempMonstre);
            lMonstre.remove(tempMonstre);
        }
    }
}
