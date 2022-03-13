package NinjaClient.modules.movement;

import org.lwjgl.input.Keyboard;

import NinjaClient.events.Event;
import NinjaClient.events.listeners.EventUpdate;
import NinjaClient.modules.Module;

public class BunnyHop extends Module{
	
	public BunnyHop() {
		super("BunnyHop", Keyboard.KEY_NONE, Category.MOVEMENT);
	}

	public void onDisable() {
		mc.gameSettings.keyBindJump.pressed = false;
	}
	
	public void onEvent(Event e) {
		if(e instanceof EventUpdate) {
			if(e.isPre()) {
				mc.gameSettings.keyBindJump.pressed = true;
			}
		}
	}

}
