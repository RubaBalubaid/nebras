package nebrasproject;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.media.MediaView;

/**
 * FXML Controller class
 *
 * @author Ahlam
 */
public class level3Controller implements Initializable {

    @FXML
    private Button fx4;
    @FXML
    private Button fx5;
    @FXML
    private Button fx6;
    @FXML
    private Button fxt;
    @FXML
    private MediaView mv1;
    @FXML
    private Button fxv;

    /**
     * Initializes the controller class.
     */
    MediaPlayer pathvm1obj;
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        String pathvm = "file:/C:/Users/loome/OneDrive/المستندات/NetBeansProjects/JavaFXProject/IMG_7750.MP4";
        Media pathvm1 = new Media(pathvm);
        pathvm1obj = new MediaPlayer(pathvm1);
        mv1.setMediaPlayer(pathvm1obj);
    }    
    String pathcorrect = "C:\\Users\\loome\\OneDrive\\المستندات\\NetBeansProjects\\JavaFXProject\\correct.m4a";
    String pathwrong = "C:\\Users\\loome\\OneDrive\\المستندات\\NetBeansProjects\\JavaFXProject\\wrong.m4a";

    
    Media correct = new Media(new File(pathcorrect).toURI().toString() );
    MediaPlayer correctobj = new MediaPlayer(correct);
    
    Media wrong = new Media(new File(pathwrong).toURI().toString() );
    MediaPlayer wrongobj = new MediaPlayer(wrong);
     
    @FXML
    private void butfx4(ActionEvent event) throws IOException, InterruptedException {
        correctobj.play(); 
    }
    
    @FXML
     private void butfx5(ActionEvent event) throws IOException, InterruptedException {
        wrongobj.play();
    }
     
     @FXML
      private void butfx6(ActionEvent event) throws IOException, InterruptedException {
         wrongobj.play(); 
    }
      @FXML
      private void butfxv(ActionEvent event) throws IOException, InterruptedException {
         pathvm1obj.play(); 
    }

    @FXML
    private void butV(ActionEvent event) {
    }
}