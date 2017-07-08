/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.travel.main;

import java.awt.Desktop;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
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
    @FXML private Button github;

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

    //LinkedIn
    @FXML
    private void linkedInButton(ActionEvent event) throws URISyntaxException, IOException {
        if(Desktop.isDesktopSupported()){
            Desktop.getDesktop().browse(new URI("https://www.linkedin.com/in/mihail-butnaru-a15347a1/"));
        }
    }
    
    //GitHub
    @FXML
    private void githubButton(ActionEvent event) throws URISyntaxException, IOException {
        if(Desktop.isDesktopSupported()){
            Desktop.getDesktop().browse(new URI(""));
        }
    }
    
}
