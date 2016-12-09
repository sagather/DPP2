/**
 * Created by bcxtr on 12/7/2016.
 */

import airtravel.FlightSection;
import airtravel.SeatClass;
import seatravel.*;
import airtravel.SeatClass;

import java.util.ArrayList;

public class SeaTravelFactory extends TravelFactory{
    private ArrayList<Port> ports = new ArrayList<Port>();
    private ArrayList<Cruise> airlines = new ArrayList<Cruise>();
    private ArrayList<Trip> flights = new ArrayList<Trip>();
    private FlightSection section;

    public void createTransport(String port)
    {

    }

    public void createCompany(String cruise){

    }

    public void createTravelMethod(String transport, String depart, String arrive, int iYear, int month, int day, int hour, int minute, String line){

    }

    @Override
    public void createSection(String iAirline, String iFlightNumber, int iRow, char iCols, SeatClass iClass) {

    }

    @Override
    public void bookSpecific(String iAirline, String iFlight, SeatClass iClass, int iRow, char iSeat) {

    }

    @Override
    public void bookPreference(String iAirline, String iFlight, SeatClass iClass, char iSeat) {

    }

    public void createSection(String s) {

    }

    public void bookSpecific() {

    }

    @Override
    public String getAirlineName(int index) {
        return null;
    }

}
