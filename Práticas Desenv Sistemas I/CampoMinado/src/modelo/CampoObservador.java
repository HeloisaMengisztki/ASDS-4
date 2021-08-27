package modelo;

@FunctionalInterface
public interface CampoObservador {
	void ocorreuEvento(Campo campo, Eventos evento);
}
