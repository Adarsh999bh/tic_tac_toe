

public class Player{

    public char playerChoosenLetter;// X or O
    public String playerName;// name of the player
    public int playerWinningStatus;// 0(lost) 1(won)
    public int playerWinningStreak;
    public String allocatedIndices;

    //constructor
    Player(char playerChoosenLetter,String playerName){
        this.playerChoosenLetter=playerChoosenLetter;
        this.playerName=playerName;
        this.playerWinningStreak=0;
        this.playerWinningStatus=0;
        this.allocatedIndices="";
    }
    public void printPlayerDetails(){
        System.out.println(playerName+" has choosen letter "+playerChoosenLetter);
    }
}