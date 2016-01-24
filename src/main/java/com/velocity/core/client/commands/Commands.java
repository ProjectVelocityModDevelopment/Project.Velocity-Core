package com.velocity.core.client.commands;

import cpw.mods.fml.common.event.FMLServerStartingEvent;

/**
 * Created by Alex on 1/20/2016.
 */
public class Commands {
    public static void init(FMLServerStartingEvent event)
    {
        event.registerServerCommand(new CommandUpdate());

    }
}
