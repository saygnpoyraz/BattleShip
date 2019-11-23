public class Board {

    Position[][] player1;
    Position[][] player2;

    public Board(){
        createEmptyBoard();
        fillPlayerBoard(player1);
        fillPlayerBoard(player2);
    }

    private void createEmptyBoard(){
        player1 = new Position[10][10];
        player2 = new Position[10][10];
        for (int x = 0 ; x < 10; x++){
            for(int y = 0 ; y < 10; y++){
                ShipFactory nullShipFactory = new NullShipFactory();
                player1[x][y] = new Position(x,y,nullShipFactory.produceShip());
                player2[x][y] = new Position(x,y,nullShipFactory.produceShip());
            }
        }
    }

    private void fillPlayerBoard(Position[][] player1){
        ShipFactory bombShipFactory = new BombShipFactory();
        ShipFactory machineGunShipFactory = new MachineGunShipFactory();
        ShipFactory sandalFactory = new SandalFactory();

        BombShip bombShip =(BombShip)bombShipFactory.produceShip();
        for (int i = 3;  i < 8; i++){
            player1[i][2] = new Position(i,2, bombShip);
        }

        Sandal sandal =(Sandal) sandalFactory.produceShip();
        for (int i = 5;  i < 7; i++){
            player1[2][i] = new Position(2,i, sandal);
        }

        MachineGunShip machineGunShip =(MachineGunShip) machineGunShipFactory.produceShip();
        for (int i = 3;  i < 6; i++){
            player1[i][9] = new Position(i,9, machineGunShip);
        }
        player1[4][8] = new Position(4,8, machineGunShip);

        MachineGunShip machineGunShip2 =(MachineGunShip) machineGunShipFactory.produceShip();
        for (int i = 7;  i < 10; i++){
            player1[i][6] = new Position(i,6, machineGunShip2);
        }
        player1[8][5] = new Position(8,5, machineGunShip2);


        Sandal sandal2 =(Sandal) sandalFactory.produceShip();
        for (int i = 7;  i < 9; i++){
            player1[i][9] = new Position(i,9, sandal2);
        }
    }

    public void printBoard(){
        for (int x = 0 ; x < 10; x++){
            for(int y = 0 ; y < 10; y++){
                System.out.print(returnType(player1[x][y].getShip()) + " ");
            }
            System.out.println();
        }
        System.out.println("-------------------");
        for (int x = 0 ; x < 10; x++){
            for(int y = 0 ; y < 10; y++){
                System.out.print(returnType(player2[x][y].getShip())+ " ");
            }
            System.out.println();
        }
    }


    private String returnType(Ship ship){
        String result = "";

        if (ship instanceof NullShip){
            result = "x";
        }
        if (ship instanceof Sandal){
            result = "S";
        }
        if (ship instanceof BombShip){
            result = "B";
        }
        if (ship instanceof MachineGunShip){
            result = "M";
        }

        return result;



    }




}
