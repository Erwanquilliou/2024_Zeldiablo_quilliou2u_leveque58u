import gameLaby.laby.LabyDessin;
import gameLaby.laby.LabyJeu;
import org.junit.jupiter.api.Test;

import java.io.IOException;

import gameLaby.laby.Labyrinthe;

import static org.junit.jupiter.api.Assertions.*;

public class TestLabyrinthe {
    @Test
    public void test_getMur_true() throws Exception {
        // utilise laby0.txt
        Labyrinthe l = new Labyrinthe("labySimple/laby0.txt",0);

        // teste si getChar renvoie bien le caractère d'un mur en (0,0)
        assertTrue(l.getMur(0, 0));
    }

    @Test
    public void test_getMur_false() throws Exception {
        // utilise laby0.txt
        Labyrinthe l = new Labyrinthe("labySimple/laby0.txt",0);

        // teste si getChar renvoie bien le caractère d'un mur en (0,0)
        assertFalse(l.getMur(1, 1));
    }

    /**
     * teste getSuivant lorsque l'action est "haut"
     */
    @Test
    public void test_getSuivant_haut() {
        // teste si getSuivant en (1,1) avec l'action "haut" renvoie bien un tableau : {0,1}
        assertEquals(Labyrinthe.getSuivant(1, 1, Labyrinthe.HAUT)[1], 0);
    }

    /**
     * teste getSuivant lorsque l'action est "bas"
     */
    @Test
    public void test_getSuivant_bas() {
        // teste si getSuivant en (1,1) avec l'action "bas" renvoie bien un tableau : {2,1}
        assertEquals(Labyrinthe.getSuivant(1, 1, Labyrinthe.BAS)[1], 2);
    }

    /**
     * teste getSuivant lorsque l'action est "gauche"
     */
    @Test
    public void test_getSuivant_gauche() {
        // teste si getSuivant en (1,1) avec l'action "gauche" renvoie bien un tableau : {1,0}
        assertEquals(Labyrinthe.getSuivant(1, 1, Labyrinthe.GAUCHE)[0], 0);
    }

    /**
     * teste getSuivant lorsque l'action est "droite"
     */
    @Test
    public void test_getSuivant_droite() {
        // teste si getSuivant en (1,1) avec l'action "droite" renvoie bien un tableau : {1,2}
        assertEquals(Labyrinthe.getSuivant(1, 1, Labyrinthe.DROITE)[0], 2);
    }

    /**
     * teste deplacerPerso avec l'action "haut"
     */
    @Test
    public void test_deplacerPerso_haut() throws Exception {
        // utilise laby0.txt avec perso en (2,3)
        Labyrinthe l = new Labyrinthe("labySimple/laby0.txt",0);
        LabyDessin ld = new LabyDessin();
        LabyJeu lj = new LabyJeu("labySimple/laby0.txt",ld);

        // execution de la methode
        l.deplacerPerso(Labyrinthe.HAUT, lj);

        // verifie que le personnage est bien aux bonnes coordonees
        assertEquals(l.getPerso().getX(), 3);
        assertEquals(l.getPerso().getY(), 1);
    }

    /**
     * teste deplacerPerso avec l'action "bas"
     */
    @Test
    public void test_deplacerPerso_bas() throws Exception {
        // utilise laby0.txt avec perso en (2,3)
        Labyrinthe l = new Labyrinthe("labySimple/laby0.txt",0);
        LabyDessin ld = new LabyDessin();
        LabyJeu lj = new LabyJeu("labySimple/laby0.txt",ld);

        // execution de la methode
        l.deplacerPerso(Labyrinthe.BAS, lj);

        // verifie que le personnage est bien aux bonnes coordonees
        assertEquals(l.getPerso().getX(), 3);
        assertEquals(l.getPerso().getY(), 3);
    }

    /**
     * teste deplacerPerso avec l'action "gauche"
     */
    @Test
    public void test_deplacerPerso_gauche() throws Exception {
        // utilise laby0.txt avec perso en (2,3)
        Labyrinthe l = new Labyrinthe("labySimple/laby0.txt",0);
        LabyDessin ld = new LabyDessin();
        LabyJeu lj = new LabyJeu("labySimple/laby0.txt",ld);

        // execution de la methode
        l.deplacerPerso(Labyrinthe.GAUCHE, lj);

        // verifie que le personnage est bien aux bonnes coordonees
        assertEquals(l.getPerso().getX(), 2);
        assertEquals(l.getPerso().getY(), 2);
    }

    /**
     * teste deplacerPerso avec l'action "droite"
     */
    @Test
    public void test_deplacerPerso_droite() throws Exception {
        // utilise laby0.txt avec perso en (2,3)
        Labyrinthe l = new Labyrinthe("labySimple/laby0.txt",0);
        LabyDessin ld = new LabyDessin();
        LabyJeu lj = new LabyJeu("labySimple/laby0.txt",ld);

        // execution de la methode
        l.deplacerPerso(Labyrinthe.DROITE, lj);

        // verifie que le personnage est bien aux bonnes coordonees
        assertEquals(l.getPerso().getX(), 4);
        assertEquals(l.getPerso().getY(), 2);
    }

    /**
     * teste si etre fini renvoie bien faux
     */
    @Test
    public void test_etreFini_false() throws Exception {
        // utilise laby0.txt
        Labyrinthe l = new Labyrinthe("labySimple/laby0.txt",0);

        assertFalse(l.etreFini());
    }

    /**
     * teste chargerLabyrinthe avec un nom incorrect (fichier non trouve)
     * doit donc generer une IOException
     */
    @Test
    public void test_chargerLaby_nomIncorrect() {
        boolean b = false;
        // essaie de charger un labyrinthe inexistant
        try {
            Labyrinthe l = new Labyrinthe("labySimple/labi0.txt",0);
        } catch (IOException e) {
            b = true;
        }
        // verifie que b a bien ete modifie suite au catch de IOException
        assertTrue(b);
    }

    @Test
    public void test_peutSeDeplacer_false() throws Exception {
        // charge laby0
        Labyrinthe l = new Labyrinthe("labySimple/laby0.txt",0);
        LabyDessin ld = new LabyDessin();
        LabyJeu lj = new LabyJeu("labySimple/laby0.txt",ld);

        // deplace le perso contre un mur
        l.deplacerPerso(Labyrinthe.DROITE, lj);
        l.deplacerPerso(Labyrinthe.DROITE, lj);

        // verifie que la methode renvoie false
        assertFalse(l.peutSeDeplacer(6, 2));
    }

    @Test
    public void test_peutSeDeplacer_true() throws Exception {
        // charge laby0.txt
        Labyrinthe l = new Labyrinthe("labySimple/laby0.txt",0);

        // verifie que le perso peut bien se deplacer
        assertTrue(l.peutSeDeplacer(4, 2));
    }

    /**
     * teste si etreCerne renvoie bien false lorsque le monstre peut encore se deplacer
     */
    @Test
    public void test_etreCerne_false() throws Exception {
        // charge couloir.txt
        Labyrinthe l = new Labyrinthe("labySimple/couloir.txt",1);

        // met le monstre en haut
        l.getMonstre(0).setX(1);
        l.getMonstre(0).setY(1);

        // verifie que le monstre peut toujours se deplacer
        assertFalse(l.etreCerne(l.getMonstre(0)));
    }

    /**
     * teste si etreCerne renvoie bien true lorsque le monstre ne peut pas se deplacer
     */
    @Test
    public void test_etreCerne_true() throws Exception {
        // charge couloir.txt
        Labyrinthe l = new Labyrinthe("labySimple/couloir.txt", 1);
        LabyDessin ld = new LabyDessin();
        LabyJeu lj = new LabyJeu("labySimple/laby0.txt",ld);

        // met le monstre en haut
        l.getMonstre(0).setX(1);
        l.getMonstre(0).setY(1);

        // bloque le monstre avec le perso
        l.deplacerPerso(Labyrinthe.HAUT, lj);
        l.deplacerPerso(Labyrinthe.HAUT, lj);

        // verifie que le monstre est bien coince
        assertTrue(l.etreCerne(l.getMonstre(0)));
    }


    /**
     * teste si getLength renvoie bien la bonne largeur
     */
    @Test
    public void test_getLength() throws Exception {
        // charge laby0
        Labyrinthe l = new Labyrinthe("labySimple/laby0.txt",0);
        assertEquals(l.getLength(), 7);
    }


    /**
     * teste getLengthY renvoie bien la bonne hauteur
     */
    @Test
    public void test_getLengthY() throws Exception {
        // charge laby0
        Labyrinthe l = new Labyrinthe("labySimple/laby0.txt",0);
        assertEquals(l.getLengthY(), 5);
    }

    /**
     * teste si le monstre n'est bien plus a la meme place apres avoir utiliser deplacerMonstre()
     */
    @Test
    public void test_deplacerMonstre() throws Exception {
        // charge laby0
        Labyrinthe l = new Labyrinthe("labySimple/laby0.txt",1);
        LabyDessin ld = new LabyDessin();
        LabyJeu lj = new LabyJeu("labySimple/laby0.txt",ld);

        // ajoute un monstre
        l.getMonstre(0).setX(4);
        l.getMonstre(0).setY(2);
        l.deplacerPerso(Labyrinthe.GAUCHE, lj);

        // teste si il y a bien un changement dans les coordonees du monstre
        boolean changement = false;
        int tempX = l.getMonstre(0).getX();
        int tempY = l.getMonstre(0).getY();
        l.actionMonstre(lj);
        if ((tempX!=l.getMonstre(0).getX()) || (tempY!=l.getMonstre(0).getY())) {
            changement = true;
        }
        assertTrue(changement);
    }
}