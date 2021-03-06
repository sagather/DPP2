import airtravel.Seat;
import airtravel.SeatClass;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;
//Megan Ostby & Sam Agather
public class SampleClient{

    static TravelFactory travel;
    static TravelFactory travel2;

    public static void main(String[] args){
        displayUI();
    }

    public static void displayAdminUI(){

        int choice = 0;
        Scanner kb = new Scanner(System.in);

        System.out.println("----------------Admin Menu-------------------\n");

        System.out.println("------------Air Travel Options---------------");
        System.out.println("\n1:  Create a new Airport");
        System.out.println("2:  Create a new Airline");
        System.out.println("3:  Create a new Flight");
        System.out.println("4:  Display Current State");
        System.out.println();
        System.out.println("------------Sea Travel Options----------------");
        System.out.println("\n5:  Create a new Cruise");
        System.out.println("6:  Create a new Port");
        System.out.println("7:  Create a new Trip");
        System.out.println("8:  Create a new Ship");
        System.out.println("9:  Display Current State");
        System.out.println();
        System.out.println("--------Choose your fate 0 to exit menu-------");

        choice = kb.nextInt() + 10;

        processChoice(choice);

    }

    public static void displayUI(){

        int choice;
        Scanner kb = new Scanner(System.in);

        System.out.println("---------------General UI--------------------");
        System.out.println("\n1:  Create Airport System with input file");
        System.out.println("2:  Change the price of seats in a flight section");
        System.out.println("3:  Search for seats");
        System.out.println("4:  Change seat class pricing for flight destination [ ] and arrival [ ]");
        System.out.println("5:  Book a seat on a flight");
        System.out.println("6:  Book a seat by seat class and window/aisle preference");
        System.out.println("7:  Display Airport System details");
        System.out.println("8:  Write system details to file");
        System.out.println("9:  Display Admin UI\n");
        System.out.println("---------------End UI, press 0 to quit--------");

        choice = kb.nextInt();

        processChoice(choice);
    }

    public static void processChoice(int c){

        Scanner kb = new Scanner(System.in);

        while(c >  19 ){

            System.out.println("That is not a valid response.");
            c = kb.nextInt();

        }
        switch(c){
            case 0:  System.exit(0);
                    break;
            case 1:  createFromFile();//Fully Implemented
                    break;
            case 2: priceChange(); //Fully Implemented
                    break;
            case 3: searchSeats(); //Fully implemented
                    break;
            case 4: changeSeatClassPrice(); //Fully Implemented
                    break;
            case 5: bookSpecific(); //Fully Implemented
                    break;
            case 6: BookPreference(); //Fully Implemented
                    break;
            case 7: System.out.println(travel.displaySystemDetails());//Fully Implemented
                    break;
            case 8:  writeOutput();//Fully Implemented
                    break;
            case 9:  displayAdminUI();//Fully Implemented
                    break;
            case 10:  displayUI();//Fully Implemented
                    break;
            case 11:  airportCreate();
                    break;
            case 12:  airlineCreate();
                    break;
            case 13:  flightCreate();
                    break;
            case 14:  System.out.println(travel.displaySystemDetails());
                    break;
            case 15:  cruiseCreate();
                    break;
            case 16:  portCreate();
                    break;
            case 17:  tripCreate();
                    break;
            case 18:  shipCreate();
                    break;
            case 19:  displayCruiseLineStat();
                    break;
            default:
                System.exit(0);
        }
        displayUI();
    }

    public static void createFromFile(){
        //Open file

        if(travel == null){
            travel = new AirTravelFactory();
        }

        try{
            Scanner kb = new Scanner(System.in);
            System.out.println("Please enter full input file path and name: ");
            String fileName = kb.nextLine();
            File file = FileReader.openFile(fileName);//C:/Users/Megan Ostby/IdeaProjects/DPP2/project/src/input.txt
            ArrayList<String> construction = FileReader.readFile(file);
            String[]  airports = FileParser.parseAirports(construction);
            for(String s: airports){
                travel.createTransport(s);
            }
            construction.remove(0);
            String[] airlines = FileParser.parseAirlines(construction);
            for(String s : airlines){

                travel.createCompany(s);
            }
            String[] flights = FileParser.parseFlights();
            String[] dates = FileParser.parseDates();
            String[] departures = FileParser.parseDepartures();
            String[] arrivals = FileParser.parseArrivals();
            String[] seats = FileParser.parseSeats();
            int seatCounter = 0;
            for(int i = 0; i < flights.length; i++) {
                String airlineName;

                if (i < 2) {

                    airlineName = airlines[0];
                } else {

                    airlineName = airlines[1];
                }
                travel.createTravelMethod(airlineName, departures[i], arrivals[i], Integer.parseInt(dates[i * 5]),
                        Integer.parseInt(dates[(i * 5) + 1]), Integer.parseInt(dates[(i * 5) + 2]), Integer.parseInt(dates[(i * 5) + 3]),
                        Integer.parseInt(dates[(i * 5) + 4]), flights[i]);

                // String iAirline, String iFlightNumber, int iRow, char iCols, SeatClass iClass, int price
                SeatClass iClass;
                String[] seat1 = seats[seatCounter].split(":");
                String[] seat2 = seats[seatCounter+1].split(":");
                if(seat1[0].equals("E"))
                {
                    iClass = SeatClass.ECONOMY;
                }
                else if(seat1[0].equals("B"))
                {
                    iClass = SeatClass.BUSINESS;
                }
                else
                {
                    iClass = SeatClass.FIRST;
                }
                SeatClass iClass2;
                if(seat2[0].equals("E"))
                {
                    iClass2 = SeatClass.ECONOMY;
                }
                else if(seat2[0].equals("B"))
                {
                    iClass2 = SeatClass.BUSINESS;
                }
                else
                {
                    iClass2 = SeatClass.FIRST;
                }

                int price = Integer.parseInt(seat1[1]);
                int price2 = Integer.parseInt(seat2[1]);

                char cols = (seat1[2]).charAt(0);
                char cols2 = (seat2[2]).charAt(0);

                int row = Integer.parseInt(seat1[3]);
                int row2 = Integer.parseInt(seat2[3]);

                travel.createSection(airlineName,flights[i], row, cols, iClass, price);
                travel.createSection(airlineName,flights[i], row2,cols2,iClass2,price2);

                seatCounter = seatCounter + 2;
            }

        }
        catch (FileNotFoundException e){
            System.out.println("File was not found" + e.getMessage());
        }
    }

    public static void searchSeats()
    {
        Scanner kb = new Scanner(System.in);
        System.out.println("Please enter desired seat class: ");
        String seatClass = kb.nextLine();
        SeatClass classend;
        if (seatClass.equalsIgnoreCase("first")) {
            classend = SeatClass.FIRST;
        } else if (seatClass.equalsIgnoreCase("economy")) {
            classend = SeatClass.ECONOMY;
        } else if (seatClass.equalsIgnoreCase("business")) {
            classend = SeatClass.BUSINESS;
        } else {
            throw new IllegalArgumentException("Please only enter available class types!");
        }
        System.out.println("Please enter desired departure airport: ");
        String departAir = kb.nextLine();
        System.out.println("Please enter desired arrival airport: ");
        String arriveAir = kb.nextLine();
        System.out.println("Please enter desired departure month: ");
        int month = kb.nextInt();
        System.out.println("Please enter desired departure day: ");
        int day = kb.nextInt();
        System.out.println("Please enter desired departure year: ");
        int year = kb.nextInt();
        travel.searchSeats(classend,departAir,arriveAir,month,day,year);
    }


    public static void priceChange()
    {
        Scanner kb = new Scanner(System.in);
        System.out.println("Please enter desired airline: ");
        String departAir = kb.nextLine();
        System.out.println("Please enter desired flight number: ");
        String flightNum = kb.nextLine();
        System.out.println("Please enter desired price: ");
        int price = kb.nextInt();
        travel.priceChange(departAir,flightNum,price);
    }

    public static void changeSeatClassPrice()
    {
        Scanner kb = new Scanner(System.in);
        System.out.println("Please enter desired airline: ");
        String Air = kb.nextLine();
        System.out.println("Please enter desired origin city: ");
        String origin = kb.nextLine();
        System.out.println("Please enter desired destination city: ");
        String destination = kb.nextLine();
        System.out.println("Please enter desired class to change the price in (Must be ECONOMY, BUSINESS, or FIRST): ");
        String seatClass = kb.nextLine();
        SeatClass classend;
        if (seatClass.equalsIgnoreCase("first")) {
            classend = SeatClass.FIRST;
        } else if (seatClass.equalsIgnoreCase("economy")) {
            classend = SeatClass.ECONOMY;
        } else if (seatClass.equalsIgnoreCase("business")) {
            classend = SeatClass.BUSINESS;
        } else {
            throw new IllegalArgumentException("Please only enter available class types!");
        }
        System.out.println("Please enter desired price: ");
        int price = kb.nextInt();
        travel.changeSeatClassPrice(Air,origin,destination,classend,price);
    }

    public static void bookSpecific()
    {
        try {
            Scanner kb = new Scanner(System.in);
            System.out.println("Please enter desired Airline: ");
            String iAirline = kb.nextLine();
            System.out.println("Please enter desired Flight number: ");
            String iFlight = kb.nextLine();
            System.out.println("Please enter desired Seat Class: ");
            String iClass = kb.nextLine();
            SeatClass classend;
            if (iClass.equalsIgnoreCase("first")) {
                classend = SeatClass.FIRST;
            } else if (iClass.equalsIgnoreCase("economy")) {
                classend = SeatClass.ECONOMY;
            } else if (iClass.equalsIgnoreCase("business")) {
                classend = SeatClass.BUSINESS;
            } else {
                throw new IllegalArgumentException("Please only enter available class types!");
            }
            System.out.println("Please enter desired seat row number: ");
            int row = kb.nextInt();
            System.out.println("Please enter desired letter: ");
            char letter = kb.next().trim().charAt(0);
            travel.bookSpecific(iAirline, iFlight, classend, row, letter);
        }
        catch (IllegalArgumentException e)
        {
            System.out.println(e.getMessage());
        }
    }

    public static void BookPreference()
    {
        try {
            Scanner kb = new Scanner(System.in);
            System.out.println("Please enter desired Airline: ");
            String iAirline = kb.nextLine();
            System.out.println("Please enter desired Flight number: ");
            String iFlight = kb.nextLine();
            System.out.println("Please enter desired Seat Class: ");
            String iClass = kb.nextLine();
            SeatClass classend;
            if (iClass.equalsIgnoreCase("first")) {
                classend = SeatClass.FIRST;
            } else if (iClass.equalsIgnoreCase("economy")) {
                classend = SeatClass.ECONOMY;
            } else if (iClass.equalsIgnoreCase("business")) {
                classend = SeatClass.BUSINESS;
            } else {
                throw new IllegalArgumentException("Please only enter available class types!");
            }
            System.out.println("Please enter desired type (w = window, a = aisle): ");
            char letter = kb.next().charAt(0);
            travel.bookPreference(iAirline, iFlight, classend, letter);
        }
        catch (IllegalArgumentException e)
        {
            System.out.println(e.getMessage());
        }
    }

    public static void writeOutput(){

        FileReader.writeToFile(travel.displaySystemDetails());

    }

    public static void airportCreate(){
        Scanner kb = new Scanner(System.in);
        System.out.println("Please Enter Airport name: ");
        String name = kb.nextLine();
        travel.createTransport(name);

    }

    public static void airlineCreate(){

        Scanner kb = new Scanner(System.in);
        System.out.println("Please Enter airline name: ");
        String name = kb.nextLine();
        travel.createCompany(name);
    }

    public static void flightCreate(){

        String airline, departure, arrival, lineNumber;
        int year, month, day, hour, minute;

        Scanner kb = new Scanner(System.in);
        System.out.println("Please Enter airline name: ");
        airline = kb.nextLine();
        System.out.println("Please Enter departure city name: ");
        departure = kb.nextLine();
        System.out.println("Please Enter arrival city name: ");
        arrival = kb.nextLine();
        System.out.println("Please Enter flight number name: ");
        lineNumber = kb.nextLine();
        System.out.println("Please Enter year: ");
        year = kb.nextInt();
        System.out.println("Please Enter month: ");
        kb.nextLine();
        System.out.println("Please Enter day: ");
        month = kb.nextInt();
        kb.nextLine();
        day = kb.nextInt();
        kb.nextLine();
        System.out.println("Please Enter hour name: ");
        hour = kb.nextInt();
        kb.nextLine();
        System.out.println("Please Enter minute: ");
        minute = kb.nextInt();
        kb.nextLine();

        travel.createTravelMethod(airline, departure, arrival, year, month, day, hour, minute, lineNumber);
    }

    public static void cruiseCreate(){

        travel2 = new SeaTravelFactory();

        System.out.println("Enter Cruise company name: ");

        Scanner kb = new Scanner(System.in);
        travel2.createCompany(kb.nextLine());


    }

    public static void portCreate(){

        Scanner kb = new Scanner(System.in);

        System.out.println("Enter port name: ");

        travel2.createTransport(kb.nextLine());

    }

    public static void tripCreate(){

        Scanner kb = new Scanner(System.in);
        String cruise, departure, arrival, lineNumber;
        int year, month, day, hour, minute;


        System.out.println("Enter the cruise name: ");
        cruise = kb.nextLine();
        System.out.println("Enter the departure port: ");
        departure = kb.nextLine();
        System.out.println("Enter the arrival port: ");
        arrival = kb.nextLine();
        System.out.println("Enter the line number: ");
        lineNumber = kb.nextLine();
        System.out.println("Enter the year of departure: ");
        year = kb.nextInt();
        kb.nextLine();
        System.out.println("Enter the month of departure: ");
        month = kb.nextInt();
        kb.nextLine();
        System.out.println("Enter the day of departure: ");
        day = kb.nextInt();
        kb.nextLine();
        System.out.println("Enter hour of departure: ");
        hour = kb.nextInt();
        kb.nextLine();
        System.out.println("Enter minute of departure: ");
        minute = kb.nextInt();
        kb.nextLine();

        travel2.createTravelMethod(cruise, departure, arrival, year, month, day, hour, minute, lineNumber);

    }

    public static void shipCreate(){

        //travel2.

    }

    public static void displayCruiseLineStat(){

        System.out.println(travel2.displaySystemDetails());

    }

}