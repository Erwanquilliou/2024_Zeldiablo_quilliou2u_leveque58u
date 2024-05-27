package gameLaby.laby;

import moteurJeu.Clavier;
import moteurJeu.Jeu;

public abstract class LabyJeu implements Jeu {
    private final Labyrinthe laby;

    public LabyJeu(Labyrinthe l) {
        this.laby = l;
    }

    /**
     * met a jour l'etat du jeu
     */
    public void update(double secondes, Clavier clavier) {

        // deplace la raquette en fonction des touches
        if (clavier.droite) {
            this.laby.deplacerPerso("droite");
        }

        if (clavier.gauche) {
            this.laby.deplacerPerso("gauche");
        }

        if (clavier.haut) {
            this.laby.deplacerPerso("haut");
        }

        if (clavier.bas) {
            this.laby.deplacerPerso("bas");
        }
    }

    @Override
    public void init() {
        // pas d'initialisation particuliere
    }

    @Override
    public boolean etreFini() {
        return this.laby.etreFini();
    }
}