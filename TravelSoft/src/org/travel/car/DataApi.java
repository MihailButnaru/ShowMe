
package org.travel.car;

/**
 *
 * @author MIHAIL BUTNARU
 */
public class DataApi {
    private String distanceMiles;
    private String duration;
    private String startAddress;
    private String endAddress;
    
    public void setDistanceMiles(String distMile){
        distanceMiles = distMile;
    }
    public String getDistanceMiles(){
        return distanceMiles;
    }
    public void setDuration(String dur){
        duration = dur;
    }
    public String getDuration(){
        return duration;
    }
    public void setStartAddress(String add){
        startAddress = add;
    }
    public String getStartAddress(){
        return startAddress;
    }
    public void setEndAddress(String endAres){
        endAddress = endAres;
    }
    public String getEndAddress(){
        return endAddress;
    }
    
    
}
