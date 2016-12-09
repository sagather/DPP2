import java.util.ArrayList;
import java.util.regex.Pattern;

/**
 * Created by bcxtr on 12/8/2016.
 */
public class FileParser {

    private static String[] airports;
    private static String[] airlines;
    private static String flights = "";
    private static String dates = "";
    private static String dep = "";
    private static String arr = "";
    private static String seats = "";
    private static String interim;

    public static String[] parseAirports(ArrayList<String> input){

        String interim = input.get(0);
        interim = interim.substring(1, interim.length() - 1);
        airports = interim.split(", ");

        return airports;

    }

    public static String[] parseAirlines(ArrayList<String> input){

        interim = input.get(0);
        interim = interim.substring(0, interim.length() - 1);
        String[] inBetween = interim.split("\\], ");

        interim = "";

        for(String s : inBetween){

            interim = interim + s + "[";

        }

        inBetween = interim.split("\\[");
        interim = inBetween[0] + " " + inBetween[5];
        airlines = interim.split(" ");
        interim = "";

        for(int i = 1; i < inBetween.length; i++){

            if(i == 5){
                i++;
            }

            interim = interim + inBetween[i] + "|";

        }

        return airlines;

    }

    public static void parse(){

        String[] inBetween = interim.split("\\|");

        for(int i = 0; i < inBetween.length; i= i + 5){

            flights += inBetween[i] + " ";
            dates += inBetween[i+1] + " ";
            dep += inBetween[i + 2] + " ";
            arr += inBetween[i +3] + " ";
            seats += inBetween[i+4] + " ";

        }

        inBetween = dates.split(", ");
        dates = "";

        for(String s :inBetween){

            dates = dates + " " + s;

        }

        dates = dates.substring(2);

    }

    public static String[] parseFlights(){

        parse();
        return flights.split(" ");
    }

    public static String[] parseDates(){

        parse();
        return dates.split(" ");
    }

    public static String[] parseDepartures(){

        parse();
        return dep.split(" ");
    }

    public static String[] parseArrivals(){

        parse();
        return arr.split(" ");         }

    public static String[] parseSeats(){

        parse();
        return seats.split(",");       }

    public static void print(){

        System.out.println(flights);
        System.out.println(dates);
        System.out.println(dep);
        System.out.println(arr);
        System.out.println(seats);

    }


}
