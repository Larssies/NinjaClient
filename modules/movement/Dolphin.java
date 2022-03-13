package NinjaClient.modules.movement;

import org.lwjgl.input.Keyboard;

import NinjaClient.events.Event;
import NinjaClient.events.listeners.EventUpdate;
import NinjaClient.modules.Module;

public class Dolphin extends Module{
	
	public Dolphin() {
		super("Dolphin", 0, Category.MOVEMENT);
	}
	
	public void onEvent(Event e) {
		if(e instanceof EventUpdate) {
			if(e.isPre()) {
				if(mc.thePlayer.isInWater()) {
					mc.thePlayer.motionY += 0.04;
				}
			}
		}
	}

}
