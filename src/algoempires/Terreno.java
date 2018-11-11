package algoempires;


public class Terreno {

	private Parcela[][] parcelas;

	public Terreno(int tamanioHorizontal, int tamanioVertical) {

		parcelas = new Parcela[tamanioHorizontal][tamanioVertical];
		
		for (int i = 0; i < tamanioHorizontal; i++) {
			for (int j = 0; j < tamanioVertical; j++) {
				Parcela parcela= new Parcela();
				parcela.setCoordenadaHorizontal(i);
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
	
}
