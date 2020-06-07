import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;

public class ControllerLekarz implements Initializable {

	@FXML
	private ListView<Grafik> list;

	@FXML
	private TextField idl;

	@FXML
	private TextField d;

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {

		LocalDate ld = LocalDate.now();
		d.setText(DateTimeFormatter.ofLocalizedDate(FormatStyle.FULL).format(ld));
		d.setEditable(false);

	}

	public void lll() throws IOException {

		try {

			int IDLekarza = Integer.parseInt(idl.getText());

			if (IDLekarza > 100 && IDLekarza < 105) {
				Grafik grafik = new Grafik();
				Connection con1 = DBConnector.getConnection();
				PreparedStatement pst6 = null;
				System.out.println("Connected to Database");
				String sql = "select * from grafik1 WHERE IDlekarza = '" + IDLekarza + "'";
				pst6 = con1.prepareStatement(sql);
				ResultSet result6 = pst6.executeQuery();
				DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
				while (result6.next()) {
					grafik = new Grafik(LocalDate.parse(result6.getString("ldt"), formatter),
							result6.getBoolean("czyZarezerwowany"), result6.getBoolean("czyWykonany"),
							result6.getInt("IDpacjenta"), result6.getInt("IDlekarza"));

					list.getItems().add(grafik);

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
	
	public void e() throws IOException {
		list.getItems().clear();
		
	}

}
