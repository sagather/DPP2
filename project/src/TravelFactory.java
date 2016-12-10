import airtravel.SeatClass;
//Megan Ostby & Sam Agather
/**
 * Created by bcxtr on 12/7/2016.
 */

import airtravel.*;

public abstract class TravelFactory {

    public abstract void createTransport(String s);

    public abstract void  createCompany(String s);

    public abstract void createTravelMethod(String transport, String departure, String arrival, int year, int month, int day, int hour, int minute, String lineNumber);

    public abstract void createSection(String iAirline, String iFlightNumber, int iRow, char iCols, SeatClass iClass, int price);

    public abstract void bookSpecific(String iAirline, String iFlight, SeatClass iClass, int iRow, char iSeat);

    public abstract void bookPreference(String iAirline, String iFlight, SeatClass iClass, char iSeat);

    public abstract void priceChange(String iAirline, String iFlight, int price);

    public abstract void changeSeatClassPrice(String iAirline, String iOrigin, String iDestination, SeatClass iClass, int price);

    public abstract void searchSeats(SeatClass seatClass, String iOrigin, String iDestination, int iMonth, int iDay, int iYear);

    public abstract String getAirlineName(int index);

    public abstract String displaySystemDetails();

}

