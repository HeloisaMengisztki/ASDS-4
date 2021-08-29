package jogo;

@FunctionalInterface
public interface CampoObservador {
	void ocorreuEvento(Campo campo, Eventos evento);
}
