

package org.travel.plane;

import java.io.IOException;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

/**
 *
 * @author MIHAIL BUTNARU
 */
public class Test  extends Application{
    
    public void start(Stage primaryStage){
        try{
            Parent root = FXMLLoader.load(getClass().getResource("Plane.fxml"));
            Scene scene = new Scene(root);
            primaryStage.setResizable(false);
            primaryStage.initStyle(StageStyle.UTILITY);
            primaryStage.setScene(scene);
            primaryStage.show();
        }catch(IOException e){
            e.printStackTrace();
        }
    }
    public static void main(String [] args){
        launch(args);
    }

}
