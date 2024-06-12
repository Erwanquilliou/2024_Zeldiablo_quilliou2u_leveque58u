package gameLaby.laby;

import moteurJeu.Clavier;
import moteurJeu.Jeu;

import java.io.IOException;

public class LabyJeu implements Jeu {
    /**
     * labyrinthe dans lequel se trouve actuellement le perso
     */
    private Labyrinthe laby;

    /**
     * objet permettant d'afficher les elements du Labyrinthe
     */
    private LabyDessin labyD;

    /**
     * tableau a deux dimensions de Labyrinthe pour pouvoir gérer plusieurs salles
     */
    private Labyrinthe[][] map;

    /**
     * coordonee x du Labyrinthe affiche en temps reel par LabyJeu
     */
    private int x;

    /**
     * coordonee y du Labyrinthe affiche en temps reel par LabyJeu
     */
    private int y;

    /**
     * permet de creer des intervalles d'activation des methodes actionMonstre et subirDegats
     */
    private int compteur;

    /**
     * boolen a vrai si le perso est considere comme en feu
     * passe a false apres 3 subirDegats de feu
     */
    private boolean enFeu;

    /**
     * si superieur a 3, passe le booleen enFeu a false
     * permet de fixer le nombre de fois que le perso doit bruler
     */
    private int compteurFeu;

    /**
     * constructeur de LabyJeu avec un seul labyrinthe pour faire un LabySimple
     * @param l est le nom du fichier du labyrinthe a charger
     * @param ld objet LabyDessin a utiliser pour l'affichage
     * @throws IOException
     */
    public LabyJeu(String l, LabyDessin ld) throws IOException {
        this.laby = new Labyrinthe(l, 10);
        this.labyD = ld;
    }

    /**
     * constructeur de LabyJeu qui prend une liste de Labyrinthe pour faire un labyrinthe multi-salles
     * @param labys liste de noms des fichiers des labyrinthes a charger
     * @param ld objet LabyDessin a utiliser pour l'affichage
     * @throws IOException
     */
    public LabyJeu(String[] labys, LabyDessin ld) throws IOException {
        this.labyD = ld;
        map = new Labyrinthe[4][4];
        for (int i=0; i<4; i++) {
            for (int j=0; j<4; j++) {
                map[j][i] = new Labyrinthe(labys[j + (4 *i)], 0);
            }
        }
        laby = map[0][0];
        x = 0;
        y = 0;
    }

    /**
     * change l'attribut laby du jeu en fonction de la direction dans laquelle est allé le perso
     * @param dir est la direction dans laquelle le personnage
     */
    public void changerLabyrinthe(String dir) {
        Perso pTemp = this.laby.getPerso();
        switch (dir) {
            case Labyrinthe.GAUCHE:
                if (map[x-1][y]!=null) {
                    this.laby = map[x-1][y];
                    this.laby.setPJ(new Perso(16,8, pTemp.getVie()));
                    x--;
                }
                break;
            case Labyrinthe.DROITE:
                if (map[x+1][y]!=null) {
                    this.laby = map[x+1][y];
                    this.laby.setPJ(new Perso(0,8, pTemp.getVie()));
                    x++;
                }
                break;
            case Labyrinthe.HAUT:
                if (map[x][y-1]!=null) {
                    this.laby = map[x][y-1];
                    this.laby.setPJ(new Perso(8,16, pTemp.getVie()));
                    y--;
                }
                break;
            case Labyrinthe.BAS:
                if (map[x][y+1]!=null) {
                    this.laby = map[x][y+1];
                    this.laby.setPJ(new Perso(8,0, pTemp.getVie()));
                    y++;
                }
                break;
        }
    }

    /**
     * active le booleen enFeu pour que le personnage prenne des degats de feu
     */
    public void activerFeu() {
        this.enFeu = true;
    }

    /**
     * met a jour l'etat du jeu
     */
    public void update(double secondes, Clavier clavier) {
        // deplace la raquette en fonction des touches
        if (clavier.droite) {
            this.laby.deplacerPerso("Droite", this);
        }

        if (clavier.gauche) {
            this.laby.deplacerPerso("Gauche", this);
        }

        if (clavier.haut) {
            this.laby.deplacerPerso("Haut", this);
        }

        if (clavier.bas) {
            this.laby.deplacerPerso("Bas", this);
        }

        if (this.laby.getPerso().estSurCaseEffet(this.laby)) {
            CaseEffet.getCaseEffet(this.laby, this.laby.getPerso().getX(), this.laby.getPerso().getY()).executerEffet(this, this.laby);
        }

        if(clavier.coup) {
            this.laby.getPerso().estProcheDeMonstre(laby);
        }
        if(compteur % 10 == 0) {
            this.laby.actionMonstre(this);
        }

        if (enFeu) {
            if (compteurFeu <= 3) {
                if (compteur % 10 == 0) {
                    this.laby.getPerso().subirDegats(1);
                    compteurFeu++;
                    try {
                        this.labyD.getSprite().changementHerosDegat();
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                }
            } else {
                enFeu = false;
                compteurFeu = 0;
            }
        }
        compteur++;
    }

    @Override
    public void init() {
        // pas d'initialisation particuliere
    }

    /**
     * indique le jeu est fini
     * @return un booleen vrai si le labyrinthe est fini
     */
    @Override
    public boolean etreFini() {
        return this.laby.etreFini();
    }

    // GETTERS ET SETTERS
    public boolean getEnFeu() {return this.enFeu;}

    public Labyrinthe getLaby() {
        return this.laby;
    }

    public LabyDessin getLabyD() {
        return this.labyD;
    }

    public void setFeu(boolean f) {
        this.enFeu = f;
    }
}