import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;

public class DiologsUtils3 {
	
	   public static void dialogAboutApplication() {
	    	Alert errorAlert = new Alert(AlertType.ERROR);
	    	errorAlert.setTitle("ERROR");
	    	errorAlert.setHeaderText("Blad");
	    	errorAlert.setContentText("TEN TERMIN JEST NIEDOSTEPNY");
	    	errorAlert.showAndWait();
	    }

}
