public class Pawn extends ConcretePiece{
    private int killcount;
    //private Position concret;
    // String type;
    //private Player onwer;
    public Pawn(ConcretePiece cp){
        super(cp.getPosition(), cp.getOwner(), "Pawn");
        this.killcount=0;
    }
    public Pawn(Position position, Player owner){
        super(position, owner, "Pawn");
        this.killcount=0;
    }
    public void killed(){
        killcount++;
    }

}


