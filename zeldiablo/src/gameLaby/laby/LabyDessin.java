package gameLaby.laby;

import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import moteurJeu.Jeu;
import moteurJeu.DessinJeu;
import java.io.IOException;

public class LabyDessin implements DessinJeu {

    /**
     * Variable de classe qui passe a 1 a la premiere execution de dessinerJeu.
     * Permet d'executer une seule fois la creation d'un objet Sprite.
     */
    public static int LANCEMENT = 0;

    /**
     * taille permettant d'ajuster la taille d'affichage
     */
    public static int TAILLE_JEU = 80;

    /**
     * objet Sprite qui permet d'enregistrer les textures du jeu
     */
    private Sprite sprite;

    /**
     * dessine sur un Canvas tous les elements du jeu a afficher
     * @param jeu jeu a afficher
     * @param canvas canvas dans lequel dessiner l'etat du jeu
     * @throws IOException
     */
    @Override
    public void dessinerJeu(Jeu jeu, Canvas canvas) throws IOException {
        LabyJeu laby = (LabyJeu) jeu;
        if (LANCEMENT == 0){
            LANCEMENT++;
            this.sprite = new Sprite();
        }



        // recupere un pinceau pour dessiner
        final GraphicsContext gc = canvas.getGraphicsContext2D();
        gc.clearRect(0, 0, canvas.getWidth(), canvas.getHeight());

        if (!jeu.etreFini()) {
            for (int y = 0; y < laby.getLaby().getLengthY()+1; y++) {
                for (int x = 0; x < laby.getLaby().getLength()+1; x++) {
                    gc.drawImage(sprite.getImgSol(), (double) (x * TAILLE_JEU) / 2, (double) (y * TAILLE_JEU) / 2, (double) TAILLE_JEU / 2, (double) TAILLE_JEU / 2);
                }
            }

            // dessin monstre
            for (int i = 0; i < laby.getLaby().getNbMonstre(); i++) {
                Monstre m = laby.getLaby().getMonstre(i);
                double mx = m.getX();
                double my = m.getY();
                if (!laby.getLaby().getMonstre(i).etreMort()) {
                    gc.drawImage(sprite.getImgMonstre(), mx * TAILLE_JEU / 2, my * TAILLE_JEU / 2, TAILLE_JEU, TAILLE_JEU);
                } else {
                    gc.drawImage(sprite.getImgMonstreMort(), mx * TAILLE_JEU / 2, my * TAILLE_JEU / 2 + 10, TAILLE_JEU, TAILLE_JEU);
                }
            }

            //dessin case a effet
            for (CaseEffet c : laby.getLaby().getCasesEffet()) {
                if (c instanceof Feu) {
                    gc.drawImage(sprite.getImgFeu(), c.getX() * TAILLE_JEU / 2, c.getY() * TAILLE_JEU / 2 + 10, TAILLE_JEU, TAILLE_JEU);
                }
            }

            Position posA = laby.getLaby().getAmulette();
            if (posA!=null) {
                double pAx = posA.getX();
                double pAy = posA.getY();
                gc.drawImage(sprite.getImgAmulette(), pAx * TAILLE_JEU / 2, pAy * TAILLE_JEU / 2, TAILLE_JEU, TAILLE_JEU);
            }

            Perso p = laby.getLaby().getPerso();
            double px = p.getX();
            double py = p.getY();
            if (!laby.getLaby().getPerso().etreMort()) {
                gc.drawImage(sprite.getImgHeros(), px * TAILLE_JEU / 2, py * TAILLE_JEU / 2, TAILLE_JEU, TAILLE_JEU);
            } else {
                gc.drawImage(sprite.getImgMonstre(), px * TAILLE_JEU / 2, py * TAILLE_JEU / 2, TAILLE_JEU, TAILLE_JEU);
            }





            for (int y = 0; y < laby.getLaby().getLengthY(); y++) {
                // affiche la ligne
                for (int x = 0; x < laby.getLaby().getLength(); x++) {
                    if (laby.getLaby().getMur(x, y)) {
                        gc.drawImage(sprite.getImgMur(), (double) (x * TAILLE_JEU) / 2, (double) (y * TAILLE_JEU) / 2, TAILLE_JEU, TAILLE_JEU);
                    }
                }

            }
            //affichage de l'inventaire (nous l'avons mis en commentaire car il nuit au parcours du labyrinthe)
            for (int i = 0;i<laby.getLaby().getInventaire().length;i++){
                /*gc.setFill(Color.YELLOW);
                gc.setStroke(Color.ORANGE);
                gc.setLineWidth(10);
                gc.fillRect(i*canvas.getWidth()/laby.getLaby().getInventaire().length,canvas.getHeight()-canvas.getHeight()/5.5, canvas.getWidth()/laby.getLaby().getInventaire().length, canvas.getHeight()/6);
                gc.strokeRect(i*canvas.getWidth()/laby.getLaby().getInventaire().length,canvas.getHeight()-canvas.getHeight()/5.5, canvas.getWidth()/laby.getLaby().getInventaire().length, canvas.getHeight()/6);
                */if(laby.getLaby().getInventaire()[i] != null){
                    switch (laby.getLaby().getInventaire()[i]) {
                        case "amulette" : gc.drawImage(sprite.getImgAmulette(), i*canvas.getWidth()/laby.getLaby().getInventaire().length,canvas.getHeight()-canvas.getHeight()/5.5,canvas.getWidth()/laby.getLaby().getInventaire().length, canvas.getHeight()/6);
                    }
                }


            }
        } else {
            gc.clearRect(0, 0, canvas.getWidth(), canvas.getHeight());
            gc.setFill(Color.BLACK);
            gc.fillRect(0, 0, canvas.getWidth(), canvas.getHeight());

            gc.setFill(Color.RED);

            gc.setFont(new Font("Comic sans MS", 50));
            gc.fillText("GAME OVER", canvas.getWidth()/3 -50, canvas.getHeight()/2);
        }


    }

    /**
     * @return sprite
     */
    public Sprite getSprite() {return this.sprite;}

}
