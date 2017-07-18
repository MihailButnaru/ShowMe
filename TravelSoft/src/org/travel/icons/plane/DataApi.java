

package org.travel.icons.plane;

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

/**
 *
 * @author MIHAIL BUTNARU
 */
public class DataApi {
    private static String readAll(Reader rd) throws IOException{
        StringBuilder sb = new StringBuilder();
        int m;
        while((m = rd.read()) != -1){
            sb.append((char)  m);
            
        }
        return sb.toString();
    }
    
    public static String dataFromUrl() throws IOException{
        String line = null;
        String response;
        URL url1 = new URL("https://www.skyscanner.net/transport/flights/lond/pari/170720/cheap-flights-from-london-to-paris.html?adults=1&children=0&adultsv2=1&childrenv2=&infants=0&cabinclass=economy&rtn=0&preferdirects=false&outboundaltsenabled=false&inboundaltsenabled=false&ref=day-view#results");
        HttpURLConnection conn = (HttpURLConnection) url1.openConnection();
        BufferedReader rd = new BufferedReader(new InputStreamReader(conn.getInputStream()));
        while(rd.readLine() != null){
            line += rd.readLine();
        }
        return line;
    }
//    public static JSONObject readJsonFromUrl(String url) throws IOException, JSONException{
//        InputStream is = new URL(url).openStream();
//        URL url1 = new URL("https://www.skyscanner.net/transport/flights/lond/par/170720/cheap-flights-from-London-to-Paris.html?adults=1&children=0&adultsv2=1&childrenv2=&infants=0&cabinclass=economy&rtn=0&preferdirects=false&outboundaltsenabled=false&inboundaltsenabled=false&ref=day-view#results");
////        URL url1 = new URL("http://www.google.com/");
//        HttpURLConnection con = (HttpURLConnection)url1.openConnection();
//       
//        
//        System.out.println(con.getResponseMessage());
//        try{
//            BufferedReader rd = new BufferedReader(new InputStreamReader(is, Charset.forName("UTF-8")));
//            String jsonText = readAll(rd);
//            JSONObject json = new JSONObject(jsonText);
//            return json;
//        }finally{
//            is.close();
//        }
//    }
    public void test1() throws IOException{
//        
        System.out.println(dataFromUrl());        
    }
//    public String displayPrice(String start, String end) throws IOException{
//        try{
//            JSONObject json = readJsonFromUrl("https://www.skyscanner.net/transport/flights/lond/pari/170720/cheap-flights-from-"+start+"-to-"+end+".html?adults=1&children=0&adultsv2=1&childrenv2=&infants=0&cabinclass=economy&rtn=0&preferdirects=false&outboundaltsenabled=false&inboundaltsenabled=false&ref=day-view#results");
//           System.out.println(json);
//           return null;
//            
//
//        }catch(JSONException e){
//            
//        }
//        return null;
//    }
}
