package com.velocity.core.client.Main;

import com.velocity.core.client.ClientProxy;
import com.velocity.core.client.commands.Commands;
import com.velocity.core.client.event.ForgeEvent;
import com.velocity.core.client.gui.GuiVelocity;
import com.velocity.core.client.web.WebHelper;
import com.velocity.core.client.web.update.Update;
import com.velocity.core.common.CommonProxy;
import cpw.mods.fml.common.FMLCommonHandler;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLServerStartingEvent;
import cpw.mods.fml.common.registry.LanguageRegistry;
import net.minecraftforge.common.MinecraftForge;

@Mod(modid = Reference.MODID, version = Reference.VERSION)
public class ProjectVelocityCore {

    public static String ASSET_PREFIX = "velocity_core";
    public static String TEXTURE_PREFIX = ProjectVelocityCore.ASSET_PREFIX + ":";
    public static ProjectVelocityCore instance;
    public static Update latestUpdate;

    @SidedProxy(clientSide = "com.velocity.core.client.ClientProxy", serverSide = "com.velocity.core.common.ClientProxy")

    public static CommonProxy proxy;

    @EventHandler
    public void preInit(FMLPreInitializationEvent event) {

        MinecraftForge.EVENT_BUS.register(new ForgeEvent());
        FMLCommonHandler.instance().bus().register(new ForgeEvent());


        GuiVelocity.init();

        try
        {
            WebHelper.readPastebin("Kyct1Dvz");
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }


    }

    @EventHandler
    public void init(FMLInitializationEvent event) {


    }

}
