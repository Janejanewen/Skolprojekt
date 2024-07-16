package javaClass;


public class Cabin {
    private int id;
    private String type;
    private int capacity;
    private double price;
    private String information;

    public Cabin( int id,String type, int capacity,double price, String information) {
        this.id=id;
        this.type = type;
        this.capacity = capacity;
        this.price = price;
        this.information = information;

    }

    public int getId(){
        return id;
    }
    public String gettype() {
        return type;
    }

    public int getCapacity() {
        return capacity;
    }

    public double getPrice()
    {
        return price;
    }

    public String getInformation() {return information;}

}


