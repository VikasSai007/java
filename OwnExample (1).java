public class OwnExample{
	public static void main(String[] args) {
	    MultiPlayer multiplayer = new MultiPlayer();
	    multiplayer.play();
	    multiplayer.sitting();
	    multiplayer.switchingOnConsole();
	    multiplayer.gatherSquad();
	}
    
}
//1
interface Games
{
    void play();
}
//2 IndoorGames
abstract class InDoorGames implements Games{
   abstract void sitting(); 
}

//3 VIDEOGAME

abstract class VideoGames extends InDoorGames{
    abstract void switchingOnConsole();
}
//4
class MultiPlayer extends VideoGames{
    
    public void play(){
        System.out.println("Playing Multiplayer game");
    }
    void sitting(){
        System.out.println("Playing Multiplayer game while in sitting position");
    }
    void switchingOnConsole(){
        System.out.println("Switching on Console for playing Multiplayer game");
    }
    void gatherSquad(){
        System.out.println("Gather Squad for multiplayer game");
    }
}
//4
class SinglePlayer extends VideoGames{
     public void play(){
        System.out.println("Playing Single Player game");
    }
    void sitting(){
        System.out.println("Playing Single Player while in sitting positon");
    }
    void switchingOnConsole(){
        System.out.println("Switching on Console for playing Single Player game");
    }
    void startGame(){
        System.out.println("Staring single player game");
    }
}

abstract class BoardGames extends InDoorGames{
    abstract void settingUpBoard();
}

class StrategyGames extends BoardGames{
    public void play(){
        System.out.println("Playing Strategy Games");
    }
    void sitting(){
        System.out.println("Playing Strategy Games while in sitting positon");
    }
    void settingUpBoard(){
        System.out.println("Setting up board for Strategy Games");
    }
    void makingStrategy(){
        System.out.println("Making Strategy for Board games");
    }
}

class DiceGames extends BoardGames{
    public void play(){
        System.out.println("Playing Dice Games");
    }
    void sitting(){
        System.out.println("Playing Dice Games while in sitting position");
    }
    void settingUpBoard(){
        System.out.println("Setting up board for Dice Games");
    }
    void rollingDice(){
        System.out.println("Rolling dice");
    }
}

abstract class OutDoorGames implements Games{
    abstract void standing();
}

abstract class TeamGames extends OutDoorGames{
    abstract void gatherTeam();
}

class Cricket extends TeamGames{
    public void play(){
        System.out.println("Playing cricket ");
    }
    
    void standing(){
        System.out.println("Playing cricket while in standing position ");
    }
    
    void gatherTeam(){
        System.out.println("Gathering Team for Playing cricket");
    }
    void hittingSix(){
        System.out.println("Hitting six....");
    }
}

class FootBall extends TeamGames{
    public void play(){
        System.out.println("Playing FootBall ");
    }
    
    void standing(){
        System.out.println("Playing FootBall while in standing position ");
    }
    
    void gatherTeam(){
        System.out.println("Gathering Team for Playing FootBall");
    }
    void scoringGoal(){
        System.out.println("Scoring a Goal....");
    }
}

abstract class IndividualGames extends OutDoorGames {
    abstract void gearingUp();
}

class Golf extends IndividualGames{
    public void play(){
        System.out.println("Playing Golf ");
    }
    
    void standing(){
        System.out.println("Playing Golf while in standing position ");
    }
    void gearingUp(){
        System.out.println("Gearing up for playing Golf");
    }
    void hittingInAimPoint(){
        System.out.println("Hitting in Aim Point....");
    }
}

class BadmintonSingles extends IndividualGames{
    public void play(){
        System.out.println("Playing Badminton Singles  ");
    }
    
    void standing(){
        System.out.println("Playing Badminton Singles while in standing position ");
    }
    void gearingUp(){
        System.out.println("Gearing up for playing Badminton Singles");
    }
    void hittingSmash(){
        System.out.println("Hitting in Smash....");
    }
}