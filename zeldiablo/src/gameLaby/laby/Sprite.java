package gameLaby.laby;

import javafx.scene.image.Image;

import java.io.File;
import java.net.MalformedURLException;

public class Sprite {
    public Image img_heros;
    public Image img_monstre;
    public Image img_monstre_mort;
    public Image img_mur;
    public Image img_feu;
    public Image img_amulette;
    public Image img_sol;
    public Image img_heros_degat;
    public Image img_intermediaire;
    public boolean changement;


    public Sprite() throws MalformedURLException {
        this.img_heros = new Image(new File("images/heros.png").toURI().toURL().toExternalForm());
        this.img_monstre = new Image(new File("images/monstre1.png").toURI().toURL().toExternalForm());
        this.img_monstre_mort = new Image(new File("images/monstre1_mort.png").toURI().toURL().toExternalForm());
        this.img_mur = new Image(new File("images/arbre.png").toURI().toURL().toExternalForm());
        this.img_sol = new Image(new File("images/sol.jpg").toURI().toURL().toExternalForm());
        this.img_amulette = new Image(new File("images/amulette.jpg").toURI().toURL().toExternalForm());
        this.img_heros_degat = new Image(new File("images/heros_degat.png").toURI().toURL().toExternalForm());
        this.img_intermediaire = new Image(new File("images/heros.png").toURI().toURL().toExternalForm());
        this.img_feu = new Image(new File("images/feu.png").toURI().toURL().toExternalForm());
        this.changement = false;
    }

    /**
     * GETTERS
     * @return image recherchee
     */
    public Image getImgHeros() {
        return this.img_heros;
    }

    public Image getImgMonstre() {
        return this.img_monstre;
    }

    public Image getImgMonstreMort() {
        return this.img_monstre_mort;
    }

    public Image getImgMur() {
        return this.img_mur;
    }

    public Image getImgSol() {
        return this.img_sol;
    }

    public Image getImgAmulette() {return this.img_amulette;}
    public Image getImgFeu() {return this.img_feu;}
    public boolean getChang() {return this.changement;}



    /**
     * methode qui permet de changer l'image du heros pendant 0.3 secondes
     * pendant qu'il se prend des degats
     */
    public void changementHerosDegat() throws InterruptedException {
        if (this.changement) {
            this.changement = false;
        } else {
            this.changement = true;
        }
        this.img_intermediaire = this.img_heros;
        this.img_heros = this.img_heros_degat;
        this.img_heros_degat = this.img_intermediaire;
        Thread.sleep(300);
    }
}
