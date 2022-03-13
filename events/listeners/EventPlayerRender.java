package NinjaClient.events.listeners;

import NinjaClient.events.Event;
import net.minecraft.client.entity.AbstractClientPlayer;
import net.minecraft.entity.Entity;

public class EventPlayerRender extends Event {
	
	public EventPlayerRender(AbstractClientPlayer entity) {
		
		this.entity = entity;
		
	}
	
	public AbstractClientPlayer entity;
	
}