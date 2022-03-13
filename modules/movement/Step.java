package NinjaClient.modules.movement;

import org.lwjgl.input.Keyboard;

import NinjaClient.events.Event;
import NinjaClient.events.listeners.EventUpdate;
import NinjaClient.modules.Module;
import net.minecraft.network.play.client.C03PacketPlayer;

public class Step extends Module{
	
	public Step() {
		super("Step", 0, Category.MOVEMENT);
	}
	
	public void onEvent(Event e) {
		if(e instanceof EventUpdate) {
			if(e.isPre()) {
				if((mc.thePlayer.isCollidedHorizontally) && (mc.thePlayer.onGround)) {
					mc.thePlayer.sendQueue.addToSendQueue(new C03PacketPlayer.C04PacketPlayerPosition(mc.thePlayer.posX, mc.thePlayer.posY+0.42, mc.thePlayer.posZ, mc.thePlayer.onGround));
					mc.thePlayer.sendQueue.addToSendQueue(new C03PacketPlayer.C04PacketPlayerPosition(mc.thePlayer.posX, mc.thePlayer.posY+0.72, mc.thePlayer.posZ, mc.thePlayer.onGround));
					mc.thePlayer.stepHeight = 1.0f;
				}
			}
		}else {
			mc.thePlayer.stepHeight = 0.5f;
		}
	}

}
