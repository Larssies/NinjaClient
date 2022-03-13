package NinjaClient.modules.movement;

import org.lwjgl.input.Keyboard;

import NinjaClient.events.Event;
import NinjaClient.events.listeners.EventUpdate;
import NinjaClient.modules.Module;

public class Speed extends Module{
	
	public Speed() {
		super("Speed", 0, Category.MOVEMENT);
	}
	
	public void onEvent(Event e) {
		if(e instanceof EventUpdate) {
			if(e.isPre()) {
				if(mc.thePlayer.onGround) {
					mc.thePlayer.motionX *= 2.0f;
					mc.thePlayer.motionZ *= 2.0f;
				}
			}
		}
	}

}
