import java.security.PublicKey;

public class Player{

    public char playerChoosenLetter;// X or O
    public String playerName;// name of the player
    public int playerWinningStatus;// 0(lost) 1(won)

    //constructor
    Player(char playerChoosenLetter,String playerName){
        this.playerChoosenLetter=playerChoosenLetter;
        this.playerName=playerName;
        this.playerWinningStatus=0;
    }
    public void printPlayerDetails(){
        System.out.println(playerName+" has choosen letter "+playerChoosenLetter);
    }
}