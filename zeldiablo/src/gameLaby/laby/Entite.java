package gameLaby.laby;

public class Entite {
    private int x;
    private int y;
    private int vie;

    public Entite(int dx, int dy, int v){
        this.x = dx;
        this.y = dy;
        this.vie = v;
    }
    /**
     * @return position x de l'entite
     */
    public int getX(){
        return this.x;
    }

    /**
     * @return position y de l'entite
     */
    public int getY(){
        return this.y;
    }

    /**
     * @return vie de l'entite
     */
    public int getVie() { return this.vie; }

    /**
     * @param dx nouvelle coordonne
     */
    public void setX(int dx){
        this.x = dx;
    }

    /**
     * @param dy nouvelle coordonne
     */
    public void setY(int dy){
        this.y = dy;
    }

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
     * @param d nombre de degats a faire subir
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
     * methode etreMort
     * @return true si l'entite est morte, false sinon
     */
    public boolean etreMort() {
        if (this.vie <= 0) {
            return true;
        } else {
            return false;
        }
    }

}
