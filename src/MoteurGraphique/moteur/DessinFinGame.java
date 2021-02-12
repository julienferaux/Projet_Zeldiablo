package MoteurGraphique.moteur;

import MoteurPhysique.Hero;

import java.awt.*;
import java.awt.image.BufferedImage;

public class DessinFinGame implements DessinAbstract {
    @Override
    public void dessiner(BufferedImage image) {
        int height = image.getHeight();
        int width = image.getWidth();
        Graphics2D g = (Graphics2D) image.getGraphics();
        g.setColor(Color.green);
        g.fillRect(0, 0, width, height);
        g.setColor(Color.white);
        g.setFont(new Font("Courier New", Font.BOLD, 50));
        g.drawString("Bravo vous avez reussi ", 4, width / 2);
        g.drawString("Votre score: " + Hero.score, 4, width/2+60);
    }
}
