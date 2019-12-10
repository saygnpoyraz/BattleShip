import java.util.ArrayList;
import java.util.Iterator;

public class ShipStore implements Iterable {

    private ArrayList<Ship> ships = new ArrayList<>();


    public int getSize(){
        return ships.size();
    }

    public Ship getCharAt(int index){
        return ships.get(index);
    }

    public void addShips(Ship ship){
        ships.add(ship);
    }


    public ArrayList<Ship> getShips() {
        return ships;
    }

    @Override
    public Iterator iterator() {
        return new ShipIterator(this);
    }
}
