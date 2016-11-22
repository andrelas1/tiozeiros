package br.unifor.poo.tiozeiros.entity;

import java.util.Date;
import java.util.Timer;

/**
 * Created by andre on 12/11/16.
 */
public class Partidas {
    private Equipe equipe1;
    private Equipe equipe2;
    private String resultado;
    private Timer tempo;
    private Date data;

    public Partidas(Equipe equipe1, Equipe equipe2, Timer tempo){
        this.equipe1 = equipe1;
        this.equipe2 = equipe2;
        this.tempo = tempo;
    }

    public Partidas(){

    }

    public void iniciarPartida(Integer tempoMinutos){
        int time = tempoMinutos*60;
        do{
            int minutes = time / 60;
            int seconds = time % 60;
            System.out.println(minutes + ":" + seconds);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            time = time - 1;
        }while(time!=0);
        System.out.println("Time's up");
    }

    public void setData(Date data) {
        this.data = data;
    }

    public void setResultado(String resultado) {
        this.resultado = resultado;
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
