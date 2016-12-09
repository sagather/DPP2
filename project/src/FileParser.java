import java.util.ArrayList;
import java.util.regex.Pattern;

/**
 * Created by bcxtr on 12/8/2016.
 */
public class FileParser {

    private static String[] airports;
    private static String[] airlines;
    private static String[] flights;

    public static String[] parseAirports(ArrayList<String> input){

        String interim = input.get(0);
        interim = interim.substring(1, interim.length() - 1);
        airports = interim.split(", ");

        return airports;

    }

    public static String[] parseAirlines(ArrayList<String> input){

        String interim = input.get(0);
        interim = interim.substring(0, interim.length() - 1);
        airlines = interim.split("\\], ");



        print();

        return airlines;

    }

    public static void parseFlight(String[] flights){



    }

    public static void print(){

        for(String s: airlines){
            System.out.println(s);
        }

    }


}
