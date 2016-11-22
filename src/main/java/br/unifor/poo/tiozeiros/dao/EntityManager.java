package br.unifor.poo.tiozeiros.dao;

import br.unifor.poo.tiozeiros.exception.DAOException;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.logging.Logger;

/**
 * Created by andre on 22/11/16.
 */
public abstract class EntityManager {
    private Logger logger = Logger.getLogger(EntityManager.class);

    public void execute(String sql, Object... params) throws DAOException{
        Connection connection = null;
        PreparedStatement preparedStatement = null;

        try {
            connection = ConnectionFactory.getConnection();
            preparedStatement
        }
    }

}
