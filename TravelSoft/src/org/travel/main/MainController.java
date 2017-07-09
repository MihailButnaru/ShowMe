
package org.travel.main;

import java.awt.Desktop;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.ImageView;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

/**
    * author MIHAIL BUTNARU
    * The Main Controller which connects with carScene and PlaneScene
 */
public class MainController implements Initializable {

    @FXML private ImageView imageID;
    @FXML private Button carID;
    @FXML private Button flightID;
    @FXML private Button linkedIn;
    @FXML private Button github;


    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
    @FXML
    private void carAction(ActionEvent event) throws IOException {
        Parent windowCar;
        windowCar = FXMLLoader.load(getClass().getResource("/org/travel/car/Car.fxml"));
        
        Scene newScene;
        newScene = new Scene(windowCar);
        
        Stage mainWindow;
        mainWindow = (Stage)((Node)event.getSource()).getScene().getWindow();
        mainWindow.setScene(newScene);
        mainWindow.show();
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
            Desktop.getDesktop().browse(new URI("https://github.com/MihailButnaru"));
        }
    }
    
}
