package br.unifor.poo.tiozeiros.bo;

import br.unifor.poo.tiozeiros.dao.JogadoresDAO;
import br.unifor.poo.tiozeiros.entity.Jogadores;
import br.unifor.poo.tiozeiros.exception.DAOException;
import org.apache.log4j.Logger;

import java.sql.SQLException;
import java.util.ArrayList;

/**
 * Created by andre on 22/11/16.
 */
public class JogadoresBO {
    private Logger logger = Logger.getLogger(JogadoresBO.class);
    private JogadoresDAO jogadoresDAO;


    public JogadoresBO(){
        this.jogadoresDAO = new JogadoresDAO();
    }

    public void salvar(Jogadores jogador) throws DAOException{
        this.jogadoresDAO.salvar(jogador);
    }

    public ArrayList<Object> listarJogadores() throws SQLException{
        ArrayList<Object> listaJogadores;
        try{
            listaJogadores = this.jogadoresDAO.buscarJogadorCadastrado();
        }catch (SQLException sql){
            throw sql;
        }
        return listaJogadores;
    }

}
