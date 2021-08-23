public class Board{
    //board attribute
    public char gameBoard[];

    //constructor declaring size of gameBoard (default 10)
    Board(){
        this.gameBoard=new char[10];
    }
    
    //function to initilize and set gameboard
    public void initilizeBoardElements(){
        for(int i=1;i<gameBoard.length;i++){
            this.gameBoard[i]=" ".charAt(0);
            System.out.println("haii");
        }
    }
}