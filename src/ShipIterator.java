import java.util.Iterator;

public class ShipIterator implements Iterator {
    private ShipStore shipStore;
    private int index;

    public ShipIterator(ShipStore shipStore){
        this.shipStore = shipStore;
        index = 0;
    }

    public void reset(){
        index = 0;
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
}
