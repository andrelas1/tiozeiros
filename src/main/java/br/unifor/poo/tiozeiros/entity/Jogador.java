package br.unifor.poo.tiozeiros.entity;

/**
 * Created by andre on 12/11/16.
 */
public class Jogador {

    private String nome;
    private Double chute, passe, velocidade, marcação;

    public Jogador(String nome) {
        this.nome = nome;
    }

    public void setChute(Double chute) {
        if (chute >= 0.0 && chute <= 10.0) {
            this.chute = chute;
        }
    }

    public void setMarcação(Double marcação) {
        if (marcação >= 0.0 && marcação <= 10.0) {
            this.marcação = marcação;
        }

    }

    public void setPasse(Double passe) {
        if (passe >= 0.0 && passe <= 10.0) {
            this.passe = passe;
        }

    }

    public void setVelocidade(Double velocidade) {
        if (passe >= 0.0 && passe <= 10.0) {
            this.velocidade = velocidade;
        }
    }

    public String getNome() {
        return nome;
    }

    public Double getChute() {
        return this.chute;
    }

    public Double getPasse() {
        return this.passe;
    }

    public Double getVelocidade() {
        return this.velocidade;
    }

    public Double getMarcação() {
        return this.marcação;
    }

}
