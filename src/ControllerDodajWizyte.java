import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class ControllerDodajWizyte implements Initializable {

	@FXML
	private TextField zg;

	@FXML
	private TextField wg;

	@FXML
	private TextField idlg;

	@FXML
	private Button dodajG;
	
	 @FXML
	private DatePicker dg;

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub

	}

	@FXML
	void dodajG() {
		try {
			
			LocalDate ld = dg.getValue();
			
			DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
			String x = ld.format(formatter);
			
			Boolean xx = Boolean.parseBoolean(zg.getText());
			Boolean xxx = Boolean.parseBoolean(wg.getText());	
			int xxxx = Integer.parseInt(idlg.getText());


			Connection con = DBConnector.getConnection();
			PreparedStatement pst = null;
			System.out.println("Rekord dodany");
			System.out.println("Connected to Database");
			String sql = "INSERT INTO grafik1" + "(ldt, czyZarezerwowany, czyWykonany, IDlekarza)" + "VALUES(?,?,?,?)";
			pst = con.prepareStatement(sql);
			pst.setString(1, x);
			pst.setBoolean(2, xx);
			pst.setBoolean(3, xxx);
			pst.setInt(4, xxxx);
			pst.executeUpdate();
			DialogsUtils10.dialogAboutApplication();
			
			Stage stage = (Stage) dodajG.getScene().getWindow();
			stage.close();

		} catch (SQLException e) {
			e.printStackTrace();
			DialogsUtil20.dialogAboutApplication();
		} 
		
		catch (Exception e) {
			DialogsUtil20.dialogAboutApplication();
		} 


	}

}
