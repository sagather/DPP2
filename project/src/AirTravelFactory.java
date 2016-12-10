/**
 * Created by bcxtr on 12/7/2016.
 */
//Megan Ostby & Sam Agather
import airtravel.*;

import java.util.ArrayList;

public class AirTravelFactory extends TravelFactory{
    private ArrayList<Airport> airports = new ArrayList<Airport>();
    private ArrayList<Airline> airlines = new ArrayList<Airline>();
    private ArrayList<Flight> flights = new ArrayList<Flight>();
    private FlightSection section;
    //Acts as System manager for airtravel

    public void createTransport(String iAirport){
        try
        {
            if (iAirport.length() > 3 || iAirport.length() < 3) {
                //Must be alphabetic characters
                throw new IllegalArgumentException("Airport name must be exactly 3 characters long!");
            }
            if (!iAirport.matches("[a-zA-Z]+")) {
                throw new IllegalArgumentException("Airport name must only contain alphabetic characters. ");
            }

            for(Airport sAirport:airports)
            {
                if (sAirport.getName().equals(iAirport)) {
                    throw new IllegalArgumentException("Airport name must not be the same as another airport name.");
                }
            }
            Airport airport = new Airport(iAirport);
            System.out.println("Creation of Airport " + iAirport + " was successful.");
            airports.add(airport);
        }
        catch (IllegalArgumentException e)
        {
            System.out.println("Airport: "+ iAirport + " This airport was not created due an issue with the name. " + e.getMessage());
        }
    }

    public void createCompany(String iAirline){
        try
        {
            if (iAirline.length() > 6) {
                throw new IllegalArgumentException("Airline name must be less than 6 characters long!");
            }
            for(Airline sAirline:airlines)
            {
                if (sAirline.getName().equals(iAirline)) {
                    throw new IllegalArgumentException("Airline name must not be the same as another airline name.");
                }
            }
            Airline airline = new Airline(iAirline);
            System.out.println("Creation of Airline " + iAirline + " was successful.");
            airlines.add(airline);
        }
        catch (IllegalArgumentException e)
        {
            System.out.println("Airline: "+ iAirline + " This airline was not created due an issue with the name. " + e.getMessage());
        }
    }

    @Override
    public String getAirlineName(int index) {
        return airlines.get(index).getName();
    }

    public void createTravelMethod(String iLine, String iDeparture, String iArrival, int year, int month, int day, int hour, int minute, String iFlightNumber)
    {
        Boolean airlineGood = false;
        Boolean departureGood = false;
        Boolean arrivalGood = false;
        Boolean dayGood = false;
        Boolean monthGood = false;
        Boolean hourGood = false;
        Boolean minGood = false;

        try {
            for(Airline sAirline:airlines)
            {
                if (sAirline.getName().equals(iLine)) {
                    airlineGood = true;
                }
            }
            //invalid airports
            for(Airport sAirport:airports)
            {
                if (sAirport.getName().equals(iDeparture))
                {
                    departureGood =true;
                }
            }
            for(Airport sAirport:airports)
            {
                if (sAirport.getName().equals(iArrival)) {
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

            if(airlineGood && arrivalGood  && departureGood && dayGood && monthGood && hourGood &&minGood) {
                Flight flight = new Flight(iLine, iDeparture, iArrival, year, month, day,hour,minute, iFlightNumber);
                System.out.println("Creation of Flight " + iFlightNumber + " was successful.");
                flights.add(flight);
            }
            else
            {
                if(!airlineGood)
                {
                    throw new IllegalArgumentException("Airline must match an existing airline name!");
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
            System.out.println("Flight: "+ iFlightNumber + " This flight was not created. " + e.getMessage());
        }
    }

    public void createSection(String iAirline, String iFlightNumber, int iRow, char iCols, SeatClass iClass, int price)
    {
        Boolean airlineGood = false;
        Boolean classGood = false;

        try {
            for(Airline sAirline:airlines)
            {
                if (sAirline.getName().equals(iAirline))
                {
                    airlineGood = true;
                }
            }

            if(airlineGood) {
                this.section = new FlightSection(iAirline, iFlightNumber, iRow, iCols, iClass,price);
                for (Flight fly : flights) {

                    if (fly.getID().equals(iFlightNumber))
                    {
                        for(int i = 0; i <= fly.sectionSize(); i++) {
                            if (fly.sectionSize() == 0 || fly.getFlightSection(iClass) == null)
                            {
                                classGood = true;
                            }
                        }
                        if(classGood) {
                            System.out.println("Creation of section " + iClass + " was successful.");
                            fly.addFlightSection(section);

                        }

                    }

                }
            }

            if(!airlineGood) {
                throw new IllegalArgumentException("Airline must match an existing airline name!");
            }
            else if(!classGood)
            {
                throw new IllegalArgumentException("Flight cannot have two of the same section!");
            }
        }
        catch (IllegalArgumentException e)
        {
            System.out.println("Section: "+ iClass + " This class was not created for this flight. " + e.getMessage());
        }

    }

    public void findAvailableFlights(String iDeparture, String iArrival){

        System.out.print("\nAvailable Flights: ");
        int i = 0;

        try{

            for(Flight flight : flights){

                if(iDeparture.equals(flight.getDepartureCity())){

                    if(iArrival.equals(flight.getArrivalCity())){

                        System.out.print(flight.toString());
                        i++;

                    }

                }

            }

            if(i == 0){

                throw new IllegalArgumentException();

            }

        }

        catch(IllegalArgumentException e){

            System.out.println("There are no flights with the destination and arrival airport combination provided");

        }


    }

    @Override
    public void bookSpecific(String iAirline, String iFlight, SeatClass iClass, int iRow, char iSeat){
        Boolean airlineGood = false;
        try{
            for(Airline sAirline:airlines)
            {
                if (sAirline.getName().equals(iAirline))
                {
                    airlineGood = true;
                }
            }
            if(airlineGood) {
                for (Flight fly : flights) {

                    if (fly.getID().equals(iFlight)) {

                        this.section = fly.getFlightSection(iClass);

                        if (section.hasAvailableSeats()) {
                            section.bookSeat(iRow, iSeat, iClass);
                            return;
                        }

                    } else {
                        throw new IllegalArgumentException("Flight ID must match!");
                    }
                }
            }
            else
            {
                throw new IllegalArgumentException("Airline name is not valid.");
            }
        }
        catch(IllegalArgumentException e){
            System.out.println("Could not book seat. " + e.getMessage());
        }
    }

    @Override
    public void bookPreference(String iAirline, String iFlight, SeatClass iClass, char iSeat)//iSeat acts as Window or Aisle preference, A or W ignore case
    {
        Boolean airlineGood = false;
        try{
            for(Airline sAirline:airlines)
            {
                if (sAirline.getName().equals(iAirline))
                {
                    airlineGood = true;
                }
            }
            if(airlineGood) {
                for (Flight fly : flights) {

                    if (fly.getID().equals(iFlight)) {

                        this.section = fly.getFlightSection(iClass);

                        if (section.hasAvailableSeats())
                        {
                            Seat theSeat = section.hasAvailableType(iSeat);
                            if(theSeat!=null) {
                                section.bookSeat(theSeat.getRow(),theSeat.getCol(), iClass);
                                return;
                            }
                        }

                    } else {
                        throw new IllegalArgumentException("Flight ID must match!");
                    }

                }
            }
            else
            {
                throw new IllegalArgumentException("Airline name is not valid.");
            }
        }
        catch(IllegalArgumentException e){
            System.out.println("Could not book seat. " + e.getMessage());
        }
    }

    public String displaySystemDetails(){

        String s = "[";

        for(Airport port : airports){
            s = s+ port.toString() + ", ";
        }
        s += "]{";

        for(Flight fly : flights){
            s += fly.toString();
        }

        return s;
    }

}

