package com.velocity.core.client.gui;

import cpw.mods.fml.common.FMLCommonHandler;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import net.minecraft.client.Minecraft;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.server.MinecraftServer;
import net.minecraft.util.EnumChatFormatting;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.World;
import net.minecraftforge.client.event.RenderGameOverlayEvent;
import net.minecraftforge.common.MinecraftForge;
import org.lwjgl.opengl.GL11;

/**
 * Created by Alex on 1/20/2016.
 */
public class GuiVelocity {
    public static void init(){
        MinecraftForge.EVENT_BUS.register(new Render());
    }

    Minecraft mc;
    private static final ResourceLocation renderer = new ResourceLocation("/gui/inventory.png");



    public static class Render
    {
        Minecraft mc;

        @SubscribeEvent
        public void eventHandler(RenderGameOverlayEvent event){

            if(event.type == event.type.HOTBAR)
            {

                GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
                GL11.glDisable(GL11.GL_LIGHTING);
                GL11.glEnable(GL11.GL_DEPTH_TEST);
                GL11.glDepthMask(true);
                int posX = (event.resolution.getScaledWidth()) /2;
                int posY = (event.resolution.getScaledHeight()) /2;

                EntityPlayer entity = Minecraft.getMinecraft().thePlayer;
                int i = (int)entity.posX;
                int j = (int)entity.posY;
                int k = (int)entity.posZ;
                MinecraftServer server = FMLCommonHandler.instance().getMinecraftServerInstance();
                World world = server.worldServers[0];

                Minecraft.getMinecraft().renderEngine.bindTexture(renderer);

                if(true){

                    Minecraft.getMinecraft().fontRenderer.drawString(EnumChatFormatting.DARK_RED +  "Project: Velocity (V0.1) - Mod: Core  ", posX+(-260), posY+(-170), 0xffffff);


                }



            }

        }




        @SubscribeEvent
        public void render(RenderGameOverlayEvent.Post event) {
        }

    }
}

