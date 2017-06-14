
package org.travel.car;

/**
 *
 * @author MIHAIL BUTNARU
 */

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.net.URL;
import java.util.List;
import com.google.gson.Gson;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.nio.charset.Charset;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class CarApi {
     private static String readAll(Reader rd) throws IOException{
         StringBuilder sb = new StringBuilder();
         int m;
         while((m = rd.read()) != -1){
             sb.append((char) m);
         }
         return sb.toString();
     }
     public static JSONObject readJsonFromUrl(String url) throws IOException, JSONException
     {
         InputStream is = new URL(url).openStream();
         try{
             BufferedReader rd = new BufferedReader(new InputStreamReader(is, Charset.forName("UTF-8")));
             String jsonText = readAll(rd);
             JSONObject json = new JSONObject(jsonText);
             return json;
         }finally{
             is.close();
         }
     }
     
     public static void main(String [] args) throws IOException{
         JSONObject json = readJsonFromUrl("https://maps.googleapis.com/maps/api/directions/json?origin=Disneyland&destination=Universal+Studios+Hollywood4&key=AIzaSyC62daLUcu1lxrLXbc1RjapmU2dDA_AIIY");
//         System.out.println(json.toString());
         
         JSONArray jsonarr = json.getJSONArray("routes");
         JSONObject json1 = jsonarr.getJSONObject(0);
         JSONArray jsonarr1 = json1.getJSONArray("legs");
         JSONObject json2 = jsonarr1.getJSONObject(0);
         JSONObject json3 = json2.getJSONObject("distance");
         String distance = json3.getString("text");
         
         System.out.println(jsonarr);
         System.out.println(json1);
         System.out.println(jsonarr1);
         System.out.println(distance);
     
     }



}
