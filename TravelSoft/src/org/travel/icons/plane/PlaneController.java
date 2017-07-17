
package org.travel.icons.plane;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;

/**
 * @author MichaelButnaru
 */
public class PlaneController implements Initializable {

    @FXML private Button closeID;
    @FXML private Button menuID;
    @FXML private Button linkedIn;
    @FXML private Button github;
    @FXML private Pane flightBlueID;
    @FXML private Pane flightID;
    @FXML private TextField fromID;
    @FXML private TextField toID;
    @FXML private Button searchID;
    @FXML private Label priceID;
    @FXML private Pane flightID1;
    @FXML private Pane flightID2;

    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        flightID.setVisible(false);
    }    

    @FXML
    private void closeIDButton(ActionEvent event) {
    }

    @FXML
    private void menuButton(ActionEvent event) {
    }

    @FXML
    private void linkedInButton(ActionEvent event) {
    }

    @FXML
    private void gitHubButton(ActionEvent event) {
    }

    @FXML
    private void search(ActionEvent event) {
        
        final String from = fromID.getText();
        final String to = toID.getText();
        flightID.setVisible(true);
        
        
    }
    
    
}
