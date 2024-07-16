package javaClass;


public class Hotel {
    private int id;
    private String type;
    private String information;

    public Hotel( int id, String type, String information) {
        this.id=id;
        this.type = type;
        this.information = information;

    }

    public int getId(){
        return id;
    }
    public String gettype() {
        return type;
    }

    public String getInformation() {return information;}

}


