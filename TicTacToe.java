import java.util.Scanner;


public class TicTacToe{

    static Scanner sc=new Scanner(System.in);


    private static Player[] setPlayerAattributes(){


        Player[] p=new Player[2];
        //ask for user inputs
        System.out.print("Enter player name : ");
        String name=sc.nextLine();
        System.out.print("Enter player's choice X or O : ");
        char choice=sc.next().charAt(0);
        sc.nextLine();



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



    //find number of matches in string
    private static int findMatch(String s1,String s2){
        int noOfMatches=0;
        for(int i=0;i<s1.length();i++){
            for(int j=0;j<s2.length();j++){
                if(s1.charAt(i)==s2.charAt(j)){
                    noOfMatches+=1;
                    break;
                }
            }
        }
        return noOfMatches;
    }
    private static int winningPosition(Board b, Player computer){

        String[] winningCases=new String[]{"123","456","789","147","258","369","159","357"};
        int noOfMatches=0;

        for(int i=0;i<winningCases.length;i++){
            noOfMatches=findMatch(computer.allocatedIndices, winningCases[i]);
            if(noOfMatches==2){
                for(int j=0;j<3;j++){
                    int index= Character.getNumericValue(winningCases[i].charAt(j));
                    if(b.gameBoard[index]=='_')
                        return index;
                }
            }

        }
        return -1;

    }
    
    //function to find critical index
    private static int findCriticalIndex(Board b, Player user){
        
        //possible winnig patterns
        String[] winningCases=new String[]{"123","456","789","147","258","369","159","357"};

        int noOfMatches=0;

        /*
        
        iterate through all find number of matching chracters and check

        number of matches is equal to 2 if it  is 2 then user might be in the winning position 

        find the winning position and return the index
        
        */
        for(int i=0;i<winningCases.length;i++){
            noOfMatches=findMatch(user.allocatedIndices, winningCases[i]);
            if(noOfMatches==2){
                for(int j=0;j<3;j++){
                    int index= Character.getNumericValue(winningCases[i].charAt(j));
                    if(b.gameBoard[index]=='_')
                        return index;
                }
            }

        }

        /*
        if match is lessthan 2 user is not in winnig position so return index randomnly 
        
        which has benn not used already
        */

        while(true){
            int index=((int)(Math.random() * 9) + 1);
            if(b.gameBoard[index]=='_')
                return index;
        }
    }

    //function to check winner check for all possible winning patterns
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

    //function which staarts the game
    private static Player startPlaying(Player p1,Player p2,Board b){

        int i=2;
        //initiall i will be at 2 since we are discarding 0th index in the gameBoard array

        //checking who has won the toss
        if(p1.playerName.equals("Computer")){

            int index=((int)(Math.random() * 9) + 1);//setting index randomnly for first time
            b.gameBoard[index]=p1.playerChoosenLetter;
            p1.allocatedIndices+=""+index;

            System.out.println("Board after "+p1.playerName+" Played");
            b.displayBoard();
            int status=0;
            while(i<b.gameBoard.length){

                System.out.println("enter the location for input");

                index=sc.nextInt();

                //alternate code for automatic assign
                // while(true){
                //     index=((int)(Math.random() * 9) + 1);
                //     if(b.gameBoard[index]=='_')
                //         break;
                // }

                b.gameBoard[index]=p2.playerChoosenLetter;
                p2.allocatedIndices+=""+index;

                System.out.println("Board after "+p2.playerName+" Played");
                b.displayBoard();

                status=checkWinner(b);

                //checking if the Player has won the game or not
                if(status==1){
                    p2.playerWinningStatus=1;
                    p2.playerWinningStreak+=1;
                    return p2;
                }


                //index=findCriticalIndex(b, p2);
                index=winningPosition(b, p2);
                if(index==-1){
                    index=findCriticalIndex(b, p1);
                }
                b.gameBoard[index]=p1.playerChoosenLetter;
                p1.allocatedIndices+=""+index;


                //displaying details of board
                
                System.out.println("Board after "+p1.playerName+" Played");
                b.displayBoard();

                //checkiing winner
                status=checkWinner(b);
                if(status==1){
                    p1.playerWinningStatus=1;
                    p1.playerWinningStreak+=1;
                    return p1;
                }

                //incrementing since player 1 and player 2 made move in thw while loop 
                i+=2;
            }
            

            //return any player object if its a tie 
            return p1;//default return
        }


        else{

            System.out.println("enter the location for input");

            int index=sc.nextInt();

            //alternate code to set index
            // while(true){
            //     index=((int)(Math.random() * 9) + 1);
            //     if(b.gameBoard[index]=='_')
            //         break;
            // }

            b.gameBoard[index]=p1.playerChoosenLetter;

            p1.allocatedIndices+=""+index;
            System.out.println("Board after "+p1.playerName+" Played");
            b.displayBoard();
            int status=0;


            while(i<b.gameBoard.length){ 

                //finding critical index before making move
                //index=findCriticalIndex(b, p1);
                index=winningPosition(b, p2);
                if(index==-1){
                    index=findCriticalIndex(b, p1);
                }
                b.gameBoard[index]=p2.playerChoosenLetter;

                p2.allocatedIndices+=""+index;
                System.out.println("Board after "+p2.playerName+" Played");
                b.displayBoard();
                status=checkWinner(b);

                //checking winner
                if(status==1){
                    p2.playerWinningStatus=1;
                    p2.playerWinningStreak+=1;
                    return p2;
                }

                //for  user player
                System.out.println("enter the location for input");

                index=sc.nextInt();

                //alternate code
                // while(true){
                //     index=((int)(Math.random() * 9) + 1);
                //     if(b.gameBoard[index]=='_')
                //         break;
                // }
                b.gameBoard[index]=p1.playerChoosenLetter;

                p1.allocatedIndices+=""+index;
                System.out.println("Board after "+p1.playerName+" Played");
                b.displayBoard();
                
                //chcking winner
                status=checkWinner(b);
                if(status==1){
                    p1.playerWinningStatus=1;
                    p1.playerWinningStreak+=1;
                    return p1;
                }
                i+=2;
            }
        }

        //return any player object if its a tie
        return p1;//default return
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
        
        /*no need of reference p anymore set it to null
        so that it goes to garbege collector
        */
        p=null;

        //displaying details
        user.printPlayerDetails();
        computer.printPlayerDetails();
        boardObj.displayBoard();

        while(true){
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
                System.out.println("\nWant to play again.? (1 or 0)");
                //s=sc.nextLine();
                //toss=(int) (Math.floor(Math.random()*10)%2);
                int choice=sc.nextInt();
                if(choice==0){
                    System.exit(0);
                }
                else{

                    //new game Initilizations
                    System.out.println("New game");
                    boardObj.initilizeBoardElements();
                    boardObj.displayBoard();
                    user.playerWinningStatus=0;
                    computer.playerWinningStatus=0;
                    user.allocatedIndices="";
                    computer.allocatedIndices="";
                }
            }
            else{

                System.out.println("Oops.! its a tie");
                System.out.println("Want to play again.? (1 or 0)");

                //toss=(int) (Math.floor(Math.random()*10)%2);
                int choice=sc.nextInt();
                if(choice==0){
                    System.exit(0);
                }

                else{

                    System.out.println("New game");
                    boardObj.initilizeBoardElements();
                    boardObj.displayBoard();
                    user.playerWinningStatus=0;
                    computer.playerWinningStatus=0;
                    user.allocatedIndices="";
                    computer.allocatedIndices="";

                }
            }
        }
    }
}