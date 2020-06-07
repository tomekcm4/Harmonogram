import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Month;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.Scanner;
import java.util.regex.MatchResult;
import java.util.stream.Collectors;

public class Util {
	
	List<Grafik> listaGrafik = new ArrayList<>();
	
	
	public void setListaGrafik(List<Grafik> listaGrafik) {
		this.listaGrafik = listaGrafik;
	}
	
	
	Pacjent pacjent1 = new Pacjent("Jan", "Stary", 45);
	Pacjent pacjent2 = new Pacjent("Jerzy", "Nowy", 25);
	Pacjent pacjent3 = new Pacjent("Adam", "Len", 45);
	Pacjent pacjent4 = new Pacjent("Michal", "Chorowity", 45);
	Pacjent pacjent5 = new Pacjent("Stefan", "Batory", 45);
	
	Lekarz lekarz1 = new Lekarz("Lekarz1", "Nazwisko1", 101, "ENDOKRYNOLOG");
	Lekarz lekarz2 = new Lekarz("Lekarz2", "Nazwisko2", 102, "OKULISTA");
	Lekarz lekarz3 = new Lekarz("Lekarz3", "Nazwisko3", 103, "INTERNISTA");
	Lekarz lekarz4 = new Lekarz("Lekarz4", "Nazwisko4", 104, "OKULISTA");
	

	/*
	 * Grafik grafik1 = new Grafik(LocalDateTime.of(2020, Month.JUNE, 1, 10, 0),
	 * lekarz1); Grafik grafik2 = new Grafik(LocalDateTime.of(2020, Month.JUNE, 2,
	 * 10, 0), lekarz1); Grafik grafik3 = new Grafik(LocalDateTime.of(2020,
	 * Month.JUNE, 3, 10, 0), lekarz1); Grafik grafik4 = new
	 * Grafik(LocalDateTime.of(2020, Month.JUNE, 4, 10, 0), lekarz1); Grafik grafik5
	 * = new Grafik(LocalDateTime.of(2020, Month.JUNE, 5, 10, 0), lekarz1); Grafik
	 * grafik6 = new Grafik(LocalDateTime.of(2020, Month.JUNE, 6, 10, 0), lekarz1);
	 * Grafik grafik7 = new Grafik(LocalDateTime.of(2020, Month.JUNE, 7, 10, 0),
	 * lekarz1);
	 * 
	 * Grafik grafik8 = new Grafik(LocalDateTime.of(2020, Month.JUNE, 1, 10, 0),
	 * lekarz2); Grafik grafik9 = new Grafik(LocalDateTime.of(2020, Month.JUNE, 2,
	 * 10, 0), lekarz2); Grafik grafik10 = new Grafik(LocalDateTime.of(2020,
	 * Month.JUNE, 3, 10, 0), lekarz2); Grafik grafik11 = new
	 * Grafik(LocalDateTime.of(2020, Month.JUNE, 4, 10, 0), lekarz2); Grafik
	 * grafik12 = new Grafik(LocalDateTime.of(2020, Month.JUNE, 5, 10, 0), lekarz2);
	 * Grafik grafik13 = new Grafik(LocalDateTime.of(2020, Month.JUNE, 6, 10, 0),
	 * lekarz2); Grafik grafik14 = new Grafik(LocalDateTime.of(2020, Month.JUNE, 7,
	 * 10, 0), lekarz2);
	 * 
	 * 
	 * Grafik grafik15 = new Grafik(LocalDateTime.of(2020, Month.JUNE, 1, 10, 0),
	 * lekarz3); Grafik grafik16 = new Grafik(LocalDateTime.of(2020, Month.JUNE, 2,
	 * 10, 0), lekarz3); Grafik grafik17 = new Grafik(LocalDateTime.of(2020,
	 * Month.JUNE, 3, 10, 0), lekarz3); Grafik grafik18 = new
	 * Grafik(LocalDateTime.of(2020, Month.JUNE, 4, 10, 0), lekarz3); Grafik
	 * grafik19 = new Grafik(LocalDateTime.of(2020, Month.JUNE, 5, 10, 0), lekarz3);
	 * Grafik grafik20 = new Grafik(LocalDateTime.of(2020, Month.JUNE, 6, 10, 0),
	 * lekarz3); Grafik grafik21 = new Grafik(LocalDateTime.of(2020, Month.JUNE, 7,
	 * 10, 0), lekarz3);
	 */
	

	
	/*
	 * public List<Grafik> getListaGrafik() { listaGrafik.add(grafik1);
	 * listaGrafik.add(grafik2); listaGrafik.add(grafik3); listaGrafik.add(grafik4);
	 * listaGrafik.add(grafik5); listaGrafik.add(grafik6); listaGrafik.add(grafik7);
	 * listaGrafik.add(grafik8); listaGrafik.add(grafik9);
	 * listaGrafik.add(grafik10); listaGrafik.add(grafik11);
	 * listaGrafik.add(grafik12); listaGrafik.add(grafik13);
	 * listaGrafik.add(grafik14); listaGrafik.add(grafik15);
	 * listaGrafik.add(grafik16); listaGrafik.add(grafik17);
	 * listaGrafik.add(grafik18); listaGrafik.add(grafik19);
	 * listaGrafik.add(grafik20); listaGrafik.add(grafik21);
	 * 
	 * 
	 * return listaGrafik; }
	 */
	



//
//	public void walidacjaStatusu() {
//
//		List<Grafik> lg = listaGrafik.stream().collect(Collectors.toList());
//		
//		for(Grafik x: lg) {
//			if(x.getLdt().isAfter(LocalDateTime.now())){
//				x.setCzyWykonany(true);
//			}
//			
//		}
//		
//		
//	}
//	
	
	public void zarezerwujTermin(Pacjent pac, Lekarz l, Specjalizacja spec) {
		System.out.println("Lista dostepny terminow to: ");
		listaGrafik.stream()
			.sorted(Comparator.comparing(Grafik::getLdt))
				.filter(o -> o.czyZarezerwowany == false)
					.filter(o -> o.getLekarz().getImie().equals(l.getImie()))
						.filter(o -> o.getLekarz().getSpecjalizacja().contains(spec.toString())).forEach(o -> System.out.println(o));
		
		List<Grafik> lg = listaGrafik.stream()
		.sorted(Comparator.comparing(Grafik::getLdt))
			.filter(o -> o.czyZarezerwowany == false)
				.filter(o -> o.getLekarz().getImie().equals(l.getImie()))
					.filter(o -> o.getLekarz().getSpecjalizacja().toString().contains(spec.toString())).collect(Collectors.toList());
		
		int rok =0;
		Scanner sc = new Scanner(System.in);
		while(rok < 2020) {
			System.out.println("Podaj date");
		
		
		while(!sc.hasNextInt()){
           System.out.println("Enter a whole number or do not choose data from the past");
           sc.next();

        }
	
		rok = sc.nextInt();
		if(rok < 2020) {
			System.out.println("Data z przeszlosci");
		}
		
		}
		 
       // rok = sc.nextInt();
		/*
		 * Month m = Month.JUNE; System.out.println("Podaj dzien"); int d =
		 * sc.nextInt(); System.out.println("Podaj godzine"); int godzina =
		 * sc.nextInt(); System.out.println("Podaj minute"); int minuta = sc.nextInt();
		 * sc.close();
		 * 
		 * LocalDateTime localDate = LocalDateTime.of(rok, m, d, godzina, minuta);
		 */
		
	    System.out.println("Podaj dane w formacie przykladowo: 27.08 10:00");
	    sc.nextLine();
	    sc.findInLine("(\\d\\d)\\.(\\d\\d)\\ (\\d\\d):(\\d\\d)");
	     // sc.findInLine("(\\d\\d)\\.(\\d\\d)\\ (\\d\\d):(\\d\\d)");
	    try {
	        MatchResult mr = sc.match();
	       int month = Integer.parseInt(mr.group(2));
	       int day = Integer.parseInt(mr.group(1));
	       int hour = Integer.parseInt(mr.group(3));
	       int minute = Integer.parseInt(mr.group(4));
	        LocalDateTime dt = LocalDateTime.of(rok, month, day, hour, minute);
	        System.out.println(dt);
	        
	    	
			for(Grafik x: lg) {
				if(x.getLdt().equals(dt)) {
					x.czyZarezerwowany = true;
					System.out.println(pac.imie);
					x.setPa(pac);
					x.setPacjent(pac);
					System.out.println("ZAREZERWOWANO");
					
				}
				

			}
				if(listaGrafik.stream().allMatch(o -> o.czyZarezerwowany == false)) {

					System.out.println("NIE MA MOZLIWOSC WYBORU TAKIEGO TERMINU");
					
				}
	        
	        
	    } catch (Exception e) {
	        System.err.println("WPISZ PRAWIDLOWE DANE W FORMACIE 27.08 10:00");
	    }
	
	
		
		
			

		}
	
	public void limit() {
		
		Grafik lll = listaGrafik.stream().sorted(Comparator.comparing(Grafik::getLdt)).
				filter(o -> o.getLekarz().getListaSpecjalizacji().toString().contains("OKULISTA")).findFirst().get();
		
		System.out.println(lll);
	}
	
public void limit2() {
		
		listaGrafik.stream().sorted(Comparator.comparing(Grafik::getLdt)).
				filter(o -> o.getLekarz().getListaSpecjalizacji().toString().contains("OKULISTA")).map(o -> o.getPa()).forEach(o -> System.out.println(o));
		
	}

		
	}

	
	
	
	
	
	
	
	
	
	
	
	
	

