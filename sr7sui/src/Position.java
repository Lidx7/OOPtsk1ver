public class Position {
    private int x;
    private int y;
    public Position(int y,int x){
        this.x = x;
        this.y = y;
    }
    public Position(Position pos)
    {
        this.x=pos.x;
        this.y=pos.y;
    }
    public int get_x(){
        return x;
    }
    public int get_y(){
        return y;
    }
    public Position get_position(){
        return new Position(y,x);
    }
    public void set_position(Position pos){
        this.x=pos.x;
        this.y=pos.y;
    }

    public String toString (){
        return ("["+this.get_y()+"]"+"["+this.get_x()+"]");
    }
}
