package nebrasproject;
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;

/**
 * FXML Controller class
 *
 * @author wed-a
 */
public class Level4Controller implements Initializable {

    @FXML
    private TextField fieldNum;
    @FXML
    private Button enterBtn;
    @FXML
    private Label q1;
    @FXML
    private Label q1pt2;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        
        
        
    }
         String pathcorrect = "C:\\Users\\wed-a\\OneDrive\\Documents\\NetBeansProjects\\projectfx\\correct.m4a";
    String pathwrong = "C:\\Users\\wed-a\\OneDrive\\Documents\\NetBeansProjects\\projectfx\\wrong.m4a";

    
    Media correct = new Media(new File(pathcorrect).toURI().toString() );
    MediaPlayer correctobj = new MediaPlayer(correct);
    
    Media wrong = new Media(new File(pathwrong).toURI().toString() );
    MediaPlayer wrongobj = new MediaPlayer(wrong);
    
    @FXML
    private void enterBtn(ActionEvent event) throws IOException, InterruptedException {
        correctobj.play(); 
    }
    }    
    

