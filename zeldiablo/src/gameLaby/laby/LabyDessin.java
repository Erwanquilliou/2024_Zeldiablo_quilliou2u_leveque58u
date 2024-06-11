package gameLaby.laby;

import gameArkanoid.ArkanoidJeu;
import gameArkanoid.Balle;
import gameArkanoid.Raquette;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
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

    public static int LANCEMENT = 0;
    public static int TAILLE_JEU = 80;
    private Sprite sprite;

    @Override
    public void dessinerJeu(Jeu jeu, Canvas canvas) throws IOException {
        LabyJeu laby = (LabyJeu) jeu;
        if (LANCEMENT == 0){
            LANCEMENT++;
            this.sprite = new Sprite();
        }



        // recupere un pinceau pour dessiner
        final GraphicsContext gc = canvas.getGraphicsContext2D();
        gc.clearRect(0, 0, canvas.getWidth(), canvas.getHeight());
        for (int y = 0; y < laby.getLaby().getLengthY(); y++) {
            for (int x = 0; x < laby.getLaby().getLength(); x++) {
            gc.drawImage(sprite.getImgSol(), x * TAILLE_JEU / 2, y * TAILLE_JEU / 2, TAILLE_JEU / 2, TAILLE_JEU / 2);
            }
        }
        /*
        Image im = new Image(new File("heros.png").toURI().toURL().toExternalForm());// dessin fond

        gc.setFill(Color.LIGHTGRAY);
        gc.fillRect(0, 0, canvas.getWidth(), canvas.getHeight());
        */
        // dessin personnage



        // dessin monstre
        gc.setFill(Color.RED);
        for (int i = 0;i<laby.getLaby().nbMonstre;i++) {
            Monstre m = laby.getLaby().getMonstre(i);
            double mx = m.getX();
            double my = m.getY();
            if(!laby.getLaby().getMonstre(i).etreMort()) {
                gc.drawImage(sprite.getImgMonstre(),mx*TAILLE_JEU/2,my*TAILLE_JEU/2,TAILLE_JEU,TAILLE_JEU);
            }else{
                gc.drawImage(sprite.getImgMonstreMort(),mx*TAILLE_JEU/2,my*TAILLE_JEU/2+10,TAILLE_JEU,TAILLE_JEU);
            }
        }

        Perso p = laby.getLaby().getPerso();
        double px = p.getX();
        double py = p.getY();
        if(!laby.getLaby().getPerso().etreMort()) {
            gc.drawImage(sprite.getImgHeros(),px*TAILLE_JEU/2,py*TAILLE_JEU/2,TAILLE_JEU,TAILLE_JEU);
        }else{
            gc.drawImage(sprite.getImgMonstre(),px*TAILLE_JEU/2,py*TAILLE_JEU/2,TAILLE_JEU,TAILLE_JEU);
        }


        for (int y = 0; y < laby.getLaby().getLengthY(); y++) {
            // affiche la ligne
            for (int x = 0; x < laby.getLaby().getLength(); x++) {
                if (laby.getLaby().getMur(x, y)) {
                    gc.drawImage(sprite.getImgMur(),x*TAILLE_JEU/2,y*TAILLE_JEU/2,TAILLE_JEU,TAILLE_JEU);
                }
            }

        }


    }
}
