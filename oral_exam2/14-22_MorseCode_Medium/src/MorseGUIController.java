import javafx.fxml.FXML;



import javafx.scene.control.TextField;

/**
 * Controller class for the GUI
 * @author Konnor Sommer
 */
public class MorseGUIController {
    /**
     * Text field for morse input
     */
    @FXML
    private TextField morseIn;
    /**
     * Text field for morse output
     */
    @FXML
    private TextField morseOut;
    /**
     * Text field for english input
     */
    @FXML
    private TextField englishIn;
    /**
     * Text fied for englihs output
     */
    @FXML
    private TextField englishOut;

    /**
     * Translates morse input to english upon action event
     * @param event
     */
    @FXML
    public void translateToEnglish(javafx.event.ActionEvent event){
        englishOut.setText(MorseTranslator.morseToEnglish(morseIn.getText()));
    }

    /**
     * Translates english input to morse code upon action event
     * @param actionEvent
     */
    @FXML
    public void translateToMorse(javafx.event.ActionEvent actionEvent) {
        morseOut.setText(MorseTranslator.englishToMorse(englishIn.getText()));
    }
}
