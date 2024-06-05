package gameLaby.laby;

import moteurJeu.Clavier;
import moteurJeu.Jeu;

public class LabyJeu implements Jeu {
    private final Labyrinthe laby;

    public LabyJeu(Labyrinthe l) {
        this.laby = l;
    }

    /**
<<<<<<< HEAD
     * met a jour l'etat du jeu
     */
    public void update(double secondes, Clavier clavier) {

        // deplace la raquette en fonction des touches
        if (clavier.droite) {
            this.laby.deplacerPerso("Droite");
        }

        if (clavier.gauche) {
            this.laby.deplacerPerso("Gauche");
        }

        if (clavier.haut) {
            this.laby.deplacerPerso("Haut");
        }

        if (clavier.bas) {
            this.laby.deplacerPerso("Bas");
        }

        if(clavier.coup) {
            this.laby.getPerso().estProcheDeMonstre(laby);
        }
        this.laby.actionMonstre();

    }

    @Override
    public void init() {
        // pas d'initialisation particuliere
    }

    @Override
    public boolean etreFini() {
        return this.laby.etreFini();
    }

    public Labyrinthe getLaby() {
        return this.laby;
    }
}