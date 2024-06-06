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

}
