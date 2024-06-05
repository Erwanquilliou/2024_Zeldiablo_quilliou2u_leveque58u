package gameLaby.laby;

import java.util.Random;

import static gameLaby.laby.Labyrinthe.*;

public class Monstre extends Entite {
    public Monstre(int x, int y,int v) {
        super(x,y,v);
    }

    /**
     * déplace aléatoirement le monstre
     * @param laby labyrinthe dans lequel on deplace le monstre
     */
    public void deplacer(Labyrinthe laby) {
        Random random = new Random();
        String[] actions = {Labyrinthe.HAUT, Labyrinthe.BAS, Labyrinthe.GAUCHE, Labyrinthe.DROITE};
        boolean deplace = false;

        while ((!deplace)&&(!laby.etreCerne(this))) {
            String action = actions[random.nextInt(actions.length)];
            int[] courante = {this.getX(), this.getY()};
            int[] suivante = getSuivant(courante[0], courante[1], action);
            // vérifier si le monstre peut se deplacer ou s'il est bloque
            if (laby.peutSeDeplacer(suivante[0],suivante[1])) {
                // mettre à jour les coordonnées du monstre
                this.setX(suivante[0]);
                this.setY(suivante[1]);
                deplace = true;
            }
        }
    }

    public boolean estProcheDePerso(Labyrinthe laby){
        boolean b =false;
        String[] actions = {Labyrinthe.HAUT, Labyrinthe.BAS, Labyrinthe.GAUCHE, Labyrinthe.DROITE};
        for(int i = 0;i<4;i++){
            int[] posPossible = getSuivant(this.getX(), this.getY(), actions[i]);
            if ((posPossible[0] -laby.getPerso().getX() == 0) && (posPossible[1] -laby.getPerso().getY() == 0)) {
                b = true;
            }
        }
        return b;
    }

}