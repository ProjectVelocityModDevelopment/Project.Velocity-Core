package com.velocity.core.client.packet;

import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import cpw.mods.fml.common.network.FMLNetworkEvent;

import java.io.IOException;

/**
 * Created by Alex on 1/19/2016.
 */
public class PacketHandler {

    protected String channelName = "velocity_core";

    @SubscribeEvent
    public void onServerPacket(FMLNetworkEvent.ServerCustomPacketEvent event) throws IOException
    {

		/* Register Your server Side Stuff Here */


    }

    @SubscribeEvent
    public void onClientPacket(FMLNetworkEvent.ClientCustomPacketEvent event) throws IOException
    {



		/* Register Your server Side Stuff Here */
    }
}

