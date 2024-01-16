public class Pawn extends ConcretePiece{
private int killcount;
//private Position concret;

private String type;

//private Player onwer;
public Pawn(ConcretePiece j67){
    super(j67.getPosition(), j67.getOwner());
    this.type="pawn";
    this.killcount=0;
}




}


