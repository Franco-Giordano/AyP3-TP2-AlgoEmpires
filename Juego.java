package cosasVarias;


import java.util.ArrayList;

public class Juego {

	private ArrayList<Jugador> jugadores;
	
	public Juego() {
		
		int numeroDeJugadores=2;
		
		for (int i = 0; i <= numeroDeJugadores; i++) {
			Jugador nuevoJugador= new Jugador();
			jugadores.add(nuevoJugador);
			
			System.out.println("Jugador" +i+ " agregado correctamente.");
		}
		
		
	}
}
