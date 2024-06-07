package gameLaby.laby;

import javafx.scene.image.Image;

import java.io.File;
import java.net.MalformedURLException;

public class Sprite {
    public static Image IMG_HEROS = null;
    public static Image IMG_MONSTRE = null;
    public static Image IMG_MONSTRE_MORT = null;
    public static Image IMG_MUR = null;

    static void init() throws MalformedURLException {
        IMG_HEROS = new Image(new File("heros.png").toURI().toURL().toExternalForm());
        IMG_MONSTRE = new Image(new File("monstre1.png").toURI().toURL().toExternalForm());
        IMG_MONSTRE_MORT = new Image(new File("monstre1_mort.png").toURI().toURL().toExternalForm());
        IMG_MUR = new Image(new File("arbre.png").toURI().toURL().toExternalForm());
    }
}
