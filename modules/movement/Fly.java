package NinjaClient.modules.movement;

import org.lwjgl.input.Keyboard;

import NinjaClient.events.Event;
import NinjaClient.events.listeners.EventUpdate;
import NinjaClient.modules.Module;

public class Fly extends Module{
	
	public Fly() {
		super("Fly", Keyboard.KEY_G, Category.MOVEMENT);
	}

	public void onDisable() {
		mc.thePlayer.capabilities.isFlying = false;
	}
	
	public void onEvent(Event e) {
		if(e instanceof EventUpdate) {
			if(e.isPre()) {
				mc.thePlayer.capabilities.isFlying = true;
			}
		}
	}

}
