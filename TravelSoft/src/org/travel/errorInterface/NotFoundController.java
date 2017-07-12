
package org.travel.errorInterface;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.stage.Stage;

/**
 * @author MichaelButnaru
 */
public class NotFoundController implements Initializable {

    @FXML private Button close;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void closeButton(ActionEvent event) {
        Stage stage = (Stage) close.getScene().getWindow();
        stage.close();
    }
    
}
