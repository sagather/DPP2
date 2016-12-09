/**
 * Created by bcxtr on 12/7/2016.
 */
//Megan Ostby & Sam Agather
import airtravel.SeatClass;
import seatravel.*;

//NOT Implemented, Lack of time

import java.util.ArrayList;

public class SeaTravelFactory extends TravelFactory{
    private ArrayList<Port> ports = new ArrayList<Port>();
    private ArrayList<Cruise> cruises = new ArrayList<Cruise>();
    private ArrayList<Trip> trips = new ArrayList<Trip>();
    private CabinSection section;

    public void createTransport(String port)
    {

    }

    public void createCompany(String cruise){

    }

    public void createTravelMethod(String transport, String depart, String arrive, int iYear, int month, int day, int hour, int minute, String line){

    }

    @Override
    public void createSection(String iAirline, String iFlightNumber, int iRow, char iCols, SeatClass iClass, int price) {

    }

    @Override
    public void bookSpecific(String iAirline, String iFlight, SeatClass iClass, int iRow, char iSeat) {

    }

    @Override
    public void bookPreference(String iAirline, String iFlight, SeatClass iClass, char iSeat) {

    }

    @Override
    public String getAirlineName(int index) {
        return null;
    }

    public String displaySystemDetails(){
        return null;
    }

}
