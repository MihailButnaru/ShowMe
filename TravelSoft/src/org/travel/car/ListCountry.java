
package org.travel.car;

import java.util.Locale;

public class ListCountry {
    public static void main(String [] args){
        ListCountry obj = new ListCountry();
        
        obj.run();
    }
    
    public void run(){
        String[] countries = Locale.getISOCountries();
        
        for(String countryCode : countries){
            Locale obj = new Locale("", countryCode);
            
            System.out.println("Country Code = "+ obj.getCountry() + ", Country Name = " + obj.getDisplayCountry() + ", City Name ");
        }
    }
}
