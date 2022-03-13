package NinjaClient.modules.render;

import org.lwjgl.input.Keyboard;

import NinjaClient.events.Event;
import NinjaClient.events.listeners.EventUpdate;
import NinjaClient.modules.Module;

public class FullBright extends Module{
	
	public FullBright() {
		super("FullBright", Keyboard.KEY_P, Category.RENDER);
	}
	
	public void onEnable() {
		mc.gameSettings.gammaSetting = 100;
	}
	
	public void onDisable() {
		mc.gameSettings.gammaSetting = 1;
	}

}
