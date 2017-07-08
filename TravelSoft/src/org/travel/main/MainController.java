/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.travel.main;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.image.ImageView;

/**
 * FXML Controller class
 *
 * @author MichaelButnaru
 */
public class MainController implements Initializable {

    @FXML private ImageView imageID;
    @FXML private Button carID;
    @FXML private Button flightID;
    @FXML private Button linkedIn;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void carAction(ActionEvent event) {
    }

    @FXML
    private void flightAction(ActionEvent event) {
    }

    @FXML
    private void linkedInButton(ActionEvent event) {
    }
    
}
