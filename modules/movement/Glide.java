package NinjaClient.modules.movement;

import org.lwjgl.input.Keyboard;

import NinjaClient.events.Event;
import NinjaClient.events.listeners.EventUpdate;
import NinjaClient.modules.Module;
import net.minecraft.block.material.Material;

public class Glide extends Module{
	
	public Glide() {
		super("Glide", 0, Category.MOVEMENT);
	}
	
	public void onEvent(Event e) {
		double oldY = mc.thePlayer.motionY;
		float oldJ = mc.thePlayer.jumpMovementFactor;
		if(e instanceof EventUpdate) {
			if(e.isPre()) {
				if((mc.thePlayer.motionY < 0.0d) && (mc.thePlayer.isAirBorne) && (!mc.thePlayer.isInWater()) && (!mc.thePlayer.isOnLadder())) {
					if(!mc.thePlayer.isInsideOfMaterial(Material.lava)) {
						mc.thePlayer.motionY = -.125d;
						mc.thePlayer.jumpMovementFactor *= 1.12337f;
					}
				}
			}else {
				mc.thePlayer.motionY = oldY;
				mc.thePlayer.jumpMovementFactor = oldJ;
			}
		}
	}

}
