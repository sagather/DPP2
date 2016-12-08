import java.io.*;
import java.util.*;

/**
 * Created by bcxtr on 12/7/2016.
 */
//TODO: Sam, create parser for file,output file
    public class FileReader {

    public static File openFile(String fileName) throws FileNotFoundException{

        File inf = new File(fileName);

        if(inf == null){

            throw new FileNotFoundException("This file was not created");

        }

        return inf;

    }

    public static String[] readFile(File inFile)throws FileNotFoundException{

        Scanner fileScanner = new Scanner(inFile);
        int i = 0;
        String[] constructions = null;

        while(fileScanner.hasNextLine()){

            constructions[i++] = fileScanner.nextLine();

        }

        return constructions;

    }


}
