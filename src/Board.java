import javafx.geometry.Pos;

public class Board {

//    private Player player1;
//    private Player player2;

   // private Position[][] player1;
//    private Position[][] player2;
//    private ShipStore player1Ships = new ShipStore();
//    private ShipStore player2Ships = new ShipStore();
//    private ShipIterator player1Iterator = new ShipIterator(player1Ships);
//    private ShipIterator player2Iterator = new ShipIterator(player2Ships);


    public Board(){
//        player1 = new Player();
//        player2 = new Player();
//        createEmptyBoard();
//        fillPlayerBoard(player1 , player1Ships);
//        fillPlayerBoard(player2 , player2Ships);
    }


//
//    private void createEmptyBoard(){
//        player1 = new Position[10][10];
//        player2 = new Position[10][10];
//        for (int x = 0 ; x < 10; x++){
//            for(int y = 0 ; y < 10; y++){
//                ShipFactory nullShipFactory = new NullShipFactory();
//                player1[x][y] = new Position(x,y,nullShipFactory.produceShip());
//                player2[x][y] = new Position(x,y,nullShipFactory.produceShip());
//            }
//        }
//    }
//
//    public Position getPosition(int x,int y , int turn){
//        if (turn == 1) return player1[x][y];
//        return player2[x][y];
//    }
//
//    private void fillPlayerBoard(Position[][] player , ShipStore shipStore ){
//        ShipFactory bombShipFactory = new BombShipFactory();
//        ShipFactory machineGunShipFactory = new MachineGunShipFactory();
//        ShipFactory sandalFactory = new SandalFactory();
//
//        BombShip bombShip =(BombShip)bombShipFactory.produceShip();
//        shipStore.addShips(bombShip);
//        for (int i = 3;  i < 8; i++){
//            Position position = new Position(i,2, bombShip);
//            bombShip.addPosition(position);
//            player[i][2] = position;
//        }
//
//        Sandal sandal =(Sandal) sandalFactory.produceShip();
//        shipStore.addShips(sandal);
//        for (int i = 5;  i < 7; i++){
//            Position position = new Position(2,i, sandal);
//            sandal.addPosition(position);
//            player[2][i] = position;
//        }
//
//        MachineGunShip machineGunShip =(MachineGunShip) machineGunShipFactory.produceShip();
//        shipStore.addShips(machineGunShip);
//        for (int i = 3;  i < 6; i++){
//            Position position = new Position(i,9, machineGunShip);
//            machineGunShip.addPosition(position);
//            player[i][9] = position;
//        }
//        Position position =new Position(4,8, machineGunShip);
//        machineGunShip.addPosition(position);
//        player[4][8] = position;
//
//        MachineGunShip machineGunShip2 =(MachineGunShip) machineGunShipFactory.produceShip();
//        shipStore.addShips(machineGunShip2);
//        for (int i = 7;  i < 10; i++){
//            Position position1 =new Position(i,6, machineGunShip2);
//            machineGunShip2.addPosition(position1);
//            player[i][6] = position1;
//        }
//        Position position1 = new Position(8,5, machineGunShip2);
//        machineGunShip2.addPosition(position1);
//        player[8][5] = position1;
//
//
//        Sandal sandal2 =(Sandal) sandalFactory.produceShip();
//        shipStore.addShips(sandal2);
//        for (int i = 7;  i < 9; i++){
//            Position position2 = new Position(i,9, sandal2);
//            sandal2.addPosition(position2);
//            player[i][9] = position2;
//        }
//    }
//
//    public void printBoard(int player){
//
//        if (player == 1){
//            for (int x = 0 ; x < 10; x++){
//                for(int y = 0 ; y < 10; y++){
//                    System.out.print(returnType(player1[x][y].getShip()) + " ");
//                }
//                System.out.println();
//            }
//        }
//        if (player == 2){
//            for (int x = 0 ; x < 10; x++){
//                for(int y = 0 ; y < 10; y++){
//                    System.out.print(returnType(player2[x][y].getShip())+ " ");
//                }
//                System.out.println();
//            }
//        }
//
//    }
//
//
//    private String returnType(Ship ship){
//        String result = "";
//
//        if (ship instanceof NullShip){
//            result = "x";
//        }
//        if (ship instanceof Sandal){
//            result = "S";
//        }
//        if (ship instanceof BombShip){
//            result = "B";
//        }
//        if (ship instanceof MachineGunShip){
//            result = "M";
//        }
//
//        return result;
//
//    }
//
//
//    public ShipIterator getPlayer1Iterator() {
//        return player1Iterator;
//    }
//
//    public ShipIterator getPlayer2Iterator() {
//        return player2Iterator;
//    }
}
