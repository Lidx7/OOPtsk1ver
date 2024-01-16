private int x;
  private int y;
public Position(int x,int y){
    this.x=x;
    this.y=y;
    }
    public Position(Position pos)
    {
        this.x=pos.x;
        this.y=pos.y;
    }
    public int get_x(){
    return this.x;
    }
    public int get_y(){
        return this.y;
    }
    public Position get_position(){
        return new Position(this.x,this.y);
    }
