public class ConcretePiece implements Piece{
    private Position position;

    private String type;
    private Player owner;

    public ConcretePiece(Position d2, Player d3){
        this.position=d2;
//        this.type = type;
        this.owner=d3;

    }

    public Player getOwner() {
        return this.owner;
    }
    public String getType() {
        return this.type;
    }

    public void setPosition(Position p1){
        this.position = p1;
    }
    public Position getPosition(){
        return this.position;
    }
}
