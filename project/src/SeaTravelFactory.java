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
        try
        {
            if (port.length() > 3 || port.length() < 3) {
                //Must be alphabetic characters
                throw new IllegalArgumentException("Port name must be exactly 3 characters long!");
            }
            if (!port.matches("[a-zA-Z]+")) {
                throw new IllegalArgumentException("Port name must only contain alphabetic characters. ");
            }

            for(Port p:ports)
            {
                if (p.getName().equals(port)) {
                    throw new IllegalArgumentException("Port name must not be the same as another port name.");
                }
            }
            Port po = new Port(port);
            System.out.println("Creation of Port " + port + " was successful.");
            ports.add(po);
        }
        catch (IllegalArgumentException e)
        {
            System.out.println("Port: "+ port + " This port was not created due an issue with the name. " + e.getMessage());
        }

    }

    public void createCompany(String cruise){

        try
        {
            if (cruise.length() > 6) {
                throw new IllegalArgumentException("Cruise name must be less than 6 characters long!");
            }
            for(Cruise c:cruises)
            {
                if (c.getName().equals(cruise)) {
                    throw new IllegalArgumentException("Cruise name must not be the same as another cruise name.");
                }
            }
            Cruise cr = new Cruise(cruise);
            System.out.println("Creation of Cruise " + cruise + " was successful.");
            cruises.add(cr);
        }
        catch (IllegalArgumentException e)
        {
            System.out.println("Cruise: "+ cruise + " This airline was not created due an issue with the name. " + e.getMessage());
        }

    }

    public void createTravelMethod(String transport, String depart, String arrive, int iYear, int month, int day, int hour, int minute, String line){
        Boolean cruiseGood = false;
        Boolean departureGood = false;
        Boolean arrivalGood = false;
        Boolean dayGood = false;
        Boolean monthGood = false;
        Boolean hourGood = false;
        Boolean minGood = false;

        try {
            for(Cruise c:cruises)
            {
                if (c.getName().equals(transport)) {
                    cruiseGood = true;
                }
            }
            //invalid airports
            for(Port p:ports)
            {
                if (p.getName().equals(depart))
                {
                    departureGood =true;
                }
            }
            for(Port p1:ports)
            {
                if (p1.getName().equals(arrive)) {
                    arrivalGood = true;
                }
            }
            //invalid dates
            if(day >= 1 && day <= 31)
            {
                dayGood = true;
            }

            if(month >= 1 && month <= 12)
            {
                monthGood = true;
            }
            if(hour >=0 && hour <= 24)
            {
                hourGood = true;
            }
            if(minute >= 0 && minute <= 59)
            {
                minGood = true;
            }

            if(cruiseGood && arrivalGood  && departureGood && dayGood && monthGood && hourGood &&minGood) {
                /*Trip trip = new Trip(line, depart, arrive, iYear, month, day,hour,minute, line);
                System.out.println("Creation of Trip " + line + " was successful.");
                trips.add(trip);*/
            }
            else
            {
                if(!cruiseGood)
                {
                    throw new IllegalArgumentException("Cruise must match an existing cruise name!");
                }
                else if(!departureGood)
                {
                    throw new IllegalArgumentException("Departure city must match an existing airport name!");
                }
                else if(!arrivalGood)
                {
                    throw new IllegalArgumentException("Arrival city must match an existing airport name!");
                }
                else if(!dayGood)
                {
                    throw new IllegalArgumentException("Day must be an actual calender value!");
                }
                else if(!monthGood)
                {
                    throw new IllegalArgumentException("Month must be an actual calender value!");
                }
                else if(!hourGood)
                {
                    throw new IllegalArgumentException("Hour must be within the 24 hour clock!");
                }
                else if(!minGood)
                {
                    throw new IllegalArgumentException("Minute must be an acceptable value!");
                }
            }
        }
        catch(IllegalArgumentException e)
        {
            System.out.println("Flight: "+ line + " This flight was not created. " + e.getMessage());
        }
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
    public void priceChange(String iAirline, String iFlight, int price) {

    }

    @Override
    public String getAirlineName(int index) {
        return null;
    }

    public String displaySystemDetails(){
        return null;
    }

}
