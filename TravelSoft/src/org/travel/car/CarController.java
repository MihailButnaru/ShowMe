package org.travel.car;

import com.lynden.gmapsfx.GoogleMapView;
import com.lynden.gmapsfx.MapComponentInitializedListener;
import com.lynden.gmapsfx.javascript.object.DirectionsPane;
import com.lynden.gmapsfx.javascript.object.GoogleMap;
import com.lynden.gmapsfx.javascript.object.LatLong;
import com.lynden.gmapsfx.javascript.object.MapOptions;
import com.lynden.gmapsfx.javascript.object.MapTypeIdEnum;
import com.lynden.gmapsfx.service.directions.DirectionStatus;
import com.lynden.gmapsfx.service.directions.DirectionsRenderer;
import com.lynden.gmapsfx.service.directions.DirectionsRequest;
import com.lynden.gmapsfx.service.directions.DirectionsResult;
import com.lynden.gmapsfx.service.directions.DirectionsService;
import com.lynden.gmapsfx.service.directions.DirectionsServiceCallback;
import com.lynden.gmapsfx.service.directions.TravelModes;
import com.lynden.gmapsfx.javascript.JavascriptObject;
import java.awt.Desktop;


import java.io.IOException;
import static java.lang.Integer.parseInt;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.Optional;

import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;

import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;

import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import javafx.stage.Modality;
import javafx.stage.Stage;

/**
 * @author MIHAIL BUTNARU
 */
public class CarController extends JavascriptObject implements Initializable, MapComponentInitializedListener, DirectionsServiceCallback {
    @FXML private TextField startTextID;
    @FXML private TextField endTextID;
    @FXML private Button calculateID;
    @FXML private Label labelID;        //Display the Distance (KM)
    @FXML private Label timeID;             //It display the Distance Time
    @FXML private Label litrlesID;              //It displays the fuel(litres)
    @FXML private Label costID;                 //Displays the cost of the fuel(it uses an API)
    @FXML private Pane mapID;                   //Pane for the MAP
    @FXML private TextField mpgID;              //MPG MILES PER GALLON
    
    //Fuel Choice
    @FXML private ComboBox choiceID;
    ObservableList<String> choice = FXCollections.observableArrayList("Diesel", "Petrol");
    
    ///Map Details
    protected DirectionsService directionsService;
    protected DirectionsPane directionsPane;
    private GoogleMap map;
    private DirectionsRenderer directionsRenderer = null;
    @FXML protected GoogleMapView mapView;

    protected  String language;
    protected  String region;
    protected String key;
    
    @FXML private Label fromID;
    @FXML private Label toID;
    @FXML private Button closeID;
    @FXML private Button menuID;
    @FXML private Button linkedIn;
    @FXML private Button github;
   

    @Override
    public void directionsReceived(DirectionsResult results, DirectionStatus status) {
    }
    
    @Override
    public void mapInitialized() {
        MapOptions options = new MapOptions();

        options.center(new LatLong(51.49506473, -0.12359619))
                .zoomControl(false)
                .zoom(7)
                .overviewMapControl(false)
                .panControl(false)
                .scaleControl(false)
                .streetViewControl(false)
                .overviewMapControl(false)
                .mapTypeControl(false)
                .overviewMapControl(false)
                .mapType(MapTypeIdEnum.ROADMAP);
        GoogleMap map = mapView.createMap(options);
        directionsService = new DirectionsService();
        directionsPane = mapView.getDirec();
        
    }


    

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        //It initilize the diesel first
       choiceID.setItems(choice);
       choiceID.getSelectionModel().select("Diesel");
       
       //It initilizing the googleMap
        mapView.addMapInializedListener(this);       
        
    } 
    
    //Method calculates everything and it displays all the information search by the user.
    @FXML
    private void CalculateAction(ActionEvent event) throws IOException  {
        
       //Is initilizing a new map before loading another thing for deleting the old search
       mapInitialized(); 
       
       //AlertMPG
       Alert mpgAlert = null;
        
       DataApi dataAp = new DataApi();
       
       //Getting the startLocation and endLocation
       String startLocation = startTextID.getText();
       String endLocation = endTextID.getText();
       String mpg =  mpgID.getText();
       
       //Rules allows just string not numbers for search a location
       String txtFormat = "[a-zA-Z\\s]{1,30}";  // It checks for any numbers
       String test = "^\\d*";
       String test11 = "";
       
       if(!startLocation.matches(txtFormat)){
           System.out.println("Error start location"); // It will be a popup designed in a cool way
       }else if(!endLocation.matches(txtFormat)){
           System.out.println("Error end Location"); // Popup design in a cool way
       }else if(!mpg.matches(test) || mpg.matches(test11)){
            Stage stage = null;
             Parent root = null;
            stage = new Stage();
            root = FXMLLoader.load(getClass().getResource("/org/travel/mpg/mpgDesign.fxml"));
            stage.setScene(new Scene(root));
            stage.initModality(Modality.APPLICATION_MODAL);
            stage.setResizable(false);
            stage.showAndWait();
            
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
            
            labelID.setText(distance);
            
            //Getting the travelTime
            String timeTravel = carAp.displayTime(startName, endName);
            timeID.setText(timeTravel);
            
            //Calculates Litres
            String calc = distanceNumber[0];
            int convertingTheLitres = (int) calculateLitres(calc);
            String test1 = String.valueOf(convertingTheLitres);
            litrlesID.setText(test1);
            String valueFuel = (String) choiceID.getValue();
            
            //Test Directions
            fromID.setText(startTextID.getText());
            toID.setText(endTextID.getText());

            
            if(valueFuel.equals("Diesel")){
            //Display the diesel Price
            String litres = litrlesID.getText();
            PriceApi fuel = new PriceApi();
            int fuelChoice = Integer.parseInt(litres);
            double fuelPrice = (double) fuelChoice * (double)fuel.fuelDiesel();
            int fuelPrice1 = (int) fuelPrice;
            String fuelPriceLabel = String.valueOf(fuelPrice1);
            costID.setText(fuelPriceLabel);
            litrlesID.setText(test1 + " litres");
            
            }else if(valueFuel.equals("Petrol")){
            //Display petrol Price
            String litres = litrlesID.getText();
            PriceApi fuel = new PriceApi();
            int fuelChoice = Integer.parseInt(litres);
            double fuelPrice = (double) fuelChoice * (double)fuel.fuelPetrol();
            int fuelPrice1 = (int) fuelPrice;
            String fuelPriceLabel = String.valueOf(fuelPrice1);
            costID.setText(fuelPriceLabel);
            litrlesID.setText(test1 + " litres");
            }else{
                
            }
            
            //Map Derections
           DirectionsRequest request = new DirectionsRequest(startLocation, endLocation, TravelModes.DRIVING);
           directionsRenderer = new DirectionsRenderer(true, mapView.getMap(), directionsPane);
           directionsService.getRoute(request, this, directionsRenderer);  
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
            double calculated = (finalCalculation * litres)/100;
            
            return calculated;
            
    }   

    @FXML
    private void closeIDButton(ActionEvent event) {
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Exit Confirmation!");
        alert.setHeaderText("Are you leaving?");
        ButtonType yes = new ButtonType("Yes");
        ButtonType no = new ButtonType("No");
        alert.getButtonTypes().setAll(yes,no);
        Optional<ButtonType> result = alert.showAndWait();
        
        if(result.isPresent() && (result.get() == yes)){
           Stage stage = (Stage) closeID.getScene().getWindow();
           stage.close();
        }       
        
    }

    @FXML
    private void menuButton(ActionEvent event) throws IOException{
        Parent windowMenu;       //It loads the layout provided bellow
        windowMenu = FXMLLoader.load(getClass().getResource("/org/travel/main/Main.fxml"));
        
        Scene newScene = new Scene(windowMenu);
        
        Stage mainWindow;           //New Stage
        mainWindow = (Stage)((Node)event.getSource()).getScene().getWindow();
        mainWindow.setScene(newScene);
        mainWindow.show();
    }

    @FXML
    private void linkedInButton(ActionEvent event) throws URISyntaxException, IOException {
        if(Desktop.isDesktopSupported()){
            Desktop.getDesktop().browse(new URI("https://www.linkedin.com/in/mihail-butnaru-a15347a1/"));
        }
    }

    @FXML
    private void gitHubButton(ActionEvent event) throws URISyntaxException, IOException{
        if(Desktop.isDesktopSupported()){
            Desktop.getDesktop().browse(new URI("https://github.com/MihailButnaru"));
        }
        
    }
}
