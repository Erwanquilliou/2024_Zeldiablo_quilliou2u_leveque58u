package gameLaby.laby;

import gameArkanoid.ArkanoidJeu;
import gameArkanoid.Balle;
import gameArkanoid.Raquette;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.paint.Color;
import moteurJeu.Jeu;
import moteurJeu.DessinJeu;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class LabyDessin implements DessinJeu {

    public void setImageToFrame(BufferedImage image) {
        ImageIcon imageIcon = new ImageIcon(image);

        JFrame jFrame = new JFrame();
        jFrame.setLayout(new FlowLayout());
        jFrame.setSize(700, 500);

        JLabel jLabel = new JLabel();
        jLabel.setIcon(imageIcon);

        jFrame.add(jLabel);
        jFrame.setVisible(true);

        jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    @Override
    public void dessinerJeu(Jeu jeu, Canvas canvas) throws IOException {
        LabyJeu laby = (LabyJeu) jeu;

        // recupere un pinceau pour dessiner
        final GraphicsContext gc = canvas.getGraphicsContext2D();
        Image im = new Image(getClass().getResource("perso.png").toString());
        // dessin fond
        gc.setFill(Color.LIGHTGRAY);
        gc.fillRect(0, 0, canvas.getWidth(), canvas.getHeight());

        // dessin personnage
        if(!laby.getLaby().getPerso().etreMort()) {
            gc.setFill(Color.GREEN);
        }else{
            gc.setFill(Color.LIGHTGREEN);
        }
        Perso p = laby.getLaby().getPerso();
        double px = p.getX();
        double py = p.getY();
        gc.fillOval(px*20, py*20, 20, 20);

        // dessin monstre
        gc.setFill(Color.RED);
        for (int i = 0;i<Labyrinthe.NBMONSTRE;i++) {
            Monstre m = laby.getLaby().getMonstre(i);
            double mx = m.getX();
            double my = m.getY();
            if(!laby.getLaby().getMonstre(i).etreMort()) {
                gc.fillOval(mx * 20, my * 20, 20, 20);
            }else{
                gc.setFill(Color.ORANGE);
                gc.fillOval(mx * 20, my * 20, 20, 20);
                gc.setFill(Color.RED);
            }
        }


        for (int y = 0; y < laby.getLaby().getLengthY(); y++) {
            // affiche la ligne
            for (int x = 0; x < laby.getLaby().getLength(); x++) {
                if (laby.getLaby().getMur(x, y)) {
                    gc.setFill(Color.BLACK);
                    gc.fillRect(x*20, y * 20, 20, 20);
                }
            }

        }
        gc.drawImage(im,0,0,10,10);

    }
}
