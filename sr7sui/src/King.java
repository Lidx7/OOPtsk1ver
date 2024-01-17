public class King extends ConcretePiece {
    private String type;

    public King(ConcretePiece cp){
        super(cp.getPosition(), cp.getOwner(), "King");
    }
    public King(Position position, Player owner){
        super(position, owner, "King");
    }

}
