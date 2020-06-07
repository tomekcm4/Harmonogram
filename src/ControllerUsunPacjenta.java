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
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.ButtonBar;
import javafx.scene.control.ListView;

public class ControllerUsunPacjenta implements Initializable {

	@FXML
	private ListView<Integer> lista;

	@FXML
	private Button usun;

	@Override
	public void initialize(URL location, ResourceBundle resources) {

		try {

			String imie;
			String nazwisko;
			int IDpacjenta;

			Connection con1 = DBConnector.getConnection();
			PreparedStatement pst6 = null;
			System.out.println("Connected to Database");
			String sql = "select * from pacjent";
			pst6 = con1.prepareStatement(sql);
			ResultSet result6 = pst6.executeQuery();
			while (result6.next()) {
				imie = result6.getString("imie");
				nazwisko = result6.getString("nazwisko");
				IDpacjenta = result6.getInt("IDpacjenta");

				int cale = IDpacjenta;

				lista.getItems().add(cale);

			}

		}

		catch (SQLException e) {
			e.printStackTrace();

		}

		catch (Exception e) {
			System.out.println("Bledne dane");

		}

	}

	@FXML
	void usun() throws SQLException {

		Alert alert = new Alert(Alert.AlertType.WARNING);
		alert.setTitle("Dane zostana skasowane");
		alert.setContentText("zapisac?");
		ButtonType okButton = new ButtonType("Yes", ButtonBar.ButtonData.YES);
		ButtonType noButton = new ButtonType("No", ButtonBar.ButtonData.NO);
		ButtonType cancelButton = new ButtonType("Cancel", ButtonBar.ButtonData.CANCEL_CLOSE);
		alert.getButtonTypes().setAll(okButton, noButton, cancelButton);
		alert.showAndWait().ifPresent(type -> {
			if (type == okButton) {

				try {

					int dana = lista.getSelectionModel().getSelectedItem();

					Connection con1 = DBConnector.getConnection();
					PreparedStatement pst6 = null;
					System.out.println("Connected to Database");
					String sql = "delete from pacjent where IDpacjenta = " + dana;
					pst6 = con1.prepareStatement(sql);
					pst6.executeUpdate();

					lista.getItems().clear();

					String imie;
					String nazwisko;
					int IDpacjenta;

					Grafik grafik = new Grafik();
					Connection con12 = DBConnector.getConnection();
					PreparedStatement pst66 = null;
					System.out.println("Connected to Database");
					String sql1 = "select * from pacjent";
					pst66 = con12.prepareStatement(sql1);
					ResultSet result66 = pst66.executeQuery();
					while (result66.next()) {
						imie = result66.getString("imie");
						nazwisko = result66.getString("nazwisko");
						IDpacjenta = result66.getInt("IDpacjenta");

						int cale = IDpacjenta;

						lista.getItems().add(cale);

					}

				}

				catch (SQLException e) {
					e.printStackTrace();

				}

				catch (Exception e) {
					System.out.println("Bledne dane");

				}

			} else if (type == ButtonType.NO) {
				return;
			} else {
				return;
			}
		});

	}

}
