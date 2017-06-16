
package org.travel.car;
/**
 *
 * @author MIHAIL BUTNARU
 */
import java.io.IOException;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

public class PriceApi {
 
    //is getting the average petrol Price
    public double fuelPetrol(){
        try {
            Document doc = Jsoup.connect("https://www.petrolprices.com/").get();
            Elements test = doc.select("body").select("section").select("div").select("tbody").select("td");
            String[] list = new String[test.size()];
            for (int i = 0; i < test.size(); i++) {
                list[i] = test.get(i).text();
            }

            String petrolPrice = list[0];
            double currentPetrolPrice = Double.parseDouble(petrolPrice);
            double convertPrice1 = currentPetrolPrice / 100;
            return convertPrice1;

        } catch (IOException e) {
            e.printStackTrace();
        }
        return 0;
    }
    
    //Is getting the average diesel Price
    public double fuelDiesel(){
        try {
            Document doc = Jsoup.connect("https://www.petrolprices.com/").get();
            Elements test = doc.select("body").select("section").select("div").select("tbody").select("td");
            String[] list = new String[test.size()];
            for (int i = 0; i < test.size(); i++) {
                list[i] = test.get(i).text();
            }

            String dieselPrice = list[3];
            double currentDieselPrice = Double.parseDouble(dieselPrice);
            double convertPrice = currentDieselPrice / 100;
            return convertPrice;

        } catch (IOException e) {
            e.printStackTrace();
        }
        return 0;
    
    }
    

//    public static void main(String [] args){
//        
//       PriceApi api = new PriceApi();
//       double m = api.fuelPetrol();
//       double n = api.fuelDiesel();
//       System.out.println(m);
//       System.out.println(n);
//    }
    
    
}
