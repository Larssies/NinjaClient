package NinjaClient;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

import org.lwjgl.opengl.Display;

import NinjaClient.events.Event;
import NinjaClient.events.listeners.EventKey;
import NinjaClient.modules.Module;
import NinjaClient.modules.Module.Category;
import NinjaClient.modules.combat.*;
import NinjaClient.modules.movement.*;
import NinjaClient.modules.player.*;
import NinjaClient.modules.render.*;
import NinjaClient.ui.HUD;
import net.minecraft.client.Minecraft;

public class Client {
	
	public static String name = "NinjaClient", version = "v1", creator = "Larssies";
	public static CopyOnWriteArrayList<Module> modules = new CopyOnWriteArrayList<Module>();
	public static HUD hud = new HUD();
	public Minecraft mc = Minecraft.getMinecraft();
	
	public static void startup(){		
		System.out.println("Starting " + name + " " + version + " by " + creator);
		Display.setTitle(name + " " + version + " by " + creator);
		
		modules.add(new Fly());
		modules.add(new Sprint());
		modules.add(new FullBright());
		modules.add(new NoFall());
		modules.add(new TabGUI());
		modules.add(new KillAura());
		modules.add(new CreativeFly());
		modules.add(new BunnyHop());
		modules.add(new Jetpack());
		modules.add(new AutoWalk());
		modules.add(new Sneak());
		modules.add(new Speed());
		modules.add(new AimAssist());
		modules.add(new Glide());
		modules.add(new Dolphin());
		modules.add(new Parkour());
		modules.add(new Step());
		modules.add(new Jesus());
		modules.add(new NoClip());
		modules.add(new SafeWalk());
		modules.add(new AutoArmor());
		modules.add(new InvWalk());
		modules.add(new FastBreak());
		modules.add(new FastPlace());
		modules.add(new Criticals());
	}
	
	public static void onEvent(Event e) {
		for(Module m : modules) {
			if(!m.toggled)
				continue;
			
			m.onEvent(e);
		}
	}
	
	public static void keyPress(int key) {
		Client.onEvent(new EventKey(key));
		
		for(Module m : modules) {
			if(m.getKey() == key) {
				m.toggle();
			}
		}
	}
	
	public static List<Module> getModulesByCategory(Category c){
		List<Module> modules = new ArrayList<Module>();
		
		for(Module m : Client.modules) {
			if(m.category == c)
				modules.add(m);
		}
		
		return modules;
	}

}
