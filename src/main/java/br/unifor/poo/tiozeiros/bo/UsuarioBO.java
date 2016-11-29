package br.unifor.poo.tiozeiros.bo;

import br.unifor.poo.tiozeiros.entity.Usuarios;
import br.unifor.poo.tiozeiros.exception.DAOException;
import br.unifor.poo.tiozeiros.seguranca.SegurancaTO;
import org.apache.log4j.Logger;
import br.unifor.poo.tiozeiros.dao.UsuarioDAO;

/**
 * Created by andre on 22/11/16.
 */
public class UsuarioBO {

    private Logger logger = Logger.getLogger(UsuarioBO.class);
    private UsuarioDAO usuarioDAO;

    public UsuarioBO(){
        this.usuarioDAO = new UsuarioDAO();
    }

    public void salvar(Usuarios usuario) throws DAOException{
        try{
            this.usuarioDAO.salvar(usuario);
        }catch (DAOException dao){
            logger.error(dao.getMessage(), dao);
            throw dao;
        }
    }

    public boolean loggar(Usuarios usuario) throws DAOException{
        Usuarios user;
        try{
            user = this.usuarioDAO.buscarUsuarioPorLoginSenha(usuario);
            if(user!=null){
                SegurancaTO.setUsuario(user);
            }else{
                throw new DAOException("Login ou Senha inválidos");
            }
        }catch (DAOException dao){
            logger.error(dao.getMessage(), dao);
            throw dao;
        }
        return user != null;
    }
}
