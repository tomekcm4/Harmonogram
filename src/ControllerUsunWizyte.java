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
import javafx.scene.control.ButtonBar;
import javafx.scene.control.ButtonType;
import javafx.scene.control.ListView;

public class ControllerUsunWizyte implements Initializable {

	@FXML
	private ListView<Grafik> list;

	@FXML
	private Button usun;

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		try {
			Grafik grafik = new Grafik();
			Connection con = DBConnector.getConnection();
			PreparedStatement pst = null;
			System.out.println("Connected to Database");
			DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
			String sql = "select * from grafik1";
			pst = con.prepareStatement(sql);
			ResultSet result = pst.executeQuery();
			result = pst.executeQuery();
			while (result.next()) {
				grafik = new Grafik(LocalDate.parse(result.getString("ldt"), formatter),
						result.getBoolean("czyZarezerwowany"), result.getBoolean("czyWykonany"),
						result.getInt("IDpacjenta"), result.getInt("IDlekarza"));

				list.getItems().add(grafik);

			}

		}

		catch (SQLException e) {

			e.printStackTrace();
			System.out.println("Rezerwacja nie przebiegla prawidlowo");
			DialogsUtils2.dialogAboutApplication();
		}

		catch (Exception e) {
			System.err.println("Niepoprawny fromat danych, cos poszlo nie tak");
			DialogsUtils2.dialogAboutApplication();
		}

	}

	public void usun() {

		Alert alert = new Alert(Alert.AlertType.WARNING);
		alert.setTitle("Dane zostana skasowane");
		alert.setContentText("zapisac?");
		ButtonType okButton = new ButtonType("YES", ButtonBar.ButtonData.YES);
		ButtonType noButton = new ButtonType("No", ButtonBar.ButtonData.NO);
		ButtonType cancelButton = new ButtonType("Cancel", ButtonBar.ButtonData.CANCEL_CLOSE);
		alert.getButtonTypes().setAll(okButton, noButton, cancelButton);
		alert.showAndWait().ifPresent(type -> {
			if (type == okButton) {
				try {

					Grafik dana = list.getSelectionModel().getSelectedItem();

					LocalDate ld = dana.getLdt();
					DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
					String x = ld.format(formatter);
					System.out.println(x);
					int xx = dana.IDlekarza;
					System.out.println(xx);

					Connection con1 = DBConnector.getConnection();
					PreparedStatement pst6 = null;
					System.out.println("Connected to Database");

					String sql1 = "delete from grafik1 where IDlekarza = " + xx + " AND ldt = '" + x + "'";

					pst6 = con1.prepareStatement(sql1);
					pst6.executeUpdate();

					list.getItems().clear();

					String imie;
					String nazwisko;
					int IDpacjenta;

					Grafik grafik1 = new Grafik();
					Connection con = DBConnector.getConnection();
					PreparedStatement pst = null;
					System.out.println("Connected to Database");
					String sql2 = "select * from grafik1";
					pst = con.prepareStatement(sql2);
					ResultSet result1 = pst.executeQuery();
					result1 = pst.executeQuery();
					while (result1.next()) {
						grafik1 = new Grafik(LocalDate.parse(result1.getString("ldt"), formatter),
								result1.getBoolean("czyZarezerwowany"), result1.getBoolean("czyWykonany"),
								result1.getInt("IDpacjenta"), result1.getInt("IDlekarza"));

						list.getItems().add(grafik1);

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