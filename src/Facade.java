public class Facade {

    private GameManager gameManager;
    private Board gameBoard;
    private ShipIterator player1Iterator;
    private ShipIterator player2Iterator;

    public void createGame(){
        gameManager = new GameManager();
        gameManager.createBoard();
        gameManager.printBoard();
        setVariables();
    }

    public void startGame(){

    }


    private void setVariables(){
        gameBoard = gameManager.getBoard();
        player1Iterator = gameBoard.getPlayer1Iterator();
        player2Iterator = gameBoard.getPlayer2Iterator();
    }






}
