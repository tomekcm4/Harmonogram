import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import java.util.Scanner;
import java.util.stream.Collectors;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;

public class trzeciController implements Initializable {

	@FXML
	private TextField termin;

	@FXML
	private TextField IDpacjenta;

	@FXML
	private Button zatwierdzB;

	@FXML
	private TextField IDlekarza;

	@FXML
	private ListView<String> listaLekarzy;

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stub

	}

	public void zatwierdz() throws IOException {

		try {
			Grafik grafik = new Grafik();
			Connection con = DBConnector.getConnection();
			PreparedStatement pst = null;
			System.out.println("Connected to Database");
			DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
			String sql = "select IDpacjenta from pacjent";
			pst = con.prepareStatement(sql);
			ResultSet result = pst.executeQuery();
			result = pst.executeQuery();
			List<Integer> l = new ArrayList<>();
			while (result.next()) {
				int c = result.getInt("IDpacjenta");
				l.add(c);
				
			}


			String sql1 = "select IDlekarza from lekarz";
			pst = con.prepareStatement(sql1);
			ResultSet result2 = pst.executeQuery();
			result2 = pst.executeQuery();
			List<Integer> z = new ArrayList<>();
			while (result2.next()) {
				int h = result2.getInt("IDlekarza");
				z.add(h);
				
			}


			Scanner sc = new Scanner(System.in);

			String data = termin.getText();

			int IDpacjentaa = 0;
				System.out.println("Podaj ID pacjenta:");			
				IDpacjentaa = Integer.parseInt(IDpacjenta.getText());
				System.out.println(IDpacjentaa);

				
				for(Integer ll: l) {
					System.out.println(l);
				if(l.contains(IDpacjentaa)) {	
					continue;
				}
			
			 else { 
				 
				 DialogsUtils2.dialogAboutApplication(); 
				 return; 
			 
				
		}
				}

			int IDlekarzaa = 0;
				System.out.println("Podaj ID lekarza:");
				IDlekarzaa = Integer.parseInt(IDlekarza.getText());
				System.out.println(IDlekarzaa);
				
				
				for(Integer lll: z) {
					System.out.println(z);
				if(z.contains(IDlekarzaa)) {	
					continue;
				}
			
			 else { 
				 
				 DialogsUtils5.dialogAboutApplication(); 
				 return; 
			 
				
		}
				}

				String sql5 = "select imie,nazwisko FROM lekarz WHERE IDlekarza= '" + IDlekarzaa + "'";
				PreparedStatement st5 = con.prepareStatement(sql5);
				ResultSet result3 = st5.executeQuery();
				result3 = st5.executeQuery();
				while (result3.next()) {

					String x = result3.getString("imie") + " " + result3.getString("nazwisko");

					System.out.println(
							"Twoja wizyta u lekarza " + x + " w dniu " + data + " czekamy na potwierdzenie....");

				}

			

			String sql11 = "select czyZarezerwowany, czyWykonany from grafik1 where ldt= '" + data + "'"
					+ "AND IDlekarza= '" + IDlekarzaa + "'";
			PreparedStatement st11 = con.prepareStatement(sql11);
			ResultSet result11 = st11.executeQuery();
			result11 = st11.executeQuery();
			
			boolean b = true;

			while (result11.next()) {

				if (result11.getBoolean("czyZarezerwowany") || result11.getBoolean("czyWykonany")) {
					System.out.println("NIEPOWODZENIE");
					DiologsUtils3.dialogAboutApplication();
				}

				if (!result11.getBoolean("czyZarezerwowany") && !result11.getBoolean("czyWykonany")) {

					String sql123 = "update grafik1 set IDpacjenta = '" + IDpacjentaa + "'where ldt= '" + data + "'"
							+ "AND IDlekarza= '" + IDlekarzaa + "'";
					PreparedStatement st1 = con.prepareStatement(sql123);
					st1.executeUpdate();

					// System.out.println("GOTOWE !!!!!!!!!" );

					String sql4 = "update grafik1 set czyZarezerwowany = '1' where ldt= '" + data + "'"
							+ "AND IDlekarza= '" + IDlekarzaa + "'";
					PreparedStatement st4 = con.prepareStatement(sql4);
					st4.executeUpdate();
					System.out.println("SUKCES!!!");
					b = false;
					DialogsUtils.dialogAboutApplication();
				}
				
			}
			
			
			 if (!result11.next() && b) { 
				 
				 DiologsUtils3.dialogAboutApplication();
			  
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

	public void ppp() throws IOException {

		try {
			Connection con = DBConnector.getConnection();
			String sql3 = "select * from lekarz";
			PreparedStatement st2 = con.prepareStatement(sql3);
			ResultSet result2 = st2.executeQuery();
			result2 = st2.executeQuery();

			if (listaLekarzy.getItems().isEmpty()) {

				while (result2.next()) {
					String a = result2.getString("imie");
					String b = result2.getString("nazwisko");
					int c = result2.getInt("IDlekarza");
					String d = result2.getString("specjalizacja");

					listaLekarzy.getItems().add(a + " " + b + " " + c + " " + " " + d);

				}

			}

		}

		catch (Exception e) {
			System.err.println("Niepoprawny fromat danych, cos poszlo nie tak");
		}

	}

}
