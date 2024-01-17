public class ConcretePiece implements Piece{
    private Position position;
    private String type;
    private Player owner;

    public ConcretePiece(Position d2, Player d3, String type){
        this.position=d2;
        this.type = type;
        this.owner=d3;

    }

    public Position getPosition(){
        return this.position;
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
    public void setOwner(Player owner){
        this.owner = owner;
    }
    public void setType(String type){
        this.type = type;
    }
}
