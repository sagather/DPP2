import java.util.ArrayList;

/**
 * Created by bcxtr on 12/8/2016.
 */
public class FileParser {

    private static String[] airports = new String[4];
    private String[] airlines = new String[8];

    public static void parseAirports(ArrayList<String> input){

        String interim = input.get(0);
        int i = 1;

        while(interim.charAt(i) != ']' && i < airports.length){
            if(interim.charAt(i) == ','){
                i = i+2;
            }
            airports[i] += interim.charAt(i);
        }

        //debug section
        print(input);


    }

    public static void print(ArrayList<String> input){

        for(String s: input){
            System.out.println(s);
        }

    }


}
