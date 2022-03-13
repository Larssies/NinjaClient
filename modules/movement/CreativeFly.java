package NinjaClient.modules.movement;

import org.lwjgl.input.Keyboard;

import NinjaClient.events.Event;
import NinjaClient.events.listeners.EventUpdate;
import NinjaClient.modules.Module;

public class CreativeFly extends Module{
	
	public CreativeFly() {
		super("CreativeFly", Keyboard.KEY_J, Category.MOVEMENT);
	}

	public void onEnable() {
		mc.thePlayer.capabilities.isFlying = true;
		mc.thePlayer.capabilities.allowFlying = true;
	}
	
	public void onDisable() {
		mc.thePlayer.capabilities.isFlying = false;
		mc.thePlayer.capabilities.allowFlying = false;
	}
	
	public void onEvent(Event e) {
		if(e instanceof EventUpdate) {
			if(e.isPre()) {
			}
		}
	}

}
