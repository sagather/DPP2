/**
 * Created by Megan Ostby on 12/6/2016.
 */
public class BookingFactory
{
    public void bookTravel(String type)
    {

        TravelFactory newTravel;
        //lolhiyo

        switch (type)
        {
            case "Air travel":
                newTravel = new AirTravelFactory();
                break;
            case "Cruise":
                newTravel = new SeaTravelFactory();
                break;
            case "Train":
                newTravel = new LandTravelFactory();
                break;
        }

    }
}
