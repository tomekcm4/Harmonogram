import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class Controllerdodajpacjenta implements Initializable {

	@FXML
	private TextField ip;

	@FXML
	private TextField np;

	@FXML
	private TextField idp;

	@FXML
	private Button dodajB;

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stub

	}

	public void dodajP() {
		try {

			String x = ip.getText();
			String xx = np.getText();
			int xxx = Integer.parseInt(idp.getText());

			Connection con = DBConnector.getConnection();
			PreparedStatement pst = null;
			System.out.println("Connected to Database");
			String sql = "INSERT INTO pacjent (imie,nazwisko, IDpacjenta)" + "VALUES(?,?,?)";
			pst = con.prepareStatement(sql);

			pst.setString(1, x);
			pst.setString(2, xx);
			pst.setInt(3, xxx);
			pst.executeUpdate();

			DialogsUtils10.dialogAboutApplication();
			Stage stage = (Stage) dodajB.getScene().getWindow();
			stage.close();

		} catch (SQLException e) {
			e.printStackTrace();
			DialogsUtil21.dialogAboutApplication();
			
		}

		catch (Exception e) {
			DialogsUtil11.dialogAboutApplication();
			System.out.println("Wystapil nieoczekiwany blad");
		}

	}

}
