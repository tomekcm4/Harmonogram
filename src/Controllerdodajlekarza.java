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

public class Controllerdodajlekarza implements Initializable {

    @FXML
    private TextField il;

    @FXML
    private TextField nl;

    @FXML
    private TextField idl;

    @FXML
    private TextField sl;

    @FXML
    private Button dodajL;

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub
		
	}
	
	

	public void dodajL() {
		try {
			
			String x = il.getText();
			String xx = nl.getText();
			int xxx = Integer.parseInt(idl.getText());
			String xxxx = sl.getText();

			Connection con = DBConnector.getConnection();
			PreparedStatement pst = null;
			System.out.println("Rekord dodany");
			System.out.println("Connected to Database");
			String sql = "INSERT INTO lekarz" + "(imie,nazwisko, IDLekarza, specjalizacja)" + "VALUES(?,?,?,?)";
			pst = con.prepareStatement(sql);
			pst.setString(1, x);
			pst.setString(2, xx);
			pst.setInt(3, xxx);
			pst.setString(4, xxxx);
			pst.executeUpdate();
			DialogsUtils10.dialogAboutApplication();
			Stage stage = (Stage) dodajL.getScene().getWindow();
			stage.close();

		} catch (SQLException e) {
			e.printStackTrace();
			DialogsUtil22.dialogAboutApplication();
		}
		catch (Exception e) {
			DialogsUtil11.dialogAboutApplication();
			System.out.println("Wystapil nieoczekiwany blad");
		}
		
	}

}
