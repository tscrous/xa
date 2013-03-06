package com.xa.webui.service.factory;

import com.xa.webui.persistence.datasource.DataSource;
import com.xa.webui.persistence.datasource.MySqlDataSource;

public class DataSourceFactory {

    public static DataSourceFactory getInstance() {
        if (connectionFactory == null) {
            connectionFactory = new DataSourceFactory();
        }
        return connectionFactory;
    }

    private DataSourceFactory() {
    }

    public DataSource getConfigDataSource() {
        if (mySqlDataSource == null) {
            mySqlDataSource = new MySqlDataSource();
            mySqlDataSource.setHost("localhost");
            mySqlDataSource.setPort(3306);
            mySqlDataSource.setHost("xaadmin");
            mySqlDataSource.setHost("xaadmin");
        }
        return mySqlDataSource;
    }

    private MySqlDataSource mySqlDataSource;
    private static DataSourceFactory connectionFactory;
	
}
