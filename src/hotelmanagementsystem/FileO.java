/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hotelmanagementsystem;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.stage.Stage;

/**
 *
 * @author Mohammed2
 */
public class FileO {

    public static void PrintFile(String s) throws FileNotFoundException, IOException {
        LocalDateTime myDateObj = LocalDateTime.now();
        DateTimeFormatter myFormatObj = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss a");
        String formattedDate = myDateObj.format(myFormatObj);
        File f = new File("LogoFile.txt");
        FileOutputStream fos = new FileOutputStream(f,true);
        OutputStreamWriter osw = new OutputStreamWriter(fos);
        PrintWriter pw = new PrintWriter(fos);
        pw.println(s + "  Time " + formattedDate);
        pw.flush();
        pw.close();
        osw.flush();
        osw.close();

    }

    public static void alert(String masseg) {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("Error Massege");
        alert.setContentText(masseg);
        alert.show();
    }

}
