package br.unifor.poo.tiozeiros.entity;

/**
 * Created by andre on 12/11/16.
 */
public class Jogadores {

    private String nome;
    private int chute, passe, velocidade, marcação, id;

    public void setChute(Integer chute) {
        if (chute >= 0 && chute <= 10) {
            this.chute = chute;
        }else{
            this.chute = 0;
        }
    }

    public void setMarcação(Integer marcação) {
        if (marcação >= 0.0 && marcação <= 10.0) {
            this.marcação = marcação;
        }else{
            this.marcação = 0;
        }

    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setPasse(Integer passe) {
        if (passe >= 0 && passe <= 10) {
            this.passe = passe;
        }else{
            this.passe = 0;
        }

    }

    public void setVelocidade(Integer velocidade) {
        if (passe >= 0 && passe <= 10) {
            this.velocidade = velocidade;
        }else{
            this.velocidade = 0;
        }
    }

    public String getNome() {
        return nome;
    }

    public Integer getChute() {
        return this.chute;
    }

    public Integer getPasse() {
        return this.passe;
    }

    public Integer getVelocidade() {
        return this.velocidade;
    }

    public Integer getMarcação() {
        return this.marcação;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Double calcularMedia(){
        return (chute+velocidade+passe+marcação)/4.0;
    }
}
