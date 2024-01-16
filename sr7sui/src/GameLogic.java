import java.lang.Math;
public class GameLogic implements PlayableLogic{
    public boolean move(Position a, Position b) {
        if (b==null) return true;
        if(isValid(a,b)) {
            a.set_position(b);
            return true;
        }
        return false;
    }

    public boolean isValid(Position current, Position destination){
        int crntX = current.get_x(),           crntY = current.get_y();
        int destX = destination.get_x(),   destY = destination.get_y();
        boolean validX = false, validY = false;

        if((destX == 10 && destY == 10) || (destX == 10 && destY == 0) || (destX == 0 && destY == 10) ||(destX == 0 && destY == 0)){
            return false;
        }

        if(getPieceAtPosition(destination) != null){
            return false;
        }

        if(Math.abs(crntX - destX) != 0){
            validX = true;
        }
        else if(Math.abs(crntY - destY) != 0){
            validY = true;
        }

        return (validX || validY);
    }

    /*
    TODO: write a getPosition function in ConcretePiece class
            and/or write a getPiece function in Position class
     */

    @Override
    public Piece getPieceAtPosition(Position position) {
        if(position.get_position() != null) {
            return position.get_position();
        }
        return null;
    }

    @Override
    public Player getFirstPlayer() {
        return null;
    }

    @Override
    public Player getSecondPlayer() {
        return null;
    }

    @Override
    public boolean isGameFinished() {
        return false;
    }

    @Override
    public boolean isSecondPlayerTurn() {
        return false;
    }

    @Override
    public void reset() {

    }

    @Override
    public void undoLastMove() {

    }

    @Override
    public int getBoardSize() {
        return 11;
    }
}
