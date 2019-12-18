import java.io.Console;

public class Player {
    private static final int BOARD_SIZE = 10;
    private int id;
    private ShipStore shipStore;
    private ShipIterator shipIterator;
    private Position[][] positions;

    private boolean isDefeated;


    public Player(int id){
        this.id = id;
        shipStore = new ShipStore();
        shipIterator = new ShipIterator(shipStore);
        isDefeated = false;
        createEmptyBoard();
        fillPlayerBoard();
    }

    private void createEmptyBoard(){
        positions = new Position[BOARD_SIZE][BOARD_SIZE];
        for (int x = 0 ; x < 10; x++){
            for(int y = 0 ; y < 10; y++){
                ShipFactory nullShipFactory = new NullShipFactory();
                positions[x][y] = new Position(x,y,nullShipFactory.produceShip());
            }
        }
    }

    public void gameWon(){
        System.out.println("PLAYER " + id + " WON!");
    }

    public boolean isGameOver(){
        int playerShipCount = shipIterator.getShipStore().getSize();
        while(shipIterator.hasNext()){
            if(shipIterator.next().isDead()){
                playerShipCount--;
            }
        }
        shipIterator.reset();
        if (playerShipCount == 0) {
            isDefeated = true;
            System.out.printf("GAME OVER");
        }
        return isDefeated;
    }

    public void updateShips()
    {
        while(shipIterator.hasNext()){
            if(shipIterator.next().isDead()){
                shipIterator.removeShip(shipIterator.getIndex()-1);
            }
        }
        shipIterator.reset();

    }
    public Ship getShip(int index){
        return shipStore.getCharAt(index);
    }

    public int getShipCount(){
        return shipStore.getSize();
    }

    public Position getPosition(int x,int y ){
        return positions[x][y];
    }

    public void printShipMenu(){
        while(shipIterator.hasNext()){
            System.out.print(shipIterator.getIndex());
            Ship ship = shipIterator.next();
            System.out.print(": " + ship.getName() + " HP: " + ship.getHealth() + " ARMOR: "  + ship.getArmor() + " POSITION: " );
            for (int i = 0; i< ship.getPositions().size(); i++){
                System.out.print(ship.getPositions().get(i));
            }
            System.out.println();
        }
        shipIterator.reset();
    }

    public int getId() {
        return id;
    }

    public void printBoard(){
        for (int x = 0 ; x < BOARD_SIZE; x++){
            for(int y = 0 ; y < BOARD_SIZE; y++){
                System.out.print(positions[x][y].getShip().returnType() + " ");
            }
            System.out.println();
        }
    }

    private void fillPlayerBoard(){
        ShipFactory bombShipFactory = new BombShipFactory();
        ShipFactory machineGunShipFactory = new MachineGunShipFactory();
        ShipFactory sandalFactory = new SandalFactory();

        BombShip bombShip = (BombShip)bombShipFactory.produceShip();
        shipStore.addShips(bombShip);
        for (int i = 3;  i < 8; i++){
            Position position = new Position(i,2, bombShip);
            bombShip.addPosition(position);
            positions[i][2] = position;
        }

        Sandal sandal = (Sandal) sandalFactory.produceShip();
        shipStore.addShips(sandal);
        for (int i = 5;  i < 7; i++){
            Position position = new Position(2,i, sandal);
            sandal.addPosition(position);
            positions[2][i] = position;
        }

        MachineGunShip machineGunShip = (MachineGunShip) machineGunShipFactory.produceShip();
        shipStore.addShips(machineGunShip);
        for (int i = 3;  i < 6; i++){
            Position position = new Position(i,9, machineGunShip);
            machineGunShip.addPosition(position);
            positions[i][9] = position;
        }
        Position position = new Position(4,8, machineGunShip);
        machineGunShip.addPosition(position);
        positions[4][8] = position;

        MachineGunShip machineGunShip2 = (MachineGunShip) machineGunShipFactory.produceShip();
        shipStore.addShips(machineGunShip2);
        for (int i = 7;  i < 10; i++){
            Position position1 = new Position(i,6, machineGunShip2);
            machineGunShip2.addPosition(position1);
            positions[i][6] = position1;
        }
        Position position1 = new Position(8,5, machineGunShip2);
        machineGunShip2.addPosition(position1);
        positions[8][5] = position1;


        Sandal sandal2 = (Sandal) sandalFactory.produceShip();
        shipStore.addShips(sandal2);
        for (int i = 7;  i < 9; i++){
            Position position2 = new Position(i,9, sandal2);
            sandal2.addPosition(position2);
            positions[i][9] = position2;
        }
    }


}
