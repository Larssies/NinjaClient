package NinjaClient.events.listeners;

import NinjaClient.events.Event;
import net.minecraft.entity.*;

public class EventChatmessage extends Event {
	
	public String message;
	
	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
	
}