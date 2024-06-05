package gameLaby.laby;

import java.util.Random;

public class Monstre extends Position {
    public Monstre(int x, int y) {
        super(x,y);
    }

    /**
     * déplace aléatoirement le monstre
     */
    public void deplacerAleatoire() {
        Random random = new Random();
        String[] actions = {HAUT, BAS, GAUCHE, DROITE};
        boolean deplace = false;

        while (!deplace) {

            String action = actions[random.nextInt(actions.length)];
            int[] courante = {this.monstre.getX(), this.monstre.getY()};
            int[] suivante = getSuivant(courante[0], courante[1], action);
            // vérifier si la case suivante est dans les limites du labyrinthe et n'est pas un mur
            if (suivante[0] >= 0 && suivante[0] < murs.length && suivante[1] >= 0 && suivante[1] < murs[0].length && !this.murs[suivante[0]][suivante[1]]) {
                // mettre à jour les coordonnées du monstre
                this.monstre.setX(suivante[0]);
                this.monstre.setY(suivante[1]);
                deplace = true;
            }
        }
    }

}