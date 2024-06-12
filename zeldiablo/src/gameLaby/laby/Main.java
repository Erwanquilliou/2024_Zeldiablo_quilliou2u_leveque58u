package gameLaby.laby;

import moteurJeu.MoteurJeu;

import java.io.IOException;

/**
 * charge et affiche un labyrinthe
 */
public class Main {
    public static void main(String[] args) throws IOException {

        String[] map1 = new String[]{
                "labyComplexe/map1/laby1-1.txt","labyComplexe/map1/laby1-2.txt","labyComplexe/map1/laby1-3.txt","labyComplexe/map1/laby1-4.txt",
                "labyComplexe/map1/laby2-1.txt","labyComplexe/map1/laby2-2.txt","labyComplexe/map1/laby2-3.txt","labyComplexe/map1/laby2-4.txt",
                "labyComplexe/map1/laby3-1.txt","labyComplexe/map1/laby3-2.txt","labyComplexe/map1/laby3-3.txt","labyComplexe/map1/laby3-4.txt",
                "labyComplexe/map1/laby4-1.txt","labyComplexe/map1/laby4-2.txt","labyComplexe/map1/laby4-3.txt","labyComplexe/map1/laby4-4.txt"
        };

        LabyDessin ld = new LabyDessin();
        LabyJeu l = new LabyJeu(map1, ld);
        MoteurJeu.setTaille(700,700);
        MoteurJeu.setFPS(10);
        MoteurJeu.launch(l,ld);
    }
}
