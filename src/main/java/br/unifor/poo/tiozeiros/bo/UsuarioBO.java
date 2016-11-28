package br.unifor.poo.tiozeiros.bo;

import br.unifor.poo.tiozeiros.entity.Usuarios;
import br.unifor.poo.tiozeiros.exception.DAOException;
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

    public boolean loggar(Usuarios usuario) throws DAOException{
        Usuarios user;

        try{
            user = this.usuarioDAO
        }
    }
}
