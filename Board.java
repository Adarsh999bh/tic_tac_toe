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
            this.gameBoard[i]="_".charAt(0);
        }
    }
    public void displayBoard(){
        System.out.println("\n\t"+this.gameBoard[1]+" "+this.gameBoard[2]+" "+this.gameBoard[3]);
        System.out.println("\t"+this.gameBoard[4]+" "+this.gameBoard[5]+" "+this.gameBoard[6]);
        System.out.println("\t"+this.gameBoard[7]+" "+this.gameBoard[8]+" "+this.gameBoard[9]);
        System.out.println("\n---------------------");
    }
}