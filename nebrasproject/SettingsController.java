/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nebrasproject;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author dan7b
 */
public class SettingsController implements Initializable {

    @FXML
    private Button btnProfile;
    @FXML
    private Button btnHwo;
    @FXML
    private Button btnMain;
    @FXML
    private Button btnLogout;
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
    private void Profile(ActionEvent event) {
    }

    @FXML
    private void HwoAreWe(ActionEvent event) {
    }

    @FXML
    private void Main(ActionEvent event) {
    }

    @FXML
    private void Logout(ActionEvent event) {
    }

}
