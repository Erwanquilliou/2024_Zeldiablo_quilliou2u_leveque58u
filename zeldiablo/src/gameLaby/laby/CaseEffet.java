package gameLaby.laby;

public abstract class CaseEffet extends Position {

    /**
     * constructeur de CaseEffet
     * @param x coordonee abscisse
     * @param y coordonee ordonee
     */
    public CaseEffet(int x, int y) {
        super(x,y);
    }

    /**
     * retourne la CaseEffet qui est situee aux coordonees (x,y) du labyrinthe l
     * @param l Labyrinthe ou l'on recherche la CaseEffet
     * @param x coordonee ou l'on teste si il y a la CaseEffet
     * @param y coordonee ou l'on teste si il y a la CaseEffet
     * @return la CaseEffet situee aux coordonees donnees
     */
    public static CaseEffet getCaseEffet(Labyrinthe l, int x, int y) {
        CaseEffet res = null;
        for (CaseEffet c : l.getCasesEffet()) {
            if ((c.getX()==x) && (c.getY()==y)) {
                res = c;
            }
        }
        return res;
    }

    /**
     * methode redefinie par les classes héritant de CaseEffet afin de definir leur propre effet
     * @param lj est le LabyJeu ou l'on souhaite appliquer cet effet
     * @param l est le Labyrinthe ou l'on souhaite appliquer cet effet
     */
    public abstract void executerEffet(LabyJeu lj, Labyrinthe l);
}