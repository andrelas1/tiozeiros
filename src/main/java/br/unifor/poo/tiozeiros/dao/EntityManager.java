package br.unifor.poo.tiozeiros.dao;

import br.unifor.poo.tiozeiros.exception.DAOException;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.apache.log4j.*;

/**
 * Created by andre on 22/11/16.
 */
public abstract class EntityManager {
    private Logger logger = Logger.getLogger(EntityManager.class);

    public void execute(String sql, Object... params) throws DAOException{ //método para guardar os objetos no preparedStatement e atualizar a tabela do banco de dados
        Connection connection = null;
        PreparedStatement preparedStatement = null;

        try {
            connection = ConnectionFactory.getConnection();
            preparedStatement = connection.prepareStatement(sql);

            for(int i = 1; i<= params.length; i++){
                preparedStatement.setObject(i, params[i-1]);
            }

            preparedStatement.execute();
        }catch (SQLException e){
            String msg = "Não foi possível " + this.getTipoOperacao(sql)
                    + ", tente mais tarde.";
            logger.error(msg, e);
            throw new DAOException(msg, e);
        }finally {
            this.close(connection, preparedStatement);
        }
    }

    public Object getSingleResult(String sql, Object... params)
            throws DAOException {

        ResultSet resultSet = null;
        Connection conn = null;
        PreparedStatement pstm = null;

        try {
            conn = ConnectionFactory.getConnection();
            pstm = conn.prepareStatement(sql);

            for (int i = 1; i <= params.length; i++) {
                pstm.setObject(i, params[i - 1]);
            }

            resultSet = pstm.executeQuery();
            if (resultSet.next()) {
                return trataResultSet(resultSet);
            }
        } catch (SQLException e) {
            String msg = "Não foi possível realizar a consulta.";
            logger.error(msg);
            throw new DAOException(msg, e);
        } finally {
            close(conn, pstm, resultSet);
        }

        return null;
    }

    public abstract Object trataResultSet(ResultSet rs) throws SQLException;

    private String getTipoOperacao(String sql) {
        if (sql.toLowerCase().startsWith("insert")) {
            return "inserir";
        } else if (sql.toLowerCase().startsWith("update")) {
            return "atualizar";
        } else if (sql.toLowerCase().startsWith("delete")) {
            return "excluir";
        } else if (sql.toLowerCase().startsWith("select")) {
            return "selecionar";
        } else {
            return "realizar a operação";
        }
    }

    private void close(Connection conn, PreparedStatement pstm) {
        try {
            if (pstm != null && !pstm.isClosed()) {
                pstm.close();
            }
        } catch (SQLException e) {
            logger.warn("Não foi possível fechar o preparedStatemant", e);
        } finally {
            try {
                if (conn != null && !conn.isClosed()) {
                    conn.close();
                }
            } catch (SQLException e) {
                logger.warn("Não foi possível encerrar a conexão", e);
            }
        }
    }

    private void close(Connection conn, PreparedStatement pstm, ResultSet rs) {
        try {
            if (rs != null && !rs.isClosed()) {
                rs.close();
            }
        } catch (SQLException e) {
            logger.warn("Não foi possível fechar o resultset", e);
        } finally {
            try {
                if (pstm != null && !pstm.isClosed()) {
                    pstm.close();
                }
            } catch (SQLException e) {
                logger.warn("Não foi possível fechar o preparedStatemant", e);
            } finally {
                try {
                    if (conn != null && !conn.isClosed()) {
                        conn.close();
                    }
                } catch (SQLException e) {
                    logger.warn("Não foi possível encerrar a conexão", e);
                }
            }
        }
    }

}
