package algoempires;

public class Parcela {

	private boolean ocupada;
	private Entidad entidadOcupante;

	Parcela() {
		ocupada = false;
		entidadOcupante = null;
	}

	public void ocupar(Entidad entidadOcupanteRecibida) {
		this.entidadOcupante = entidadOcupanteRecibida;
		ocupada = true;
	}

	public boolean estaOcupada() {
		return ocupada;
	}

}
