package br.unifor.poo.tiozeiros.entity;

/**
 * Created by andre on 22/11/16.
 */
public class Usuarios {
    private String login;
    private String senha;

    public Usuarios(String login, String senha){
        this.login = login;
        this.senha = senha;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }
}
