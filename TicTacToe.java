import java.util.Scanner;
public class TicTacToe{
    private static void setPlayerAattributes(Player user,Player computer){

        //ask for user inputs
        Scanner sc=new Scanner(System.in);
        System.out.print("Enter player name : ");
        String name=sc.nextLine();
        System.out.println("Enter player's choice X or Y");
        char choice=sc.next().charAt(0);
        sc.close();

        // creating Player Object (one for real player and one for computer)
        user=new Player(choice, name);
        if(choice=='X'){
            computer=new Player('O', "Computer");// if user has choosen x
        }
        else{
            computer=new Player('X', "Computer");// if user has choosen y
        }
    }
    public static void main(String[] args) {
        //welcome message
        System.out.println("welcome to tictactoe game");

        //creating Board object
        Board boardObj=new Board();

        //initilizing board elements with space
        boardObj.initilizeBoardElements();
        Player user=null, computer=null;
        setPlayerAattributes(user, computer);
        user.printPlayerDetails();
        computer.printPlayerDetails();
    }
}