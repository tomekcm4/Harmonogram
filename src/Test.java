import java.sql.Connection;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.Scanner;
import java.util.regex.MatchResult;
import java.util.stream.Collectors;

public class Test extends Application {

	@Override
	public void start(Stage primaryStage) throws Exception {
		Parent root = FXMLLoader.load(getClass().getResource("sample.fxml"));
		primaryStage.setTitle("GRAFIK");
		primaryStage.setHeight(600);
		primaryStage.setWidth(800);
		primaryStage.setScene(new Scene(root, 300, 275));
		primaryStage.show();

	}

	public static void main(String[] args) {

		launch(args);

		// dodawanieRekorduPacjent();
		// dodawanieRekorduLekarz("Jan", "Majka", 101, "OKULISTA");

		// Util u = new Util();

		// List<Grafik> g = u.getListaGrafik();

		// g.stream().forEach(o -> System.out.println(o));
		// u.walidacjaStatusu();

		// System.out.println();

		// Pacjent pacjent1 = new Pacjent("Jan", "S202tary", 45);
		// Lekarz lekarz1 = new Lekarz("Lekarz1", "Nazwisko1", 101, "ENDOKRYNOLOG");
		// Lekarz lekarz2 = new Lekarz("Lekarz2", "Nazwisko2",102, "OKULISTA");

		// Lekarz d = u.getListaGrafik().stream().filter(o ->
		// o.getLekarz().getImie().equals("Lekarz1")).map(o ->
		// o.getLekarz()).findAny().get();
		// System.out.println(d);

		// u.zarezerwujTermin(pacjent1, lekarz2, Specjalizacja.OKULISTA);
		// System.out.println();
//u.limit2();

		// g.stream().forEach(o -> System.out.println(o));
		walidacjaDaty();
		// harmonogram();

		// anulujTermin("2020-07-07", 1, 101);
		grafikLekarza1(101);
		// rezerwacja2();

	}

	private static void walidacjaDaty() {

		try {

			Connection con1 = DBConnector.getConnection();
			PreparedStatement pst6 = null;
			System.out.println("Connected to Database");
			String sql = "select ldt from grafik1";
			pst6 = con1.prepareStatement(sql);
			ResultSet result6 = pst6.executeQuery();
			while (result6.next()) {

				String a = result6.getString("ldt");
//System.out.println(a);

				DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
				LocalDate localDate = LocalDate.parse(a, formatter);
				if (localDate.isBefore(LocalDate.now())) {

					String sql7 = "update grafik1 set czyWykonany = '1' where ldt= '" + a + "'";
					PreparedStatement st7 = con1.prepareStatement(sql7);
					st7.executeUpdate();

				}

			}
		}

		catch (SQLException e) {
			e.printStackTrace();
		}

	}

	private static void rezerwacja() {
		try {

			Connection con = DBConnector.getConnection();
			PreparedStatement pst = null;
			System.out.println("Connected to Database");
			String sql = "select * from pacjent";
			pst = con.prepareStatement(sql);
			ResultSet result = pst.executeQuery();
			while (result.next()) {
				int i = 1;
				Pacjent pacjenti = new Pacjent(result.getString("imie"), result.getString("nazwisko"),
						result.getInt("IDpacjenta"));
				i++;

			}
		}

		catch (SQLException e) {
			e.printStackTrace();
		}
	}

	private static void rezerwacja2() {

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
				System.out.println(grafik.toString());

				System.out.println(grafik.isCzyWykonany());
			}

			Scanner sc = new Scanner(System.in);
			System.out.println("Podaj termin w formacie YYYY-MM-DD");

			String data = sc.nextLine();

			int IDpacjenta = 0;
			while (IDpacjenta < 1 || IDpacjenta > 5) {
				System.out.println("Podaj ID pacjenta: zakres 1-5");
				IDpacjenta = sc.nextInt();
			}

			String sql3 = "select * from lekarz";
			PreparedStatement st2 = con.prepareStatement(sql3);
			ResultSet result2 = st2.executeQuery();
			result2 = st2.executeQuery();
			while (result2.next()) {
				String a = result2.getString("imie");
				String b = result2.getString("nazwisko");
				int c = result2.getInt("IDlekarza");
				String d = result2.getString("specjalizacja");

				System.out.println(a + " " + b + " " + c + " " + " " + d);
			}

			int IDlekarza = 0;
			while (IDlekarza < 101 || IDlekarza > 104) {
				System.out.println();
				System.out.println("Podaj ID lekarza: zakres 101 - 104");
				IDlekarza = sc.nextInt();

				String sql5 = "select imie,nazwisko FROM lekarz WHERE IDlekarza= '" + IDlekarza + "'";
				PreparedStatement st5 = con.prepareStatement(sql5);
				ResultSet result3 = st5.executeQuery();
				result3 = st5.executeQuery();
				while (result3.next()) {

					String x = result3.getString("imie") + " " + result3.getString("nazwisko");

					System.out.println(
							"Twoja wizyta u lekarza " + x + " w dniu " + data + " czekamy na potwierdzenie....");
				}

			}

			String sql11 = "select czyZarezerwowany, czyWykonany from grafik1 where ldt= '" + data + "'"
					+ "AND IDlekarza= '" + IDlekarza + "'";
			PreparedStatement st11 = con.prepareStatement(sql11);
			ResultSet result11 = st11.executeQuery();
			result11 = st11.executeQuery();
			while (result11.next()) {

				if (!result11.getBoolean("czyZarezerwowany") && !result11.getBoolean("czyWykonany")) {

					String sql1 = "update grafik1 set IDpacjenta = '" + IDpacjenta + "'where ldt= '" + data + "'"
							+ "AND IDlekarza= '" + IDlekarza + "'";
					PreparedStatement st1 = con.prepareStatement(sql1);
					st1.executeUpdate();

					// System.out.println("GOTOWE !!!!!!!!!" );

					String sql4 = "update grafik1 set czyZarezerwowany = '1' where ldt= '" + data + "'"
							+ "AND IDlekarza= '" + IDlekarza + "'";
					PreparedStatement st4 = con.prepareStatement(sql4);
					st4.executeUpdate();
					System.out.println("SUKCES!!!");
				} else {
					System.out.println("NIEPOWODZENIE");
				}

			}

		}

		catch (SQLException e) {
			e.printStackTrace();
			System.out.println("Rezerwacja nie przebiegla prawidlowo");
		}

		catch (Exception e) {
			System.err.println("Niepoprawny fromat danych, cos poszlo nie tak");
		}
	}

	private static void dodawanieRekorduPacjent() {
		try {

			Connection con = DBConnector.getConnection();
			PreparedStatement pst = null;
			System.out.println("Connected to Database");
			String sql = "INSERT INTO pacjent (imie,nazwisko, wiek)" + "VALUES(?,?,?)";
			pst = con.prepareStatement(sql);

			pst.setString(1, "michal");
			pst.setString(2, "chory");
			pst.setInt(3, 22);
			pst.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	private static void dodawanieRekorduLekarz(String a, String b, int c, String d) {
		try {

			Connection con = DBConnector.getConnection();
			PreparedStatement pst = null;
			System.out.println("Rekord dodany");
			System.out.println("Connected to Database");
			String sql = "INSERT INTO lekarz" + "(imie,nazwisko, IDLekarza, specjalizacja)" + "VALUES(?,?,?,?)";
			pst = con.prepareStatement(sql);
			pst.setString(1, a);
			pst.setString(2, b);
			pst.setInt(3, c);
			pst.setString(4, d);
			pst.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	private static void harmonogram() {

	}

	private static void anulujTermin(String ldt, int IDpacjenta, int IDlekarza) {

		try {

			Connection con = DBConnector.getConnection();
			String sql1 = "update grafik1 set czyZarezerwowany = '0', czyWykonany = '0', IDpacjenta = null WHERE IDpacjenta = '"
					+ IDpacjenta + "'" + "AND IDlekarza ='" + IDlekarza + "'" + "AND ldt = '" + ldt + "'";
			PreparedStatement st1 = con.prepareStatement(sql1);
			st1.executeUpdate();
		}

		catch (SQLException e) {
			e.printStackTrace();
		}

		catch (Exception e) {
			e.printStackTrace();
		}

	}

	private static void grafikLekarza1(int IDLekarza) {

		try {
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

				System.out.println(grafik.toString());

			}

		}

		catch (SQLException e) {
			e.printStackTrace();

		}

	}

}
