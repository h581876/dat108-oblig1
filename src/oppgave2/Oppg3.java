package oppgave2;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.OptionalDouble;
import java.util.stream.IntStream;

public class Oppg3 {
	
	
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
		ansatteListe.add(new Ansatt("Hans", "Hansen", Kjonn.MANN, "Banksjef", 2000000));
		ansatteListe.add(new Ansatt("Tor", "Torsen", Kjonn.MANN, "Butikksjef",850000));
		
		//a)
		List<String> etternavnListe = ansatteListe.stream()
				.map(Ansatt::getEtternavn)
				.toList();
		etternavnListe.forEach(System.out::println);
		
		System.out.println();
		
		//b)
		long antallKvinnerListe = ansatteListe.stream()
				.filter(kjønn -> kjønn.getKjonn() == Kjonn.KVINNE)
				.count();
		System.out.println("Antall kvinner:" + antallKvinnerListe);
		
		System.out.println();
		
		//c
		double snittLønnKvinner = ansatteListe.stream()
				.filter(kjønn -> kjønn.getKjonn() == Kjonn.KVINNE)
				.mapToInt(lønn -> lønn.getAarslonn())
				.average()
				.orElse(0);	
		System.out.println("Snittlønn for kvinner: " + snittLønnKvinner);
		
		System.out.println();
		
		//d)
		ansatteListe.stream()
				.filter(sjef -> sjef.getStilling().toLowerCase().contains("sjef"))
				.forEach(a -> a.setAarslonn((int) (a.getAarslonn() * 1.07)));
		ansatteListe.forEach(System.out::println);
		
		System.out.println();
		
		
		//e)
		boolean merEnn = ansatteListe.stream()
				.anyMatch(lønn -> lønn.getAarslonn() > 800000);
		System.out.println(merEnn);
		
		System.out.println();
		
		//f 
		ansatteListe.forEach(System.out::println);
		
		System.out.println();
		
		//g)
		Optional<Ansatt> lavestLønn = ansatteListe.stream()
				.min(Comparator.comparingInt(lønn -> lønn.getAarslonn()));
		lavestLønn.ifPresent(System.out::println);
		
		System.out.println();
		
		//h
		IntStream intervall = IntStream.range(1, 1000);
		
		int sumHeltall = intervall
				.filter(x -> x % 3 == 0 || x % 5 == 0 )
				.sum();
		System.out.println("Sum av tall: " + sumHeltall);
		
			

				
		
				
		
		
		
				
				
				
				
				
			
		
		
		
		
	}

}
