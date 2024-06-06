import org.junit.jupiter.api.Test;

import java.io.IOException;

import gameLaby.laby.Labyrinthe;

import static org.junit.jupiter.api.Assertions.*;

public class TestMonstre {

    @Test
    public void test_deplacer_possible() throws IOException {
        // charge laby0.txt
        Labyrinthe l = new Labyrinthe("labySimple/laby0.txt", 0);

        // ajoute le monstre
        l.ajoutMonstreLaby();
        l.getMonstre(0).setX(2);
        l.getMonstre(0).setY(2);
        int[] temp = new int[]{2,2};

        // deplace le monstre
        l.getMonstre(0).deplacer(l);

        // teste si le monstre s'est bien deplace

        boolean deplace = false;
        // teste si les coordonees du monstre ont changees
        if (!( (l.getMonstre(0).getX()==temp[0]) && (l.getMonstre(0).getY()==temp[1]) )) {
            deplace = true;
        }
        assertTrue(deplace);
    }

    @Test
    public void test_deplacer_pasPossible() throws IOException {
        // charge couloir.txt
        Labyrinthe l = new Labyrinthe("labySimple/couloir.txt", 0);

        // ajoute le monstre
        l.ajoutMonstreLaby();
        l.getMonstre(0).setX(1);
        l.getMonstre(0).setY(1);
        int[] temp = new int[]{1,1};

        // bloque le monstre avec le perso
        l.getPerso().setX(1);
        l.getPerso().setY(2);

        // deplace le monstre
        l.getMonstre(0).deplacer(l);

        // verifie que le monstre ne s'est pas deplace

        boolean deplace = false;
        // teste si les coordonees du monstre ont changees
        if (!( (l.getMonstre(0).getX()==temp[0]) && (l.getMonstre(0).getY()==temp[1]) )) {
            deplace = true;
        }
        assertFalse(deplace);
    }

    @Test
    public void test_estProcheDePerso_true() throws IOException {
        // charge laby0.txt
        Labyrinthe l = new Labyrinthe("labySimple/laby0.txt", 0);

        // ajout d'un monstre a cote du perso
        l.ajoutMonstreLaby();
        l.getMonstre(0).setX(4);
        l.getMonstre(0).setY(2);

        // teste si le personnage est bien proche du monstre
        assertTrue(l.getMonstre(0).estProcheDePerso(l));
    }

    @Test
    public void test_estProcheDePerso_false() throws IOException {
        // charge laby0.txt
        Labyrinthe l = new Labyrinthe("labySimple/laby0.txt", 0);

        // ajout d'un monstre a cote du perso
        l.ajoutMonstreLaby();
        l.getMonstre(0).setX(5);
        l.getMonstre(0).setY(2);

        // teste si le personnage est bien proche du monstre
        assertFalse(l.getMonstre(0).estProcheDePerso(l));
    }
}
