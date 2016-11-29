package br.unifor.poo.tiozeiros.dao;

import br.unifor.poo.tiozeiros.entity.Jogadores;
import br.unifor.poo.tiozeiros.exception.DAOException;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by andre on 29/11/16.
 */
public class JogadoresDAO {

    private EntityManager em;

    public JogadoresDAO(){
        this.em = new EntityManager() {
            @Override
            public Object trataResultSet(ResultSet rs) throws SQLException {
                Jogadores jogador = new Jogadores();
                jogador.setId(rs.getInt("id"));
                jogador.setNome(rs.getString("nome"));
                jogador.setChute(rs.getInt("chute"));
                jogador.setPasse(rs.getInt("passe"));
                jogador.setMarcação(rs.getInt("marcacao"));
                jogador.setVelocidade(rs.getInt("velocidade"));
                return jogador;
            }
        };
    }
    public void salvar(Jogadores jogador) throws DAOException{
        em.execute("insert into jogadores (nome, chute, passe, marcacao, velocidade) values (?,?,?,?,?)",
                jogador.getNome(), jogador.getChute(), jogador.getPasse(), jogador.getMarcação(), jogador.getVelocidade());
    }
}
