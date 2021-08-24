import java.util.Scanner;

import javax.swing.text.Style;

public class TicTacToe{
    private static Player[] setPlayerAattributes(){
        Player[] p=new Player[2];
        //ask for user inputs
        Scanner sc=new Scanner(System.in);
        System.out.print("Enter player name : ");
        String name=sc.nextLine();
        System.out.println("Enter player's choice X or O");
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
    private static int findCriticalIndex(Board b,String allocatedIndexes, Player user){
        
        return 0;
    }
    private static int checkWinner(Board b){
        if(b.gameBoard[1]==b.gameBoard[2] && b.gameBoard[2]==b.gameBoard[3] && b.gameBoard[1]!='_' && b.gameBoard[2]!='_' && b.gameBoard[3]!='_'){
            return 1;
        }
        else if(b.gameBoard[4]==b.gameBoard[5] && b.gameBoard[5]==b.gameBoard[6] && b.gameBoard[4]!='_' && b.gameBoard[5]!='_' && b.gameBoard[6]!='_'){
            return 1;
        }
        else if(b.gameBoard[7]==b.gameBoard[8] && b.gameBoard[8]==b.gameBoard[9] && b.gameBoard[7]!='_' && b.gameBoard[8]!='_' && b.gameBoard[9]!='_'){
            return 1;
        }
        else if(b.gameBoard[1]==b.gameBoard[4] && b.gameBoard[4]==b.gameBoard[7] && b.gameBoard[1]!='_' && b.gameBoard[4]!='_' && b.gameBoard[7]!='_'){
            return 1;
        }
        else if(b.gameBoard[2]==b.gameBoard[5] && b.gameBoard[5]==b.gameBoard[8] && b.gameBoard[2]!='_' && b.gameBoard[5]!='_' && b.gameBoard[8]!='_'){
            return 1;
        }
        else if(b.gameBoard[3]==b.gameBoard[6] && b.gameBoard[6]==b.gameBoard[9] && b.gameBoard[3]!='_' && b.gameBoard[6]!='_' && b.gameBoard[9]!='_'){
            return 1;
        }
        else if(b.gameBoard[1]==b.gameBoard[5] && b.gameBoard[5]==b.gameBoard[9] && b.gameBoard[1]!='_' && b.gameBoard[5]!='_' && b.gameBoard[9]!='_'){
            return 1;
        }
        else if(b.gameBoard[3]==b.gameBoard[5] && b.gameBoard[5]==b.gameBoard[7] && b.gameBoard[3]!='_' && b.gameBoard[5]!='_' && b.gameBoard[7]!='_'){
            return 1;
        }
        else{
            return 0;
        }
    }
    private static Player startPlaying(Player p1,Player p2,Board b){
        int i=1;
        Scanner sc=new Scanner(System.in);
        if(p1.playerName.equals("Computer")){
            int index=((int)(Math.random() * 9) + 1);
            b.gameBoard[index]=p1.playerChoosenLetter;
            String allocatedIndexes=""+index;
            System.out.println("Board after "+p1.playerName+" Played");
            b.displayBoard();
            int status=0;
            while(i<b.gameBoard.length){
                System.out.println("enter the location for input");
                index=sc.nextInt();
                b.gameBoard[index]=p2.playerChoosenLetter;
                allocatedIndexes+=""+index;
                System.out.println("Board after "+p2.playerName+" Played");
                b.displayBoard();
                status=checkWinner(b);
                if(status==1){
                    p2.playerWinningStatus=1;
                    p2.playerWinningStreak+=1;
                    return p2;
                }
                index=findCriticalIndex(b,allocatedIndexes,p2);
                b.gameBoard[index]=p1.playerChoosenLetter;
                allocatedIndexes+=""+index;
                System.out.println("Board after "+p1.playerName+" Played");
                b.displayBoard();
                status=checkWinner(b);
                if(status==1){
                    p1.playerWinningStatus=1;
                    p1.playerWinningStreak+=1;
                    return p1;
                }
                i+=2;
            }
            return p1;//default return
        }
        else{
            System.out.println("enter the location for input");
            int index=sc.nextInt();
            b.gameBoard[index]=p1.playerChoosenLetter;
            String allocatedIndexes=""+index;
            System.out.println("Board after "+p1.playerName+" Played");
            b.displayBoard();
            int status=0;
            while(i<b.gameBoard.length){ 
                index=findCriticalIndex(b,allocatedIndexes,p1);
                b.gameBoard[index]=p2.playerChoosenLetter;
                allocatedIndexes+=""+index;
                System.out.println("Board after "+p2.playerName+" Played");
                b.displayBoard();
                status=checkWinner(b);
                if(status==1){
                    p2.playerWinningStatus=1;
                    p2.playerWinningStreak+=1
                    return p2;
                }
                System.out.println("enter the location for input");
                index=sc.nextInt();
                b.gameBoard[index]=p1.playerChoosenLetter;
                allocatedIndexes+=""+index;
                System.out.println("Board after "+p1.playerName+" Played");
                b.displayBoard();
                status=checkWinner(b);
                if(status==1){
                    p1.playerWinningStatus=1;
                    p1.playerWinningStreak+=1;
                    return p1;
                }
                i+=2;
            }
            return p1;//default return
        }
    }
    public static void main(String[] args) {
        //welcome message
        System.out.println("welcome to tictactoe game");

        //creating Board object
        Board boardObj=new Board();
        Player winner;

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
        Scanner sc = new Scanner(System.in);
        String s="yes";
        while("yes".equals(s)){
            //tossing
            int toss=(int) (Math.floor(Math.random()*10)%2);
            if(toss==0){
                //then user move first
                winner=startPlaying(user,computer,boardObj);
            }
            else{
                //then computer move first
                winner=startPlaying(computer,user,boardObj);
            }
            if(winner.playerWinningStatus==1){
                System.out.println(winner.playerName+" has won the game");
                //displaying winning streak
                System.out.println("Winning Stats");
                System.out.println(user.playerName+" : "+user.playerWinningStreak);
                System.out.println(computer.playerName+" : "+computer.playerWinningStreak);
                System.out.println("\nWant to play again.? (yes or no)");
                s=sc.nextLine();
                if(s.equals("no")){
                    System.exit(0);
                }
                else{
                    System.out.println("New game");
                    boardObj.initilizeBoardElements();
                    user.playerWinningStatus=0;
                    computer.playerWinningStatus=0;
                }
            }
            else{
                System.out.println("Oops.! its a tie");
                System.out.println("Want to play again.? (yes or no)");
                s=sc.nextLine();
                if(s.equals("no")){
                    sc.close();
                    System.exit(0);
                }
                else{
                    System.out.println("New game");
                    boardObj.initilizeBoardElements();
                    user.playerWinningStatus=0;
                    computer.playerWinningStatus=0;
                }
            }
        }
    }
}