
package org.travel.plane;

import org.travel.plane.Plane;
import org.travel.plane.DataApi;
import java.awt.Desktop;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.time.LocalDate;
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
import javafx.scene.control.DateCell;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import javafx.util.Callback;

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
    @FXML private DatePicker dateID;
    @FXML private DatePicker DateID1;
    @FXML private ComboBox<Integer> passengerID;
    @FXML private ComboBox<String> typeID;

    ObservableList<Integer> passengerNumber = FXCollections.observableArrayList(1,2,3);
    ObservableList<String> flightType = FXCollections.observableArrayList("Economy", "Premium Economy", "Business Class", "First Class");
    
    @FXML private TextField fromID1;
    @FXML private TextField toID1;
    @FXML private ComboBox<Integer> passengerID1;
    @FXML private ComboBox<String> typeID1;
    
    ObservableList<Integer> passengerNumber1 = FXCollections.observableArrayList(1,2,3);
    ObservableList<String> flightType1 = FXCollections.observableArrayList("Economy", "Premium Economy", "Business Class", "First Class");
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        flightID.setVisible(false);
        dateLimit();
        
        //ComboBox Number of Passengers
        passengerID.setItems(passengerNumber);
        passengerID.getSelectionModel().select(0);
        
        //ComboBox Flight Type
        typeID.setItems(flightType);
        typeID.getSelectionModel().select(0);
        
        
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
    private void menuButton(ActionEvent event) throws IOException {
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
    private void gitHubButton(ActionEvent event) throws URISyntaxException, IOException {
        if(Desktop.isDesktopSupported()){
            Desktop.getDesktop().browse(new URI("https://github.com/MihailButnaru"));
        }
    }
    
    //Date Validation ---- The Rule not allowed to pick up date before. Just today
    public void dateLimit(){
        final Callback<DatePicker, DateCell> dayCellFactory;
        dayCellFactory = (final DatePicker datePicker) -> new DateCell(){
            @Override
            public void updateItem(LocalDate item, boolean empty){
                super.updateItem(item, empty);
                if(item.isBefore(LocalDate.now().plusDays(0))){
                    setDisable(true);
                    setStyle("-fx-background-color: #ff4747;");

                }
            }
        };
        dateID.setDayCellFactory(dayCellFactory);
        
    }

    @FXML
    private void search(ActionEvent event) throws IOException{
        
        String from = fromID.getText();
        String to = toID.getText();
        int numberPassengers = passengerID.getValue();
        String flightType = typeID.getValue();
        
        if(dateID.getValue() == null){
            System.out.println("Error!");
  
        }else if(from == null){
            System.out.println("Error");
          
        }else if(to == null){
            System.out.println("Error");
        }else{
            
            DataApi data = new DataApi();
            Plane plane = new Plane();
            plane.setDateFrom(from);
            plane.setDateTo(to);
            plane.setFlightType(flightType);
            plane.setPassengers(numberPassengers);
            
            
           
            flightID.setVisible(true);
        
        
        
        
        //Let's test
        
 
        System.out.println(dateID.getValue());
        }
        
    }
    
    
}
