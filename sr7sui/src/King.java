public class King extends ConcretePiece {
    private String type;


    public King( Player owner)
    {
        super (owner);
    }

//    @Override
    public String getType() {
        return "♔";
    }
}
