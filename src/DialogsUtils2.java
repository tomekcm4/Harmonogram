import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextInputDialog;

import java.util.Optional;
import java.util.ResourceBundle;

public class DialogsUtils2 {

    public static void dialogAboutApplication() {
    	Alert errorAlert = new Alert(AlertType.ERROR);
    	errorAlert.setTitle("ERROR");
    	errorAlert.setHeaderText("Blad");
    	errorAlert.setContentText("ID pacjenta jest niepoprawne");
    	errorAlert.showAndWait();
    }

}