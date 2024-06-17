package gameLaby.laby;

public class Sortie extends CaseEffet{


    public Sortie(int x, int y) { super(x, y); }

    public void executerEffet(LabyJeu lj, Labyrinthe l) {
        if (lj.getChangePlace()) {
            Perso p = l.getPerso();
            if (p.getX() == 0) {
                lj.changerLabyrinthe(Labyrinthe.GAUCHE);
            } else if (p.getX() == l.getLength() - 1) {
                lj.changerLabyrinthe(Labyrinthe.DROITE);
            } else if (p.getY() == 0) {
                lj.changerLabyrinthe(Labyrinthe.HAUT);
            } else if (p.getY() == l.getLengthY() - 1) {
                lj.changerLabyrinthe(Labyrinthe.BAS);
            }
        }
    }
}
