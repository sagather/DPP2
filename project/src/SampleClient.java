import airtravel.SeatClass;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class SampleClient{

    static TravelFactory travel;

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
        System.out.println("2:  Change the price of seats in a flight section (Not Fully Implemented)");
        System.out.println("3:  Search for seats (Not Fully Implemented)");
        System.out.println("4:  Change seat class pricing for flight destination [ ] and arrival [ ](Not Fully Implemented) ");
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
            case 1:  createFromFile();
                    break;
            case 2: priceChange();
                    break;
            case 3: searchSeats();
                    break;
            case 4: changeSeatClassPrice();
                    break;
            case 5: bookSpecific();
                    break;
            case 6: //BookPreference();
                    break;
            case 7: System.out.println(travel.displaySystemDetails());
                    break;
            case 8:  writeOutput();
                    break;
            case 9:  displayAdminUI();
                    break;
            case 10:  displayUI();
                    break;
            case 11:  //airportCreate();
                    break;
            case 12:  //airlineCreate();
                    break;
            case 13:  //flightCrete();
                    break;
            case 14:  //displayAirlineStat();
                    break;
            case 15:  //cruiseCreate();
                    break;
            case 16:  //portCreate();
                    break;
            case 17:  //tripCreate();
                    break;
            case 18:  //shipCreate();
                    break;
            case 19:  //displayCruiseLineStat();
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
            for(int i = 0; i < flights.length; i++){
                String airlineName;

                if(i < 2){

                    airlineName = airlines[0];
                }
                else{

                    airlineName = airlines[1];
                }
                travel.createTravelMethod(airlineName, departures[i], arrivals[i], Integer.parseInt(dates[i *5]),
                    Integer.parseInt(dates[(i*5)+1]), Integer.parseInt(dates[(i*5)+2]), Integer.parseInt(dates[(i*5)+3]),
                        Integer.parseInt(dates[(i*5)+4]), flights[i]);

            }
        }
        catch (FileNotFoundException e){

            System.out.println("File was not found" + e.getMessage());
        }
    }

    public static void searchSeats() //Not fully implemented, If time allowed I would create methods within travel factory to check each
    {
        Scanner kb = new Scanner(System.in);
        System.out.println("Please enter desired seat class: ");
        String seatClass = kb.nextLine();
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
    }


    public static void priceChange() {//Not fully implemented, if time allowed I would search through the given associated prices, and swap them as needed
        Scanner kb = new Scanner(System.in);
        System.out.println("Please enter desired section to change the price in (Must be ECONOMY, BUSINESS, or FIRST): ");
        String seatClass = kb.nextLine();
        System.out.println("Please enter desired price: ");
        int price = kb.nextInt();
    }

    public static void changeSeatClassPrice()//Not fully implemented, if time allowed I would search through the given associated prices, and swap them as needed
    {
        Scanner kb = new Scanner(System.in);
        System.out.println("Please enter desired class to change the price in (Must be ECONOMY, BUSINESS, or FIRST): ");
        String seatClass = kb.nextLine();
        System.out.println("Please enter desired price: ");
        int price = kb.nextInt();
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
            char letter = kb.next().charAt(0);
            travel.bookSpecific(iAirline, iFlight, classend, row, letter);
        }
        catch (IllegalArgumentException e)
        {
            System.out.println(e.getMessage());
        }
    }

    public static void writeOutput(){

        FileReader.writeToFile(travel.displaySystemDetails());

    }

}