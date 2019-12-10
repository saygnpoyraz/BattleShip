import java.util.InputMismatchException;
import java.util.Scanner;

public class Facade {

    private GameManager gameManager;


    public void createGame(){
        gameManager = new GameManager();
        gameManager.createBoard();
    }

    public void startGame(){
        Scanner scanner = new Scanner(System.in);
        gameManager.setVariables();
        int turn = 1;
        while (gameManager.isGameOver() == 0){
            if (turn == 1){
                gameManager.printBoard(turn);
                int selectedShipIndex = 0;
                System.out.println("PLAYER 1 TURN");
                boolean checkInput = true;
                while(checkInput){
                    gameManager.printPlayer1Ship();
                    System.out.println("Choose Your Ship To Get Action");
                    try {
                        selectedShipIndex = scanner.nextInt();
                        if (selectedShipIndex < gameManager.shipCount(1) && selectedShipIndex > -1)checkInput = false;
                        else System.out.println("There is no ship in that index");
                    }catch (InputMismatchException e){
                        scanner = new Scanner(System.in);
                        System.out.println("Invalid input please enter a number");
                    }
                }
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
                    gameManager.getPlayer1Ship(selectedShipIndex).attack(gameManager.getBoard().getPosition(x,y,2));

                }
                if (action == 'd'){
                    gameManager.getPlayer1Ship(selectedShipIndex).defence();
                }
                gameManager.updateShips();
                turn = 2;
            }
            if (gameManager.isGameOver() == 1){
                System.out.println("PLAYER 2 WON!!!!");
                break;
            }
            else if (gameManager.isGameOver() == 2){
                System.out.println("PLAYER 1 WON!!!!");
                break;
            }


            System.out.println("*********************");
            if (turn == 2){
                gameManager.printBoard(2);
                int selectedShipIndex = 0;
                char action;
                System.out.println("PLAYER 2 TURN");
                boolean checkInput = true;
                while(checkInput){
                    gameManager.printPlayer2Ship();
                    System.out.println("Choose Your Ship To Get Action");
                    try {
                        selectedShipIndex = scanner.nextInt();
                        if (selectedShipIndex < gameManager.shipCount(2) && selectedShipIndex > -1)checkInput = false;
                        else System.out.println("There is no ship in that index");
                    }catch (InputMismatchException e){
                        scanner = new Scanner(System.in);
                        System.out.println("Invalid input please enter a number");
                    }
                }

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
                    gameManager.getPlayer2Ship(selectedShipIndex).attack(gameManager.getBoard().getPosition(x,y,1));

                }
                if (action == 'd'){
                    gameManager.getPlayer2Ship(selectedShipIndex).defence();
                }
                turn = 1;
                gameManager.updateShips();
            }
            System.out.println("*********************");
            if (gameManager.isGameOver() == 1){
                System.out.println("PLAYER 2 WON!!!!");
                break;
            }
            else if (gameManager.isGameOver() == 2){
                System.out.println("PLAYER 1 WON!!!!");
                break;
            }
        }
    }
}