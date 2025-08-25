package oppgave2;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;

public class Oppg2 {
	
	private static void lonnsoppgjor(List<Ansatt> ansatte, Function<Ansatt, Integer> funksjon) {
		for (Ansatt a : ansatte) {
			a.setAarslonn(funksjon.apply(a));
		}
	}
	
	
	private static void skrivUtAlle(List<Ansatt> ansatte) {
		for (Ansatt a : ansatte) {
			System.out.println(a);
		}
	}

	public static void main(String[] args) {
		
		List<Ansatt> ansatteListe = new ArrayList<>();
		ansatteListe.add(new Ansatt("Per", "Hansen", Kjonn.MANN, "Utvikler", 55000));
		ansatteListe.add(new Ansatt("Kari", "Olsen", Kjonn.KVINNE, "Lærer", 45000));
		ansatteListe.add(new Ansatt("Ole", "Larsen", Kjonn.MANN, "Elektriker", 50000));
		ansatteListe.add(new Ansatt("Kristine", "Johansen", Kjonn.KVINNE, "Butikkansatt", 25000));
		ansatteListe.add(new Ansatt("Tore", "Berg", Kjonn.MANN, "Ingeniør", 70000));
		
		
		Function<Ansatt, Integer> kroneTillegg = x -> x.getAarslonn() + 5000;
		
		Function<Ansatt, Integer> prosentTillegg = x -> (int) (x.getAarslonn() * 1.05);
		
		Function<Ansatt, Integer> lavLonnTillegg = x -> {
			if (x.getAarslonn() < 40000) {
				return x.getAarslonn() + 2000;
			}
			return x.getAarslonn();
		};
		
		Function<Ansatt, Integer> mannTillegg = x -> {
			if (x.getKjonn() == Kjonn.MANN) {
				return (int)(x.getAarslonn() * 1.04);
			}
			return x.getAarslonn();
		};
		
		lonnsoppgjor(ansatteListe, kroneTillegg);
		skrivUtAlle(ansatteListe);
		
		System.out.println();
		
		lonnsoppgjor(ansatteListe, prosentTillegg);
		skrivUtAlle(ansatteListe);
		
		System.out.println();
		
		lonnsoppgjor(ansatteListe, lavLonnTillegg);
		skrivUtAlle(ansatteListe);
				
		System.out.println();
		
		lonnsoppgjor(ansatteListe, mannTillegg);
		skrivUtAlle(ansatteListe);
		
		
		

	}

}
