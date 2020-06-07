import java.util.List;

public class Lekarz {
	
	String imie;
	String naziwsko;
	int IDlekarza;
	List<Specjalizacja> listaSpecjalizacji;
	String specjalizacja;
	
	public Lekarz(String imie, String naziwsko, int iDlekarza, String specjalizacja) {
		super();
		this.imie = imie;
		this.naziwsko = naziwsko;
		IDlekarza = iDlekarza;
		this.specjalizacja = specjalizacja;
	}
	
	
	
	
	public String getSpecjalizacja() {
		return specjalizacja;
	}




	public void setSpecjalizacja(String specjalizacja) {
		this.specjalizacja = specjalizacja;
	}




	public Lekarz(String imie, String naziwsko, int iDlekarza, List<Specjalizacja> listaSpecjalizacji) {
		super();
		this.imie = imie;
		this.naziwsko = naziwsko;
		IDlekarza = iDlekarza;
		this.listaSpecjalizacji = listaSpecjalizacji;
	}
	public String getImie() {
		return imie;
	}
	public void setImie(String imie) {
		this.imie = imie;
	}
	public String getNaziwsko() {
		return naziwsko;
	}
	public void setNaziwsko(String naziwsko) {
		this.naziwsko = naziwsko;
	}
	public int getIDlekarza() {
		return IDlekarza;
	}
	public void setIDlekarza(int iDlekarza) {
		IDlekarza = iDlekarza;
	}
	public List<Specjalizacja> getListaSpecjalizacji() {
		return listaSpecjalizacji;
	}
	public void setListaSpecjalizacji(List<Specjalizacja> listaSpecjalizacji) {
		this.listaSpecjalizacji = listaSpecjalizacji;
	}
	@Override
	public String toString() {
		return "Lekarz [imie=" + imie + ", naziwsko=" + naziwsko + ", IDlekarza=" + IDlekarza + ", listaSpecjalizacji="
				+ specjalizacja + "]";
	}
	
	
	
	
	


}
