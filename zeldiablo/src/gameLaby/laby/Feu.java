package gameLaby.laby;

public class Feu extends CaseEffet{

    public Feu(int x, int y) { super(x,y); }
    public void executerEffet(LabyJeu lj, Labyrinthe l) {
        lj.setFeu(true);
    }


}
