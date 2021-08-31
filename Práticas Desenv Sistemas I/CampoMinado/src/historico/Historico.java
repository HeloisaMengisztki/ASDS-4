package historico;

import java.sql.Date;
import java.sql.Time;
import java.time.*;

import static java.time.temporal.ChronoUnit.*;

public class Historico {
    private Date data;
    private Time inicio;
    private Time fim;
    private String nivel;
    private String status;
    private Time duracao;

    public Historico(Date data, Time inicio, String nivel) {
        this.data = data;
        this.inicio = inicio;
        this.nivel = nivel;
    }

    public Historico() {
    }

    public String getNivel() {
        return nivel;
    }

    public void calculaDuracao() {
        var inicio = this.inicio.toLocalTime();
        var fim = this.fim.toLocalTime();


        var horas = (int) inicio.until(fim, HOURS);
        var minutos  = (int) inicio.until(fim, MINUTES);
        var segundos = (int) inicio.until(fim, SECONDS);

        LocalTime time = LocalTime.of(horas, minutos, segundos);
        duracao = Time.valueOf(time);
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

    public void setData(Date data) {
        this.data = data;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public void setFim(Time fim) {
        this.fim = fim;
    }

    public void setDuracao(Time duracao) {
        this.duracao = duracao;
    }

    public Time getDuracao() {
        return this.duracao;
    }
}
