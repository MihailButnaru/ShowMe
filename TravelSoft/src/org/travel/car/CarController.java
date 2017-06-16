package org.travel.car;

import java.awt.event.KeyEvent;
import java.io.IOException;
import static java.lang.Double.parseDouble;
import static java.lang.Float.parseFloat;
import static java.lang.Integer.parseInt;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.ResourceBundle;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import javafx.scene.text.Text;

/**
 * @author MIHAIL BUTNARU
 */
public class CarController implements Initializable {

    @FXML private TextField startTextID;
    @FXML private TextField endTextID;
    @FXML private Text startID;
    @FXML private Text endID;
    @FXML private CheckBox kmID;
    @FXML private CheckBox milesID;
    @FXML private Button calculateID;
    @FXML private Label labelID;
    @FXML private Label timeID;
    @FXML private Label litrlesID;
    @FXML private Label costID;
    @FXML private Pane mapID;
    @FXML private RadioButton KimID;
    private ChoiceBox engineID;
//    ObservableList<Double> choice = FXCollections.observableArrayList(1.0, 1.5, 1.6, 1.7, 1.8, 2.0,2.2, 2.3, 2.5, 2.6, 2.7, 2.8, 3.0, 3.2, 3.3, 3.5, 3.7, 3.8, 3.9, 4.1, 4.2, 4.4, 4.8, 5.0);
    @FXML private TextField mpgID;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
//       engineID.setItems(choice);
//       engineID.getSelectionModel().select(2.2);
        
    } 
    

    @FXML
    private void CalculateAction(ActionEvent event) throws IOException  {
        
       DataApi dataAp = new DataApi();
       
       //Getting the startLocation and endLocation
       String startLocation = startTextID.getText();
       String endLocation = endTextID.getText();
       
       //Rules allows just string not numbers for search a location
       String txtFormat = "[a-zA-Z\\s]{1,30}";  // It checks for any numbers
       if(!startLocation.matches(txtFormat)){
           System.out.println("Error start location"); // It will be a popup designed in a cool way
       }else if(!endLocation.matches(txtFormat)){
           System.out.println("Error end Location"); // Popup design in a cool way
       }else{
           
           //Setting the start and endLocatoin
            dataAp.setStartAddress(startLocation);
            dataAp.setEndAddress(endLocation);
            
            //Parse the data into the API
            CarApi carAp = new CarApi();
            String startName = dataAp.getStartAddress();
            String endName = dataAp.getEndAddress();
       
            //Getting the distance and split in several strings
            String distance = carAp.displayData(startName,endName);
            String[] distanceNumber = distance.split(" ");
            
            labelID.setText(distanceNumber[0]);
            
            //Getting the travelTime
            String timeTravel = carAp.displayTime(startName, endName);
            timeID.setText(timeTravel);
            
            //Calculates Litres
            String calc = distanceNumber[0];
            int convertingTheLitres = (int) calculateLitres(calc);
            String test1 = String.valueOf(convertingTheLitres);
            litrlesID.setText(test1);
     
       } 
    }
    
    public double calculateLitres(String str){
        
            //MPG Convert To Litres based on the Kilometres 100km
            String convert =  mpgID.getText();
            int convertLitres = parseInt(convert);
            Converter conv = new Converter();
            double litres = conv.convertMPGToLitres(convertLitres);
            
            //Calculating the km / litres to know litres total
            String calc = str;
            String[] calculation1 = calc.split(",");
            String km ="";
            for(int i = 0; i < calculation1.length; i++){
                km = calculation1[i];
                break;
                
            }
            String km1 = "";
            for(int i = 1; i < calculation1.length; i++){
                km1 = calculation1[i];
            }
            String km2 = km + km1;
            int finalCalculation = Integer.parseInt(km2);
            double calculated = finalCalculation / litres;
            
            return calculated;
            
    }


   
    
}
