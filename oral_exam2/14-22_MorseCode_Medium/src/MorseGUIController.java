import javafx.fxml.FXML;



import javafx.scene.control.TextField;

public class MorseGUIController {
    @FXML
    private TextField morseIn;
    @FXML
    private TextField morseOut;
    @FXML
    private TextField englishIn;
    @FXML
    private TextField englishOut;

    @FXML
    public void translateToEnglish(javafx.event.ActionEvent event){
        englishOut.setText(MorseTranslator.morseToEnglish(morseIn.getText()));
    }
    @FXML
    public void translateToMorse(javafx.event.ActionEvent actionEvent) {
        morseOut.setText(MorseTranslator.englishToMorse(englishIn.getText()));
    }
}
