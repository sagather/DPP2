package airtravel;

/**
 * Created by bcxtr on 12/7/2016.
 */
public class Seat {

    private int row;
    private char seat;
    private char type;//w = window a = aisle n=nothing
    private String assignment;
    private boolean assigned = false;
    private int price;

    public Seat(int iRow, char iSeat, char type){

        this.row = iRow;
        this.seat = iSeat;
        this.type = type;//window, aisle or none
    }

    public String toString(){
        this.assignment = "Seat: " + row + seat;
        return this.assignment;

    }

    public void setPrice(int iPrice){

        this.price = iPrice;

    }

    public int getPrice(){

        return this.price;

    }

    public boolean isAssigned(){
        return this.assigned;

    }

    public void setAssigned(){
        this.assigned = !this.assigned;
    }

    public int getRow(){
        return this.row;
    }

    public char getCol(){
        return this.seat;
    }

    public char getType(){
        return this.type;
    }

}
