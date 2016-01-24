package com.velocity.core.client.web.update;

import net.minecraft.client.Minecraft;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.ChatComponentText;
import net.minecraft.util.EnumChatFormatting;

/**
 * Created by Alex on 1/21/2016.
 */
public class Version implements Comparable<Version>
{
    private String version;

    Minecraft mc = Minecraft.getMinecraft();
    public EntityPlayer player = mc.thePlayer;

    public final String get()
    {
        return version;
    }

    public Version(String version)
    {
        if (version == null)
        {

            throw new IllegalArgumentException("Version can not be null");

        }
        if (!version.matches("[0-9]+(\\.[0-9]+)*"))
        {
            throw new IllegalArgumentException("Invalid version format");
        }

        this.version = version;
    }

    @Override
    public int compareTo(Version version)
    {
        if (version == null)
        {
            return 1;
        }

        String[] thisParts = get().split("\\.");
        String[] thatParts = version.get().split("\\.");

        int length = Math.max(thisParts.length, thatParts.length);

        for (int i = 0; i < length; i++)
        {
            int thisPart = i < thisParts.length ? Integer.parseInt(thisParts[i]) : 0;
            int thatPart = i < thatParts.length ? Integer.parseInt(thatParts[i]) : 0;

            if (thisPart < thatPart)
            {
                return -1;
            }
            if (thisPart > thatPart)
            {
                return 1;
            }
        }

        return 0;
    }

    @Override
    public boolean equals(Object version)
    {
        if (this == version)
        {
            return true;
        }
        if (version == null)
        {
            return false;
        }
        if (this.getClass() != version.getClass())
        {
            return false;
        }

        return compareTo((Version) version) == 0;
    }

}