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
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javax.swing.JOptionPane;

/**
 * FXML Controller class
 *
 * @author Mohammed2
 */
public class R3ConfirmController implements Initializable {

    @FXML
    private Label name;
    @FXML
    private Label birthday;
    @FXML
    private Label address;
    @FXML
    private Label phone;
    @FXML
    private Label gender;
    @FXML
    private Label branch;
    @FXML
    private Label Room;
    @FXML
    private Label children;
    @FXML
    private Label Breakfast;
    @FXML
    private Label activtty;
    @FXML
    private Label numberday;
    @FXML
    private Label roomnuber;
    @FXML
    private Label numgust;
    @FXML
    private ComboBox<String> method;
    @FXML
    private Button Save;
    @FXML
    private Button cancel;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        ObservableList<String> list = FXCollections.observableArrayList(
                "Male", "Female"
        );
        method.setItems(list);
        name.setText(GlobalVariable.guest.name);
        phone.setText(GlobalVariable.guest.phone);
        String multiaddress = "";
        for (int i = 0; i < GlobalVariable.adresses.size(); i++) {
            multiaddress += GlobalVariable.adresses.get(i).address + " ";
        }
        address.setText(GlobalVariable.guest.address + " " + multiaddress);

        birthday.setText(GlobalVariable.guest.birthday);
        branch.setText(GlobalVariable.reservation.branch);
        roomnuber.setText(String.valueOf(GlobalVariable.reservation.roomnumber));
        if (GlobalVariable.reservation.withchildren == 1) {
            children.setText("with Child");
        } else {
            children.setText("without Child");
        }
        if (GlobalVariable.reservation.breakfast == 1) {
            Breakfast.setText("with Breakfast");
        } else {
            Breakfast.setText("without Breakfast");
        }

        String s = GlobalVariable.Gender.toString();
        gender.setText(s);
        Room.setText(GlobalVariable.room);
        activtty.setText(GlobalVariable.reservation.activity);
        numberday.setText(String.valueOf(GlobalVariable.reservation.numberday));
        numgust.setText(String.valueOf(GlobalVariable.reservation.numberguest));
    }
    static Connection conn;
    PreparedStatement pst = null;

    @FXML
    private void save(ActionEvent event) {
        // TODO add your handling code here:
        Connection con = null;
        con = db.java_db();
        conn = con;
        try {

            Guest newGuest = GlobalVariable.guest;
            String sql = "INSERT INTO Guest(Name , Address ,PhoneNumber ,Birthdate ,Gender ) values (?,?,?,?,?)";

            pst = con.prepareStatement(sql);
            System.out.println(newGuest.name);
            pst.setString(1, newGuest.name);
            pst.setString(2, newGuest.address);
            pst.setString(3, newGuest.phone);
            pst.setString(4, newGuest.birthday);
            pst.setString(5, newGuest.gender);

            pst.execute();

            PreparedStatement ps = con
                    .prepareStatement("select Guest.ID from Guest order by Guest.ID desc limit 1");

            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                GlobalVariable.GusetID = (int) rs.getLong(1);
            }

            pst.close();
            ps.close();
        } catch (Exception e) {
        }
        try {

            Reservation reservation = GlobalVariable.reservation;
            String sql = "INSERT INTO Reservation(WithChildren , Branch ,CheckInDate ,CheckOutDate ,NumberOfRooms,NumberOfGuest,NumberOfDay,Breakfast,Activity,roomType,roomNumber,GuestID )"
                    + " values (?,?,?,?,?,?,?,?,?,?,?,?)";
            pst = con.prepareStatement(sql);
            pst.setInt(1, reservation.withchildren);
            pst.setString(2, reservation.branch);
            pst.setString(3, reservation.checkin);
            pst.setString(4, reservation.checkout);
            pst.setInt(5, reservation.numberroom);
            pst.setInt(6, reservation.numberguest);
            pst.setInt(7, reservation.numberday);
            pst.setInt(8, reservation.breakfast);
            pst.setString(9, reservation.activity);
            pst.setString(10, reservation.roomType);
            pst.setInt(11, reservation.roomnumber);
            pst.setInt(12, GlobalVariable.GusetID);
            pst.execute();
            pst.close();

        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        for (int i = 0; i < GlobalVariable.adresses.size(); i++) {
            GlobalVariable.adresses.get(i).guestId = GlobalVariable.GusetID;

            Guest newGuest = GlobalVariable.guest;
            String sql = "INSERT INTO Address(ID , address ) values (?,?)";
            try {
                pst = con.prepareStatement(sql);
                pst.setInt(1, GlobalVariable.adresses.get(i).guestId);
                pst.setString(2, GlobalVariable.adresses.get(i).address);

                pst.execute();
            } catch (SQLException ex) {
            }

        }
        PreparedStatement psr;
        int reserveId = 0;
        try {
            psr = con
                    .prepareStatement("select ReserveID from Reservation order by ReserveID desc limit 1");

            ResultSet rsr = psr.executeQuery();

            if (rsr.next()) {
                reserveId = (int) rsr.getLong(1);
            }
        } catch (SQLException ex) {
        }

        updateRooms(reserveId, GlobalVariable.reservation.roomnumber);
        updateBills(reserveId);

        GlobalVariable.guest = null;
        GlobalVariable.adresses = new ArrayList<Adress>();
        System.exit(0);
        try {
            con.close();
        } catch (SQLException ex) {
        }

    }

    public void updateRooms(int resserveId, int roomNum) {

        String sql = "update Room set ReserveID='" + resserveId
                + "' where RoomNumber='" + roomNum + "' ";
        try {
            pst = conn.prepareStatement(sql);
            pst.execute();

        } catch (SQLException ex) {
        }
    }

    public void updateBills(int reserveId) {
        String method = this.method.getSelectionModel().getSelectedItem().toString();
        DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
        Date date = new Date();
        String now = dateFormat.format(date); //2016/11/16 12:08:43
        double total = GlobalVariable.price * GlobalVariable.reservation.numberday;
        double discount;
        if (GlobalVariable.reservation.breakfast == 1) {
            discount = 0;
        } else {
            discount = 20;
        }
        if (discount != 0) {
            total = total * discount;
        }
        GlobalVariable.price = total;
        try {

            String sql = "INSERT INTO Bill(TotalPrice , Date ,Discount ,PaymentMethod,reserveId ) values (?,?,?,?,?)";
            pst = conn.prepareStatement(sql);
            pst.setDouble(1, total);
            pst.setString(2, now);
            pst.setDouble(3, discount);
            pst.setString(4, method);
            pst.setInt(5, reserveId);
            pst.execute();
        } catch (SQLException s) {
        }

    }

}
