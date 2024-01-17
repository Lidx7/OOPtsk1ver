public class King extends ConcretePiece {
    private String type;

    public King(ConcretePiece j67) {
        super(j67.getPosition(), j67.getOwner());
        this.type = "king";


    }

}