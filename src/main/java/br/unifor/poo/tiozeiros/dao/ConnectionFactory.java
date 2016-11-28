package br.unifor.poo.tiozeiros.dao;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;

import java.sql.Connection;
import java.sql.SQLException;

import org.apache.log4j.*;

/**
 * Created by andre on 22/11/16.
 */
@SuppressWarnings("unused")
public class ConnectionFactory {
    private static Logger logger = Logger.getLogger(ConnectionFactory.class); //ESTA ACEITANDO APENAS STRING
    private static final ConnectionFactory connectionFactory = new ConnectionFactory();
    private static HikariDataSource dataSource;

    private ConnectionFactory() {
        HikariConfig config = new HikariConfig();
        config.setJdbcUrl("jdbc:postgresql://localhost:5432/Tiozeiros");

        config.setUsername("pg-admin");
        config.setPassword("p0stgr3s");
        config.setMinimumIdle(2);
        config.setMaximumPoolSize(10);
        config.setConnectionTestQuery("SELECT 1");

        dataSource = new HikariDataSource(config);
    }

    public static Connection getConnection() throws SQLException{
        return dataSource.getConnection();
    }
}
