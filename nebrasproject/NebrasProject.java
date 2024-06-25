/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nebrasproject;

import java.lang.reflect.InvocationTargetException;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

/**
 *
 * @author Nebras team
 */
public class NebrasProject extends Application {
    
    @Override
    public void start(Stage primaryStage)  throws InvocationTargetException {
        try {
        // Code that may throw an exception
//        FXMLLoader loader = new FXMLLoader(getClass().getResource("welcome.fxml"));
//loader.setController(new WelcomeController());
//Pane root = loader.load();
        Parent root = FXMLLoader.load(getClass().getResource("welcome.fxml"));
        primaryStage.setTitle("نبراس");
        Scene scene = new Scene(root);
        primaryStage.setScene(scene);
        primaryStage.show();
        
    } catch (Exception e) {
        // Catch the exception and wrap it in an InvocationTargetException
        throw new InvocationTargetException(e);
    }
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}
