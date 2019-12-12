import java.util.InputMismatchException;
import java.util.Scanner;

public class GameManager {

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


    public void printShips(){
        currentPlayer.printShipMenu();
    }


    public void updateShips()
    {
        if (turn % 2 == 0) player1.updateShips();
        else player2.updateShips();
    }
}
