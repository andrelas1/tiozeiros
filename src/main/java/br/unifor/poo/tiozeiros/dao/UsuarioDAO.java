package br.unifor.poo.tiozeiros.dao;

/**
 * Created by andre on 22/11/16.
 */

import br.unifor.poo.tiozeiros.bo.UsuarioBO;
import br.unifor.poo.tiozeiros.entity.Usuarios;
import br.unifor.poo.tiozeiros.exception.DAOException;

import java.sql.ResultSet;
import java.sql.SQLException;

public class UsuarioDAO {

    private EntityManager em;

    public UsuarioDAO() {
        this.em = new EntityManager() {
            @Override
            public Object trataResultSet(ResultSet rs) throws SQLException {
                Usuarios usuario = new Usuarios();
                usuario.setId(rs.getInt("id"));
                usuario.setNome(rs.getString("nome"));
                usuario.setLogin(rs.getString("email"));
                usuario.setSenha(rs.getString("senha"));
                return usuario;
            }
        };
    }

    public void salvar(Usuarios usuario) throws DAOException {
        em.execute("insert into usuario (nome, email, senha) values (?, ?, ?)", usuario.getNome(), usuario.getLogin(),
                usuario.getSenha());
    }

    public Usuarios buscarUsuarioPorLoginSenha(Usuarios usuario) throws DAOException{
        Usuarios user = null;

        user = (Usuarios) em.getSingleResult("SELECT * FROM usuario where email = ? and senha = ?", usuario.getLogin(),
                usuario.getSenha());
        return user;
    }
}
