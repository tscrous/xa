package com.xa.webui.persistence.datasource;

import com.xa.webui.exception.persistence.PersistenceDataSourceException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class MySqlDataSource implements JdbcDataSource {

    public final String CONNECTION_DRIVER = "com.mysql.jdbc.Driver";
    public final String CONNECTION_PREFIX = "jdbc:mysql://";

    public MySqlDataSource() {
    }

    @Override
    public Connection getConnection() throws PersistenceDataSourceException {
        try {
              Class.forName(CONNECTION_DRIVER);			
              return DriverManager.getConnection(CONNECTION_PREFIX + host +"/feedback?user="+ username +"&password="+ password);
        }
        catch (ClassNotFoundException cnfe) {
                throw new PersistenceDataSourceException(cnfe);
        }
        catch (SQLException sqle) {
                throw new PersistenceDataSourceException(sqle);
        }	      
    }

    @Override
    public String getHost() {
            return host;
    }

    @Override
    public void setHost(String host) {
            this.host = host;
    }

    @Override
    public int getPort() {
            return port;
    }

    @Override
    public void setPort(int port) {
            this.port = port;
    }

    @Override
    public String getUsername() {
            return username;
    }

    @Override
    public void setUsername(String username) {
            this.username = username;
    }

    @Override
    public String getPassword() {
            return password;
    }

    @Override
    public void setPassword(String password) {
            this.password = password;
    }

    private String host;
    private int port;
    private String username;
    private String password;
	
}
