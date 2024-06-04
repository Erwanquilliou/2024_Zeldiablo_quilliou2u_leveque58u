package gameLaby.laby;


/**
 * gere un personnage situe en x,y
 */
public class Perso extends Position {

    /**
     * position du personnage
     */

    /**
     * constructeur
     *
     * @param dx position selon x
     * @param dy position selon y
     */
    public Perso(int dx, int dy) {
        this.setX(dx);
        this.setY(dy);;
    }

    /**
     * permet de savoir si le personnage est en x,y
     *
     * @param dx position testee
     * @param dy position testee
     * @return true si le personnage est bien en (dx,dy)
     */
    public boolean etrePresent(int dx, int dy) {

        return (this.getX() == dx && this.getY() == dy);
    }





}
