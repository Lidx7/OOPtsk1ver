public class ConcretePiece implements Piece{
    private int x;
    private int y;
    private String unicode;
    private Player owner;


    public Player getOwner() {
        return this.owner;
    }
    public String getType() {
        return this.unicode;
    }

}
