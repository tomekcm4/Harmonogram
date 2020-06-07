import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextInputDialog;

import java.util.Optional;
import java.util.ResourceBundle;

public class DialogsUtils10 {

    public static void dialogAboutApplication() {
        Alert informationAlert = new Alert(Alert.AlertType.INFORMATION);
        informationAlert.setTitle("Potwierdzenie");
        informationAlert.setHeaderText("Zrobione");
        informationAlert.setContentText("Rekord zostal dodany");
        informationAlert.showAndWait();
    }

}