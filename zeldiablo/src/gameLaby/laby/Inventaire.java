package gameLaby.laby;

public class Inventaire {
    String[] items;


    public Inventaire() {
        this.items = new String[]{null, null, null};
    }
    public String[] getInventaire() {
        return this.items;
    }

    public void ajouterItem(String item){
        int i = 0;
        while(this.items[i] != null){
            i++;
        }
        this.items[i] = item;
    }
}
