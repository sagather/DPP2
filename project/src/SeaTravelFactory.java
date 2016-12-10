/**
 * Created by bcxtr on 12/7/2016.
 */
//Megan Ostby & Sam Agather
import airtravel.SeatClass;
import seatravel.*;

//NOT Implemented, Lack of time

import java.util.ArrayList;
import java.util.Scanner;

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
            System.out.println("Cruise: "+ cruise + " This cruise was not created due an issue with the name. " + e.getMessage());
        }

    }

    public void createTravelMethod(String transport, String depart, String arrive, int iYear, int month, int day, int hour, int minute, String line){

        Scanner kb = new Scanner(System.in);
        System.out.println("Enter the ship name");
        String ship = kb.nextLine();
        System.out.println("Enter the arrival year");
        int aYear = kb.nextInt();
        kb.nextLine();
        System.out.println("Enter the arrival month");
        int aMonth = kb.nextInt();
        kb.nextLine();
        System.out.println("Enter the arrival day");
        int aDay = kb.nextInt();
        kb.nextLine();

        createTrip(ship, transport, depart, arrive, iYear, month, day, aYear, aMonth, aDay);

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
    public void changeSeatClassPrice(String iAirline, String iOrgin, String iDestination, SeatClass iClass, int price) {
    }

    @Override
    public void searchSeats(SeatClass seatClass, String iOrigin, String iDestination, int iMonth, int iDay, int iYear) {
    }

    @Override
    public String getAirlineName(int index) {
        return null;
    }

    public String displaySystemDetails(){

        String s = "[";

        for(Port port : ports){
            s = s+ port.toString() + ", ";
        }
        s += "]{";

        for(Trip t : trips){
            s += t.toString();
        }

        return s;
    }

    private void createTrip(String shipName, String cruiseName, String departurePort, String arrivalPort,int dYear,int dMonth, int dDay,int aYear, int aMonth, int aDay){

        Boolean cruiseGood = false;
        Boolean departureGood = false;
        Boolean arrivalGood = false;
        Boolean dayGood = false;
        Boolean monthGood = false;

        try {
            for(Cruise c:cruises)
            {
                if (c.getName().equals(cruiseName)) {
                    cruiseGood = true;
                }
            }
            //invalid airports
            for(Port p:ports)
            {
                if (p.getName().equals(departurePort))
                {
                    departureGood =true;
                }
            }
            for(Port p:ports)
            {
                if (p.getName().equals(arrivalPort)) {
                    arrivalGood = true;
                }
            }
            //invalid dates
            if(dDay >= 1 && dDay <= 31 && aDay >= 1 && aDay <= 31)
            {
                dayGood = true;
            }

            if(dMonth >= 1 && dMonth <= 12 && dMonth >= 1 && dMonth <=12)
            {
                monthGood = true;
            }

            if(cruiseGood && arrivalGood  && departureGood && dayGood && monthGood ) {
                Trip t = new Trip(shipName, cruiseName, departurePort, arrivalPort, dYear, dMonth, dDay,aYear,aMonth, aDay);
                System.out.println("Creation of Trip " + shipName + " was successful.");
                trips.add(t);
            }
            else
            {
                if(!cruiseGood)
                {
                    throw new IllegalArgumentException("Cruise must match an existing Cruise name!");
                }
                else if(!departureGood)
                {
                    throw new IllegalArgumentException("Departure city must match an existing port name!");
                }
                else if(!arrivalGood)
                {
                    throw new IllegalArgumentException("Arrival city must match an existing port name!");
                }
                else if(!dayGood)
                {
                    throw new IllegalArgumentException("Day must be an actual calender value!");
                }
                else if(!monthGood)
                {
                    throw new IllegalArgumentException("Month must be an actual calender value!");
                }
            }
        }
        catch(IllegalArgumentException e)
        {
            System.out.println("Trip: "+ shipName + " This flight was not created. " + e.getMessage());
        }

    }

}
