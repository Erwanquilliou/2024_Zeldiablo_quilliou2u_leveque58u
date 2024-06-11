package gameLaby.laby;

public class CaseEffet extends Position {

    /**
     * caractere correspondant a une sortie menant
     */
    public final static String SORTIE = "Sortie";
    public final static String FEU = "Feu";

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

    public static void executerEffet(LabyJeu lj, Labyrinthe l, String e){
        switch (e) {
            case SORTIE:
                Perso p = l.getPerso();
                if (p.getX()==0) {
                    lj.changerLabyrinthe(Labyrinthe.GAUCHE);
                } else if (p.getX()==l.getLength()-1) {
                    lj.changerLabyrinthe(Labyrinthe.DROITE);
                } else if (p.getY()==0) {
                    lj.changerLabyrinthe(Labyrinthe.HAUT);
                } else if (p.getY()==l.getLengthY()-1) {
                    lj.changerLabyrinthe(Labyrinthe.BAS);
                }
                break;
            case FEU:
                Perso p = l.getPerso().subirDegats(1);

        }
    }

    public String getEffet() { return this.effet; }
}