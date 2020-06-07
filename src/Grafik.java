import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Optional;

public class Grafik {
	
	
	LocalDate ldt;
	Lekarz lekarz;
	Pacjent pa;
	boolean czyZarezerwowany;
	boolean czyWykonany;
	int IDpacjenta;
	int IDlekarza;
	String imie;
	String nazwisko;
	String imiee;
	String nazwiskoo;
	
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

	

	public String getImiee() {
		return imiee;
	}


	public void setImiee(String imiee) {
		this.imiee = imiee;
	}


	public String getNazwiskoo() {
		return nazwiskoo;
	}


	public void setNazwiskoo(String nazwiskoo) {
		this.nazwiskoo = nazwiskoo;
	}


	public Grafik() {
		
		
	}
	
public Grafik(String imie) {
		this.imie = imie;
		
	}
	
public Grafik(LocalDate ldt, boolean czyZarezerwowany, boolean czyWykonany, String imie, String nazwisko, String imiee, String nazwiskoo) {
	super();
	this.ldt = ldt;
	this.czyZarezerwowany = czyZarezerwowany;
	this.czyWykonany = czyWykonany;
	this.imie = imie;
	this.nazwisko = nazwisko;
	this.imiee = imiee;
	this.nazwiskoo = nazwiskoo;	
	
	}


	
	

	public Grafik(LocalDate ldt, boolean czyZarezerwowany, boolean czyWykonany, int iDpacjenta, int iDlekarza) {
		super();
		this.ldt = ldt;
		this.czyZarezerwowany = czyZarezerwowany;
		this.czyWykonany = czyWykonany;
		IDpacjenta = iDpacjenta;
		IDlekarza = iDlekarza;
	}
	public Grafik(LocalDate ldt, Lekarz lekarz) {
		super();
		this.ldt = ldt;
		this.lekarz = lekarz;
		this.czyZarezerwowany = false;
		this.czyWykonany = false;
	}
	public LocalDate getLdt() {
		return ldt;
	}
	public void setLdt(LocalDate ldt) {
		this.ldt = ldt;
	}
	public Lekarz getLekarz() {
		return lekarz;
	}
	public void setLekarz(Lekarz lekarz) {
		this.lekarz = lekarz;
	}

	/*
	 * public Optional<Pacjent> getPacjent() { return pacjent; } public void
	 * setPacjent(Optional<Pacjent> pacjent) { this.pacjent = pacjent; }
	 */
	public boolean isCzyZarezerwowany() {
		return czyZarezerwowany;
	}
	public void setCzyZarezerwowany(boolean czyZarezerwowany) {
		this.czyZarezerwowany = czyZarezerwowany;
	}
	public boolean isCzyWykonany() {
		return czyWykonany;
	}
	public void setCzyWykonany(boolean czyWykonany) {
		this.czyWykonany = czyWykonany;
	}



	public int getIDpacjenta() {
		return IDpacjenta;
	}


	public void setIDpacjenta(int iDpacjenta) {
		IDpacjenta = iDpacjenta;
	}


	public int getIDlekarza() {
		return IDlekarza;
	}


	public void setIDlekarza(int iDlekarza) {
		IDlekarza = iDlekarza;
	}


	@Override
	public String toString() {
		return "Grafik [ldt=" + ldt + ", czyZarezerwowany=" + czyZarezerwowany + ", czyWykonany=" + czyWykonany
				+ ", IDpacjenta=" + IDpacjenta + ", IDlekarza=" + IDlekarza + "]";
	}
	public void setPacjent(Pacjent pac) {
		this.pa = pac;
		
	}
	public Pacjent getPa() {
		return pa;
	}
	public void setPa(Pacjent pa) {
		this.pa = pa;
	}
	
	

}
