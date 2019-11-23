public class GameManager {
    private static GameManager instance;
    private Board board;


    private GameManager(){

    }

    public static GameManager getInstance(){
        if(instance == null) instance = new GameManager();
        return instance;
    }

    public void createBoard(){
        board = new Board();
    }

    public void printBoard(){
        board.printBoard();
    }









}
