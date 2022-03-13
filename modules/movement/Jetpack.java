package NinjaClient.modules.movement;

import org.lwjgl.input.Keyboard;

import NinjaClient.events.Event;
import NinjaClient.events.listeners.EventUpdate;
import NinjaClient.modules.Module;

public class Jetpack extends Module{
	
	public Jetpack() {
		super("Jetpack", 0, Category.MOVEMENT);
	}
	
	public void onEvent(Event e) {
		if(e instanceof EventUpdate) {
			if(e.isPre()) {
				if(mc.gameSettings.keyBindJump.pressed) {
					mc.thePlayer.jump();
				}
			}
		}
	}

}
