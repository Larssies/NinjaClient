package NinjaClient.modules.movement;

import org.lwjgl.input.Keyboard;

import NinjaClient.events.Event;
import NinjaClient.events.listeners.EventUpdate;
import NinjaClient.modules.Module;
import net.minecraft.entity.Entity;

public class Parkour extends Module{
	
	public Parkour() {
		super("Parkour", Keyboard.KEY_Z, Category.MOVEMENT);
	}
	
	public void onEvent(Event e) {
		if(e instanceof EventUpdate) {
			if(e.isPre()) {
				if(mc.thePlayer.onGround && !mc.thePlayer.isSneaking() && !this.mc.gameSettings.keyBindSneak.pressed &&
						this.mc.theWorld.getCollidingBoundingBoxes((Entity)mc.thePlayer, mc.thePlayer.getEntityBoundingBox().offset(0.0D, -0.5D, 0.0D).expand(-0.001D, 0.0D, -0.001D)).isEmpty())mc.thePlayer.jump();
			}
		}
	}

}
