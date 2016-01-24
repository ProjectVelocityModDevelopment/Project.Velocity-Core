package com.velocity.core.client.event;

import com.velocity.core.client.Main.ProjectVelocityCore;
import com.velocity.core.client.Main.Reference;
import com.velocity.core.client.web.update.Update;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.ChatComponentText;
import net.minecraft.util.EnumChatFormatting;
import net.minecraftforge.event.entity.EntityJoinWorldEvent;
import net.minecraftforge.event.entity.player.EntityInteractEvent;
import net.minecraftforge.event.world.WorldEvent;

import java.util.regex.Pattern;

/**
 * Created by Alex on 1/20/2016.
 */
@SideOnly(Side.CLIENT)
public class ForgeEvent {



    private boolean displayedUpdates;

    @SubscribeEvent
    public void playerInteract(EntityInteractEvent event)
    {

    }


    @SubscribeEvent
    public void worldLoad(WorldEvent.Load event)
    {

    }



    @SubscribeEvent
    public void clientLoggedIn(EntityJoinWorldEvent event)
    {
        if (event.entity instanceof EntityPlayer)
        {
            EntityPlayer player = (EntityPlayer) event.entity;
       //     player.addChatMessage(new ChatComponentText(EnumChatFormatting.DARK_RED + "Welcome to Project: Velocity-Core."));



            if (!displayedUpdates)
            {
                Update update = ProjectVelocityCore.latestUpdate;

                if (update != null && update.isAvailable()) {
                    player.addChatMessage(new ChatComponentText(EnumChatFormatting.BLUE + "Project: Velocity-Core version " + update.getVersion() + " is now available!"));
                    player.addChatMessage(new ChatComponentText(""));
                    player.addChatMessage(new ChatComponentText(EnumChatFormatting.BLUE + "" + EnumChatFormatting.BOLD + "What's New: "));

                    String[] updates = update.getUpdateLog().split(Pattern.quote("(newline)"));

                    for (String updatePart : updates) {
                        EnumChatFormatting colour = EnumChatFormatting.RED;

                        if (updatePart.trim().startsWith("*")) {
                            colour = EnumChatFormatting.GOLD;
                        } else if (updatePart.trim().startsWith("+")) {
                            colour = EnumChatFormatting.GREEN;
                        } else if (updatePart.trim().startsWith("-")) {
                            colour = EnumChatFormatting.RED;
                        }

                        player.addChatMessage(new ChatComponentText(colour + updatePart));
                    }

                    player.addChatMessage(new ChatComponentText(""));
                }

                displayedUpdates = true;
            }

        }
    }

}
