package com.velocity.core.client.web.update;

/**
 * Created by Alex on 1/21/2016.
 */
public class Update {

    private boolean isAvailable;
    private String version;
    private String updateLog;

    public Update(boolean isAvailable, String version, String update)
    {
        this.isAvailable = isAvailable;
        this.version = version;
        updateLog = update;
    }

    public Update()
    {
        isAvailable = false;
    }

    public boolean isAvailable()
    {
        return isAvailable;
    }

    public String getVersion()
    {
        return version;
    }

    public String getUpdateLog()
    {
        return updateLog;
    }
}
