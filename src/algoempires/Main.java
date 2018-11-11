package algoempires;


import algoempires.entidad.unidad.utilero.Aldeano;
import algoempires.entidad.unidad.guerrero.Arquero;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		
		Scanner scanner= new Scanner(System.in); 
		System.out.println("Por ahora, todo bien.");
		
		Aldeano aldeano= new Aldeano();
		Terreno terreno= new Terreno(10, 10);
		Arquero alvaro = new Arquero();
		
		System.out.println("Coordenada horizontal:");
		int coordenadaHorizontal=scanner.nextInt();
		
		System.out.println("Coordenada vertical:");
		int coordenadaVertical= scanner.nextInt();		
		
		System.out.println("Ingresaste en: " + coordenadaHorizontal+ ","+ coordenadaVertical);
		
		terreno.ocuparParcela(coordenadaHorizontal, coordenadaVertical, alvaro);
		
		System.out.println("Coordenada horizontal:");
		int coordenadaHorizontalDeAtaque=scanner.nextInt();
		
		System.out.println("Coordenada vertical:");
		int coordenadaVerticalDeAtaque= scanner.nextInt();	
		
		if(alvaro.tieneRangoSuficiente(coordenadaHorizontalDeAtaque, coordenadaVerticalDeAtaque)){
			System.out.println("Está en rango");
		}
		
	}

}
