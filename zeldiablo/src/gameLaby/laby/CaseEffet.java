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
     * @param x
     * @param y
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

    public abstract void executerEffet(LabyJeu lj, Labyrinthe l);
}