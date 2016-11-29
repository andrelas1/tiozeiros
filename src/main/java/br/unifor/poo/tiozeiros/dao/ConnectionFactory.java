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
    //private static Logger logger = Logger.getLogger(ConnectionFactory.class);
    private static final ConnectionFactory connectionFactory = new ConnectionFactory();
    private static HikariDataSource dataSource;

    private ConnectionFactory() {
        HikariConfig config = new HikariConfig();
        config.setJdbcUrl("jdbc:postgresql://localhost:5432/usuario");
        config.setUsername("postgres");
        config.setPassword("postgres");
        config.setMinimumIdle(2);
        config.setMaximumPoolSize(20);
        config.setConnectionTestQuery("SELECT 1");

        dataSource = new HikariDataSource(config);
    }

    public static Connection getConnection() throws SQLException {
        return dataSource.getConnection();
    }
}
