import java.io.IOException;

import marvin.Marvin;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

/**
 * A GUI for Duke using FXML.
 */
public class Main extends Application {

    private Marvin marvin = new Marvin();

    @Override
    public void start(Stage stage) {
        assert marvin != null;
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("/view/MainWindow.fxml"));
            AnchorPane ap = fxmlLoader.load();
            Scene scene = new Scene(ap);
            stage.setScene(scene);
            stage.setTitle("Marvin");
            fxmlLoader.<MainWindow>getController().setMarvin(marvin);
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
