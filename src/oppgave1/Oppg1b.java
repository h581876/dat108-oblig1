package oppgave1;

import java.util.function.BiFunction;

public class Oppg1b {
	
	public static int beregn(int a, int b, BiFunction<Integer, Integer, Integer> funksjon) {
		return funksjon.apply(a, b);
		}

	public static void main(String[] args) {
		
		
		BiFunction<Integer, Integer, Integer> summerFunksjon = (a, b) -> a + b;
		
		BiFunction<Integer, Integer, Integer> størsteFunksjon = (a, b) -> Math.max(a, b);
		
		BiFunction<Integer, Integer, Integer> avstandFunksjon = (a, b) -> Math.abs(a - b);
		
		int sum = beregn(12, 13, summerFunksjon);
		
		System.out.println("Summen er: " + sum);
		
		int største = beregn(-5, 3, størsteFunksjon);
		
		System.out.println("Største tallet er: " + største);
		
		int avstand = beregn(54, 45, avstandFunksjon);
		
		System.out.println("Avstanden er: " + avstand);
		
	}

}
