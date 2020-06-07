import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

public class drugiController implements Initializable {
	
	
    @FXML
    private TableView<Grafik> table;
    @FXML
    private TableColumn<Grafik,String> col_data;
    @FXML
    private TableColumn<Grafik,String> col_rez;
    @FXML
    private TableColumn<Grafik,String> col_wyk;
    @FXML
    private TableColumn<Grafik,String> col_pacimie;
    @FXML
    private TableColumn<Grafik,String> col_pacnazwisko;
    @FXML
    private TableColumn<Grafik,String> col_lekimie;
    @FXML
    private TableColumn<Grafik,String> col_leknazwisko;
    
    
	
    ObservableList<Grafik> oblist = FXCollections.observableArrayList();

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {


		try {
			Grafik grafik = new Grafik();
			Connection con = DBConnector.getConnection();
			PreparedStatement pst = null;
			DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
String sql = "select grafik1.ldt, grafik1.czyZarezerwowany, grafik1.czyWykonany, pacjent.imie, pacjent.nazwisko, lekarz.imie, lekarz.nazwisko from grafik1 LEFT JOIN pacjent on pacjent.IDpacjenta = grafik1.IDpacjenta JOIN lekarz on lekarz.IDlekarza = grafik1.IDlekarza";
			pst = con.prepareStatement(sql);
			ResultSet result = pst.executeQuery();
			result = pst.executeQuery();
			while (result.next()) {
				/*
				 * grafik = new Grafik(LocalDate.parse(result.getString("ldt"), formatter),
				 * result.getBoolean("czyZarezerwowany"), result.getBoolean("czyWykonany"),
				 * result.getInt("IDpacjenta"), result.getInt("IDlekarza"));
				 */
				//System.out.println(grafik.toString());
				
oblist.add(new Grafik(LocalDate.parse(result.getString("ldt"), formatter),
		result.getBoolean("czyZarezerwowany"), result.getBoolean("czyWykonany"),
		result.getString("pacjent.imie"), result.getString("pacjent.nazwisko"), result.getString("lekarz.imie"), result.getString("lekarz.nazwisko")));


				

			}
		}

		catch (SQLException e) {
			e.printStackTrace();
		}

		catch (Exception e) {
			e.printStackTrace();
		}
		
		System.out.println(oblist);
		
		 col_data.setCellValueFactory(new PropertyValueFactory<>("ldt"));
	        col_rez.setCellValueFactory(new PropertyValueFactory<>("czyZarezerwowany"));
	        col_wyk.setCellValueFactory(new PropertyValueFactory<>("czyWykonany"));
	        col_pacimie.setCellValueFactory(new PropertyValueFactory<>("imie"));
	        col_pacnazwisko.setCellValueFactory(new PropertyValueFactory<>("nazwisko"));
	        col_lekimie.setCellValueFactory(new PropertyValueFactory<>("imiee"));
	        col_leknazwisko.setCellValueFactory(new PropertyValueFactory<>("nazwiskoo"));

	        table.setItems(oblist);
	        
	        
		
	}
	
	
	 public void dodaj() throws IOException {
		Parent root = FXMLLoader.load(getClass().getResource("trzeci.fxml"));
		Stage stage1 = new Stage();
		stage1.setScene(new Scene(root));
		stage1.setTitle("Formatka dodaj rekord");
		stage1.show();


	    }

}
