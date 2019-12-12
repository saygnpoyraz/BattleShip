import java.util.InputMismatchException;
import java.util.Scanner;

public class Facade {

    private GameManager gameManager;


    public void createGame(){
        gameManager = new GameManager();
    }

    public void startGame(){
        while (!gameManager.isGameOver()){
            System.out.println("PLAYER " + (gameManager.currentPlayer.getId()));
            gameManager.printBoard();
            gameManager.getShipInput();
            gameManager.chooseAction();
            gameManager.updateShips();
            gameManager.switchTurn();
        }
    }
}