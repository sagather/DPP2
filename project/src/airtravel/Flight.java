package airtravel;
//Megan Ostby & Sam Agather
import java.util.ArrayList;

/**
 * Created by bcxtr on 12/7/2016.
 */
public class Flight {

    private ArrayList<FlightSection> section = new ArrayList<FlightSection>();
    private String ID;
    private String airlineName;
    private String departureCity;
    private String arrivalCity;
    private int year;
    private int month;
    private int day;
    private int hour;
    private int minute;

    public Flight(String airlineName, String departCity, String arriveCity, int year, int month, int day, int hour, int minute, String flightNumber) {
        this.ID = flightNumber;
        this.airlineName = airlineName;
        this.departureCity = departCity;
        this.arrivalCity = arriveCity;
        this.year = year;
        this.month = month;
        this.day = day;
        this.minute = minute;
        this.hour = hour;
    }

    public String toString()
    {
        String flight = this.ID + "|" + this.year + ", " + this.month + ", " + this.day + ", " + this.hour + "," + this.minute + "|";

        flight += this.departureCity + "|" + this.arrivalCity + "[";

        for(FlightSection sect : section){

            flight += sect.toString() + "], ";

        }

        return flight;
    }

    public String getDepartureCity()
    {
        return this.departureCity;
    }

    public String getArrivalCity()
    {
        return this.arrivalCity;
    }

    public String getID()
    {
        return this.ID;
    }

    public void addFlightSection(FlightSection fs)
    {
        section.add(fs);
    }

    public FlightSection getFlightSection(SeatClass iClass)
    {
        for(FlightSection sect : section){

            if(sect.classCompare(iClass)){

                return sect;
            }
        }
        return null;
    }

    public int sectionSize(){
        return section.size();
    }

}
