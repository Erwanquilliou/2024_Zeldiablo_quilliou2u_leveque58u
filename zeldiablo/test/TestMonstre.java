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

    @Test
    public void test_estProcheDePerso_attaque_true() throws IOException {
        // charge laby0.txt
        Labyrinthe l = new Labyrinthe("labySimple/laby0.txt", 0);

        // ajout d'un monstre a cote du perso
        l.ajoutMonstreLaby();
        l.getMonstre(0).setX(3);
        l.getMonstre(0).setY(2);

        // initialiser la vie du personnage
        int vieInitiale = l.getPerso().getVie();

        // le monstre attaque automatiquement le perso s'il est proche
        if (l.getMonstre(0).estProcheDePerso(l)) {
            l.getMonstre(0).attaquer(l.getPerso());
        }

        // verifie que le personnage a subi 1 de degat
        assertEquals(l.getPerso().getVie(), vieInitiale--);
    }

    @Test
    public void test_estLoinDePerso_attaque_true() throws IOException {
        // charge laby0.txt
        Labyrinthe l = new Labyrinthe("labySimple/laby0.txt", 0);

        // ajout d'un monstre loin du perso
        l.ajoutMonstreLaby();
        l.getMonstre(0).setX(0);
        l.getMonstre(0).setY(0);

        // initialiser la vie du monstre
        int vieInitiale = l.getMonstre(0).getVie();

        // verifie que le perso n'attaque pas le monstre
        if (l.getMonstre(0).estProcheDePerso(l)) {
            l.getPerso().attaquer(l.getMonstre(0));
        }

        // vérifie que la vie du monstre n'a pas changé
        assertEquals(l.getMonstre(0).getVie(), vieInitiale);
    }

    @Test
    public void test_subirDegats() throws IOException {
        // charge laby0.txt
        Labyrinthe l = new Labyrinthe("labySimple/laby0.txt", 0);

        // ajout d'un monstre
        l.ajoutMonstreLaby();
        l.getMonstre(0).setX(3);
        l.getMonstre(0).setY(2);

        // initialiser la vie du monstre
        int vieInitiale = l.getMonstre(0).getVie();

        // le monstre subit des degats
        int degats = 2;
        l.getMonstre(0).subirDegats(degats);

        // verifie que le monstre a bien subi des degats
        assertEquals(l.getMonstre(0).getVie(), vieInitiale - degats);
    }
}
