import java.util.Queue;

public class ConcretePlayer implements Player{

    private boolean isAttacker;
    private int wins;


    public ConcretePlayer(boolean isAttacker){
        this.isAttacker = isAttacker;
        this.wins = 0;

    }

    public void win(){
        this.wins++;
    }

    @Override
    public boolean isPlayerOne() {
        return isAttacker;
    }

    @Override
    public int getWins() {
        return this.wins;
    }
}