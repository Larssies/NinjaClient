package NinjaClient.modules.movement;

import org.lwjgl.input.Keyboard;

import NinjaClient.events.Event;
import NinjaClient.events.listeners.EventUpdate;
import NinjaClient.modules.Module;

public class AutoWalk extends Module{
	
	public AutoWalk() {
		super("AutoWalk", 0, Category.MOVEMENT);
	}

	public void onDisable() {
		mc.gameSettings.keyBindForward.pressed = false;
	}
	
	public void onEvent(Event e) {
		if(e instanceof EventUpdate) {
			if(e.isPre()) {
				mc.gameSettings.keyBindForward.pressed = true;
			}
		}
	}

}
