import gameLaby.laby.LabyJeu;
import org.junit.jupiter.api.Test;

import java.io.IOException;

import gameLaby.laby.Labyrinthe;

import static org.junit.jupiter.api.Assertions.*;

public class TestPerso {

    @Test
    public void test_etrePresent_true() throws IOException {
        // charge laby0.txt
        Labyrinthe l = new Labyrinthe("labySimple/laby0.txt", 0);

        // teste si la méthode renvoie bien true si le perso est aux coordonees fournies
        assertTrue(l.getPerso().etrePresent(3,2));
    }

    @Test
    public void test_etrePresent_false() throws IOException {
        // charge laby0.txt
        Labyrinthe l = new Labyrinthe("labySimple/laby0.txt", 0);

        // teste si la méthode renvoie bien false si le perso n'est pas aux coordonees fournies
        assertFalse(l.getPerso().etrePresent(3,1));
    }

    @Test
    public void test_estProcheDeMonstre_true() throws IOException {
        // charge laby0.txt
        Labyrinthe l = new Labyrinthe("labySimple/laby0.txt", 0);

        // ajout d'un monstre a cote du perso
        l.ajoutMonstreLaby();
        l.getMonstre(0).setX(4);
        l.getMonstre(0).setY(2);

        // utilise la methode estProcheDeMonstre
        l.getPerso().estProcheDeMonstre(l);

        // teste si le monstre prend bien 1 degat quand il est a cote du joueur et
        // se fait attaquer par celui ci
        assertEquals(l.getMonstre(0).getVie(),4);
    }

    @Test
    public void test_estProcheDeMonstre_false() throws IOException {
        // charge laby0.txt
        Labyrinthe l = new Labyrinthe("labySimple/laby0.txt", 0);

        // ajout d'un monstre a cote du perso
        l.ajoutMonstreLaby();
        l.getMonstre(0).setX(5);
        l.getMonstre(0).setY(2);

        // utilise la methode estProcheDeMonstre
        l.getPerso().estProcheDeMonstre(l);

        // teste si le monstre ne prend bien aucun degat quand il n'est pas a cote du joueur et
        // se fait attaquer par celui ci
        assertEquals(l.getMonstre(0).getVie(),5);
    }

    @Test
    public void test_estProcheDeMonstre_attaque_true() throws IOException {
        // charge laby0.txt
        Labyrinthe l = new Labyrinthe("labySimple/laby0.txt", 0);

        // ajout d'un monstre a cote du perso
        l.ajoutMonstreLaby();
        l.getMonstre(0).setX(3);
        l.getMonstre(0).setY(2);

        // initialiser la vie du monstre
        int vieInitiale = l.getMonstre(0).getVie();

        // le personnage attaque le monstre s'il est proche
        if (l.getMonstre(0).estProcheDePerso(l)) {
            l.getPerso().attaquer(l.getMonstre(0));
        }

        // verifie que le monstre a subi 1 de degat
        assertEquals(l.getMonstre(0).getVie(), vieInitiale--);
    }

    @Test
    public void test_estProcheDeMonstre_attaque_false() throws IOException {
        // charge laby0
        Labyrinthe l = new Labyrinthe("labySimple/laby0.txt", 0);

        // ajout d'un monstre a cote du perso
        l.ajoutMonstreLaby();
        l.getMonstre(0).setX(3);
        l.getMonstre(0).setY(2);

        // initialiser la vie du monstre
        int vieInitiale = l.getMonstre(0).getVie();

        // verifie que le monstre n'a pas subi de degats
        assertEquals(l.getMonstre(0).getVie(), vieInitiale);
    }

    @Test
    public void test_attaque_estLoinDeMonstre() throws IOException {
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

        // verifie que la vie du monstre n'a pas change
        assertEquals(l.getMonstre(0).getVie(), vieInitiale);
    }

    @Test
    public void test_subir_degats() throws IOException {
        // charge laby0.txt
        Labyrinthe l = new Labyrinthe("labySimple/laby0.txt", 0);

        // initialiser la vie du perso
        int vieInitiale = l.getPerso().getVie();

        // le perso subit des dégâts
        int degats = 2;
        l.getPerso().subirDegats(degats);

        // verifie que le perso a bien subi les degats
        assertEquals(l.getPerso().getVie(), vieInitiale - degats);
    }

    public void test_estSurCaseEffet_true() throws IOException {
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
        LabyJeu lj = new LabyJeu(map1);
        Labyrinthe laby = lj.getLaby();

        // Trouver une case de feu dans le labyrinthe
        // .... laby.getCasesEffet()
        laby.getPerso().setX(8);
        laby.getPerso().setY(15);

    }
}

