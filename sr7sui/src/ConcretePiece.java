import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.Queue;

abstract class  ConcretePiece implements Piece{
    private Player owner;
    private int travel;
    private int kills;
    private ArrayList<Position> positions;
    private int  id ;
    private String idS;

     public void kill(){
        this.kills++;
    }
    public void setString(String h){
         this.idS=h;
    }
    public String getStirng(){
         return this.idS;
    }
    public int getKills(){
         return this.kills;
        }
    public void add1(Position p1 ){
         this.positions.add(p1);
    }
    public Position getPosition(int i){
         return positions.get(i);
    }
    public ArrayList getarray(){
         return this.positions;
    }
        public void plusdistance(){
        this.travel++;
    }
    public void setDistance(int x){
         this.travel=this.travel+x;
    }
    public int getDistance(){
        return this.travel;
    }
    public int getId(){
         return this.id;
    }
    public void setid(int  ID){
         this.id=ID;
    }

    public ConcretePiece(Player d3 ) {
        this.owner = d3;
        this.positions= new ArrayList<Position>();

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
