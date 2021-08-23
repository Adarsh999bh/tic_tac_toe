class Board{

    public char gameBoard[];

    Board(){
        this.gameBoard=new char[10];
    }
    
    public void initilizeBoardElements(){
        for(int i=1;i<10;i++){
            this.gameBoard[i]=" ".charAt(0);
        }
    }
}
public class TicTacToe{
    public static void main(String[] args) {
        System.out.println("welcome to tictactoe game");
        Board b=new Board();
        b.initilizeBoardElements();
    }
}