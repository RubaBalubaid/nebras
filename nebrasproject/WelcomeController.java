/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nebrasproject;

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
import javafx.scene.control.Label;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author wed-a
 */
public class WelcomeController implements Initializable {

    @FXML
    private Button startbtn = new Button("");
    @FXML
    private Label welcomeLabel = new Label("");
    @FXML
    private Parent root;
    @FXML
    private Stage stage;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {

        // TODO
    }

    @FXML
    private void goToLevel4(ActionEvent event) throws IOException {
        root= FXMLLoader.load(getClass().getResource("Level4.fxml"));
        stage=(Stage)((Node)event.getSource()).getScene().getWindow();
        Scene scene = new Scene(root);
        stage.setTitle("level4");
        stage.setScene(scene);
        stage.show();
    }

}
