public class Main {
    public static void main(String[] args){

        GameManager gameManager = new GameManager();
        gameManager.createBoard();
        gameManager.printBoard();

        while(gameManager.getBoard().getPlayer1Iterator().hasNext()){
            System.out.println(gameManager.getBoard().getPlayer1Iterator().next().getName());
        }


    }
}
