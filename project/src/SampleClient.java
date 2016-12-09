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
            case 1:  createFromFile();
                    break;
            case 2:
                    break;
            case 3:
                    break;
            case 4:
                    break;
            case 5:
                    break;
            case 6:
                    break;
            case 7:
                    break;
            case 8:
                    break;
            case 9:  displayAdminUI();
                    break;
            case 10:  displayUI();
                    break;
            case 11:
                    break;
            case 12:
                    break;
            case 13:
                    break;
            case 14:
                    break;
            case 15:
                    break;
            case 16:
                    break;
            case 17:
                    break;
            case 18:
                    break;
            case 19:
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

            File file = FileReader.openFile("C:/Users/bcxtr/IdeaProjects/DPP2/project/src/input.txt");
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

                travel.createTravelMethod("transport", departures[i], arrivals[i], Integer.parseInt(dates[i]),
                    Integer.parseInt(dates[i+1]), Integer.parseInt(dates[i+2]), Integer.parseInt(dates[i+3]),
                        Integer.parseInt(dates[i+4]), flights[i]);

            }


        }
        catch (FileNotFoundException e){

            System.out.println(e.getMessage());

        }
    }


}