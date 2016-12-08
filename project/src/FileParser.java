import java.util.ArrayList;

/**
 * Created by bcxtr on 12/8/2016.
 */
public class FileParser {

    private static String[] airports = new String[4];
    private static String[] airlines = new String[8];
    private static String[] flights = new String[22];

    public static String[] parseAirports(ArrayList<String> input){

        String interim = input.get(0);
        interim = interim.substring(1, interim.length() - 1);
        airports = interim.split(", ");

        return airports;

    }

    public static String[] parseAirlines(ArrayList<String> input){

        String interim = input.get(0);
        interim = interim.substring(1, interim.length() - 1);
        flights = interim.split(", ");
        parseFlight(flights);

        print();

        return airlines;

    }

    public static void parseFlight(String[] flight){



    }

    public static void print(){

        for(String s: flights){
            System.out.println(s);
        }

    }


}
