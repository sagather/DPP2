/**
 * Created by Megan Ostby on 12/6/2016.
 */
//Megan Ostby & Sam Agather
public class BookingFactory
{
    public void bookTravel(String type)
    {
        TravelFactory newTravel;
        switch (type)
        {
            case "Air travel":
                newTravel = new AirTravelFactory();
                break;
            case "Cruise":
                newTravel = new SeaTravelFactory();
                break;
        }

    }
}
