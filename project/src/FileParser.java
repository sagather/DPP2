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
        String[] inBetween = interim.split("\\], ");

        interim = "";

        for(String s : inBetween){

            interim = interim + s + "[";

        }

        inBetween = interim.split("\\[");
        interim = inBetween[0] + " " + inBetween[5];
        airlines = interim.split(" ");
        interim = "";

        for(int i = 1; i < inBetween.length - 1; i++){

            if(i == 5){
                i++;
            }

            interim = interim + " " + inBetween[i];

        }

        return airlines;

    }

    public static void parseFlight(String[] f){



        print();

    }

    public static void print(){

        for(String s: flights){
            System.out.println(s);
        }

    }


}
