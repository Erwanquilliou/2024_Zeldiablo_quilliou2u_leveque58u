package gameLaby.laby;

import moteurJeu.MoteurJeu;

import java.io.IOException;

/**
 * charge et affiche un labyrinthe
 */
public class Main {
    public static void main(String[] args) throws IOException {

        // charge le labyrinthe
        Labyrinthe laby = new Labyrinthe("Labyrinthe/labySimple/laby2.txt");

        //affiche le labyrinthe charge
        for (int y = 0; y < laby.getLengthY(); y++) {
            // affiche la ligne
            for (int x = 0; x < laby.getLength(); x++) {
                if (laby.getMur(x, y))
                    System.out.print('X');
                else
                    System.out.print('.');
            }
            // saut de ligne
            System.out.println();
        }
        LabyJeu l = new LabyJeu(laby);
        LabyDessin ld = new LabyDessin();
        MoteurJeu.setTaille(800,600);
        MoteurJeu.setFPS(40);
        MoteurJeu.launch(l,ld);
    }
}
