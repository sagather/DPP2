import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

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

        displayUI();



    }

    public static void displayUI(){

        int choice = 0;
        Scanner kb = new Scanner(System.in);

        System.out.println("------------Air Travel Options---------------");
        System.out.println("\n1:  Create a new Airport");
        System.out.println("2:  Create a new Airline");
        System.out.println("3:  Create a new Flight");
        System.out.println("4:  Display Current State");
        System.out.println();
        System.out.println("------------Sea Travel Options----------------");
        System.out.println("\n5:  Create a new Cruise");
        System.out.println("6:  Create a new Port");
        System.out.println("7:  Create a new Trip");
        System.out.println("8:  Create a new Ship");
        System.out.println("9:  Display Current State");
        System.out.println();
        System.out.println("------Choose your fate (enter 0 to quit)------");

        choice = kb.nextInt();

        while(choice >  9){

            System.out.println("That is not a valid response.");
            choice = kb.nextInt();

        }

        if(choice == 0){

            System.exit(0);

        }

    }


}