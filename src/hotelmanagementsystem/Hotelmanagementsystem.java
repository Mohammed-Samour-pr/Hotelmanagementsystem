/* To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hotelmanagementsystem;

import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Map;
import java.util.TreeMap;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

/**
 *
 * @author Mohammed2
 */
public class Hotelmanagementsystem extends Application {

    @Override
    public void start(Stage stage) throws Exception {
        Pane paneTableView = FXMLLoader.load(getClass().getResource("Show_guests.fxml"));
        Scene scene = new Scene(paneTableView);
        stage.setScene(scene);
        stage.show();

    }

    public static void main(String[] args) throws IOException {
        launch(args);
    }

}
