/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hotelmanagementsystem;

import java.net.URL;
import java.sql.Connection;
import java.util.List;
import java.util.Observable;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javax.swing.JOptionPane;

/**
 * FXML Controller class
 *
 * @author Mohammed2
 */
public class R1Controller implements Initializable {

    @FXML
    private TextField Fname;
    @FXML
    private TextField Lname;
    @FXML
    private ComboBox<String> Genger;
    @FXML
    private TextField phone;
    @FXML
    private TextField address;
    @FXML
    private DatePicker date;
    @FXML
    private Button next;

    /**
     * Initializes the controller class.
     */
    ObservableList<String> list = FXCollections.observableArrayList(
            "Male", "Female"
    );

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        Genger.setItems(list);
    }

    @FXML
    private void next(ActionEvent event) {
        if ((Fname.getText().length() != 0) && (Lname.getText().length() != 0)
                && (phone.getText().length() != 0)
                && (address.getText().length() != 0)) {

            String name = Fname.getText() + Lname.getText();
            String Date = date.getValue().toString();
            String phone = this.phone.getText();
            String addres = address.getText();
            String genger = Genger.getSelectionModel().getSelectedItem().toString();
            Guest newguest = new Guest(name, 0, phone, addres, Date, genger);
            GlobalVariable.guest = newguest;
            GlobalVariable.Gender = genger;
            try {
                Parent blah = FXMLLoader.load(getClass().getResource("R2.fxml"));
                Scene scene = new Scene(blah);
                Stage appStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
                appStage.setScene(scene);
                appStage.show();
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        } else {
            FileO.alert("Please complete all fields");
        }

    }

}
