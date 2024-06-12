import static org.junit.Assert.*;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

import gameLaby.laby.LabyJeu;
import gameLaby.laby.Labyrinthe;
import gameLaby.laby.Perso;
import org.junit.Before;
import org.junit.Test;
import java.io.IOException;

public class TestSortie {

//    @Test
//    public void testSortieGauche() throws IOException {
//        // Initialisation du jeu avec la carte complexe
//        String[] map1 = new String[]{
//                "labyComplexe/map1/laby1-1.txt", "labyComplexe/map1/laby1-2.txt",
//                "labyComplexe/map1/laby1-3.txt", "labyComplexe/map1/laby1-4.txt",
//                "labyComplexe/map1/laby2-1.txt", "labyComplexe/map1/laby2-2.txt",
//                "labyComplexe/map1/laby2-3.txt", "labyComplexe/map1/laby2-4.txt",
//                "labyComplexe/map1/laby3-1.txt", "labyComplexe/map1/laby3-2.txt",
//                "labyComplexe/map1/laby3-3.txt", "labyComplexe/map1/laby3-4.txt",
//                "labyComplexe/map1/laby4-1.txt", "labyComplexe/map1/laby4-2.txt",
//                "labyComplexe/map1/laby4-3.txt", "labyComplexe/map1/laby4-4.txt"
//        };
//        LabyJeu lj = new LabyJeu(map1);
//        Labyrinthe laby = lj.getLaby();
//
//        // Placer le personnage près de la sortie gauche
//        laby.setPJ(new Perso(0, 8, Labyrinthe.VIEPERSO));
//        laby.deplacerPerso(Labyrinthe.GAUCHE, lj);
//        // Vérifier que le labyrinthe a changé
//        assertNotEquals(laby, lj.getLaby());
//    }
//
//    @Test
//    public void testSortieDroite() throws IOException {
//        // Initialisation du jeu avec la carte complexe
//        String[] map1 = new String[]{
//                "labyComplexe/map1/laby1-1.txt", "labyComplexe/map1/laby1-2.txt",
//                "labyComplexe/map1/laby1-3.txt", "labyComplexe/map1/laby1-4.txt",
//                "labyComplexe/map1/laby2-1.txt", "labyComplexe/map1/laby2-2.txt",
//                "labyComplexe/map1/laby2-3.txt", "labyComplexe/map1/laby2-4.txt",
//                "labyComplexe/map1/laby3-1.txt", "labyComplexe/map1/laby3-2.txt",
//                "labyComplexe/map1/laby3-3.txt", "labyComplexe/map1/laby3-4.txt",
//                "labyComplexe/map1/laby4-1.txt", "labyComplexe/map1/laby4-2.txt",
//                "labyComplexe/map1/laby4-3.txt", "labyComplexe/map1/laby4-4.txt"
//        };
//        LabyJeu lj = new LabyJeu(map1);
//        Labyrinthe laby = lj.getLaby();
//
//        // Placer le personnage près de la sortie droite
//        laby.setPJ(new Perso(laby.getLength() - 1, 8, Labyrinthe.VIEPERSO));
//        laby.deplacerPerso(Labyrinthe.DROITE, lj);
//        // Vérifier que le labyrinthe a changé
//        assertNotEquals(laby, lj.getLaby());
//    }
//
//    @Test
//    public void testSortieHaut() throws IOException {
//        // Initialisation du jeu avec la carte complexe
//        String[] map1 = new String[]{
//                "labyComplexe/map1/laby1-1.txt", "labyComplexe/map1/laby1-2.txt",
//                "labyComplexe/map1/laby1-3.txt", "labyComplexe/map1/laby1-4.txt",
//                "labyComplexe/map1/laby2-1.txt", "labyComplexe/map1/laby2-2.txt",
//                "labyComplexe/map1/laby2-3.txt", "labyComplexe/map1/laby2-4.txt",
//                "labyComplexe/map1/laby3-1.txt", "labyComplexe/map1/laby3-2.txt",
//                "labyComplexe/map1/laby3-3.txt", "labyComplexe/map1/laby3-4.txt",
//                "labyComplexe/map1/laby4-1.txt", "labyComplexe/map1/laby4-2.txt",
//                "labyComplexe/map1/laby4-3.txt", "labyComplexe/map1/laby4-4.txt"
//        };
//        LabyJeu lj = new LabyJeu(map1);
//        Labyrinthe laby = lj.getLaby();
//
//        // Placer le personnage près de la sortie haute
//        laby.setPJ(new Perso(8, 0, Labyrinthe.VIEPERSO));
//        laby.deplacerPerso(Labyrinthe.HAUT, lj);
//        // Vérifier que le labyrinthe a changé
//        assertNotEquals(laby, lj.getLaby());
//    }
//
//    @Test
//    public void testSortieBas() throws IOException {
//        // Initialisation du jeu avec la carte complexe
//        String[] map1 = new String[]{
//                "labyComplexe/map1/laby1-1.txt", "labyComplexe/map1/laby1-2.txt",
//                "labyComplexe/map1/laby1-3.txt", "labyComplexe/map1/laby1-4.txt",
//                "labyComplexe/map1/laby2-1.txt", "labyComplexe/map1/laby2-2.txt",
//                "labyComplexe/map1/laby2-3.txt", "labyComplexe/map1/laby2-4.txt",
//                "labyComplexe/map1/laby3-1.txt", "labyComplexe/map1/laby3-2.txt",
//                "labyComplexe/map1/laby3-3.txt", "labyComplexe/map1/laby3-4.txt",
//                "labyComplexe/map1/laby4-1.txt", "labyComplexe/map1/laby4-2.txt",
//                "labyComplexe/map1/laby4-3.txt", "labyComplexe/map1/laby4-4.txt"
//        };
//        LabyJeu lj = new LabyJeu(map1);
//        Labyrinthe laby = lj.getLaby();
//
//        // Placer le personnage près de la sortie basse
//        laby.setPJ(new Perso(8, laby.getLengthY() - 1, Labyrinthe.VIEPERSO));
//        laby.deplacerPerso(Labyrinthe.BAS, lj);
//        // Vérifier que le labyrinthe a changé
//        assertNotEquals(laby, lj.getLaby());
//    }
}
