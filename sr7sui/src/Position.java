import java.util.ArrayList;

public class Position {
    private int x;
    private int y;
    private ArrayList<Integer> peoples = new ArrayList<Integer>();
    public Position(int y,int x){
        this.x = x;
        this.y = y;
    }
    public Position(Position pos)
    {
        this.x=pos.x;
        this.y=pos.y;
        this.peoples= new ArrayList<Integer>();
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
    public void addpeople(int id){
        this.peoples.add(id);
    }
    public int getPeopleSize(){
        return this.peoples.size();
    }
    public ArrayList<Integer> getPeoples(){
        return this.peoples;
    }
    public String toString (){
        return ("["+this.get_y()+"]"+"["+this.get_x()+"]");
    }
}
