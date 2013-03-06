package com.xa.webui.exception.service;

public class ServiceManagementException extends RuntimeException {

    public ServiceManagementException() {
    }

    public ServiceManagementException(String string) {
        super(string);
    }

    public ServiceManagementException(String string, Throwable thrwbl) {
        super(string, thrwbl);
    }

    public ServiceManagementException(Throwable thrwbl) {
        super(thrwbl);
    }

}
