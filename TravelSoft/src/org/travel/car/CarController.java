package org.travel.car;

import java.awt.event.KeyEvent;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
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

    @Override
    public void initialize(URL url, ResourceBundle rb) {
       
        
    } 
    

    @FXML
    private void CalculateAction(ActionEvent event) {
        
       DataApi dataAp = new DataApi();
       
       //Getting the startLocation and endLocation
       String startLocation = startTextID.getText();
       String endLocation = endTextID.getText();
       
       //Setting the start and endLocatoin
       dataAp.setStartAddress(startLocation);
       dataAp.setEndAddress(endLocation);

       
    }

   
    
}
