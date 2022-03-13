package NinjaClient.modules.player;

import org.lwjgl.input.Keyboard;

import NinjaClient.events.Event;
import NinjaClient.events.listeners.EventUpdate;
import NinjaClient.modules.Module;

public class Invincible extends Module{
	
	public Invincible() {
		super("Invincible", Keyboard.KEY_O, Category.PLAYER);
	}

	public void onEnable() {
		mc.thePlayer.capabilities.disableDamage = true;
	}
	
	public void onDisable() {
		mc.thePlayer.capabilities.disableDamage = false;
	}
	
	public void onEvent(Event e) {
		if(e instanceof EventUpdate) {
			if(e.isPre()) {
			}
		}
	}

}
