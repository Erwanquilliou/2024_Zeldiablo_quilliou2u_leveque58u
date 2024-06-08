package gameLaby.laby;

public class Position {
    private int x;
    private int y;

    public Position(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX(){
        return this.x;
    }

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