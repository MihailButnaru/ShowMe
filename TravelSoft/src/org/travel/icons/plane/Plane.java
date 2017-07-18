

package org.travel.icons.plane;

/**
 *
 * @author MIHAIL BUTNARU
 */
public class Plane {
    
    private String from;
    private String to;
    private String dateFrom;
    private String dateTo;
    private Integer passengersNumber;
    private String flightType;
    
    public String getFrom(){
        return from;
    }
    public void setFrom(String fromFlight){
        from = fromFlight;
    }
    
    public String getTo(){
        return to;
    }
    public void setTo(String toFlight){
        to = toFlight;
    }
    
    public String getDateFrom(){
        return dateFrom;
    }
    public String getDateTo(){
        return dateTo;
    }
    public void setDateFrom(String dateFromFlight){
        dateFrom = dateFromFlight;
    }
    public void setDateTo(String dateToFlight){
        dateTo = dateToFlight;
    }

    public int getPassengers(){
        return passengersNumber;
    }
    public void setPassengers(int number){
        passengersNumber = number;
    }
    
    public String getFlightType(){
        return flightType;
    }
    public void setFlightType(String flightTyp){
        flightType = flightTyp;
    }
}
