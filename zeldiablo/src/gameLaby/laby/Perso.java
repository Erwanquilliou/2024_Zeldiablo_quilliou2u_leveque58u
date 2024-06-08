package gameLaby.laby;


import static gameLaby.laby.Labyrinthe.getSuivant;

/**
 * gere un personnage situe en x,y
 */
public class Perso extends Entite {


    /**
     * constructeur
     *
     * @param dx position selon x
     * @param dy position selon y
     */
    public Perso(int dx, int dy,int v) {
        super(dx,dy,v);
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

    public void estProcheDeMonstre(Labyrinthe laby){
        for (int i =0;i<laby.NBMONSTRE;i++){
            if (laby.getMonstre(i).estProcheDePerso(laby) && (!this.etreMort())){
                this.attaquer(laby.getMonstre(i));
            }
        }
    }

    public boolean estSurCaseEffet(Labyrinthe l) {
        boolean res = false;
        for (int i=0; i<l.getCasesEffet().size();i++) {
            if ((l.pj.getX() == l.getCasesEffet().get(i).getX()) && (l.pj.getY() == l.getCasesEffet().get(i).getY())) {
                res = true;
                break;
            }
        }
        return res;
    }

    public void changerLabyrinthe() {

    }

}