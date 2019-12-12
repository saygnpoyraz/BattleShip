import java.util.InputMismatchException;
import java.util.Scanner;

public class GameManager {
//    private Board board;
//    private ShipIterator player1Iterator;
//    private ShipIterator player2Iterator;
    int turn = 1;
    Player player1;
    Player player2;
    Player currentPlayer;
    int selectedShipIndex;
    Scanner scanner;


    public GameManager(){
        player1 = new Player(1);
        player2 = new Player(2);
        currentPlayer = player1;
        scanner = new Scanner(System.in);
    }

    public int getTurn(){
        return turn;
    }
    // public void createBoard(){
//        board = new Board();
//    }

    public boolean isGameOver(){
        boolean gameOver = false;
        if (player1.isGameOver()) {
            player2.gameWon();
            gameOver = true;
        }
        if (player2.isGameOver()){
            player1.gameWon();
            gameOver = true;
        }

        return gameOver;
    }

    public void getShipInput(){
        boolean checkInput = true;
        while(checkInput){
            currentPlayer.printShipMenu();
            System.out.println("Choose Your Ship To Get Action");
            try {
                selectedShipIndex = scanner.nextInt();
                if (selectedShipIndex < currentPlayer.getShipCount() && selectedShipIndex > -1)checkInput = false;
                else System.out.println("There is no ship in that index");
            }catch (InputMismatchException e){
                scanner = new Scanner(System.in);
                System.out.println("Invalid input please enter a number");
            }
        }
    }

    public void chooseAction(){
        char action;
        do {
            System.out.println("Choose Your Action\n a for Attack \n d for Defence");
            action = scanner.next().charAt(0);
        }while(!(action == 'a' || action == 'd'));

        if (action == 'a'){
            int x;
            int y;
            System.out.println("Enter The Position You Want To Attack ");
            System.out.print("X: ");
            x = scanner.nextInt();
            System.out.print("Y: ");
            y = scanner.nextInt();
            currentPlayer.getShip(selectedShipIndex).attack(returnEnemyPos(x,y));

        }
        if (action == 'd'){
            currentPlayer.getShip(selectedShipIndex).defence();
        }
    }

    public void switchTurn(){
        turn++;
        if (turn % 2 == 0) currentPlayer = player2;
        else currentPlayer = player1;
    }

    public void printBoard(){
        currentPlayer.printBoard();
    }


    public Position returnEnemyPos(int x,int y){
        if (currentPlayer.getId() == 1) return player2.getPosition(x,y);
        return player1.getPosition(x, y);
    }

//
//    public Board getBoard() {
//        return board;
//    }
//
//    public void setVariables(){
//        player1Iterator = board.getPlayer1Iterator();
//        player2Iterator = board.getPlayer2Iterator();
//    }

    public void printShips(){
        currentPlayer.printShipMenu();
    }

//    public void printPlayer1Ship(){
//        while(player1Iterator.hasNext()){
//            System.out.println(player1Iterator.getIndex() + ": " + player1Iterator.next().getName());
//        }
//        player1Iterator.reset();
//    }
//    public void printPlayer2Ship(){
//        while(player2Iterator.hasNext()){
//            System.out.println(player2Iterator.getIndex() + ": " + player2Iterator.next().getName());
//        }
//        player2Iterator.reset();
//    }


    public void updateShips()
    {
        if (turn % 2 == 0) player1.updateShips();
        else player2.updateShips();
    }


//    public int shipCount(int player){
//        if (player == 1) return player1Iterator.getShipStore().getSize();
//        return player2Iterator.getShipStore().getSize();
//
//    }
//
//    public void getPlayerShip(){
//
//    }

//
//    public Ship getPlayer1Ship(int index){
//        return player1Iterator.getShipStore().getCharAt(index);
//    }
//    public Ship getPlayer2Ship(int index){
//        return player2Iterator.getShipStore().getCharAt(index);
//    }

}
