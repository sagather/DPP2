import java.io.*;
import java.util.*;

/**
 * Created by bcxtr on 12/7/2016.
 */
//TODO: Sam, create parser for file,output file
    public class FileReader {

    public static File openFile(String fileName) throws FileNotFoundException{

        File inf = new File(fileName);

        if(!inf.exists()){

            throw new FileNotFoundException("This file was not created");

        }

        return inf;

    }

    public static ArrayList<String> readFile(File inFile)throws FileNotFoundException{

        Scanner fileScanner = new Scanner(inFile);
        ArrayList<String> constructions = new ArrayList<>();
        fileScanner.useDelimiter("\\{");

        while(fileScanner.hasNext()){

            constructions.add(fileScanner.next());

        }

        fileScanner.close();

        return constructions;

    }

    public void writeToFile(String output){

        try{
            PrintWriter writer = new PrintWriter("output.txt");
            writer.write(output);
        }
        catch(FileNotFoundException e){

            System.out.println("For some reason the file was not found or created");
        }




    }


}
