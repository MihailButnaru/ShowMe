

package org.travel.plane;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.charset.Charset;
import org.json.JSONException;
import org.json.JSONObject;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

/**
 *
 * @author MIHAIL BUTNARU
 */
public class DataApi {
    public String pricesFlight(String start, String end){
        try{
            Document doc = Jsoup.connect("https://www.travelsupermarket.com/en-gb/flight-search/#/result?originplace="+start+"&destinationplace="+end+"&outbounddate=2017-08-30&inbounddate=&cabinclass=Economy&adults=1&children=0&infants=0").get();
            Elements test = doc.getAllElements();
            String[] list = new String[test.size()];
            for(int i = 0; i < test.size(); i++){
                list[i] = test.get(i).text();
                System.out.println(list[i]);
            }
            String test1 = list[0];
            return test1;
            
                  
        }catch(IOException e){
            
        }
        return null;
    }
//    public static String dataFromUrl() throws IOException{
//        String line = null;
//        String response;
//        URL url1 = new URL("https://www.travelsupermarket.com/en-gb/flight-search/#/result?originplace=London&destinationplace=Nantes&outbounddate=2017-08-30&inbounddate=&cabinclass=Economy&adults=1&children=0&infants=0");
//        HttpURLConnection conn = (HttpURLConnection) url1.openConnection();
//        BufferedReader rd = new BufferedReader(new InputStreamReader(conn.getInputStream()));
//        while(rd.readLine() != null){
//            line += rd.readLine();
//            if(line.equals("div")){
//            System.out.println("test");
//        }
//        }
//        return line;
//    }
    
  public static void main(String[] args) throws IOException{
            Document doc = Jsoup.connect("https://www.edreams.co.uk/travel/flights/#/results/type=O;dep=2017-08-24;from=LON;to=KIV;collectionmethod=false;airlinescodes=false;internalSearch=true").get();
            Elements test = doc.getAllElements();
             String test1 = null;
            for(Element element : test.select("body")){
               
               System.out.println(element);
            }
             System.out.println(test1);
           
            
  }
}
