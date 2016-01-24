package net.MagikVehicleHelper.api;


import com.velocity.core.client.Main.Reference;
import net.minecraft.block.Block;
import net.minecraft.entity.EntityFlying;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.MathHelper;
import net.minecraft.world.World;


/**
 * 
 * Extend this into your Entity. 
 * 
 * This Part of the API Has Not been worked on and is literally a copy of the Land Vehicle Helper
 * 
 * @author Magik
 */


public class AirVehicleHelper extends EntityFlying
{
	public float vehicXOffset = 5;
	public float vehicYOffset = 0;
	public float vehicZOffset = 0;

	public float moveModifier = 1F;

	public AirVehicleHelper(World p_i1689_1_)
	{
		super(p_i1689_1_);
		setSize(0.9F, 0.9F);
		isImmuneToFire = true;
	}

	@Override
	public boolean canRenderOnFire()
	{
		return false;
	}

	@Override
	public void fall(float p1)
	{
		return;
	}

	@Override
	protected void func_145780_a(int p_145780_1_, int p_145780_2_, int p_145780_3_, Block p_145780_4_)
	{
		playSound(Reference.MODID + ":" + getMovingSound(), 0.15F, 1.0F);
	}

	public String getMovingSound()
	{
		return "";
	}

	/**
	 * Called when a player interacts with a mob. e.g. gets milk from a cow,
	 * gets into the saddle on a pig.
	 */
	@Override
	public boolean interact(EntityPlayer p_70085_1_)
	{
		if (!worldObj.isRemote && (riddenByEntity == null || riddenByEntity == p_70085_1_))
		{
			p_70085_1_.mountEntity(this);
			return true;
		}
		else
		{
			return false;
		}
	}

	@Override
	protected boolean isAIEnabled()
	{
		return true;
	}

	@Override
	public void moveEntityWithHeading(float p_70612_1_, float p_70612_2_)
	{
		if (riddenByEntity != null && riddenByEntity instanceof EntityLivingBase)
		{
			prevRotationYaw = rotationYaw = riddenByEntity.rotationYaw;
			rotationPitch = riddenByEntity.rotationPitch * 0.5F;
			setRotation(rotationYaw, rotationPitch);
			rotationYawHead = renderYawOffset = rotationYaw;
			p_70612_1_ = ((EntityLivingBase)riddenByEntity).moveStrafing * 0.5F;
			p_70612_2_ = ((EntityLivingBase)riddenByEntity).moveForward * (moveModifier / 8);

			if (onGround)
			{
				float f2 = MathHelper.sin(rotationYaw * (float)Math.PI / 180.0F);
				float f3 = MathHelper.cos(rotationYaw * (float)Math.PI / 180.0F);
				motionX += -0.4F * f2 * p_70612_2_;
				motionZ += 0.4F * f3 * p_70612_2_;
			}

			stepHeight = 1.0F;
			jumpMovementFactor = getAIMoveSpeed() * 0.1F;

			if (!worldObj.isRemote)
			{
				setAIMoveSpeed(p_70612_2_);
				super.moveEntityWithHeading(p_70612_1_, p_70612_2_);
			}
		}
	}

	@Override
	public void onUpdate()
	{
		super.onUpdate();

		moveEntityWithHeading(0, 0);
	}

	@Override
	public void updateRiderPosition()
	{
		if (riddenByEntity != null)
		{
			riddenByEntity.setPosition(posX + vehicXOffset, posY + getMountedYOffset() + riddenByEntity.getYOffset() + vehicYOffset, posZ + vehicZOffset);
		}
	}

}
