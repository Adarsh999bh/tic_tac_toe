import java.util.Scanner;
public class TicTacToe{
    private static Player[] setPlayerAattributes(){
        Player[] p=new Player[2];
        //ask for user inputs
        Scanner sc=new Scanner(System.in);
        System.out.print("Enter player name : ");
        String name=sc.nextLine();
        System.out.println("Enter player's choice X or Y");
        char choice=sc.next().charAt(0);
        sc.close();

        // creating Player Object (one for real player and one for computer)
        p[0]=new Player(choice, name);
        if(choice=='X'){
            p[1]=new Player('O', "Computer");// if user has choosen x
        }
        else{
            p[1]=new Player('X', "Computer");// if user has choosen y
        }
        return p;
    }
    public static void main(String[] args) {
        //welcome message
        System.out.println("welcome to tictactoe game");

        //creating Board object
        Board boardObj=new Board();

        //initilizing board elements with space
        boardObj.initilizeBoardElements();
        Player user=null, computer=null;
        Player[] p=setPlayerAattributes();
        user=p[0];
        computer=p[1];
        p=null;
        user.printPlayerDetails();
        computer.printPlayerDetails();
        boardObj.displayBoard();
    }
}