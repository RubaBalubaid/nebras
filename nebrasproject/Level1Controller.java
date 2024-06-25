/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nebrasproject;

import java.io.File;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.shape.Rectangle;

/**
 * FXML Controller class
 *
 * @author Ruba Balubaid
 */
public class Level1Controller implements Initializable {

    /**
     * Initializes the controller class.
     */
    
    @FXML
    Rectangle makkah = new Rectangle();
    
    @FXML
    Rectangle false1 = new Rectangle();
    
    @FXML
    Rectangle false2 = new Rectangle();
    
    @FXML
    Rectangle false3 = new Rectangle();
    
    @FXML
    Rectangle false4 = new Rectangle();
    
    String pathcorrect = "C:\\Users\\ACER\\Documents\\NetBeansProjects\\nebras\\correct.m4a";
    String pathwrong = "C:\\Users\\ACER\\Documents\\NetBeansProjects\\nebras\\wrong.m4a";

    
    Media correct = new Media(new File(pathcorrect).toURI().toString() );
    MediaPlayer correctobj = new MediaPlayer(correct);
    
    Media wrong = new Media(new File(pathwrong).toURI().toString() );
    MediaPlayer wrongobj = new MediaPlayer(wrong);
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        
    }

    @FXML
    public void trueAns(){
        makkah.setOnMousePressed(e ->{
            correctobj.play();
        });
    }

   @FXML
    public void falseAns(){
        false1.setOnMousePressed(e ->{
            wrongobj.play();
        });
        false2.setOnMousePressed(e ->{
            wrongobj.play();
        });
        false3.setOnMousePressed(e ->{
            wrongobj.play();
        });
        false4.setOnMousePressed(e ->{
            wrongobj.play();
        });
    } 
    
}
