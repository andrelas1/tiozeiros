package br.unifor.poo.tiozeiros.bo;

import br.unifor.poo.tiozeiros.dao.JogadoresDAO;
import br.unifor.poo.tiozeiros.entity.Jogadores;
import br.unifor.poo.tiozeiros.exception.DAOException;
import org.apache.log4j.Logger;

import java.sql.Array;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Objects;

/**
 * Created by andre on 22/11/16.
 */
public class JogadoresBO {
    private Logger logger = Logger.getLogger(JogadoresBO.class);
    private JogadoresDAO jogadoresDAO;
    private int quantEquipes = 0;


    public JogadoresBO() {
        this.jogadoresDAO = new JogadoresDAO();
    }

    public void salvar(Jogadores jogador) throws DAOException {
        this.jogadoresDAO.salvar(jogador);
    }

    public ArrayList<Object> listarJogadores() throws SQLException {
        ArrayList<Object> listaJogadores;
        try {
            listaJogadores = this.jogadoresDAO.buscarJogadoresCadastrados();
        } catch (SQLException sql) {
            throw sql;
        }
        return listaJogadores;
    }

    public void deletarPorNome(String nome) throws DAOException {
        try {
            this.jogadoresDAO.deletarPorNome(nome);
        } catch (DAOException dao) {
            throw dao;
        }
    }

    public Jogadores buscarPorNome(String s) throws DAOException {
        Jogadores jogador;
        try {
            jogador = this.jogadoresDAO.buscarPorNome(s);
        } catch (DAOException dao) {
            throw dao;
        }
        return jogador;
    }

    public void atualizar(Jogadores jogador) throws DAOException {
        try {
            this.jogadoresDAO.atualizar(jogador);
        } catch (DAOException dao) {
            throw dao;
        }

    }

    public ArrayList<Jogadores> listarJogadoresOrdenados() throws SQLException {
        ArrayList<Object> listaJogadores;
        ArrayList<Jogadores> jogadoresMelhores = new ArrayList<>();
        ArrayList<Jogadores> jogadoresPiores = new ArrayList<>();
        ArrayList<Jogadores> jogadoresOrdenados = new ArrayList<>();
        Jogadores jMaiorMedia = new Jogadores();
        jMaiorMedia.setMedia(0.0);
        Jogadores jMenorMedia = new Jogadores(11.0);
        Jogadores j = null;

        try {
            listaJogadores = this.jogadoresDAO.buscarJogadoresCadastrados();
        } catch (SQLException sql) {
            throw sql;
        }
        quantEquipes = listaJogadores.size() / 4;
        for (int i = 0; i < quantEquipes; i++) {
            for (Object obj : listaJogadores) {
                j = (Jogadores) obj;
                if (j.calcularMedia() > jMaiorMedia.calcularMedia()) {
                    jMaiorMedia = j;
                }
            }
            jogadoresMelhores.add(jMaiorMedia);
            listaJogadores.remove(jMaiorMedia);
            jMaiorMedia = new Jogadores();
            jMaiorMedia.setMedia(0.0);

            for (Object obj : listaJogadores) {
                j = (Jogadores) obj;
                if (j.calcularMedia() < jMenorMedia.calcularMedia()) {
                    jMenorMedia = j;
                }
            }
            jogadoresPiores.add(jMenorMedia);
            listaJogadores.remove(jMenorMedia);
            jMenorMedia = new Jogadores(11.0);

        }
        for (int i = 0; i < quantEquipes; i++) {
            jogadoresOrdenados.add(jogadoresMelhores.get(i));
            jogadoresOrdenados.add(jogadoresPiores.get(i));
            jogadoresOrdenados.add((Jogadores) listaJogadores.get(0));
            listaJogadores.remove(0);
            jogadoresOrdenados.add((Jogadores) listaJogadores.get(0));
            listaJogadores.remove(0);
        }
        return jogadoresOrdenados;
    }

}
