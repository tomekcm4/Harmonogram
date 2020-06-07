import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;

public class ControllerPacjent implements Initializable {

	@FXML
	private TextField id;

	@FXML
	private ListView<Grafik> ltw;

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stub

	}

	public void ll() throws IOException {

		try {

			int IDPacjenta = Integer.parseInt(id.getText());

			if (IDPacjenta > 0 && IDPacjenta < 40) {
				Grafik grafik = new Grafik();
				Connection con1 = DBConnector.getConnection();
				PreparedStatement pst6 = null;
				System.out.println("Connected to Database");
				String sql = "select * from grafik1 WHERE IDpacjenta = '" + IDPacjenta + "'";
				pst6 = con1.prepareStatement(sql);
				ResultSet result6 = pst6.executeQuery();
				DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
				while (result6.next()) {
					grafik = new Grafik(LocalDate.parse(result6.getString("ldt"), formatter),
							result6.getBoolean("czyZarezerwowany"), result6.getBoolean("czyWykonany"),
							result6.getInt("IDpacjenta"), result6.getInt("IDlekarza"));

					ltw.getItems().add(grafik);

					System.out.println(grafik.toString());

				}

			}

		}

		catch (SQLException e) {
			e.printStackTrace();

		}

		catch (Exception e) {
			System.out.println("Bledne dane");

		}

	}

	public void xx() throws IOException {
		ltw.getItems().clear();

	}

}
