package gameLaby.laby;

public class Feu extends CaseEffet{

    /**
     * constructeur d'un case Feu
     * @param x abscisse de la case
     * @param y ordonnee de la case
     */
    public Feu(int x, int y) { super(x,y); }

    /**
     * met le personnage en feu par l'intermediaire de l'activation d'un booleen dans LabyJeu
     * @param lj est le LabyJeu ou l'on souhaite appliquer cet effet
     * @param l est le Labyrinthe ou l'on souhaite appliquer cet effet
     */
    public void executerEffet(LabyJeu lj, Labyrinthe l) {
        lj.setFeu(true);
        System.out.println(l.getPerso().getVie());
    }

}
