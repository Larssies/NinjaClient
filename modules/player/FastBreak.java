package NinjaClient.modules.player;

import org.lwjgl.input.Keyboard;

import NinjaClient.events.Event;
import NinjaClient.events.listeners.EventSendPacket;
import NinjaClient.events.listeners.EventUpdate;
import NinjaClient.modules.Module;
import NinjaClient.settings.NumberSetting;
import NinjaClient.util.InventoryUtils;
import net.minecraft.block.Block;
import net.minecraft.client.Minecraft;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.item.ItemStack;
import net.minecraft.network.Packet;
import net.minecraft.network.play.client.C02PacketUseEntity;
import net.minecraft.network.play.client.C07PacketPlayerDigging;
import net.minecraft.network.play.client.C09PacketHeldItemChange;
import net.minecraft.util.BlockPos;
import net.minecraft.util.MovingObjectPosition.MovingObjectType;
public class FastBreak extends Module {
	
	private NumberSetting speed = new NumberSetting("Speed", 10, 1, 10, 1);
	
	public FastBreak() {
		super("FastBreak", Keyboard.KEY_NONE, Category.PLAYER);
		this.addSettings(speed);
	}
	
	public void onEnable() {
		
	}
	
	public void onDisable() {
		
	}
	
	public void onEvent(Event e) {
		
		if (e instanceof EventUpdate && e.isPre()) {
			
			if (mc.playerController.curBlockDamageMP >= 1.0) {
				mc.playerController.curBlockDamageMP = 1.0f;
				return;
			}
			
	        mc.playerController.curBlockDamageMP += speed.getValue() / 100;
	        
		}
		
		// Removed
		/*
		if (e instanceof EventAddBlockDamage) {
			
			if (e.isPre()) {
				
				EventAddBlockDamage blockDamage = (EventAddBlockDamage) e;
				blockDamage.setDamage((int) speed.getValue());
				
			}
			
		}
		*/
	}
	
}