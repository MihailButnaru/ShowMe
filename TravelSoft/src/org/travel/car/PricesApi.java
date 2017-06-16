
package org.travel.car;

/**
 *
 * @author MIHAIL BUTNARU
 */

import java.io.*;
import java.net.*;
import java.util.ArrayList;
import java.util.Arrays;

public class PricesApi {
    public static void main(String[] args ) throws IOException {
        URL url = new URL("https://www.petrolprices.com/");
        System.setProperty("http.agent", "Chrome");
        
        URLConnection con = url.openConnection();
        InputStream is = con.getInputStream();
        
        BufferedReader br = new BufferedReader(new InputStreamReader(is));
        String line = null;
        String petrol = "<div class=\"col-lg-6 col-md-6  petrol-prices-table\" style=\"margin-top:40px;\">";
//        String removePetrol ="class=\"latest-new-title\">";
        String[] petrol1 = new String[1];
        
        while((line = br.readLine()) != null){
            if(line.contains(petrol)){
                   petrol1[0] = line; 
            }
        }
        
        
        
        }
}
