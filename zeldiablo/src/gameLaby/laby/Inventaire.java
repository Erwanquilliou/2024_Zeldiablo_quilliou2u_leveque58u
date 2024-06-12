package gameLaby.laby;

public class Inventaire {
    /**
     * liste de string correspondant aux items que le perso possede
     */
    String[] items;


    /**
     * constructeur
     */
    public Inventaire() {
        this.items = new String[]{null, null, null};
    }

    /**
     * getter d'inventaire
     * @return une liste de strings correspondants items du perso
     */
    public String[] getInventaire() {
        return this.items;
    }

    /**
     * permet d'ajouter un item a partir d'un String
     * @param item est un String correspondant à l'item à ajouter a l'inventaire du perso
     */
    public void ajouterItem(String item){
        int i = 0;
        while(this.items[i] != null){
            i++;
        }
        this.items[i] = item;
    }
}
