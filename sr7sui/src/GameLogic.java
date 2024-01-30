import java.lang.Math;
import java.util.Comparator;
import java.util.Set;
import java.util.Stack;
import java.util.ArrayList;

public class GameLogic implements PlayableLogic {//

    private ConcretePiece[][] boardPieces;
    //  private Position[][] boardPositions;
    private ConcretePlayer player1 = new ConcretePlayer(true);
    private ConcretePlayer player2 = new ConcretePlayer(false);

    private  Stack<Integer> moves;
    private  Stack<Player> player;
    private  Stack<Integer> kills;
    private ArrayList<ConcretePiece> pieceList;

    private boolean turn = false; // true - player1, false - player2

    public GameLogic() {
        boardPieces = new ConcretePiece[11][11];
        moves=new Stack<Integer>();
        player=new Stack<Player>();
        kills=new Stack<Integer>();
        reset();
    }

    public boolean move(Position a, Position b) {
        if(isSecondPlayerTurn() == (boardPieces[a.get_y()][a.get_x()]).getOwner().isPlayerOne()){
            return false;
        }
        if (b == null) return true;
        if (isValid(a, b)) {
            moves.push(a.get_x());
            moves.push(a.get_y());
            moves.push(b.get_x());
            moves.push(b.get_y());
            player.push(boardPieces[a.get_y()][a.get_x()].getOwner());
            if (boardPieces[a.get_y()][a.get_x()].getarray().isEmpty()){
                boardPieces[a.get_y()][a.get_x()].add1(a);
            }
            boardPieces[a.get_y()][a.get_x()].add1(b);

//                System.out.println(a);

            if(b.get_x()-a.get_x()==0){
                boardPieces[a.get_y()][a.get_x()].setDistance(Math.abs(b.get_y()-a.get_y()));
            }
            if(b.get_y()-a.get_y()==0){
                boardPieces[a.get_y()][a.get_x()].setDistance(Math.abs(b.get_x()-a.get_x()));
            }//            System.out.println(boardPieces[a.get_y()][a.get_x()].getQueue().toString());

            boardPieces[b.get_y()][b.get_x()] = boardPieces[a.get_y()][a.get_x()];
            boardPieces[a.get_y()][a.get_x()] = null;

            turn = !turn;
            Player p1 = boardPieces[b.get_y()][b.get_x()].getOwner();
            if (boardPieces[b.get_y()][b.get_x()].getType().equals("♟")) {
                if ((b.get_x() <= 9)) {
                    if (!(boardPieces[b.get_y()][b.get_x() + 1] == null) && (boardPieces[b.get_y()][b.get_x() + 1].getType().equals("♟")) && !(boardPieces[b.get_y()][b.get_x() + 1].getOwner().equals(p1))) {
                        if ((b.get_x() + 2 <= 10) && !(boardPieces[b.get_y()][b.get_x() + 2] == null) && (boardPieces[b.get_y()][b.get_x() + 2].getOwner() == p1) && (boardPieces[b.get_y()][b.get_x() + 2].getType().equals("♟")) || (b.get_x() + 2 > 10)) {
                            boardPieces[b.get_y()][b.get_x() + 1] = null;
                            kills.push(b.get_x()+1);
                            kills.push(b.get_y());
                            boardPieces[b.get_y()][b.get_x()].kill();

                        }
                    }
                }
                if ((b.get_y() <= 9)) {
                    if (!(boardPieces[b.get_y() + 1][b.get_x()] == null) && (boardPieces[b.get_y() + 1][b.get_x()].getType().equals("♟")) && !(boardPieces[b.get_y() + 1][b.get_x()].getOwner().equals(p1))) {
                        if ((b.get_y() + 2 <= 10) && !(boardPieces[b.get_y() + 2][b.get_x()] == null) && (boardPieces[b.get_y() + 2][b.get_x()].getOwner() == p1) && (boardPieces[b.get_y() + 2][b.get_x()].getType().equals("♟")) || (b.get_y() + 2 > 10)) {
                            boardPieces[b.get_y() + 1][b.get_x()] = null;
                            kills.push(b.get_x());
                            kills.push(b.get_y()+1);
                            boardPieces[b.get_y()][b.get_x()].kill();
                        }
                    }
                }
                if ((b.get_y() >= 1)) {
                    if (!(boardPieces[b.get_y() - 1][b.get_x()] == null) && (boardPieces[b.get_y() - 1][b.get_x()].getType().equals("♟")) && !(boardPieces[b.get_y() - 1][b.get_x()].getOwner().equals(p1))) {
                        if ((b.get_y() - 2 >= 0) && !(boardPieces[b.get_y() - 2][b.get_x()] == null) && (boardPieces[b.get_y() - 2][b.get_x()].getOwner() == p1) && (boardPieces[b.get_y() - 2][b.get_x()].getType().equals("♟")) || (b.get_y() - 2 < 0)) {
                            boardPieces[b.get_y() - 1][b.get_x()] = null;
                            kills.push(b.get_x());
                            kills.push(b.get_y()-1);
                            boardPieces[b.get_y()][b.get_x()].kill();
                        }
                    }
                }
                if ((b.get_x() >= 1)) {
                    if (!(boardPieces[b.get_y()][b.get_x() - 1] == null) && (boardPieces[b.get_y()][b.get_x() - 1].getType().equals("♟")) && !(boardPieces[b.get_y()][b.get_x() - 1].getOwner().equals(p1))) {
                        if ((b.get_x() - 2 >= 0) && !(boardPieces[b.get_y()][b.get_x() - 2] == null) && (boardPieces[b.get_y()][b.get_x() - 2].getOwner() == p1) && (boardPieces[b.get_y()][b.get_x() - 2].getType().equals("♟")) || (b.get_x() - 2 < 0)) {
                            boardPieces[b.get_y()][b.get_x() - 1] = null;
                            kills.push(b.get_x()-1);
                            kills.push(b.get_y());
                            boardPieces[b.get_y()][b.get_x()].kill();
                        }
                    }
                }
                if ((b.get_x() >= 1) && !(boardPieces[b.get_y()][b.get_x() - 1] == null) && (boardPieces[b.get_y()][b.get_x() - 1].getType().equals("♔")) && !(boardPieces[b.get_y()][b.get_x() - 1].getOwner().equals(p1))) {
                    if ((b.get_x() - 2 >= 0) && !(boardPieces[b.get_y()][b.get_x() - 2] == null) && (boardPieces[b.get_y()][b.get_x() - 2].getOwner() == p1) && (boardPieces[b.get_y()][b.get_x() - 2].getType().equals("♟")) || (b.get_x() - 2 < 0)) {
                        if ((b.get_y() <= 9) && !(boardPieces[b.get_y() + 1][b.get_x() - 1] == null) && (boardPieces[b.get_y() + 1][b.get_x() - 1].getType().equals("♟")) && (boardPieces[b.get_y() + 1][b.get_x() - 1].getOwner().equals(p1)) || (b.get_y() + 1 > 10)) {
                            if ((b.get_y() >= 1) && !(boardPieces[b.get_y() - 1][b.get_x() - 1] == null) && (boardPieces[b.get_y() - 1][b.get_x() - 1].getType().equals("♟")) && (boardPieces[b.get_y() - 1][b.get_x() - 1].getOwner().equals(p1)) || (b.get_y() - 1 < 0)) {
                                boardPieces[b.get_y()][b.get_x() - 1] = null;
                                boardPieces[b.get_y()][b.get_x()].kill();
                            }
                        }
                    }
                }
//                if(boardPieces[b.get_y()][b.get_x()]){
                if ((b.get_x() <= 9) && !(boardPieces[b.get_y()][b.get_x() + 1] == null) && (boardPieces[b.get_y()][b.get_x() + 1].getType().equals("♔")) && !(boardPieces[b.get_y()][b.get_x() + 1].getOwner().equals(p1))) {
                    if ((b.get_x() + 2 <= 10) && !(boardPieces[b.get_y()][b.get_x() + 2] == null) && (boardPieces[b.get_y()][b.get_x() + 2].getOwner() == p1) && (boardPieces[b.get_y()][b.get_x() + 2].getType().equals("♟")) || (b.get_x() + 2 > 10)) {
                        if ((b.get_y() <= 9) && !(boardPieces[b.get_y() + 1][b.get_x() + 1] == null) && (boardPieces[b.get_y() + 1][b.get_x() + 1].getType().equals("♟")) && (boardPieces[b.get_y() + 1][b.get_x() + 1].getOwner().equals(p1)) || (b.get_y() + 1 > 10)) {
                            if ((b.get_y() >= 1) && !(boardPieces[b.get_y() - 1][b.get_x() + 1] == null) && (boardPieces[b.get_y() - 1][b.get_x() + 1].getType().equals("♟")) && (boardPieces[b.get_y() - 1][b.get_x() + 1].getOwner().equals(p1)) || (b.get_y() - 1 < 0)) {
                                boardPieces[b.get_y()][b.get_x() + 1] = null;
                                boardPieces[b.get_y()][b.get_x()].kill();
                            }
                        }
                    }
                }
                if ((b.get_y() <= 9) && !(boardPieces[b.get_y() + 1][b.get_x()] == null) && (boardPieces[b.get_y() + 1][b.get_x()].getType().equals("♔")) && !(boardPieces[b.get_y() + 1][b.get_x()].getOwner().equals(p1))) {
                    if ((b.get_y() + 2 <= 10) && !(boardPieces[b.get_y() + 2][b.get_x()] == null) && (boardPieces[b.get_y() + 2][b.get_x()].getOwner() == p1) && (boardPieces[b.get_y() + 2][b.get_x()].getType().equals("♟")) || (b.get_y() + 2 > 10)) {
                        if ((b.get_x() <= 9) && !(boardPieces[b.get_y() + 1][b.get_x() + 1] == null) && (boardPieces[b.get_y() + 1][b.get_x() + 1].getType().equals("♟")) && (boardPieces[b.get_y() + 1][b.get_x() + 1].getOwner().equals(p1)) || (b.get_x() + 1 > 10)) {
                            if ((b.get_x() >= 1) && !(boardPieces[b.get_y() + 1][b.get_x() - 1] == null) && (boardPieces[b.get_y() + 1][b.get_x() - 1].getType().equals("♟")) && (boardPieces[b.get_y() + 1][b.get_x() - 1].getOwner().equals(p1)) || (b.get_x() - 1 < 0)) {
                                boardPieces[b.get_y() + 1][b.get_x()] = null;
                                boardPieces[b.get_y()][b.get_x()].kill();
                            }
                        }
                    }
                }
                if ((b.get_y() >= 1) && !(boardPieces[b.get_y() - 1][b.get_x()] == null) && (boardPieces[b.get_y() - 1][b.get_x()].getType().equals("♔")) && !(boardPieces[b.get_y() - 1][b.get_x()].getOwner().equals(p1))) {
                    if ((b.get_y() - 2 >= 0) && !(boardPieces[b.get_y() - 2][b.get_x()] == null) && (boardPieces[b.get_y() - 2][b.get_x()].getOwner() == p1) && (boardPieces[b.get_y() - 2][b.get_x()].getType().equals("♟")) || (b.get_y() - 2 < 0)) {
                        if ((b.get_x() <= 9) && !(boardPieces[b.get_y() - 1][b.get_x() + 1] == null) && (boardPieces[b.get_y() - 1][b.get_x() + 1].getType().equals("♟")) && (boardPieces[b.get_y() - 1][b.get_x() + 1].getOwner().equals(p1)) || (b.get_x() + 1 > 10)) {
                            if ((b.get_x() >= 1) && !(boardPieces[b.get_y() - 1][b.get_x() - 1] == null) && (boardPieces[b.get_y() - 1][b.get_x() - 1].getType().equals("♟")) && (boardPieces[b.get_y() - 1][b.get_x() - 1].getOwner().equals(p1)) || (b.get_x() - 1 < 0)) {
                                boardPieces[b.get_y() - 1][b.get_x()] = null;
                                boardPieces[b.get_y()][b.get_x()].kill();
                            }
                        }
                    }
                }

            }
//                }
//            }
            boardPieces[a.get_y()][a.get_x()] = null;
            return true;


        }
        return false;
    }

    private boolean isValid(Position current, Position destination) {
        int crntX = current.get_x(), crntY = current.get_y();
        int destX = destination.get_x(), destY = destination.get_y();
        boolean validX = false, validY = false;

        if (boardPieces[current.get_y()][current.get_x()].getType() != "♔") {
            if ((destX == 10 && destY == 10) || (destX == 10 && destY == 0) || (destX == 0 && destY == 10) || (destX == 0 && destY == 0)) {
                return false;
            }
        }

        if (getPieceAtPosition(destination) != null) {
            return false;
        }
         if((crntX-destX==0)||(crntY-destY==0)){
             if(crntX-destX==0){
                 if(crntY>destY){
                     while(crntY-destY>0){
                         if(boardPieces[crntY-1][destX]!=null){
                             return false;
                         }
                         crntY--;
                     }
                 }
                 else {
                     while(crntY-destY<0){
                         if(boardPieces[crntY+1][destX]!=null){
                             return false;
                         }
                         crntY++;
                     }
                 }
             }
             else {
                 if(crntX>destX){
                     while(crntX-destX>0){
                         if(boardPieces[destY][crntX-1]!=null){

                             return false;
                         }
                         crntX--;
                     }
                 }
                 else {
                     while(crntX-destX<0){
                         if(boardPieces[destY][crntX+1]!=null){
                             return false;

                         }
                         crntX++;
                     }
                 }
             }
             return true;
         }
//        if (Math.abs(crntX - destX) != 0) {
//
//            validX = validWay(crntX, destX, crntY, destY);
//        }
//        if (Math.abs(crntY - destY) != 0) {
//
//            validY = validWay(crntX, destX, crntY, destY);
//        }
//            if ()

        return (validX && validY);
    }

    private boolean validWay(int crntX, int destX, int crntY, int destY) {

        boolean isRow = (destY == crntY);
        int min, max;
        if (isRow) {
            min = Math.min(crntX, destX);
            max = Math.max(crntX, destX);

            for (int i = min + 1; i < max; i++) {
                if (this.boardPieces[crntY][i] != null) {
                    return false;
                }
            }
        } else {
            min = Math.min(crntY, destY);
            max = Math.max(crntY, destY);

            for (int i = min + 1; i < max; i++) {
                if (this.boardPieces[i][crntX] != null) {
                    return false;
                }
            }
        }

        return true;
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
        Position[] edges = new Position[4];
        edges[0]  = new Position(0,0);
        edges[1] = new Position(10,10);
        edges[2] = new Position(0,10);
        edges[3] = new Position(10,0);
        for(int i=0 ; i<4; i++){
            if (getPieceAtPosition(edges[i]) != null){
                player1.win();
                System.out.println(player1.getWins());
                printg1();
                return true;}
            }


        boolean game1 = true;
        boolean game2 = true;
        boolean king =true;
        for (int i = 0; i <= 10; i++) {
            for (int j = 0; j <= 10; j++) {
                Position p8 = new Position(j, i);
                if ((getPieceAtPosition(p8)!=null)&&(getPieceAtPosition(p8).getOwner() == player1)) {
                    game1 = false;
                }
                if ((getPieceAtPosition(p8)!=null)&&(getPieceAtPosition(p8).getOwner() == player2)) {
                    game2 = false;
                }
                if((getPieceAtPosition(p8)!=null)&&(getPieceAtPosition(p8).getType().equals("♔"))){
                    king=false;

                }

            }
        }
        if (game1){
            printg1();
            System.out.println("3");

            player2.win();
        }
        if(game2){
            printg1();
            System.out.println("1");

            player1.win();
        }
        if (king){
            printg1();
            System.out.println("0");
            player2.win();
        }


        return (game1 || game2||king);

    }//anitamim

    @Override
    public boolean isSecondPlayerTurn() {
        return !turn;
    }

    @Override
    public void reset() {
        this.pieceList= new ArrayList<ConcretePiece>();
//        for(int i=0;i<10;i++){
//            for(int j=0; j<10; j++){
//                if((boardPieces[i][j]!=null)&&!(boardPieces[i][j].getQueue().isEmpty())){
//                    pieceSet.add(boardPieces[i][j]);
//                }
//            }
//        }
//        printResults();

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
    boardPieces[moves.pop()][moves.pop()]=null;
    boardPieces[moves.pop()][moves.pop()]= new Pawn(player.pop());

    if((!kills.isEmpty())){
        if ((player.pop().equals(player1))){
            System.out.println("vbfhbf");
            boardPieces[kills.pop()][kills.pop()]=new Pawn(player2);}
        if ((player.pop().equals(player2))){
            System.out.println("25363");
            boardPieces[kills.pop()][kills.pop()]=new Pawn(player1);}
    }
    }

    @Override
    public int getBoardSize() {
        return 11;
    }

    public void printResults(){

    }



//        System.out.println(23);
//        if(!(pieceSet.isEmpty())){
//            System.out  .println("34434");
//            pieceSet.stream().sorted(new comparebetween());}
//        System.out.println(pieceSet.toString());
////        for(int i=0; i<pieceSet.size(); i++){
////            System.out.println(pieceSet.stream().findFirst().get);
////        }

    Comparator<ConcretePiece> g1= new Comparator<ConcretePiece>() {
        @Override
        public int compare(ConcretePiece o1, ConcretePiece o2) {
            return Integer.compare(o2.getarray().size(),o1.getarray().size());
        }
    };

    public void printg1(){
        for(int k=0; k<11; k++){
            for(int j=0; j<11; j++){
                if(!(boardPieces[k][j]==null)){
                    if (!boardPieces[k][j].getarray().isEmpty()){
                    pieceList.add(boardPieces[k][j]);}
                }
            }
        }
        pieceList.sort(g1);
        int i=0;
        while(i<pieceList.size()){
            System.out.println(pieceList.get(i).getarray().toString());
            i++;
        }
    }
    }









