
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
import javafx.stage.Stage;
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
    @FXML private Button close;


    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
    @FXML
    private void carAction(ActionEvent event) throws IOException {
        //CarScene
        Parent windowCar;       //It loads the layout provided bellow
        windowCar = FXMLLoader.load(getClass().getResource("/org/travel/car/Car.fxml"));
        
        Scene newScene = new Scene(windowCar);
        
        Stage mainWindow;           //New Stage
        mainWindow = (Stage)((Node)event.getSource()).getScene().getWindow();
        mainWindow.setScene(newScene);
        mainWindow.show();
    }

    @FXML
    private void flightAction(ActionEvent event) throws IOException{
        //PlaneScene
        
//        Parent windowPlane;
//        windowPlane = FXMLLoader.load(getClass().getResource(""));
//        
//        Scene newScene;
//        newScene = new Scene(windowPlane);
//        
//        Stage planeStage;
//        planeStage = (Stage)((Node)event.getSource()).getScene().getWindow();
//        planeStage.setScene(newScene);
//        planeStage.show();
    }

    //LinkedIn
    @FXML
    private void linkedInButton(ActionEvent event) throws URISyntaxException, IOException {
        //Opens the default browser with the link provided.
        if(Desktop.isDesktopSupported()){
            Desktop.getDesktop().browse(new URI("https://www.linkedin.com/in/mihail-butnaru-a15347a1/"));
        }else{
            System.out.println("error");
        }
    }
    
    //GitHub
    @FXML
    private void githubButton(ActionEvent event) throws URISyntaxException, IOException {
        if(Desktop.isDesktopSupported()){
            Desktop.getDesktop().browse(new URI("https://github.com/MihailButnaru"));
        }
    }

    @FXML
    private void closeButton(ActionEvent event) {
        
    }
    
}
