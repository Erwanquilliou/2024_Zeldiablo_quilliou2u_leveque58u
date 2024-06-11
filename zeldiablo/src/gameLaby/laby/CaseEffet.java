package gameLaby.laby;

public abstract class CaseEffet extends Position {
    public CaseEffet(int x, int y) {
        super(x,y);
    }

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