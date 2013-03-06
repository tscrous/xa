package com.xa.webui.persistence.domain.user;

/**
 *
 * @author theo-alaganze
 */
public class UserSessionSessionProperties {

    public int getScreenWidth() {
        return screenWidth;
    }
    public void setScreenWidth(int screenWidth) {
        this.screenWidth = screenWidth;
    }

    public int getScreenHeight() {
        return screenHeight;
    }
    public void setScreenHeight(int screenHeight) {
        this.screenHeight = screenHeight;
    }
 
    private int screenWidth;
    private int screenHeight;
    
}
