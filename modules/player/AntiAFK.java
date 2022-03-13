package NinjaClient.modules.player;

import org.lwjgl.input.Keyboard;

import NinjaClient.events.Event;
import NinjaClient.events.listeners.EventUpdate;
import NinjaClient.modules.Module;

public class AntiAFK extends Module{
	
	public AntiAFK() {
		super("AntiAFK", 0, Category.PLAYER);
	}

	public void onDisable() {
		mc.gameSettings.keyBindLeft.pressed = false;
		mc.gameSettings.keyBindRight.pressed = false;
	}
	
	public void onEvent(Event e) {
		if(e instanceof EventUpdate) {
			if(e.isPre()) {
				mc.gameSettings.keyBindLeft.pressed = true;
				mc.gameSettings.keyBindRight.pressed = true;
			}
		}
	}

}
