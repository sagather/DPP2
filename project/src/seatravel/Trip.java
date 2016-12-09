package seatravel;
//Megan Ostby & Sam Agather
import java.util.ArrayList;

/**
 * Created by bcxtr on 12/7/2016.
 */
public class Trip
{
    private ArrayList<CabinSection> section = new ArrayList<CabinSection>();
    private String shipName;
    private String cruiseName;
    private String departurePort;
    private String arrivalPort;
    private int dYear;
    private int dMonth;
    private int dDay;
    private int aYear;
    private int aMonth;
    private int aDay;

    public Trip(String shipName, String cruiseName, String departurePort, String arrivalPort,int dYear,int dMonth, int dDay,int aYear, int aMonth, int aDay) {
        this.shipName = shipName;
        this.cruiseName = cruiseName;
        this.departurePort = departurePort;
        this.arrivalPort = arrivalPort;
        this.dYear = dYear;
        this.dMonth = dMonth;
        this.dDay = dDay;
        this.aYear = aYear;
        this.aMonth = aMonth;
        this.dDay = aDay;
    }

    public String toString()
    {
        String trip = "Trip on " + this.cruiseName + " on " + shipName+ ", departing from " + this.departurePort + ", on " + this.dMonth + ", " + this.dDay + " " + this.dYear +
                "returning on "+ this.aMonth +", "+ this.aDay +  " arriving at " + this.arrivalPort + ".\n";

        for(CabinSection sect : section){
            trip += sect.toString();
        }

        return trip;
    }

    public String getDepartureCity()
    {
        return this.departurePort;
    }

    public String getArrivalCity()
    {
        return this.arrivalPort;
    }

    public String getCruiseName()
    {
        return this.cruiseName;
    }

    public void addCabinSection(CabinSection cs)
    {
        section.add(cs);
    }

    public CabinSection getFlightSection(CabinClass iClass)
    {
        for(CabinSection sect : section){

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
