package com.xa.webui.persistence.datasource;

import com.xa.webui.exception.persistence.PersistenceDataSourceException;
import java.sql.Connection;

public interface DataSource {

    public Connection getConnection() throws PersistenceDataSourceException;
	
}
