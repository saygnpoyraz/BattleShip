import java.util.Iterator;

public class ShipIterator implements Iterator {
    private ShipStore shipStore;
    private int index;

    public ShipIterator(ShipStore shipStore){
        this.shipStore = shipStore;
        index = 0;
    }

    public ShipStore getShipStore() {
        return shipStore;
    }

    public void reset(){
        index = 0;
    }

    public int getIndex() {
        return index;
    }

    @Override
    public boolean hasNext() {
        return shipStore.getSize() > index;
    }

    @Override
    public Ship next() {
        Ship ship = shipStore.getCharAt(this.index);
        index++;
        return ship;
    }

    public void removeShip(int index){
        shipStore.getShips().remove(index);
    }
}
