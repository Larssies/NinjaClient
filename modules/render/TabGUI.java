package NinjaClient.modules.render;

import java.util.List;

import org.lwjgl.input.Keyboard;
import org.lwjgl.util.Color;

import NinjaClient.Client;
import NinjaClient.events.Event;
import NinjaClient.events.listeners.EventKey;
import NinjaClient.events.listeners.EventRenderGUI;
import NinjaClient.events.listeners.EventUpdate;
import NinjaClient.modules.Module;
import NinjaClient.settings.BooleanSetting;
import NinjaClient.settings.ModeSetting;
import NinjaClient.settings.NumberSetting;
import NinjaClient.settings.Settings;
import net.minecraft.client.gui.FontRenderer;
import net.minecraft.client.gui.Gui;

public class TabGUI extends Module{
	
	public int currentTab;
	public boolean expanded;
	
	public TabGUI() {
		super("TabGUI", Keyboard.KEY_NONE, Category.RENDER);
		toggled = true;
	}
	
	public void onEvent(Event e) {
		if(e instanceof EventRenderGUI) {
			FontRenderer fr = mc.fontRendererObj;
			
			int primaryColor = 0xff0090ff, secondaryColor = 0xff0070aa;
			
			Gui.drawRect(5, 30.5, 70, 30 + Module.Category.values().length * 16 + 1.5, 0x90000000);
			Gui.drawRect(5, 30.5f + currentTab * 16, 7 + 61 + 2, 33 + currentTab * 16 + 12 + 2.5f, primaryColor);
			
			int count = 0;
			for(Category c : Module.Category.values()) {
				fr.drawString(c.name, 11, 35.5 + count*16, -1);
				
				count++;
			}
			
			if(expanded) {
				Category category = Module.Category.values()[currentTab];
				List<Module> modules = Client.getModulesByCategory(category);
				
				if(modules.size() == 0)
					return;
				
				
				Gui.drawRect(70, 30.5, 70 + 68, 30 + modules.size() * 16 + 1.5, 0x90000000);
				Gui.drawRect(70, 30.5f + category.moduleIndex * 16, 7 + 61 + 70, 33 + category.moduleIndex * 16 + 12 + 2.5f, primaryColor);
				
				count = 0;
				for(Module m : modules) {
					fr.drawString(m.name, 73, 35.5 + count*16, -1);
					
					if(count == category.moduleIndex && m.expanded) {

						int index = 0, maxLength = 0;
						for(Settings setting : m.settings) {
							if(setting instanceof BooleanSetting) { 
								BooleanSetting bool = (BooleanSetting) setting;
								if(maxLength < fr.getStringWidth(setting.name + ": " + (bool.enabled ? "Enabled" : "Disabled"))) {
									maxLength = fr.getStringWidth(setting.name + ": " + (bool.enabled ? "Enabled" : "Disabled"));
								}
							}
							
							if(setting instanceof NumberSetting) { 
								NumberSetting number = (NumberSetting) setting;
								if(maxLength < fr.getStringWidth(setting.name + ": " + number.getValue())) {
									maxLength = fr.getStringWidth(setting.name + ": " + number.getValue());
								}
							}
							
							if(setting instanceof ModeSetting) { 
								ModeSetting mode = (ModeSetting) setting;
								if(maxLength < fr.getStringWidth(setting.name + ": " + mode.getMode())) {
									maxLength = fr.getStringWidth(setting.name + ": " + mode.getMode());
								}
							}
							
							index++;
						}
						
						if(!m.settings.isEmpty()) {
							Gui.drawRect(70 + 68, 30.5, 70 + 68 + maxLength + 9, 30 + m.settings.size() * 16 + 1.5, 0x90000000);
							Gui.drawRect(70 + 68, 30.5f + m.index * 16, 7 + 61 + maxLength + 9 + 70, 33 + m.index * 16 + 12 + 2.5f, m.settings.get(m.index).focused ? secondaryColor : primaryColor);
							
							
							index = 0;
							for(Settings setting : m.settings) {
								if(setting instanceof BooleanSetting) { 
									BooleanSetting bool = (BooleanSetting) setting;
									fr.drawString(setting.name + ": " + (bool.enabled ? "Enabled" : "Disabled"), 73 + 68 + 2, 35.5 + index*16, -1);
								}
								
								if(setting instanceof NumberSetting) { 
									NumberSetting number = (NumberSetting) setting;
									fr.drawString(setting.name + ": " + number.getValue(), 73 + 68 + 2, 35.5 + index*16, -1);
								}
								
								if(setting instanceof ModeSetting) { 
									ModeSetting mode = (ModeSetting) setting;
									fr.drawString(setting.name + ": " + mode.getMode(), 73 + 68 + 2, 35.5 + index*16, -1);
								}
								
								index++;
							}	
						}
					}
					
					count++;
				}
				
				
			}
		}
		if(e instanceof EventKey) {
			int code = ((EventKey)e).code;

			Category category = Module.Category.values()[currentTab];
			List<Module> modules = Client.getModulesByCategory(category);
			
			if(code == Keyboard.KEY_UP) {
				if(expanded) {
					if(expanded && !modules.isEmpty() && modules.get(category.moduleIndex).expanded) {
						Module module = modules.get(category.moduleIndex);
						
						if(!module.settings.isEmpty()) {
							if(module.settings.get(module.index).focused) {
								Settings setting = module.settings.get(module.index);
								
								if(setting instanceof NumberSetting) {
									((NumberSetting)setting).increment(true);
								}
							}else {
								if(module.index <= 0) {
									module.index = module.settings.size() - 1;
								}else
									module.index--;
							}
						}
					}else {
						if(category.moduleIndex <= 0) {
							category.moduleIndex = modules.size() - 1;
						}else
							category.moduleIndex--;
					}
				}else {
					if(currentTab <= 0) {
						currentTab = Module.Category.values().length - 1;
					}else
						currentTab--;
				}
			}
			
			if(code == Keyboard.KEY_DOWN) {
				if(expanded) {
					if(expanded && !modules.isEmpty() && modules.get(category.moduleIndex).expanded) {
						Module module = modules.get(category.moduleIndex);
						
						if(!module.settings.isEmpty()) {
							if(module.settings.get(module.index).focused) {
								Settings setting = module.settings.get(module.index);
								
								if(setting instanceof NumberSetting) {
									((NumberSetting)setting).increment(false);
								}
							}else {
								if(module.index >= module.settings.size() - 1) {
									module.index = 0;
								}else
									module.index++;
							}
						}
					}else {
						if(category.moduleIndex >= modules.size() - 1) {
							category.moduleIndex = 0;
						}else
							category.moduleIndex++;
					}
				}else {
					if(currentTab >= Module.Category.values().length - 1) {
						currentTab = 0;
					}else
						currentTab++;
				}
			}
			
			if(code == Keyboard.KEY_RETURN) {
				if(expanded && modules.size() != 0) {
					Module module = modules.get(category.moduleIndex);
					
					if(!module.expanded && !module.settings.isEmpty())
						module.expanded = true;
					else if(module.expanded && !module.settings.isEmpty()) {
						module.settings.get(module.index).focused = !module.settings.get(module.index).focused;
					}
				}
			}
			
			if(code == Keyboard.KEY_RIGHT) {
				if(expanded && modules.size() != 0) {
					Module module = modules.get(category.moduleIndex);

					if(expanded && !modules.isEmpty() && module.expanded) {
						if(!module.settings.isEmpty()) {
							Settings setting = module.settings.get(module.index);
							
							if(setting instanceof BooleanSetting) {
								((BooleanSetting)setting).toggle();
							}
							if(setting instanceof ModeSetting) {
								((ModeSetting)setting).cycle();
							}
						}
					}else {
						if(!module.name.equals("TabGUI"))
							module.toggle();
					}
					
				}else {
					expanded = true;
				}
			}
			
			if(code == Keyboard.KEY_LEFT) {
				if(expanded && !modules.isEmpty() && modules.get(category.moduleIndex).expanded) {
					Module module = modules.get(category.moduleIndex);
					

					if(!module.settings.isEmpty()) {
						if(module.settings.get(module.index).focused) {
						
						}else {
							modules.get(category.moduleIndex).expanded = false;
						}
					}
				}else
					expanded = false;
			}
		}
	}
}
