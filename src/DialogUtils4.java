import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;

public class DialogUtils4 {
	
	   public static void dialogAboutApplication() {
	    	Alert errorAlert = new Alert(AlertType.ERROR);
	    	errorAlert.setTitle("ERROR");
	    	errorAlert.setHeaderText("Blad");
	    	errorAlert.setContentText("TA DATA JEST JUZ ZAREZERWOWANA");
	    	errorAlert.showAndWait();
	    }


}
