package algoempires;


import algoempires.direccion.Direccion;
import algoempires.direccion.DireccionArribaIzquierda;
import algoempires.entidad.Entidad;



public class Terreno {

	private Parcela[][] parcelas;

	public Terreno(int tamanioHorizontal, int tamanioVertical) {

		parcelas = new Parcela[tamanioHorizontal][tamanioVertical];
		
		for (int i = 0; i < tamanioHorizontal; i++) {
			for (int j = 0; j < tamanioVertical; j++) {
				Parcela parcela= new Parcela();
				parcela.setCoordenadaHorizontal(i);		//TODO chequear estos setter, capaz obsoletos
				parcela.setCoordenadaVertical(j);
				parcelas[i][j]= parcela;
			}
		}

	}

	public boolean estaOcupada(int coordenadaHorizontal, int coordenadaVertical) {

		return parcelas[coordenadaHorizontal][coordenadaVertical].estaOcupada();

	}
	
	public void ocuparParcela(int coordenadaHorizontal, int coordenadaVertical, Entidad entidadAAgregar) {
		
		parcelas[coordenadaHorizontal][coordenadaVertical].ocupar(entidadAAgregar);
	}

	public Region obtenerAdyacentesA(Coordenada coordenada){

	    Parcela[][] adyacentes = new Parcela[3][3];

        DireccionArribaIzquierda direccion = new DireccionArribaIzquierda();

        coordenada.mover(direccion);

	    Coordenada coordenadaSuperiorIzquierda = coordenada;

        int corrimientoVertical = coordenadaSuperiorIzquierda.getCoordenadaVertical();

        int corrimientoHorizontal = coordenadaSuperiorIzquierda.getCoordenadaHorizontal();

        for (int i = corrimientoVertical; i < adyacentes.length + corrimientoVertical; i ++){
	        for (int j = corrimientoHorizontal; j < adyacentes[0].length + corrimientoHorizontal; j ++){

	            adyacentes[i - corrimientoVertical][j - corrimientoHorizontal] = this.parcelas[i][j];

            }
        }

        return new Region(adyacentes);

    }

	/*

	public Region generarRegionCentradaEn(Parcela parcelaActual) {
		//int[] coordenadas = this.encontrarCoordenadasParcela(parcelaActual);

		//TODO hacer que genere la region, iterando en los adyacentes a las coordenadas.
	}



	//TODO esto capaz se puede evitar con un objeto algoempires.Coordenada, que lo tendria unidad/entidad/etc
	private int[] encontrarCoordenadasParcela(Parcela parcelaActual) {
		int[] coordenadas = new int[2];

		//TODO encontrar la parcela...
	}*/
}
