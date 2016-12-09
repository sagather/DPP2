package seatravel;
//Megan Ostby & Sam Agather
import java.util.ArrayList;

/**
 * Created by bcxtr on 12/7/2016.
 */
public class CabinSection
{
    //Megan Ostby & Sam Agather
    private ArrayList<Cabin> cabins = new ArrayList<Cabin>();
    private CabinClass sClass;
    private int floor;
    private int rmNum;// total number of rooms in the section (must be an even number
    private String cruise;
    private String shipName;
    private char sectType;

    public CabinSection(String iCruiseLine, String iShipName, int floor, int rmNum, CabinClass isClass){
        try{
            if(rmNum % 2 != 0){
                throw new IllegalArgumentException("Number of rooms in the section must be even!");
            }
            else if(floor < 0){
                throw new IllegalArgumentException("Number of floors in the section must be greater than 0!");
            }

            //int seatCols = sectType(cols);
            for(int i = 1; i <= floor; i++){
                int z = 1;
                int typeCount = 1;
                for(int j = 0; j < rmNum; j++){
                    char type = balcOrInner(typeCount);
                    cabins.add(new Cabin(i, z, type));
                    z++;
                    typeCount++;
                    if(typeCount > 4) {
                        typeCount = 1;
                    }
                }
            }

            this.cruise = iCruiseLine;
            this.shipName = iShipName;
            this.sClass = isClass;
            this.floor = floor;
            this.rmNum = rmNum;
        }
        catch(IllegalArgumentException e){
            System.out.println("Cabin section not created. " + e.getMessage());
        }
    }

    public char balcOrInner(int i)
    {
        if (i == 1 || i == 4) //Always 4 rows
        {
            return 'b';
        }
        else
        {
            return 'a';
        }
    }

    public boolean hasAvailableCabins(){
        int i = 0;
        for(Cabin s : cabins){
            if(!s.isAssigned()){
                i++;
            }
        }
        return i>0;
    }

    public Cabin hasAvailableType(char c)
    {
        try {
            int i = 0;
            for (Cabin s : cabins) {
                if (!s.isAssigned() && s.getType() == c) {
                    return s;
                }
            }
        }
        catch (Exception e)
        {
            System.out.println("Something went wrong");
        }
        return null;
    }

    public void bookCabin(int floor, int rmNum, CabinClass iClass){
        try {
            int i = 0;
            for (Cabin s : cabins) {
                if (s.getFloor() == floor) {
                    if (s.getRmNum() == rmNum  && !s.isAssigned())
                    {
                        s.setAssigned();
                        System.out.println("You successfully booked " + this.sClass + ", Cabin. Floor: " + floor + " Room #: "+ rmNum);
                        i++;
                    }
                }
            }
            if (i == 0) {
                throw new IllegalArgumentException("Floor: "+ floor + " Room: " + rmNum+ " was not available. ");
            }
        }
        catch (IllegalArgumentException e)
        {
            System.out.println("Cabin was not booked. " + e.getMessage());
        }
    }

    public String toString(){
        return " For section " + sClass + " there is " + cabins.toString();

    }

    public boolean classCompare(CabinClass iClass){
        if(iClass == sClass){
            return true;
        }
        return false;
    }
}

