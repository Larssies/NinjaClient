package NinjaClient.settings;

public class SettingChangeEvent {
	
	public SettingChangeEvent(type type, Settings setting) {
		
		this.settingType = type;
		this.setting = setting;
		
	}
	
	public type settingType = type.NONE;
	public Settings setting = null;
	
	public static enum type{
		NONE,
		MODE,
		NUMBER,
		BOOLEAN,
		KEYBIND;
	}
	
}