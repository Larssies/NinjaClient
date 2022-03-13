package NinjaClient.modules.movement;

import org.lwjgl.input.Keyboard;

import NinjaClient.events.Event;
import NinjaClient.events.listeners.EventUpdate;
import NinjaClient.modules.Module;

public class Sneak extends Module{
	
	public Sneak() {
		super("Sneak", 0, Category.MOVEMENT);
	}

	public void onDisable() {
		mc.gameSettings.keyBindSneak.pressed = false;
	}
	
	public void onEvent(Event e) {
		if(e instanceof EventUpdate) {
			if(e.isPre()) {
				mc.gameSettings.keyBindSneak.pressed = true;
			}
		}
	}

}
