package airtravel;

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

    public FlightSection(String iAirline, String iFlightNumber, int seatRows, int seatCols, SeatClass isClass){

        try{

            if(seatRows > 100 || seatCols > 10 || seatRows < 1 || seatCols < 1){
                throw new IllegalArgumentException();
            }

            for(int i = 1; i <= seatRows; i++){
                char z = 'a';
                for(int j = 0; j < seatCols; j++){   //not sure if this will work... in theory it will, but...
                    seats.add(new Seat(i, z));
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

    public boolean hasAvailableSeats(){
        int i = 0;
        for(Seat s : seats){
            if(!s.isAssigned()){
                i++;
            }
        }
        return i>0;
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
        return " For section " + sClass + " there is " + seats.toString();

    }

    public boolean classCompare(SeatClass iClass){
        if(iClass == sClass){
            return true;
        }
        return false;
    }
}
