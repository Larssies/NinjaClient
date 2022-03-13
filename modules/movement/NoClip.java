package NinjaClient.modules.movement;

import org.lwjgl.input.Keyboard;

import NinjaClient.events.Event;
import NinjaClient.events.listeners.EventMotion;
import NinjaClient.events.listeners.EventOnLadder;
import NinjaClient.events.listeners.EventUpdate;
import NinjaClient.modules.Module;
import NinjaClient.settings.ModeSetting;
import net.minecraft.block.Block;
import net.minecraft.block.BlockAir;
import net.minecraft.block.BlockHopper;
import net.minecraft.network.play.client.C03PacketPlayer;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.util.BlockPos;
import net.minecraft.util.MathHelper;

public class NoClip extends Module {
	
	public NoClip() {
		super("NoClip", Keyboard.KEY_NONE, Category.MOVEMENT);
	}

	
	public void onEnable() {
		mc.thePlayer.setPosition(mc.thePlayer.posX, mc.thePlayer.posY + 0.0784001, mc.thePlayer.posZ);
	}
	
	public void onDisable() {
		
	}
	
	public void onEvent(Event e) {
		
		if (e instanceof EventMotion && e.isPre()) {
			
            double mx = Math.cos(Math.toRadians((double)(mc.thePlayer.rotationYaw + 90.0F)));
            double mz = Math.sin(Math.toRadians((double)(mc.thePlayer.rotationYaw + 90.0F)));
            double x = (double)mc.thePlayer.movementInput.moveForward * 0.4 * mx + (double)mc.thePlayer.movementInput.moveStrafe * 0.4 * mz;
            double z = (double)mc.thePlayer.movementInput.moveForward * 0.4 * mz - (double)mc.thePlayer.movementInput.moveStrafe * 0.4 * mx;
            if (mc.thePlayer.isCollidedHorizontally && !mc.thePlayer.isOnLadder()) {
                mc.getNetHandler().getNetworkManager().sendPacket(new C03PacketPlayer.C04PacketPlayerPosition(mc.thePlayer.posX + x, mc.thePlayer.posY, mc.thePlayer.posZ + z, false));
                mc.getNetHandler().getNetworkManager().sendPacket(new C03PacketPlayer.C04PacketPlayerPosition(mc.thePlayer.posX, mc.thePlayer.posY + 3.0D, mc.thePlayer.posZ, false));
                mc.thePlayer.setPosition(mc.thePlayer.posX + x, mc.thePlayer.posY, mc.thePlayer.posZ + z);
            }
        }
		
	}
	
    private boolean isInsideBlock() {
        for (int x = MathHelper.floor_double(mc.thePlayer.boundingBox.minX); x < MathHelper.floor_double(mc.thePlayer.boundingBox.maxX) + 1; x++) {
            for (int y = MathHelper.floor_double(mc.thePlayer.boundingBox.minY); y < MathHelper.floor_double(mc.thePlayer.boundingBox.maxY) + 1; y++) {
                for (int z = MathHelper.floor_double(mc.thePlayer.boundingBox.minZ); z < MathHelper.floor_double(mc.thePlayer.boundingBox.maxZ) + 1; z++) {
                    Block block = mc.theWorld.getBlockState(new BlockPos(x, y, z)).getBlock();
                    if ((block != null) && (!(block instanceof BlockAir))) {
                        AxisAlignedBB boundingBox = block.getCollisionBoundingBox(mc.theWorld, new BlockPos(x, y, z), mc.theWorld.getBlockState(new BlockPos(x, y, z)));
                        if ((block instanceof BlockHopper)) {
                            boundingBox = new AxisAlignedBB(x, y, z, x + 1, y + 1, z + 1);
                        }
                        if (boundingBox != null) {
                            if (mc.thePlayer.boundingBox.intersectsWith(boundingBox)) {
                                return true;
                            }
                        }
                    }
                }
            }
        }
        return false;
    }

	
}