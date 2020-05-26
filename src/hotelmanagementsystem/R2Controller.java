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
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;
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
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.RadioButton;
import javafx.scene.control.Spinner;
import javafx.scene.control.SpinnerValueFactory;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Mohammed2
 */
public class R2Controller implements Initializable {

    @FXML
    private ComboBox<String> Branch;
    @FXML
    private ComboBox<String> Roomtypy;
    @FXML
    private Spinner<Integer> Numberday;
    @FXML
    private Spinner<Integer> Numbergust;
    @FXML
    private DatePicker date;
    @FXML
    private RadioButton RB1;
    @FXML
    private RadioButton RB2;
    @FXML
    private RadioButton RB3;
    @FXML
    private RadioButton RB4;
    @FXML
    private Button Reserve;
    public static Connection conn;
    PreparedStatement pst = null;

    /**
     * Initializes the controller class.
     */
    ObservableList<String> list;
    ObservableList<String> list2;
    List<Room> rooms = new LinkedList<>();

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        conn = db.java_db();
        ResultSet rs;
        String sql = "select * from Room where ReserveID";
        try {
            pst = conn.prepareStatement(sql);
            rs = pst.executeQuery();
            while (rs.next()) {
                rooms.add(new Room(rs.getInt("RoomNumber"), rs.getString("RoomType"),
                        rs.getDouble("RoomPrice"), rs.getString("Description"),
                        rs.getString("rate"), rs.getInt("ReserveID")
                ));
            }
            conn.close();
            pst.close();
        } catch (SQLException s) {
        }
        list = FXCollections.observableArrayList();
        list2 = FXCollections.observableArrayList();
        list.add("single room");
        list.add("double room");
        list.add("master room");
        list.add("sweet room");
        list2.add("Al Dammam");
        list2.add("Jeddeh");
        list2.add("AlRiydh");
        Roomtypy.setItems(list);
        Branch.setItems(list2);
        final int initialValue = 3;
        SpinnerValueFactory<Integer> valueFactory
                = //
                new SpinnerValueFactory.IntegerSpinnerValueFactory(1, 30, initialValue);
        Numberday.setValueFactory(valueFactory);
        Numbergust.setValueFactory(valueFactory);
    }

    @FXML
    private void Reserveb(ActionEvent event) {
        String branch = Branch.getSelectionModel().getSelectedItem().toString();
        String Room = Roomtypy.getSelectionModel().getSelectedItem().toString();
        int numberday = Numberday.getValue();
        int numbergust = Numbergust.getValue();
        String checkin = date.getValue().toString();
        int withchildren = RB1.isSelected() ? 1 : 0;
        int breakfast = RB2.isSelected() ? 1 : 0;
        String activty = RB3.getText();
        String r4 = RB4.getText();
        String checkout = "";
        Reservation reservation = new Reservation(0, withchildren, branch, checkin, checkout, 1, numbergust, numberday, 1, breakfast, activty, Room);
        int index = Roomtypy.getSelectionModel().getSelectedIndex();
        GlobalVariable.price = rooms.get(index).price;
        index = rooms.get(index).RoomNumber;
        GlobalVariable.reservation = reservation;
        GlobalVariable.room = Room;
        try {
            Parent blah = FXMLLoader.load(getClass().getResource("R3Confirm.fxml"));
            Scene scene = new Scene(blah);
            Stage appStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            appStage.setScene(scene);
            appStage.show();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

    }

}
