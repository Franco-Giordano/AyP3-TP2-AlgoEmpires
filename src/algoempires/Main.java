package algoempires;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		
		Scanner scanner= new Scanner(System.in); 
		System.out.println("Por ahora, todo bien.");
		
		Aldeano aldeano= new Aldeano();
		Terreno terreno= new Terreno(5, 5);
		
		System.out.println("Coordeanda horizontal:");
		int coordenadaHorizontal=scanner.nextInt();
		
		System.out.println("Coordenada vertical:");
		int coordenadaVertical= scanner.nextInt();		
		
		System.out.println("Ingresaste en: " + coordenadaHorizontal+ ","+ coordenadaVertical);
		
		terreno.ocuparParcela(coordenadaHorizontal, coordenadaVertical, aldeano);
		
		
	}

}
