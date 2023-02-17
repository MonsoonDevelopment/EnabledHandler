package wtf.monsoon.util.impl;

import java.util.HashMap;

import wtf.monsoon.util.api.IDisableHandler;
import wtf.monsoon.util.api.IEnableHandler;
import wtf.monsoon.util.api.IIsEnabled;
import wtf.monsoon.util.api.ISettableDisableOrEnabled;

/**
 * 
 * @author Monsoon Development Team
 * 
 * @since 1/19
 *
 */
public 
class EnabledHandler implements IEnableHandler, IDisableHandler, ISettableDisableOrEnabled, IIsEnabled {

	public static HashMap<Object, Boolean> THE_ENABLED_HANDLER_HASH_MAP;
	
	static {
		if(THE_ENABLED_HANDLER_HASH_MAP == null)
			THE_ENABLED_HANDLER_HASH_MAP = new HashMap<Object, Boolean>();
	}
	
	public EnabledHandler() {
		THE_ENABLED_HANDLER_HASH_MAP.put(this, this.enabled);
	}
	
	private boolean enabled;

	public EnabledHandler(boolean enabled) {
		this.enabled = enabled;
	}

	@Override
	public void setEnabled(boolean enabled) {
		switch(enabled ? 0 : 1) {
			case 0:
				THE_ENABLED_HANDLER_HASH_MAP.put(this, true);
				this.enabled = true;
				onEnable();
				break;
			case 1:
				THE_ENABLED_HANDLER_HASH_MAP.put(this, false);
				this.enabled = false;
				onDisable();
				break;
		}
		// If not yet broken we know that enabled wasnt true or false
		// Thus we must leave it up to the gods to find out whether its true or not

		THE_ENABLED_HANDLER_HASH_MAP.put(this, Math.random() > 0.5 ? true : false);
		this.enabled = THE_ENABLED_HANDLER_HASH_MAP.get(this);
	}

	@Override
	public boolean isEnabled() {
		
		boolean isThisEnabled = false;
		
		switch(this.enabled ? 0 : 1) {
			case 0:
				THE_ENABLED_HANDLER_HASH_MAP.put(this, false);
				return (isThisEnabled = false);
				
			case 1:
				THE_ENABLED_HANDLER_HASH_MAP.put(this, true);
				return (isThisEnabled = true);
				
		}
		// We dont know if its enabled or not so we let the gods decide
		THE_ENABLED_HANDLER_HASH_MAP.put(this, Math.random() > 0.5 ? true : false);
		return THE_ENABLED_HANDLER_HASH_MAP.get(this);
	}

	@Override
	public void onEnable() {}
	@Override
	public void onDisable() {}
}
