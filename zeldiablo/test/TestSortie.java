import gameLaby.laby.*;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.io.IOException;

public class TestSortie {

    @Test
    public void testSortieGauche() throws IOException {
        // Initialisation du jeu avec la carte complexe
        String[] map1 = new String[]{
                "labyComplexe/map1/laby1-1.txt", "labyComplexe/map1/laby1-2.txt",
                "labyComplexe/map1/laby1-3.txt", "labyComplexe/map1/laby1-4.txt",
                "labyComplexe/map1/laby2-1.txt", "labyComplexe/map1/laby2-2.txt",
                "labyComplexe/map1/laby2-3.txt", "labyComplexe/map1/laby2-4.txt",
                "labyComplexe/map1/laby3-1.txt", "labyComplexe/map1/laby3-2.txt",
                "labyComplexe/map1/laby3-3.txt", "labyComplexe/map1/laby3-4.txt",
                "labyComplexe/map1/laby4-1.txt", "labyComplexe/map1/laby4-2.txt",
                "labyComplexe/map1/laby4-3.txt", "labyComplexe/map1/laby4-4.txt"
        };
        LabyJeu lj = new LabyJeu(map1, new LabyDessin());


        // Placer le personnage près de la sortie droite
        lj.getLaby().setPJ(new Perso(lj.getLaby().getLength() - 1, 8, Labyrinthe.VIEPERSO));

        // execute l'effet
        if (lj.getLaby().getPerso().estSurCaseEffet(lj.getLaby())) {
            CaseEffet.getCaseEffet(lj.getLaby(), lj.getLaby().getPerso().getX(), lj.getLaby().getPerso().getY()).executerEffet(lj, lj.getLaby());
        }

        // Placer le personnage près de la sortie gauche
        lj.getLaby().setPJ(new Perso(0, 8, Labyrinthe.VIEPERSO));

        // execute l'effet
        if (lj.getLaby().getPerso().estSurCaseEffet(lj.getLaby())) {
            CaseEffet.getCaseEffet(lj.getLaby(), lj.getLaby().getPerso().getX(), lj.getLaby().getPerso().getY()).executerEffet(lj, lj.getLaby());
        }

        // Vérifier que le perso a change de labyrinthe
        assertEquals(lj.getLaby().getPerso().getX(), 16);
    }

    @Test
    public void testSortieDroite() throws IOException {
        // Initialisation du jeu avec la carte complexe
        String[] map1 = new String[]{
                "labyComplexe/map1/laby1-1.txt", "labyComplexe/map1/laby1-2.txt",
                "labyComplexe/map1/laby1-3.txt", "labyComplexe/map1/laby1-4.txt",
                "labyComplexe/map1/laby2-1.txt", "labyComplexe/map1/laby2-2.txt",
                "labyComplexe/map1/laby2-3.txt", "labyComplexe/map1/laby2-4.txt",
                "labyComplexe/map1/laby3-1.txt", "labyComplexe/map1/laby3-2.txt",
                "labyComplexe/map1/laby3-3.txt", "labyComplexe/map1/laby3-4.txt",
                "labyComplexe/map1/laby4-1.txt", "labyComplexe/map1/laby4-2.txt",
                "labyComplexe/map1/laby4-3.txt", "labyComplexe/map1/laby4-4.txt"
        };
        LabyJeu lj = new LabyJeu(map1, new LabyDessin());

        // Placer le personnage près de la sortie droite
        lj.getLaby().setPJ(new Perso(lj.getLaby().getLength() - 1, 8, Labyrinthe.VIEPERSO));

        // execute l'effet
        if (lj.getLaby().getPerso().estSurCaseEffet(lj.getLaby())) {
            CaseEffet.getCaseEffet(lj.getLaby(), lj.getLaby().getPerso().getX(), lj.getLaby().getPerso().getY()).executerEffet(lj, lj.getLaby());
        }

        // Vérifier que le perso a change de labyrinthe
        assertEquals(lj.getLaby().getPerso().getX(), 0);
    }

    @Test
    public void testSortieHaut() throws IOException {
        // Initialisation du jeu avec la carte complexe
        String[] map1 = new String[]{
                "labyComplexe/map1/laby1-1.txt", "labyComplexe/map1/laby1-2.txt",
                "labyComplexe/map1/laby1-3.txt", "labyComplexe/map1/laby1-4.txt",
                "labyComplexe/map1/laby2-1.txt", "labyComplexe/map1/laby2-2.txt",
                "labyComplexe/map1/laby2-3.txt", "labyComplexe/map1/laby2-4.txt",
                "labyComplexe/map1/laby3-1.txt", "labyComplexe/map1/laby3-2.txt",
                "labyComplexe/map1/laby3-3.txt", "labyComplexe/map1/laby3-4.txt",
                "labyComplexe/map1/laby4-1.txt", "labyComplexe/map1/laby4-2.txt",
                "labyComplexe/map1/laby4-3.txt", "labyComplexe/map1/laby4-4.txt"
        };
        LabyJeu lj = new LabyJeu(map1, new LabyDessin());

        lj.getLaby().setPJ(new Perso(8, lj.getLaby().getLengthY() - 1, Labyrinthe.VIEPERSO));

        if (lj.getLaby().getPerso().estSurCaseEffet(lj.getLaby())) {
            CaseEffet.getCaseEffet(lj.getLaby(), lj.getLaby().getPerso().getX(), lj.getLaby().getPerso().getY()).executerEffet(lj, lj.getLaby());
        }

        // execute l'effet
        if (lj.getLaby().getPerso().estSurCaseEffet(lj.getLaby())) {
            CaseEffet.getCaseEffet(lj.getLaby(), lj.getLaby().getPerso().getX(), lj.getLaby().getPerso().getY()).executerEffet(lj, lj.getLaby());
        }

        // Vérifier que le perso a change de labyrinthe
        assertEquals(lj.getLaby().getPerso().getY(), 16);
    }

    @Test
    public void testSortieBas() throws IOException {
        // Initialisation du jeu avec la carte complexe
        String[] map1 = new String[]{
                "labyComplexe/map1/laby1-1.txt", "labyComplexe/map1/laby1-2.txt",
                "labyComplexe/map1/laby1-3.txt", "labyComplexe/map1/laby1-4.txt",
                "labyComplexe/map1/laby2-1.txt", "labyComplexe/map1/laby2-2.txt",
                "labyComplexe/map1/laby2-3.txt", "labyComplexe/map1/laby2-4.txt",
                "labyComplexe/map1/laby3-1.txt", "labyComplexe/map1/laby3-2.txt",
                "labyComplexe/map1/laby3-3.txt", "labyComplexe/map1/laby3-4.txt",
                "labyComplexe/map1/laby4-1.txt", "labyComplexe/map1/laby4-2.txt",
                "labyComplexe/map1/laby4-3.txt", "labyComplexe/map1/laby4-4.txt"
        };
        LabyJeu lj = new LabyJeu(map1, new LabyDessin());

        // Placer le personnage près de la sortie basse
        lj.getLaby().setPJ(new Perso(8, lj.getLaby().getLengthY() - 1, Labyrinthe.VIEPERSO));

        // execute l'effet
        if (lj.getLaby().getPerso().estSurCaseEffet(lj.getLaby())) {
            CaseEffet.getCaseEffet(lj.getLaby(), lj.getLaby().getPerso().getX(), lj.getLaby().getPerso().getY()).executerEffet(lj, lj.getLaby());
        }

        // Vérifier que le perso a change de labyrinthe
        assertEquals(lj.getLaby().getPerso().getY(), 0);
    }
}
