/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hotelmanagementsystem;

import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Mohammed2
 */
public class Login_EmployeeController implements Initializable {

    @FXML
    private TextField username;
    @FXML
    private TextField pass;
    @FXML
    private Button login;
    @FXML
    private Button ex;
    public static Connection conn;
    PreparedStatement pst = null;

    ResultSet rs = null;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        conn = db.java_db();
    }

    @FXML
    private void login(ActionEvent event) {
        String user = username.getText();
        String passw = pass.getText();
        if ((user.length() != 0) && (passw.length() != 0)) {
            String sql = "select * from EMPLOYEE Where (USERNAME =? and PASSWORD =?)";
            try {
                int count = 0;
                conn = db.java_db();
                pst = conn.prepareStatement(sql);
                pst.setString(1, user);
                pst.setString(2, passw);
                rs = pst.executeQuery();
                if (rs.next()) {
                    Alert a = new Alert(Alert.AlertType.CONFIRMATION);
                    a.setTitle("Scecess");
                    a.setContentText("تمت العملية سيتم تحويلك الة لوحة التحكم ");
                    String nameE = username.getText();
                    Employee.Ename = nameE;
                    a.show();
                    rs.close();
                    pst.close();
                    try {
                        Parent blah = FXMLLoader.load(getClass().getResource("Show_guests.fxml"));
                        Scene scene = new Scene(blah);
                        Stage appStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
                        appStage.setScene(scene);
                        appStage.show();
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                } else {
                    Alert a = new Alert(Alert.AlertType.ERROR);
                    a.setTitle("Error");
                    a.setContentText("ادخال خاطأ ");
                    a.show();
                }

            } catch (Exception e) {
            }

        } else {

            Alert a = new Alert(Alert.AlertType.ERROR);
            a.setTitle("Error");
            a.setContentText("الرجاء ملء جميع الجقول ");
            a.show();

        }

    }

    @FXML
    private void esit(ActionEvent event) {

    }

}
