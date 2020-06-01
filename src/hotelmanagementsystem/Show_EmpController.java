/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hotelmanagementsystem;

import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
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
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import javax.swing.JOptionPane;

/**
 * FXML Controller class
 *
 * @author Mohammed2
 */
public class Show_EmpController implements Initializable {

    @FXML
    private TableColumn<Employee, Integer> tcid;
    @FXML
    private TableColumn<Employee, String> tcname;

    @FXML
    private TableColumn<Employee, String> tcaddress;
    @FXML
    private TableColumn<Employee, String> tcgender;

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
    private TableView<Employee> Tabelview;
    db d = new db();
    Statement statement = null;
    ResultSet rs = null;
    @FXML
    private TableColumn<Employee, Integer> ph;
    @FXML
    private TableColumn<Employee, String> brit;
    static Connection conn;
    PreparedStatement pst = null;
    @FXML
    private Label NameE;
    @FXML
    private Label Time;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        try {
            Class.forName("org.sqlite.JDBC");
            conn = DriverManager.getConnection("jdbc:sqlite:hotel_db.sqlite");
            JOptionPane.showMessageDialog(null, "Connection to database is successful");
            this.statement = conn.createStatement();
        } catch (Exception e) {
            System.out.println(e);

        }

        tcid.setCellValueFactory(new PropertyValueFactory("ID"));
        tcname.setCellValueFactory(new PropertyValueFactory("UserName"));
        ph.setCellValueFactory(new PropertyValueFactory("PhoneNumber"));
        tcaddress.setCellValueFactory(new PropertyValueFactory("Password"));
        tcgender.setCellValueFactory(new PropertyValueFactory("WORKHOURS"));
        brit.setCellValueFactory(new PropertyValueFactory("Birthdate"));
        try {
            try {
                rs = statement.executeQuery("select * from EMPLOYEE");
                while (rs.next()) {
                    Employee e = new Employee();
                    String adf = String.valueOf(rs.getInt("E_ID"));
                    e.setID(adf);
                    e.setUserName(rs.getString("UserName"));
                    e.setBirthdate(rs.getString("BIRTHDAY"));
                    e.setPassword(rs.getString("Password"));
                    e.setWORKHOURS(rs.getInt("WORKHOURS"));
                    e.setPhoneNumber(rs.getString("PHONENUMBER"));
                    Tabelview.getItems().add(e);
                    System.out.println(e.toString());
                }
            } catch (SQLException ex) {
                System.out.println("1-" + ex.getMessage());
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        Tabelview.getSelectionModel().selectedItemProperty().addListener(
                event -> showSelected()
        );

    }

    @FXML
    private void previous(ActionEvent event) {
        try {
            Parent blah = FXMLLoader.load(getClass().getResource("Select_User.fxml"));
            Scene scene = new Scene(blah);
            Stage appStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            appStage.setScene(scene);
            appStage.show();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    @FXML
    private void add(ActionEvent event) throws IOException {
        try {
            String name = nametxt.getText();
            String ph = phonetxt.getText();
            String bert = Birthtxt.getText();
            String gender = gendertxt.getText();
            String Address = addresstxt.getText();
            Guest newGuest = GlobalVariable.guest;
            String sql = "INSERT INTO EMPLOYEE(Password , BIRTHDAY ,UserName ,PHONENUMBER ,WORKHOURS ) values (?,?,?,?,?)";
            FileO.PrintFile(sql);
            pst = conn.prepareStatement(sql);
            pst.setString(1, name);
            pst.setString(2, Address);
            pst.setString(3, ph);
            pst.setString(4, bert);
            pst.setString(5, gender);
            pst.execute();
            pst.close();
            Tabelview.getItems().clear();
            referachTable();
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }

    @FXML
    private void Edit(ActionEvent event) throws SQLException, IOException {
        Integer id = Integer.parseInt(idtxt.getText());
        String name = nametxt.getText();
        String ph = phonetxt.getText();
        String bert = Birthtxt.getText();
        String gender = gendertxt.getText();
        String Address = addresstxt.getText();

        String sql = "update EMPLOYEE set UserName='" + name + "', PHONENUMBER='" + Address + "', Password='" + ph + "',BIRTHDAY='" + bert + "',WORKHOURS"
                + "='" + gender
                + "' where E_ID='" + id + "' ";
        FileO.PrintFile(sql);
        this.statement.executeUpdate(sql);
        Tabelview.getItems().clear();
        referachTable();
    }

    @FXML
    private void Delete(ActionEvent event) throws SQLException, IOException {
        Integer id = Integer.parseInt(idtxt.getText());
        String sql = "Delete from EMPLOYEE where E_ID=" + id;
        FileO.PrintFile(sql);
        this.statement.executeUpdate(sql);
        Tabelview.getItems().clear();
        referachTable();

    }

    @FXML
    private void Refresh(ActionEvent event) throws SQLException {
        Tabelview.getItems().clear();
        referachTable();
        idtxt.setText("");
        nametxt.setText("");
        phonetxt.setText("");
        addresstxt.setText("");
        gendertxt.setText("");
        Birthtxt.setText("");

    }

    private void showSelected() {
        Employee g = Tabelview.getSelectionModel().getSelectedItem();
        if (g != null) {
            idtxt.setText(g.getID());
            nametxt.setText(g.getUserName());
            phonetxt.setText(g.getPhoneNumber());
            addresstxt.setText(g.getPassword());
            gendertxt.setText(String.valueOf(g.getWORKHOURS()));
            Birthtxt.setText(g.getBirthdate());

        }

    }

    public void referachTable() throws SQLException {

        rs = statement.executeQuery("select * from EMPLOYEE");
        while (rs.next()) {
            Employee employee = new Employee();
            String adf = String.valueOf(rs.getInt("E_ID"));
            employee.setID(adf);
            employee.setUserName(rs.getString("UserName"));
            employee.setBirthdate(rs.getString("BIRTHDAY"));
            employee.setPassword(rs.getString("Password"));
            employee.setWORKHOURS(rs.getInt("WORKHOURS"));
            employee.setPhoneNumber(rs.getString("PHONENUMBER"));
            Tabelview.getItems().add(employee);

        }
    }

}
