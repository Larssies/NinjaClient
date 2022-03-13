package NinjaClient.ui;

import java.util.Collections;
import java.util.Comparator;

import NinjaClient.Client;
import NinjaClient.events.listeners.EventRenderGUI;
import NinjaClient.modules.Module;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.FontRenderer;
import net.minecraft.client.gui.Gui;
import net.minecraft.client.gui.ScaledResolution;
import net.minecraft.client.renderer.GlStateManager;

public class HUD {
	
	public Minecraft mc = Minecraft.getMinecraft();
	
	public void draw() {
		ScaledResolution sr = new ScaledResolution(mc, mc.displayWidth, mc.displayHeight);
		FontRenderer fr = mc.fontRendererObj;
		
		Client.modules.sort(Comparator.comparingInt(m -> mc.fontRendererObj.getStringWidth(((Module)m).name)).reversed());
		
		GlStateManager.translate(4, 4, 0);
		GlStateManager.scale(2, 2, 1);
		GlStateManager.translate(-4, -4, 0);
		fr.drawString(Client.name + " " + Client.version, 4, 4, 0xFF3D3D);
		GlStateManager.translate(4, 4, 0);
		GlStateManager.scale(0.5, 0.5, 1);
		GlStateManager.translate(-4, -4, 0);
		
		int count = 0;
		for(Module m : Client.modules) {
			if(!m.toggled || m.name.equals("TabGUI"))
				continue;
			
			double offset = count*(fr.FONT_HEIGHT + 6);
			
			Gui.drawRect(sr.getScaledWidth() - fr.getStringWidth(m.name) - 10, offset, sr.getScaledWidth() - fr.getStringWidth(m.name) - 8, 6 + fr.FONT_HEIGHT + offset, 0xff0090ff);
			Gui.drawRect(sr.getScaledWidth() - fr.getStringWidth(m.name) - 8, offset, sr.getScaledWidth(), 6 + fr.FONT_HEIGHT + offset, 0x90000000);
			fr.drawString(m.name, sr.getScaledWidth() - fr.getStringWidth(m.name) - 4, 4 + offset, -1);
			
			count++;
		}
		
		Client.onEvent(new EventRenderGUI());
	}

}
