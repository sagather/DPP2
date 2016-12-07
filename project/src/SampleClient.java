import java.io.File;
import java.io.FileNotFoundException;

public class SampleClient{

    public static void main(String[] args){

        //Open file
        try{

            File file = FileReader.openFile("file");
            String[] construction = FileReader.readFile(file);

        }
        catch (FileNotFoundException e){

            System.out.println(e.getMessage());

        }



    }


}