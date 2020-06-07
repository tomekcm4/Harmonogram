import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextInputDialog;

import java.util.Optional;
import java.util.ResourceBundle;

public class DialogsUtil22 {

    public static void dialogAboutApplication() {
    	Alert errorAlert = new Alert(AlertType.ERROR);
    	errorAlert.setTitle("ERROR");
    	errorAlert.setHeaderText("Blad");
    	errorAlert.setContentText("Bledne dane, takie ID lekarza jest juz zarezerowane");
    	errorAlert.showAndWait();
    }

}