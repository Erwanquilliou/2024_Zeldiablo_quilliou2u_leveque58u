import org.junit.jupiter.api.Test;

import static java.lang.Thread.sleep;
import static org.junit.jupiter.api.Assertions.*;

import gameLaby.laby.*;
import gameLaby.laby.LabyJeu;
import moteurJeu.Clavier;
import java.io.IOException;

public class TestFeu {


    @Test
    public void testFeuActivation() throws IOException {
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

        // Placer le personnage sur une case sans effet
        lj.getLaby().setPJ(new Perso(1, 1, Labyrinthe.VIEPERSO));

        // Trouver une case de feu dans le labyrinthe
        // .... laby.getCasesEffet()
        lj.getLaby().getPerso().setX(8);
        lj.getLaby().getPerso().setY(14);
        // Vérifier que la vie du personnage n'a pas changé immédiatement

        if (lj.getLaby().getPerso().estSurCaseEffet(lj.getLaby())) {
            CaseEffet.getCaseEffet(lj.getLaby(), lj.getLaby().getPerso().getX(), lj.getLaby().getPerso().getY()).executerEffet(lj, lj.getLaby());
        }

        lj.update(3, new Clavier());

        // Vérifier que l'effet de feu est activé
        assertTrue(lj.getEnFeu());
    }

    @Test
    public void testFeuEffectSurPerso() throws IOException, InterruptedException {
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
        LabyDessin ld = new LabyDessin();
        LabyJeu lj = new LabyJeu(map1, ld);
        Labyrinthe laby = lj.getLaby();

        // Trouver une case de feu dans le labyrinthe
        // .... laby.getCasesEffet()
        laby.getPerso().setX(8);
        laby.getPerso().setY(14);
        // Vérifier que la vie du personnage n'a pas changé immédiatement
        assertEquals(Labyrinthe.VIEPERSO, laby.getPerso().getVie());

        if (lj.getLaby().getPerso().estSurCaseEffet(lj.getLaby())) {
            CaseEffet.getCaseEffet(lj.getLaby(), lj.getLaby().getPerso().getX(), lj.getLaby().getPerso().getY()).executerEffet(lj, lj.getLaby());
        }

        lj.update(3,new Clavier());

        // Vérifier que le personnage a perdu de la vie due à l'effet de feu
        assertNotEquals(laby.getPerso().getVie(), Labyrinthe.VIEPERSO);
    }
}