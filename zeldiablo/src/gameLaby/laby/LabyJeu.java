package gameLaby.laby;

import moteurJeu.Clavier;
import moteurJeu.Jeu;

import java.io.IOException;

public class LabyJeu implements Jeu {
    private Labyrinthe laby;

    private Labyrinthe[][] map;
    private int x;
    private int y;

    public LabyJeu(String l) throws IOException {
        this.laby = new Labyrinthe(l, 5);
    }

    public LabyJeu(String[] labys) throws IOException {
        map = new Labyrinthe[4][4];
        for (int i=0; i<4; i++) {
            for (int j=0; j<4; j++) {
                map[j][i] = new Labyrinthe(labys[j + (4 *i)], 0);
            }
        }
        laby = map[0][0];
        x = 0;
        y = 0;
    }

    public void changerLabyrinthe(String dir) {
        Perso pTemp = this.laby.getPerso();
        switch (dir) {
            case Labyrinthe.GAUCHE:
                if (map[x-1][y]!=null) {
                    this.laby = map[x-1][y];
                    this.laby.setPJ(new Perso(16,8, pTemp.getVie()));
                    x--;
                }
                break;
            case Labyrinthe.DROITE:
                if (map[x+1][y]!=null) {
                    this.laby = map[x+1][y];
                    this.laby.setPJ(new Perso(0,8, pTemp.getVie()));
                    x++;
                }
                break;
            case Labyrinthe.HAUT:
                if (map[x][y-1]!=null) {
                    this.laby = map[x][y-1];
                    this.laby.setPJ(new Perso(8,16, pTemp.getVie()));
                    y--;
                }
                break;
            case Labyrinthe.BAS:
                if (map[x][y+1]!=null) {
                    this.laby = map[x][y+1];
                    this.laby.setPJ(new Perso(8,0, pTemp.getVie()));
                    y++;
                }
                break;
        }
    }

    int compteur;

    /**
<<<<<<< HEAD
     * met a jour l'etat du jeu
     */
    public void update(double secondes, Clavier clavier) {
        // deplace la raquette en fonction des touches
        if (clavier.droite) {
            this.laby.deplacerPerso("Droite", this);
        }

        if (clavier.gauche) {
            this.laby.deplacerPerso("Gauche", this);
        }

        if (clavier.haut) {
            this.laby.deplacerPerso("Haut", this);
        }

        if (clavier.bas) {
            this.laby.deplacerPerso("Bas", this);
        }

        if(clavier.coup) {
            this.laby.getPerso().estProcheDeMonstre(laby);
        }
        if(compteur % 5 == 0) {
            this.laby.actionMonstre();
        }
        compteur++;

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