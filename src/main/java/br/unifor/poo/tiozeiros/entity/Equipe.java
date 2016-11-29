package br.unifor.poo.tiozeiros.entity;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by andre on 12/11/16.
 */
public class Equipe {

    private final Integer quantidadeJogadores = 4;
    private List<Jogadores> jogadores = new ArrayList<Jogadores>();
    private Integer vitórias, derrotas, empates;

    public void setDerrotas(Integer derrotas) {
        this.derrotas = derrotas;
    }

    public void setEmpates(Integer empates) {
        this.empates = empates;
    }

    public void setVitórias(Integer vitórias) {
        this.vitórias = vitórias;
    }

    /*public void addJogador(Jogadores jogadores) {
        if (jogadores.size() < 5) {
            this.jogadores.add(jogadores);
        }

    }*/

    public Integer getDerrotas() {
        return this.derrotas;
    }

    public Integer getVitórias() {
        return this.vitórias;
    }

    public Integer getEmpates() {
        return this.empates;
    }

    public List<Jogadores> getJogadores() {
        return this.jogadores;
    }

}
