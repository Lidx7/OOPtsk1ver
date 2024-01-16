public class GameLogic implements PlayableLogic{
    public boolean move(Position a, Position b) {
        if (b==null)return true;
        return false;
    }

    @Override
    public Piece getPieceAtPosition(Position position) {
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
