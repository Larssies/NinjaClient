package NinjaClient.modules.player;

import org.lwjgl.input.Keyboard;

import NinjaClient.events.Event;
import NinjaClient.events.listeners.EventUpdate;
import NinjaClient.modules.Module;
import net.minecraft.network.play.client.C03PacketPlayer;

public class NoFall extends Module{
	
	public NoFall() {
		super("NoFall", Keyboard.KEY_N, Category.PLAYER);
	}
	
	public void onEvent(Event e) {
		if(e instanceof EventUpdate && e.isPre()) {
			if(mc.thePlayer.fallDistance > 2)
				mc.thePlayer.sendQueue.addToSendQueue(new C03PacketPlayer(true));
		}
	}
}
