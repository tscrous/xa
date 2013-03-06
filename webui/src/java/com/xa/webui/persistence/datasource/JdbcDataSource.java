package com.xa.webui.persistence.datasource;

public interface JdbcDataSource extends DataSource {

    public String getHost();
    public void setHost(String host);

    public int getPort();
    public void setPort(int port);

    public String getUsername();
    public void setUsername(String username);

    public String getPassword();
    public void setPassword(String password);
	
}
