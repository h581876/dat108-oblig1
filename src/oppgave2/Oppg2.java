package oppgave2;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;

public class Oppg2 {
	
	private static void lonnsoppgjor(List<Ansatt> ansatte, Function<Ansatt, Integer> funksjon) {
		ansatte.forEach(a -> a.setAarslonn(funksjon.apply(a)));
	}
	
	
	private static void skrivUtAlle(List<Ansatt> ansatte) {
		ansatte.forEach(System.out::println);
	}

	public static void main(String[] args) {
		
		List<Ansatt> ansatteListe = new ArrayList<>();
		ansatteListe.add(new Ansatt("Per", "Hansen", Kjonn.MANN, "Utvikler", 800000));
		ansatteListe.add(new Ansatt("Kari", "Olsen", Kjonn.KVINNE, "Lærer", 650000));
		ansatteListe.add(new Ansatt("Ole", "Larsen", Kjonn.MANN, "Elektriker", 750000));
		ansatteListe.add(new Ansatt("Kristine", "Johansen", Kjonn.KVINNE, "Butikkansatt", 400000));
		ansatteListe.add(new Ansatt("Tore", "Berg", Kjonn.MANN, "Ingeniør", 950000));
		
		
		Function<Ansatt, Integer> kroneTillegg = x -> x.getAarslonn() + 30000;
		
		Function<Ansatt, Integer> prosentTillegg = x -> (int) (x.getAarslonn() * 1.05);
		
		Function<Ansatt, Integer> lavLonnTillegg = x -> {
			if (x.getAarslonn() < 500000) {
				return x.getAarslonn() + 25000;
			}
			return x.getAarslonn();
		};
		
		Function<Ansatt, Integer> mannTillegg = x -> {
			if (x.getKjonn() == Kjonn.MANN) {
				return (int)(x.getAarslonn() * 1.04);
			}
			return x.getAarslonn();
		};
		
		System.out.println("Liste med kronetillegg: ");
		lonnsoppgjor(ansatteListe, kroneTillegg);
		skrivUtAlle(ansatteListe);
		
		System.out.println();
		System.out.println("Liste med prosenttillegg: ");
		
		lonnsoppgjor(ansatteListe, prosentTillegg);
		skrivUtAlle(ansatteListe);
		
		System.out.println();
		System.out.println("Liste med tillegg for lavlønn: ");
		
		lonnsoppgjor(ansatteListe, lavLonnTillegg);
		skrivUtAlle(ansatteListe);
				
		System.out.println();
		System.out.println("Liste med tillegg for menn: ");
		
		lonnsoppgjor(ansatteListe, mannTillegg);
		skrivUtAlle(ansatteListe);
		
		
		

	}

}
