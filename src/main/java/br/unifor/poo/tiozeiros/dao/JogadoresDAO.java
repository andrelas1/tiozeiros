package br.unifor.poo.tiozeiros.dao;

import br.unifor.poo.tiozeiros.entity.Jogadores;
import br.unifor.poo.tiozeiros.exception.DAOException;

import java.sql.Array;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

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

    public ArrayList<Object> buscarJogadoresCadastrados() throws SQLException{
        ArrayList<Object> listaJogadores;
        listaJogadores = em.getResultList("select * from jogadores ORDER BY ID");
        return listaJogadores;
    }

    public void deletarPorNome(String nome) throws DAOException{
        em.execute("delete from jogadores where nome = ?", nome);
    }

    public Jogadores buscarPorNome(String s) throws DAOException{
        Jogadores jogador;
        jogador = (Jogadores) em.getSingleResult("select * from jogadores where nome = ?", s);
        return jogador;
    }

    public void atualizar(Jogadores jogador) throws DAOException{
        em.execute("update jogadores set chute = ?, passe = ?, marcacao = ?, velocidade = ? WHERE nome = ? ",
                jogador.getChute(), jogador.getPasse(), jogador.getMarcação(), jogador.getVelocidade(), jogador.getNome());
    }
}
