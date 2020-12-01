import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 * Implements the JavaFX GUI which allows for morse translation
 */
public class TranslatorTest extends Application {
    /**
     * Main method
     * @param args
     */
    public static void main(String[] args) {
        launch(args);
    }

    /**
     * Creates and launches the GUI
     * @param primaryStage
     * @throws Exception
     */
    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("MorseGUI.fxml"));
        Scene scene = new Scene(root);
        primaryStage.setTitle("Morse Translator");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

}
