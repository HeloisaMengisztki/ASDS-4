package historico;

import java.sql.Time;
import java.util.Date;

public class Historico {
    private Date data;
    private Time duracao;
    private String nivel;
    private String status;
    private FabricaConexao banco;

    public Historico(Date data, Time inicio, Time fim, String nivel, String status) {
        this.data = data;
        this.duracao = fim;
        this.nivel = nivel;
        this.status = status;
    }

    public Historico(){

    }

    public void SalvaBanco() {

    }

    public void BuscaTodos() {

    }

    public String getNivel() {
        return nivel;
    }

    public Time getDuracao() {
        return duracao;
    }

    public java.sql.Date getData() {
        return (java.sql.Date) data;
    }

    public String getStatus() {
        return status;
    }

    public void setNivel(String nivel) {
        this.nivel = nivel;
    }

    public void setDuracao(Time duracao) {
        this.duracao = duracao;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
