package seatravel;
//Megan Ostby & Sam Agather
/**
 * Created by Megan Ostby on 12/8/2016.
 */
public class Cabin
{

    private int floor;
    private int rmNum;
    private char type;//b = balcony i = inner
    private String assignment;
    private boolean assigned = false;

    public Cabin(int floor, int rmNum, char type){

        this.floor = floor;
        this.rmNum = rmNum;
        this.type = type;//window, aisle or none
    }

    public String toString(){
        this.assignment = "Cabin: Floor - " + floor + " Room# - " + rmNum;
        return this.assignment;
    }

    public boolean isAssigned(){
        return this.assigned;

    }

    public void setAssigned(){
        this.assigned = !this.assigned;
    }

    public int getFloor(){
        return this.floor;
    }

    public int getRmNum(){
        return this.rmNum;
    }

    public char getType(){
        return this.type;
    }

}
