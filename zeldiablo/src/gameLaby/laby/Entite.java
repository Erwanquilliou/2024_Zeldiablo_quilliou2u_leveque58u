package gameLaby.laby;

public class Entite extends Position{

    /**
     * nombre de points de vie l'Entite
     */
    private int vie;

    /**
     * constructeur d'Entite
     * @param dx coordonne x initiale de l'Entite
     * @param dy coordonee y initiale de l'Entite
     * @param v nombre de points de vie initiaux de l'Entite
     */
    public Entite(int dx, int dy, int v){
        super(dx,dy);
        this.vie = v;
    }

    /**
     * @return vie de l'entite
     */
    public int getVie() { return this.vie; }

    /**
     * deplace l'entite en fonction de l'action.
     * gere la collision avec les murs
     *
     * @param laby labyrinthe dans lequel on effectue le deplacement
     * @param action une des actions possibles
     */
    public void deplacer(Labyrinthe laby, String action) {
        // case courante
        int[] courante = {this.getX(), this.getY()};

        // calcule case suivante
        int[] suivante = Labyrinthe.getSuivant(courante[0], courante[1], action);

        // si il n'y a pas d'obstacles, on effectue le deplacement
        if (laby.peutSeDeplacer(suivante[0],suivante[1])) {
            // on met a jour personnage
            this.setX(suivante[0]);
            this.setY(suivante[1]);
        }
    }

    /**
     * methode qui permet a une entite d'attaquer une autre entite
     * @param e entite a attaquer
     * @return degats que subit la victime
     */
    public int attaquer(Entite e) {
        int degats = 1;
        if (this.etreMort()) {
            degats = 0;
        }
        e.subirDegats(degats);
        return degats;
    }

    /**
     * methode subirDegats qui fait subir des degats a une entite
     * @param d nombre de points de vie a enlever a l'entite
     */
    public void subirDegats(int d) {
        int nouvelleVie = this.vie - d;
        if (nouvelleVie < 0) {
            this.vie = 0;
        } else {
            this.vie = this.vie - d;
        }
    }

    /**
     * methode qui teste si l'entite est morte
     * @return true si l'entite est morte (0pv), false sinon
     */
    public boolean etreMort() { return this.vie <= 0; }
}
