import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.RadioButton;
import javafx.stage.Stage;

public class ControllerAdministratora implements Initializable {

	@FXML
	private RadioButton Dpac;

	@FXML
	private RadioButton Dlek;

	@FXML
	private RadioButton Dwiz;

	@FXML
	private RadioButton Upac;

	@FXML
	private RadioButton Ulek;

	@FXML
	private RadioButton Uwiz;
	
		

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
	

	}
	
	
	

	@FXML
	void dodajLekarza() throws IOException {

		    Dpac.setSelected(false);
			Dlek.setSelected(true);
			Dwiz.setSelected(false);
			
		
		
		Parent root = FXMLLoader.load(getClass().getResource("dodajLekarza.fxml"));
		Stage stage1 = new Stage();
		stage1.setScene(new Scene(root));
		stage1.setTitle("Formatka dodaj pacjenta");
		stage1.show();

	}

	@FXML
	void dodajPacjenta() throws IOException {
		
		 Dpac.setSelected(true);
			Dlek.setSelected(false);
			Dwiz.setSelected(false);
			
		Parent root = FXMLLoader.load(getClass().getResource("dodajPacjenta.fxml"));
		Stage stage1 = new Stage();
		stage1.setScene(new Scene(root));
		stage1.setTitle("Formatka dodaj pacjenta");
		stage1.show();

	}

	@FXML
	void dodajWizyte() throws IOException {
		
		 Dpac.setSelected(false);
			Dlek.setSelected(false);
			Dwiz.setSelected(true);
		Parent root = FXMLLoader.load(getClass().getResource("dodajWizyte.fxml"));
		Stage stage1 = new Stage();
		stage1.setScene(new Scene(root));
		stage1.setTitle("Formatka dodaj wizyte");
		stage1.show();

	}

	@FXML
	void usunLekarza() throws IOException {
		 Upac.setSelected(false);
			Ulek.setSelected(true);
			Uwiz.setSelected(false);
		Parent root = FXMLLoader.load(getClass().getResource("usunLekarza.fxml"));
		Stage stage1 = new Stage();
		stage1.setScene(new Scene(root));
		stage1.setTitle("Formatka usun lekarza");
		stage1.show();
	}

	@FXML
	void usunPacjenta() throws IOException {
		 Upac.setSelected(true);
			Ulek.setSelected(false);
			Uwiz.setSelected(false);
		Parent root = FXMLLoader.load(getClass().getResource("usunPacjenta.fxml"));
		Stage stage1 = new Stage();
		stage1.setScene(new Scene(root));
		stage1.setTitle("Formatka usun pacjenta");
		stage1.show();

	}

	@FXML
	void usunWizyte() throws IOException {
		 Upac.setSelected(false);
			Ulek.setSelected(false);
			Uwiz.setSelected(true);
		Parent root = FXMLLoader.load(getClass().getResource("usunWizyte.fxml"));
		Stage stage1 = new Stage();
		stage1.setScene(new Scene(root));
		stage1.setTitle("Formatka usun wizyte");
		stage1.show();

	}

}
