package gameLaby.laby;

public class Position {
    private int x;
    private int y;

    public Position(int dx,int dy){
        this.x = dx;
        this.y = dy;
    }
    /**
     * @return position x du personnage
     */
    public int getX(){
        return this.x;
    }

    /**
     * @return position y du personnage
     */
    public int getY(){
        return this.y;
    }

    public void setX(int dx){
        this.x = dx;
    }

    public void setY(int dy){
        this.y = dy;
    }

    /**
     * deplace le personnage en fonction de l'action.
     * gere la collision avec les murs
     *
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

}
