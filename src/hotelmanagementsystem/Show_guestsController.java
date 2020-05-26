/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hotelmanagementsystem;

import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javax.swing.JOptionPane;

/**
 * FXML Controller class
 *
 * @author Mohammed2
 */
public class Show_guestsController implements Initializable {

    @FXML
    private TableColumn<Guest, Integer> tcid;
    @FXML
    private TableColumn<Guest, String> tcname;
    @FXML
    private TableColumn<Guest, String> tcphone;
    @FXML
    private TableColumn<Guest, String> tcaddress;
    @FXML
    private TableColumn<Guest, String> tcgender;
    @FXML
    private TableColumn<Guest, String> tcberthdate;
    @FXML
    private Button previous;
    @FXML
    private TextField idtxt;
    @FXML
    private TextField nametxt;
    @FXML
    private TextField phonetxt;
    @FXML
    private TextField Birthtxt;
    @FXML
    private TextField addresstxt;
    @FXML
    private TextField gendertxt;
    @FXML
    private Button add;
    @FXML
    private Button Edit;
    @FXML
    private Button Delete;
    @FXML
    private Button Refresh;
    @FXML
    private TableView<Guest> Tabelview;
    db d = new db();
    Statement statement = null;
    ResultSet rs = null;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        try {
            Class.forName("org.sqlite.JDBC");
            Connection conn = DriverManager.getConnection("jdbc:sqlite:hotel_db.sqlite");
            JOptionPane.showMessageDialog(null, "Connection to database is successful");
            this.statement = conn.createStatement();
        } catch (Exception e) {
            System.out.println(e);

        }

        tcid.setCellValueFactory(new PropertyValueFactory("ID"));
        tcname.setCellValueFactory(new PropertyValueFactory("Name"));
        tcphone.setCellValueFactory(new PropertyValueFactory("PhoneNumber"));
        tcaddress.setCellValueFactory(new PropertyValueFactory("Address"));
        tcgender.setCellValueFactory(new PropertyValueFactory("Gender"));
        tcberthdate.setCellValueFactory(new PropertyValueFactory("BirthDate"));
        try {
            try {
                rs = statement.executeQuery("select * from Guest");
                while (rs.next()) {
                    Guest guest = new Guest();
                    guest.setId(rs.getInt("ID"));
                    guest.setName(rs.getString("Name"));
                    guest.setPhone(rs.getString("PhoneNumber"));
                    guest.setAddress(rs.getString("Address"));
                    guest.setGender(rs.getString("Gender"));
                    guest.setBirthday(rs.getString("Birthdate"));
                    String asd = rs.getString("Birthdate");
                    guest.setBirthday(asd);
                    Tabelview.getItems().add(guest);
                }

            } catch (SQLException ex) {
                System.out.println("1-" + ex.getMessage());
            }
        } catch (Exception e) {
            System.out.println(e);
        }

    }

    @FXML
    private void previous(ActionEvent event) {
    }

    @FXML
    private void add(ActionEvent event) {
    }

    @FXML
    private void Edit(ActionEvent event) {
    }

    @FXML
    private void Delete(ActionEvent event) {
    }

    @FXML
    private void Refresh(ActionEvent event) {
    }

}
