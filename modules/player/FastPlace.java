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
public class FastPlace extends Module {

	public FastPlace() {
		super("FastPlace", Keyboard.KEY_NONE, Category.PLAYER);
	}
	
	public void onEnable() {
		
	}
	
	public void onDisable() {
		
	}
	
	public void onEvent(Event e) {
		
		if (e instanceof EventUpdate) {
			
			if (e.isPre()) {
				
				mc.rightClickDelayTimer = 0;
				
			}
			
		}
		
	}
	
}