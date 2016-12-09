import airtravel.SeatClass;

/**
 * Created by bcxtr on 12/7/2016.
 */
public abstract class TravelFactory {

    public abstract void createTransport(String s);

    public abstract void  createCompany(String s);

    public abstract void createTravelMethod(String transport, String departure, String arrival, int year, int month, int day, int hour, int minute, String lineNumber);

    public abstract void createSection(String iAirline, String iFlightNumber, int iRow, char iCols, SeatClass iClass);

    public abstract void bookSpecific(String iAirline, String iFlight, SeatClass iClass, int iRow, char iSeat);

    public abstract void bookPreference(String iAirline, String iFlight, SeatClass iClass, char iSeat);

    public abstract String getAirlineName(int index);
}

