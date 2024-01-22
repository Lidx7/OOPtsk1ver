import java.lang.Math;
public class GameLogic implements PlayableLogic{//

    private ConcretePiece[][] boardPieces;
  //  private Position[][] boardPositions;
    private ConcretePlayer player1 = new ConcretePlayer(true);
    private ConcretePlayer player2 = new ConcretePlayer(false);
    private boolean turn = false; // true - player1, false - player2

    public GameLogic(){
        boardPieces = new ConcretePiece[11][11];
        reset();
//        boardPositions = new Position[11][11];
    }

    public boolean move(Position a, Position b) {
        if (b==null) return true;
        if(isValid(a,b)) {
            boardPieces[b.get_y()][b.get_x()]=boardPieces[a.get_y()][a.get_x()];;
            boardPieces[a.get_y()][a.get_x()] = null;

            turn = !turn;
            return true;
        }
        return false;
    }

    public boolean isValid(Position current, Position destination){
        int crntX = current.get_x(),           crntY = current.get_y();
        int destX = destination.get_x(),   destY = destination.get_y();
        boolean validX = false, validY = false;

        if(boardPieces[current.get_y()][current.get_x()].getType() != "♔") {
            if ((destX == 10 && destY == 10) || (destX == 10 && destY == 0) || (destX == 0 && destY == 10) || (destX == 0 && destY == 0)) {
                return false;
            }
        }

        if(getPieceAtPosition(destination) != null){
            return false;
        }

        if(Math.abs(crntX - destX) != 0){
            validX = true;
        }
        if(Math.abs(crntY - destY) != 0){
            validY = true;
        }

        return (validX ^ validY);
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
        if (getPieceAtPosition(p4).getType().equals("♔")){
            return true;}
        else if (getPieceAtPosition(p5).getType().equals("♔"))return true;
        else if (getPieceAtPosition(p1).getType().equals("♔"))return true;
        else if (getPieceAtPosition(p2).getType().equals("♔"))return true;
        else if (getPieceAtPosition(p4).getType().equals("♔"))return true;

        boolean game=true;
        boolean game1=true;

        for(int i=0;i<=10;i++) {
            for (int j = 0; j <= 10; j++) {
                Position p8 = new Position(j, i);
                if (getPieceAtPosition(p8).getOwner() == player1) {
                    game = false;
                }
                if (getPieceAtPosition(p8).getOwner() == player2) {
                    game1 = false;
                }
            }
        }
        return game||game1;

    }//a//anitamimm

    @Override
    public boolean isSecondPlayerTurn() {
        return !turn;
    }

    @Override
    public void reset() {
        boardPieces = new ConcretePiece[11][11];
        player1 = new ConcretePlayer(true);
        player2 = new ConcretePlayer(false);
        turn = false;
        boardPieces [0][3] = new Pawn(player2);
        boardPieces [0][4] = new Pawn(player2);
        boardPieces [0][5] = new Pawn(player2);
        boardPieces [0][6] = new Pawn(player2);
        boardPieces [0][7] = new Pawn(player2);

        boardPieces [1][5] = new Pawn(player2);

        boardPieces [3][0] = new Pawn(player2);
        boardPieces [3][5] = new Pawn(player1);
        boardPieces [3][10] = new Pawn(player2);

        boardPieces [4][0] = new Pawn(player2);
        boardPieces [4][4] = new Pawn(player1);
        boardPieces [4][5] = new Pawn(player1);
        boardPieces [4][6] = new Pawn(player1);
        boardPieces [4][10] = new Pawn(player2);

        boardPieces [5][0] = new Pawn(player2);
        boardPieces [5][1] = new Pawn(player2);
        boardPieces [5][3] = new Pawn(player1);
        boardPieces [5][4] = new Pawn(player1);
        boardPieces [5][5] = new King(player1);
        boardPieces [5][6] = new Pawn(player1);
        boardPieces [5][7] = new Pawn(player1);
        boardPieces [5][9] = new Pawn(player2);
        boardPieces [5][10] = new Pawn(player2);
        boardPieces [6][0] = new Pawn(player2);
        boardPieces [6][4] = new Pawn(player1);
        boardPieces [6][5] = new Pawn(player1);
        boardPieces [6][6] = new Pawn(player1);
        boardPieces [6][10] = new Pawn(player2);

        boardPieces [7][0] = new Pawn(player2);
        boardPieces [7][5] = new Pawn(player1);
        boardPieces [7][10] = new Pawn(player2);

        boardPieces [9][5] = new Pawn(player2);

        boardPieces [10][3] = new Pawn(player2);
        boardPieces [10][4] = new Pawn(player2);
        boardPieces [10][5] = new Pawn(player2);
        boardPieces [10][6] = new Pawn(player2);
        boardPieces [10][7] = new Pawn(player2);

    }

    @Override
    public void undoLastMove() {

    }

    @Override
    public int getBoardSize() {
        return 11;
    }
}
