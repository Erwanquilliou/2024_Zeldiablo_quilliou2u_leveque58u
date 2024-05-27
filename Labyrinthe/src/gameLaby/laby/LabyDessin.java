package gameLaby.laby;

import gameArkanoid.ArkanoidJeu;
import gameArkanoid.Balle;
import gameArkanoid.Raquette;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import moteurJeu.Jeu;
import moteurJeu.DessinJeu;

public class LabyDessin implements DessinJeu {
    @Override
    public void dessinerJeu(Jeu jeu, Canvas canvas) {
        LabyJeu laby = (LabyJeu) jeu;


        // recupere un pinceau pour dessiner
        final GraphicsContext gc = canvas.getGraphicsContext2D();

        // dessin fond
        gc.setFill(Color.LIGHTGRAY);
        gc.fillRect(0, 0, canvas.getWidth(), canvas.getHeight());

        // dessin mur
        gc.setFill(Color.BLACK);
        Raquette raquette = laby.getRaquette();
        double px = raquette.getPx() - Raquette.RAQUETTE_TAILLE / 2;
        double py = raquette.getPy();
        gc.fillRect(px, py, Raquette.RAQUETTE_TAILLE, 10);

    }
}
