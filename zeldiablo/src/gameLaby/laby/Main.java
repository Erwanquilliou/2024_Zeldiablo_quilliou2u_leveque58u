package gameLaby.laby;

import moteurJeu.MoteurJeu;

import java.io.IOException;

/**
 * charge et affiche un labyrinthe
 */
public class Main {
    public static void main(String[] args) throws IOException {

        // charge le labyrinthe
        Labyrinthe laby = new Labyrinthe("labySimple/laby1.txt");


        LabyJeu l = new LabyJeu(laby);
        LabyDessin ld = new LabyDessin();
        MoteurJeu.setTaille(800,600);
        MoteurJeu.setFPS(1);
        MoteurJeu.launch(l,ld);
    }
}
