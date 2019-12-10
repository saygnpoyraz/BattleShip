public class GameManager {
    private Board board;
    private ShipIterator player1Iterator;
    private ShipIterator player2Iterator;


    public GameManager(){

    }

    public void createBoard(){
        board = new Board();
    }

    public void printBoard(int player){

        board.printBoard(player);

    }


    public Board getBoard() {
        return board;
    }

    public void setVariables(){
        player1Iterator = board.getPlayer1Iterator();
        player2Iterator = board.getPlayer2Iterator();
    }

    public void printPlayer1Ship(){
        while(player1Iterator.hasNext()){
            System.out.println(player1Iterator.getIndex() + ": " + player1Iterator.next().getName());
        }
        player1Iterator.reset();
    }
    public void printPlayer2Ship(){
        while(player2Iterator.hasNext()){
            System.out.println(player2Iterator.getIndex() + ": " + player2Iterator.next().getName());
        }
        player2Iterator.reset();
    }

    public int isGameOver(){
        int result = 0;

        int player1ShipCount = player1Iterator.getShipStore().getSize();
        while(player1Iterator.hasNext()){
            if(player1Iterator.next().isDead()){
                player1ShipCount--;
            }
        }
        player1Iterator.reset();

        int player2ShipCount = player2Iterator.getShipStore().getSize();
        while(player2Iterator.hasNext()){
            if(player2Iterator.next().isDead()){
                System.out.println(player2Iterator.getIndex());
                player2ShipCount--;
            }
        }
        player2Iterator.reset();


        if (player1ShipCount == 0) result = 1;
        if (player2ShipCount == 0) result = 2;

        return result;
    }

    public void updateShips()
    {
        while(player1Iterator.hasNext()){
            if(player1Iterator.next().isDead()){
                player1Iterator.removeShip(player1Iterator.getIndex()-1);
            }
        }
        player1Iterator.reset();

        while(player2Iterator.hasNext()){
            if(player2Iterator.next().isDead()){
                player2Iterator.removeShip(player2Iterator.getIndex()-1);
            }
        }
        player2Iterator.reset();
    }


    public int shipCount(int player){
        if (player == 1) return player1Iterator.getShipStore().getSize();
        return player2Iterator.getShipStore().getSize();
    }

    public Ship getPlayer1Ship(int index){
        return player1Iterator.getShipStore().getCharAt(index);
    }
    public Ship getPlayer2Ship(int index){
        return player2Iterator.getShipStore().getCharAt(index);
    }

}
