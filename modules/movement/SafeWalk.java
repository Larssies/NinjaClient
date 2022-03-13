package NinjaClient.modules.movement;

import org.lwjgl.input.Keyboard;

import NinjaClient.events.Event;
import NinjaClient.events.listeners.EventSneaking;
import NinjaClient.events.listeners.EventUpdate;
import NinjaClient.modules.Module;
import net.minecraft.entity.player.EntityPlayer;

public class SafeWalk extends Module {

	public SafeWalk() {
		super("SafeWalk", Keyboard.KEY_NONE, Category.MOVEMENT);
	}
	
	public void onEnable() {
		
	}
	
	public void onDisable() {
		
	}
	
	public void onEvent(Event e) {
		
		if (e instanceof EventSneaking) {
			
			if (e.isPre()) {
				
				EventSneaking sneak = (EventSneaking) e;
				
				if (sneak.entity.onGround && sneak.entity instanceof EntityPlayer) {
					sneak.sneaking = true;
				}else {
					sneak.sneaking = false;
				}
				sneak.offset = -1D;
				sneak.revertFlagAfter = true;
				
			}
			
		}
		
	}
	
}