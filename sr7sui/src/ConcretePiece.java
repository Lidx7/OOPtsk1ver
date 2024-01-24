abstract class  ConcretePiece implements Piece{
    private Player owner;

    public ConcretePiece(Player d3 ){
        this.owner=d3;

    }


    public Player getOwner() {
        return this.owner;
    }


    public void setOwner(Player owner){
        this.owner = owner;
    }

    @Override
    public  String getType(){
        return "";
    }
}
