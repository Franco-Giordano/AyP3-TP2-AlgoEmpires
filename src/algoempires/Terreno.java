package algoempires;


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

	/*

	public Region generarRegionCentradaEn(Parcela parcelaActual) {
		//int[] coordenadas = this.encontrarCoordenadasParcela(parcelaActual);

		//TODO hacer que genere la region, iterando en los adyacentes a las coordenadas.
	}



	//TODO esto capaz se puede evitar con un objeto Coordenada, que lo tendria unidad/entidad/etc
	private int[] encontrarCoordenadasParcela(Parcela parcelaActual) {
		int[] coordenadas = new int[2];

		//TODO encontrar la parcela...
	}*/
}
