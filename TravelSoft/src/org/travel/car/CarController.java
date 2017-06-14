package org.travel.car;

import java.awt.event.KeyEvent;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
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

    @Override
    public void initialize(URL url, ResourceBundle rb) {
       
        
    } 
    

    @FXML
    private void CalculateAction(ActionEvent event) throws IOException  {
        
       DataApi dataAp = new DataApi();
       
       //Getting the startLocation and endLocation
       String startLocation = startTextID.getText();
       String endLocation = endTextID.getText();
       
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
      
    }

   
    
}
