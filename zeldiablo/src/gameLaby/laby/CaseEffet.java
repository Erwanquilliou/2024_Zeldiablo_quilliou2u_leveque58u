package gameLaby.laby;

public class CaseEffet extends Position {

    /**
     * caractere correspondant a une sortie menant
     */
    public final static String SORTIE = "Sortie";

    private String effet;

    public CaseEffet(int x, int y, String e) {
        super(x,y);
        this.effet = e;
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

    public static void executerEffet(Labyrinthe l, String e){
        switch (e) {
            case SORTIE:

                break;
        }
    }

    public String getEffet() { return this.effet; }
}
