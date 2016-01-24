package com.velocity.core.client.commands;

import net.minecraft.command.CommandBase;
import net.minecraft.command.ICommandSender;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.server.MinecraftServer;
import net.minecraft.util.ChatComponentText;
import net.minecraft.util.EnumChatFormatting;

import java.util.List;

/**
 * Created by Alex on 1/20/2016.
 */
public class CommandUpdate  extends CommandBase
{
    public String getCommandName()
    {
        return "velocityupdates";
    }

    public String getCommandUsage(ICommandSender icommandsender)
    {
        return "/velocityupdates <player>";
    }

    public void processCommand(ICommandSender icommandsender, String[] astring)
    {
        if (icommandsender instanceof EntityPlayer)
        {
            EntityPlayer player = (EntityPlayer)icommandsender;

            if(astring.length == 0)
            {
                icommandsender.addChatMessage(new ChatComponentText(EnumChatFormatting.RED + "Usage: /velocityupdates <player>"));
                return;
            }

          icommandsender.addChatMessage(new ChatComponentText(EnumChatFormatting.BOLD + "Current Version of Mod: 0.1-Pre_Alpha"));
        }
    }

    public List addTabCompletionOptions(ICommandSender icommandsender, String[] astring)
    {
        return astring.length >= 1 ? getListOfStringsMatchingLastWord(astring, MinecraftServer.getServer().getAllUsernames()) : null;
    }
}