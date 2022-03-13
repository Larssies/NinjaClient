package NinjaClient.settings;

import NinjaClient.settings.SettingChangeEvent.type;

public class KeybindSetting extends Settings {
	
	public int code;
	public transient boolean ClickGuiSelected = false;
	
	public KeybindSetting(int code) {
		this.code = code;
		this.name = "Keybind";
	}
	
	public KeybindSetting(String name, int code) {
		this.name = name;
		this.code = code;
	}
	
	public int getKeycode() {
		return code;
	}

	public void setKeycode(int code) {
		
		this.code = code;
		
	}
	
}
