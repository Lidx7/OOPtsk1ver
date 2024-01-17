import java.lang.Math;
public class GameLogic implements PlayableLogic{//

    private ConcretePiece[][] boardPieces;
    private Position[][] boardPositions;
    private ConcretePlayer player1 = new ConcretePlayer(true);
    private ConcretePlayer player2 = new ConcretePlayer(false);
    private boolean turn = false; // true - player1, false - player2

    public GameLogic(){
        boardPieces = new ConcretePiece[11][11];
//        boardPositions = new Position[11][11];
    }

    public boolean move(Position a, Position b) {
        if (b==null) return true;
        if(isValid(a,b)) {
            a.set_position(b);
            turn = !turn;
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
    public ConcretePiece getPieceAtPosition(Position position) {
//        if (position==boardPositions[11][11]);
        return boardPieces[position.get_y()][position.get_x()];
    }

    @Override
    public Player getFirstPlayer() {
        return player1;
    }

    @Override
    public Player getSecondPlayer() {
        return player2;
    }

    @Override
    public boolean isGameFinished() {
        Position p4=new Position(0,0);
        Position p1=new Position(11,11);
        Position p2=new Position(0,11);
        Position p5=new Position(11,0);
        if (getPieceAtPosition(p4).getType().equals("king")){
            return true;}
        else if (getPieceAtPosition(p5).getType().equals("king"))return true;
        else if (getPieceAtPosition(p1).getType().equals("king"))return true;
        else if (getPieceAtPosition(p2).getType().equals("king"))return true;
        return false;
    }

    @Override
    public boolean isSecondPlayerTurn() {
        return !turn;
    }

    @Override
    public void reset() {
        boardPieces = new ConcretePiece[11][11];
        boardPositions = new Position[11][11];
        player1 = new ConcretePlayer(true);
        player2 = new ConcretePlayer(false);
        turn = false;
    }

    @Override
    public void undoLastMove() {

    }

    @Override
    public int getBoardSize() {
        return 11;
    }
}
