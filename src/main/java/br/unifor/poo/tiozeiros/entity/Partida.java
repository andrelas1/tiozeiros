package br.unifor.poo.tiozeiros.entity;

import java.util.Date;
import java.util.Timer;

/**
 * Created by andre on 12/11/16.
 */
public class Partida {
    private Equipe equipe1;
    private Equipe equipe2;
    private String resultado;
    private Timer tempo;
    private Date data;

    public void setData(Date data) {
        this.data = data;
    }

    public void setEquipe1(Equipe equipe1) {
        this.equipe1 = equipe1;
    }

    public void setEquipe2(Equipe equipe2) {
        this.equipe2 = equipe2;
    }

    public void setResultado(String resultado) {
        this.resultado = resultado;
    }

    public void setTempo(Timer tempo) {
        this.tempo = tempo;
    }

    public Equipe getEquipe1() {
        return this.equipe1;
    }

    public Equipe getEquipe2() {
        return this.equipe2;
    }

    public String getResultado() {
        return this.resultado;
    }

    public Timer getTempo() {
        return this.tempo;
    }

    public Date getData() {
        return this.data;
    }
}
