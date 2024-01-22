public class Pawn extends ConcretePiece{
    private int killcount;

    public Pawn(Player owner){
        super(owner);
        this.killcount=0;
    }

    public void kill(){
        this.killcount++;
    }
    public void cancelKill(){
        this.killcount--;
    }
    public int getKills(){
        return this.killcount;
    }

    @Override
    public String getType() {
        return "♟";
    }
}


