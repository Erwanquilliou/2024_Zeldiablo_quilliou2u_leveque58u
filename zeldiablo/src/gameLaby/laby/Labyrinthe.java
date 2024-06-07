package gameLaby.laby;

import com.sun.scenario.effect.impl.sw.java.JSWBlend_SRC_OUTPeer;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * classe labyrinthe. represente un labyrinthe avec
 * <ul> des murs </ul>
 * <ul> un personnage (x,y) </ul>
 */
public class Labyrinthe {

    /**
     * Constantes char
     */
    public static final char MUR = 'X';
    public static final char PJ = 'P';
    public static final char VIDE = '.';

    public static final char M = 'M';

    public static final int VIEMONSTRE = 5;

    public static final int VIEPERSO = 10;

    /**
     * constantes actions possibles
     */
    public static final String HAUT = "Haut";
    public static final String BAS = "Bas";
    public static final String GAUCHE = "Gauche";
    public static final String DROITE = "Droite";

    public static int NBMONSTRE;

    /**
     * attribut du personnage
     */
    public Perso pj;
    public List<Monstre> monstre;

    /**
     * les murs du labyrinthe
     */
    public boolean[][] murs;

    /**
     * retourne la case suivante selon une actions
     *
     * @param x      case depart
     * @param y      case depart
     * @param action action effectuee
     * @return case suivante
     */
    public static int[] getSuivant(int x, int y, String action) {
        switch (action) {
            case HAUT:
                // on monte une ligne
                y--;
                break;
            case BAS:
                // on descend une ligne
                y++;
                break;
            case DROITE:
                // on augmente colonne
                x++;
                break;
            case GAUCHE:
                // on augmente colonne
                x--;
                break;
            default:
                throw new Error("action inconnue");
        }
        int[] res = {x, y};
        return res;
    }

    /**
     * charge le labyrinthe
     *
     * @param nom nom du fichier de labyrinthe
     * @return labyrinthe cree
     * @throws IOException probleme a la lecture / ouverture
     */
    public Labyrinthe(String nom,int nbM) throws IOException {
        // ouvrir fichier
        FileReader fichier = new FileReader(nom);
        BufferedReader bfRead = new BufferedReader(fichier);

        boolean monstrePresent = false;
        NBMONSTRE = 0;
        int nbLignes, nbColonnes;
        // lecture nblignes
        nbLignes = Integer.parseInt(bfRead.readLine());
        // lecture nbcolonnes
        nbColonnes = Integer.parseInt(bfRead.readLine());

        // creation labyrinthe vide
        this.murs = new boolean[nbColonnes][nbLignes];
        this.pj = null;
        this.monstre = new ArrayList<Monstre>();

        // lecture des cases
        String ligne = bfRead.readLine();

        // stocke les indices courants
        int numeroLigne = 0;

        // parcours le fichier
        while (ligne != null) {

            // parcours de la ligne
            for (int colonne = 0; colonne < ligne.length(); colonne++) {
                char c = ligne.charAt(colonne);
                switch (c) {
                    case MUR:
                        this.murs[colonne][numeroLigne] = true;
                        break;
                    case VIDE:
                        this.murs[colonne][numeroLigne] = false;
                        break;
                    case PJ:
                        // pas de mur
                        this.murs[colonne][numeroLigne] = false;
                        // ajoute PJ
                        this.pj = new Perso(colonne, numeroLigne,VIEPERSO);
                        break;
                    case M:
                        this.monstre.add(new Monstre(colonne,numeroLigne,VIEMONSTRE));
                        monstrePresent = true;
                        NBMONSTRE++;
                        break;

                    default:
                        throw new Error("caractere inconnu " + c);
                }
            }


            // lecture
            ligne = bfRead.readLine();
            numeroLigne++;
        }
        //ajout d'un monstre
        if(!monstrePresent) {
            NBMONSTRE = nbM;
            for (int i = 0; i < nbM; i++) {
                ajoutMonstreLaby();
            }
            NBMONSTRE -= nbM;
        }
        // ferme fichier
        bfRead.close();
    }



    public void ajoutMonstreLaby() {
        Random random = new Random();
        boolean place = false;
        //on teste si le monstre a ete place ou non
        while (!place) {
            int largeur = random.nextInt((this.murs.length)-1);
            int longueur = random.nextInt((this.murs[0].length)-1);
            //si la case est libre, alors on place le monstre
            if ((peutSeDeplacer(largeur,longueur))) {
                this.monstre.add(new Monstre(largeur, longueur,VIEMONSTRE));
                NBMONSTRE++;
                place = true;
            }
        }

    }

    public Monstre getMonstre(int i) {
        return this.monstre.get(i);
    }

    /**
     * deplace le personnage en fonction de l'action.
     * gere la collision avec les murs
     *
     * @param action une des actions possibles
     */
    public void deplacerPerso(String action) {
        this.pj.deplacer(this, action);
    }

    public void actionMonstre() {
        Random r = new Random();
        for (int i = 0;i<Labyrinthe.NBMONSTRE;i++) {
            int action = r.nextInt(3);
            if(!this.monstre.get(i).etreMort() && (action == 2)) {
                if (this.monstre.get(i).estProcheDePerso(this)) {
                    this.monstre.get(i).attaquer(this.getPerso());
                } else {
                    this.monstre.get(i).deplacer(this);
                }
            }
        }


    }

    /**
     * methode peutSeDeplacer qui indique si le personnage peut se deplacer ou non
     * @param x coordonnées x
     * @param y coordonnées y
     * @return booléen indiquant la présence d'obstacle, true si il n'y en a pas, false sinon
     */
    public boolean peutSeDeplacer(int x,int y) {
        if ((this.murs[x][y]) || ((this.pj.getX() == x) && (this.pj.getY() == y)) ) {
            return false;
        }
        for (int i = 0;i<this.monstre.size();i++) {
            if(((this.monstre.get(i).getX() == x) && (this.monstre.get(i).getY() == y))){
                return false;
            }
        }
        return true;

    }

    /**
     * methode estCerne
     * @return true si le monstre est cerne (ne peut plus bouger), false sinon
     */
    public boolean etreCerne(Monstre m) {
        int x = m.getX();
        int y = m.getY();
        int[] haut = getSuivant(x,y,HAUT);
        int[] bas = getSuivant(x,y,BAS);
        int[] gauche = getSuivant(x,y,GAUCHE);
        int[] droite = getSuivant(x,y,DROITE);
        //si le monstre ne peut se deplacer nul part (ni en haut, en bas, a gauche et a droite)
        if ((!peutSeDeplacer(haut[0],haut[1]))&&(!peutSeDeplacer(bas[0],bas[1]))&&(!peutSeDeplacer(gauche[0],gauche[1]))&&(!peutSeDeplacer(droite[0],droite[1]))) {
            return true;
        } else {
            return false;
        }
    }


    /**
     * jamais fini
     *
     * @return fin du jeu
     */
    public boolean etreFini() {
        return false;
    }

    // ##################################
    // GETTER
    // ##################################

    /**
     * return taille selon Y
     *
     * @return
     */
    public int getLengthY() {
        return murs[0].length;
    }

    /**
     * return taille selon X
     *
     * @return
     */
    public int getLength() {
        return murs.length;
    }

    /**
     * return mur en (i,j)
     * @param x
     * @param y
     * @return
     */
    public boolean getMur(int x, int y) {
        // utilise le tableau de boolean
        return this.murs[x][y];
    }

    public Perso getPerso() {
        return this.pj;
    }
}
