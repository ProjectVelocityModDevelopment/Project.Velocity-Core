package com.velocity.core.client.web.update;

import com.velocity.core.client.Main.ProjectVelocityCore;
import com.velocity.core.client.Main.Reference;
import com.velocity.core.client.web.WebHelper;

import java.util.List;

/**
 * Created by Alex on 1/21/2016.
 */
public class UpdateChecker extends Thread
{
    public Update update;

    public void run()
    {
        boolean isNewUpdateAvailable = false;

        try
        {
            List<String> text = WebHelper.readPastebinAsList("hBG80bPW");

            String version = text.get(0).split("\\:")[1];
            Version newestVersion = new Version(version);
            Version currentVersion = new Version(Reference.VERSION);

            if (newestVersion.compareTo(currentVersion) == 1)
            {
                isNewUpdateAvailable = true;
                update = new Update(isNewUpdateAvailable, version, text.get(1).split("\\:")[1]);
            }
            else
            {
                isNewUpdateAvailable = false;
            }
        }
        catch (Exception e)
        {
            System.err.println("[Project: Velocity-Core] Failed to read mod version! Please report this on the GitHub issue tracker! https://github.com/FiskFille/TransformersMod/issues");
            e.printStackTrace();
        }

        if (update == null)
        {
            update = new Update();
        }

        ProjectVelocityCore.latestUpdate = update;
    }

    public void handleUpdates()
    {
        start();
    }
}