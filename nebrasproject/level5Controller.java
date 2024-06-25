/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nebrasproject;

import java.io.File;
import java.io.IOException;
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
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.stage.Stage;

/**
 *
 * @author Ahlam
 */
public class level5Controller implements Initializable {
    
    @FXML
    private Button fx1;
    @FXML
    private Button fx2;
    @FXML
    private Button fx3;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }  
    String pathcorrect = "C:\\Users\\loome\\OneDrive\\المستندات\\NetBeansProjects\\JavaFXProject\\correct.m4a";
    String pathwrong = "C:\\Users\\loome\\OneDrive\\المستندات\\NetBeansProjects\\JavaFXProject\\wrong.m4a";

    
    Media correct = new Media(new File(pathcorrect).toURI().toString() );
    MediaPlayer correctobj = new MediaPlayer(correct);
    
    Media wrong = new Media(new File(pathwrong).toURI().toString() );
    MediaPlayer wrongobj = new MediaPlayer(wrong);
    
    @FXML
    private void goToPage2(ActionEvent event) throws IOException, InterruptedException {
        
        Parent FXMLDocumentControllerpage = FXMLLoader.load(getClass().getResource("FXMLpage2.fxml"));
        Scene FXMLDocumentControllerpageScene = new Scene (FXMLDocumentControllerpage);
        Stage appStage = (Stage)((Node)event.getSource()).getScene().getWindow();
        appStage.setScene(FXMLDocumentControllerpageScene);
        appStage.show();
    }
    
    @FXML
    private void butfx1(ActionEvent event) throws IOException, InterruptedException {
       wrongobj.play(); 
    }
    
    @FXML
     private void butfx2(ActionEvent event) throws IOException, InterruptedException {
        correctobj.play();
    }
     
     @FXML
      private void butfx3(ActionEvent event) throws IOException, InterruptedException {
         wrongobj.play(); 
    }
    
}
