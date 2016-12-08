import java.util.ArrayList;

/**
 * Created by bcxtr on 12/8/2016.
 */
public class FileParser {

    private static String[] airports = new String[4];
    private String[] airlines = new String[8];

    public static void parseAirports(ArrayList<String> input){

        String interim = input.get(0);
        interim = interim.substring(1, interim.length() - 1);
        airports = interim.split(", ");

        //debug section
        print();


    }

    public static void print(){

        for(String s: airports){
            System.out.println(s);
        }

    }


}
