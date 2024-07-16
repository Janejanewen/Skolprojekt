package javaClass;

public class Event
{
    private int id;
    private String namn;
    private int No_tickets; // antal biljetter som kan säljas
    private String info;
    public Event( int id,String namn, int No_tickets, String info) {
        this.id=id;
        this.namn = namn;
        this.No_tickets = No_tickets;
        this.info = info;
    }
    public void setNo_tickets(int no_tickets) {
        No_tickets = no_tickets;
    }

    public int getId() {
        return id;
    }

    public String getNamn() {
        return namn;
    }

    public int getNo_tickets() {
        return No_tickets;
    }

    public String getInfo() {
        return info;
    }
}
