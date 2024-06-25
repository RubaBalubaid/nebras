package nebrasproject;
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


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
import javafx.scene.control.TextField;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author dan7b
 */
public class LogInController implements Initializable {

    @FXML
    private TextField txtEmail;
    @FXML
    private TextField txtPassword;
    @FXML
    private Button btnLogin;
    @FXML
    private Button btnMain;
    @FXML
    private Button btnCreate;
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
    private void Login(ActionEvent event) {
    }

    @FXML
    private void Main(ActionEvent event) {
    }

    @FXML
    private void create(ActionEvent event) throws IOException {
        root=FXMLLoader.load(getClass().getResource("Register.fxml"));
        stage=(Stage)((Node)event.getSource()).getScene().getWindow();
        Scene scene=new Scene(root);
        stage.setTitle("reg");
        stage.setScene(scene);
        stage.show();
        
    }
    
}
