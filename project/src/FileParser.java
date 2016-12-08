/**
 * Created by bcxtr on 12/8/2016.
 */
public class FileParser {

    private static String[] airports;
    private String[] airlines;

    public static void parseAirports(String[] input){

        String interim = input[0];
        int i = 1;

        while(interim.charAt(i) != ']'){
            if(interim.charAt(i) == ','){
                i = i+2;
            }
            airports[i] += interim.charAt(i);
            i++;
        }

        //debug section
        print();


    }

    public static void print(){

        for(String s: airports){
            System.out.println(s);
        }

    }


}
