public class GameManager {
    private Board board;


    public GameManager(){

    }

    public void createBoard(){
        board = new Board();
    }

    public void printBoard(){
        board.printBoard();
    }


    public Board getBoard() {
        return board;
    }
}
