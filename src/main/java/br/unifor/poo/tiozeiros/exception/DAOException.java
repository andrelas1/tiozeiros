package br.unifor.poo.tiozeiros.exception;

import java.sql.SQLException;

/**
 * Created by andre on 22/11/16.
 */
public class DAOException extends SQLException {

    public DAOException(String msg, Throwable e){
        super(msg, e);
    }

    public DAOException(String msg){
        super(msg);
    }
}
