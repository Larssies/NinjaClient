package NinjaClient.events.listeners;

import NinjaClient.events.Event;
import net.minecraft.client.gui.inventory.GuiChest;

public class EventOpenChest extends Event {
	
	public EventOpenChest(GuiChest chest) {
		this.chest = chest;
	}
	
	public GuiChest chest = null;
	
}