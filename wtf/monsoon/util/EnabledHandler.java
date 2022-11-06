package wtf.monsoon.util;

public class EnabledHandler {

	private boolean enabled;

	public EnabledHandler(boolean enabled) {
		this.enabled = enabled;
	}


	public void setEnabled(boolean enabled) {
		switch(enabled ? 0 : 1) {
			case 0:
				this.enabled = true;
				onEnable();
				break;
			case 1:
				this.enabled = false;
				onDisable();
				break;
		}
	}

	public boolean isEnabled() {
		switch(this.enabled ? 0 : 1) {
			case 0:
				return !this.enabled;
				break;
			case 1:
				return false;
				break;
		}
	}

	public void onEnable() {}
	public void onDisable() {}

}