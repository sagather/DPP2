package airtravel;
//Megan Ostby & Sam Agather
/**
 * Created by bcxtr on 12/7/2016.
 */

import java.util.*;
public class FlightSection {
    private ArrayList<Seat> seats = new ArrayList<Seat>();
    private SeatClass sClass;
    private int rows;
    private int cols;
    private String airline;
    private String flightNumber;
    private char sectType;
    private int price;

    public FlightSection(String iAirline, String iFlightNumber, int seatRows, char cols, SeatClass isClass){

        try{
            if(seatRows > 100 ||  seatRows < 1){
                throw new IllegalArgumentException();
            }

            int seatCols = sectType(cols);
            for(int i = 1; i <= seatRows; i++){
                char z = 'a';
                for(int j = 0; j < seatCols; j++){
                    char type = winOrAisle(z);
                    seats.add(new Seat(i, z, type));
                    z++;
                }
            }

            this.airline = iAirline;
            this.flightNumber = iFlightNumber;
            this.sClass = isClass;
            this.rows = seatRows;
            this.cols = seatCols;
        }
        catch(IllegalArgumentException e){
            System.out.println("Invalid number of rows and cols to create a flight");
        }
    }

    public char winOrAisle(char c)
    {
        try {
            if (sectType == 'S') //3 columns (a-c)
            {
                if(c == 'a')
                {
                    return 'w';
                }
                else if(c == 'b')
                {
                    return 'a';
                }
                else if(c == 'c')
                {
                   return 'w';
                }
            }
            else if (sectType == 'M') //4 columns (a-d)
            {
                if(c == 'a')
                {
                    return 'w';
                }
                else if(c == 'b')
                {
                    return 'a';
                }
                else if(c == 'c')
                {
                    return 'a';
                }
                else if(c == 'd')
                {
                    return 'w';
                }
            }
            else if (sectType == 'W') //10 columns (a -j)
            {
                if(c == 'a')// 1 window
                {
                    return 'w';
                }
                else if(c == 'b')// 2
                {
                    return 'n';
                }
                else if(c == 'c')// 3 aisle
                {
                    return 'a';
                }
                else if(c == 'd')// 4 aisle
                {
                    return 'a';
                }
                else if(c == 'e')// 5
                {
                    return 'n';
                }
                else if(c == 'f')// 6
                {
                    return 'n';
                }
                else if(c == 'g')// 7 aisle
                {
                    return 'a';
                }
                else if(c == 'h')// 8 aisle
                {
                    return 'a';
                }
                else if(c == 'i')// 9
                {
                    return 'n';
                }
                else if(c == 'j')// 10 window
                {
                    return 'w';
                }
            }
            else
            {
                throw new IllegalArgumentException("That seat format given does not exist.");
            }
        }
        catch (IllegalArgumentException e)
        {
            System.out.println("Flight section was not created" + e.getMessage());
        }
        return 'n';
    }

    public void setPrice(int iPrice){

        this.price = iPrice;

    }

    public int getPrice(){

        return this.price;

    }

    public int sectType(char col)
    {
        try {
            if (col == 's' || col == 'S') {
                this.sectType = 'S';
                return 3;
            } else if (col == 'm' || col == 'M') {
                this.sectType = 'M';
                return 4;
            } else if (col == 'w' || col == 'W') {
                this.sectType = 'W';
                return 10;
            }
            else
            {
                throw new IllegalArgumentException("The seat format given does not exist.");
            }
        }
        catch (IllegalArgumentException e)
        {
            System.out.println("Flight section was not created" + e.getMessage());
        }
        return 0;
    }

    public boolean hasAvailableSeats(){
        int i = 0;
        for(Seat s : seats){
            if(!s.isAssigned()){
                i++;
            }
        }
        return i>0;
    }

    public Seat hasAvailableType(char c)
    {
        try {
            int i = 0;
            for (Seat s : seats) {
                if (!s.isAssigned() && s.getType() == c) {
                    return s;
                }
            }
        }
        catch (Exception e)
        {
            System.out.println("Something went wrong");
        }
        return null;
    }

    public void bookSeat(int iRow, char iCol, SeatClass iClass){
        try {
            int i = 0;
            for (Seat s : seats) {
                if (s.getRow() == iRow) {
                    if (s.getCol() == Character.toLowerCase(iCol)  && !s.isAssigned()){
                        s.setAssigned();
                        System.out.println("You successfully booked " + this.sClass + ", seat " + iRow + iCol);
                        i++;
                    }
                }
            }
            if (i == 0) {
                throw new IllegalArgumentException(iRow + "" + iCol+ " was not available. ");
            }
        }
        catch (IllegalArgumentException e)
        {
            System.out.println("Seat was not booked. " + e.getMessage());
        }
    }

    public String toString(){
        return "" + this.sectType+ ":"+this.price + "S:" + this.rows;

    }

    public boolean classCompare(SeatClass iClass){
        if(iClass == sClass){
            return true;
        }
        return false;
    }
}
