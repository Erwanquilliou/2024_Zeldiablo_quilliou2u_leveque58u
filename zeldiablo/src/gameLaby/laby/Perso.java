package gameLaby.laby;


/**
 * gere un personnage situe en x,y
 */
public class Perso extends Position {


    /**
     * constructeur
     *
     * @param dx position selon x
     * @param dy position selon y
     */
    public Perso(int dx, int dy) {
<<<<<<< HEAD
//        this.x = dx;
        this.y = dy;
=======
        super(dx,dy);
>>>>>>> b3c8e0732bb47eb8ab0accfac38a725853936db9
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
