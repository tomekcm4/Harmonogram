import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class MainController implements Initializable {
	
	
	

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub

	}

	public void add2() throws IOException {
		
		
		Parent root = FXMLLoader.load(getClass().getResource("login.fxml"));
		Stage stage1 = new Stage();
		stage1.setScene(new Scene(root));
		stage1.setTitle("Logowanie");
		stage1.show();
		


	}

	public void centrumL() throws IOException {
		Parent root = FXMLLoader.load(getClass().getResource("login4.fxml"));
		Stage stage1 = new Stage();
		stage1.setScene(new Scene(root));
		stage1.setTitle("Logowanie Lekarza");
		stage1.show();

	}

	public void centrumP() throws IOException {
		Parent root = FXMLLoader.load(getClass().getResource("login2.fxml"));
		Stage stage1 = new Stage();
		stage1.setScene(new Scene(root));
		stage1.setTitle("Logowanie Pacjent");
		stage1.show();

	}

	public void cena() throws IOException {
		Parent root = FXMLLoader.load(getClass().getResource("login3.fxml"));
		Stage stage1 = new Stage();
		stage1.setScene(new Scene(root));
		stage1.setTitle("Logowanie Administratora");
		stage1.show();
	}

}
