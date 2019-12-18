public class Position {
    private int x;
    private int y;
    private Ship ship;


    public Position(int x,int y , Ship ship){
        this.x = x;
        this.y = y;
        this.ship = ship;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public Ship getShip() {
        return ship;
    }

    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }

    public void setShip(Ship ship) {
        this.ship = ship;
    }

    @Override
    public String toString() {
        return "[" + x + "," + y + "]";
    }
}
