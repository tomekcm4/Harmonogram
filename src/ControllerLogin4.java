import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class ControllerLogin4 implements Initializable {
	
    @FXML
    private TextField login;

    @FXML
    private TextField password;
    
    @FXML
    private Text t;

    @FXML
    private Button zaloguj;
    
    MainController mc = new MainController();

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub
		
	}
	
	
	public void zaloguj() throws IOException {
		
		String log = login.getText();
		String pass = password.getText();
		
		if(log.equals("login4") && pass.equals("pass4")) {
		
		Parent root = FXMLLoader.load(getClass().getResource("centrumL.fxml"));
		Stage stage1 = new Stage();
		stage1.setScene(new Scene(root));
		stage1.setTitle("Centrum Lekarza");
		stage1.show();
		Stage stage = (Stage) zaloguj.getScene().getWindow();
		  stage.close();
		
		}
		else {
			t.setText("Bledne haslo lub login");
		}
		
		
		
	}
	
	

}