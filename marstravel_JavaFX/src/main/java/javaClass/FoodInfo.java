package javaClass;

public class FoodInfo {
    private int id;
    private String info;
    public FoodInfo( int id,String info)
    {
        this.id=id;
        this.info = info;
    }

    public int getId() {
        return id;
    }

    public String getInfo() {
        return info;
    }
}
