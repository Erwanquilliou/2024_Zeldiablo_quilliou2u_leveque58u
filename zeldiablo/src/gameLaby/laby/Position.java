package gameLaby.laby;

public class Position {
    private int x;
    private int y;

    public Position(int dx,int dy){
        this.x = dx;
        this.y = dy;
    }
    /**
     * @return position x du personnage
     */
    public int getX(){
        return this.x;
    }

    /**
     * @return position y du personnage
     */
    public int getY(){
        return this.y;
    }

    public void setX(int dx){
        this.x = dx;
    }

    public void setY(int dy){
        this.y = dy;
    }
}
