
public class Pacjent {
	
	int IDpacjenta;
	String imie;
	String nazwisko;
	
	
	
	public Pacjent(String imie, String nazwisko, int IDpacjenta) {
		super();
		this.imie = imie;
		this.nazwisko = nazwisko;
		this.IDpacjenta = IDpacjenta;
	}
	public String getImie() {
		return imie;
	}
	public void setImie(String imie) {
		this.imie = imie;
	}
	public String getNazwisko() {
		return nazwisko;
	}
	public void setNazwisko(String nazwisko) {
		this.nazwisko = nazwisko;
	}
	public int getIDpacjenta() {
		return IDpacjenta;
	}
	public void setIDpacjenta(int wiek) {
		this.IDpacjenta = wiek;
	}
	@Override
	public String toString() {
		return "Pacjent [imie=" + imie + ", nazwisko=" + nazwisko + ", wiek=" + IDpacjenta + "]";
	}
	
	
	

}
