import java.util.Queue;

abstract class  ConcretePiece implements Piece{
    private Player owner;
    private int travel;
    private int kills;
    private Queue<Position> distance_cover;
     public void kill(){
        this.kills++;
    }
        public int getKills(){
         return this.kills;
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
    public Queue<Position> getQueue(){
        return this.distance_cover;
    }
    public void adddistance(Position p1 ){
        distance_cover.add(p1);
    }

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
