/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hotelmanagementsystem;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Mohammed2
 */
public class Manger_SystemController implements Initializable {

    @FXML
    private TextField username;
    @FXML
    private TextField Pass;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

    @FXML
    private void login(ActionEvent event) {
        if (username.getText().equalsIgnoreCase("admin") && Pass.getText().equalsIgnoreCase("123456")) {
            try {
                Parent blah = FXMLLoader.load(getClass().getResource("Manger2.fxml"));
                Scene scene = new Scene(blah);
                Stage appStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
                appStage.setScene(scene);
                appStage.show();
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        } else {
            FileO.alert("خطأ في كملة المرور  الكلمة الافتراضية هي admin وكلمة السر 123456");

        }
    }

    @FXML
    private void cancel(ActionEvent event) {
        System.exit(0);
    }

}
