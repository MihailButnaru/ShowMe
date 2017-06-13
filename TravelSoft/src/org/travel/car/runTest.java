/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.travel.car;

import java.io.IOException;
import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

/**
 *
 * @author MichaelButnaru
 */
public class runTest extends Application
{
   public void start(Stage primaryStage){
        
       try{
            Parent root = FXMLLoader.load(getClass().getResource("Car.fxml"));
            Scene scene = new Scene(root);
            primaryStage.setResizable(false);
            primaryStage.initStyle(StageStyle.DECORATED);
            primaryStage.setScene(scene);
            primaryStage.show();
        }catch(IOException e){
            e.printStackTrace();
        }
}
    public static void main(String[] args){
        launch(args);
    }
}
