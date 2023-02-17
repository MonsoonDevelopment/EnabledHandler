package wtf.monsoon.util.impl;

public class EnabledHandlerFactory {

	public EnabledHandler handler;
	
	public int calls = 0;
	
	public EnabledHandlerFactory() {
		handler = new EnabledHandler();
		calls = 0;
	}
	
	public EnabledHandlerFactory setTheEnabledHandlerToTrue() {
		if(handler.isEnabled() == true)
			throw new RuntimeException("Attempted to set the handler to true but it already was, illegal order");
		handler.setEnabled(true);
		calls = calls + 1;
		if(calls > 5) {
			throw new RuntimeException("Factory ran overrtime and its workers are now on strike! The union has shut down your factory until further notice");
		}
		return this;
	}
	

	public EnabledHandlerFactory setTheEnabledHandlerToFalse() {
		if(handler.isEnabled() == false)
			throw new RuntimeException("Attempted to set the handler to false but it already was, illegal order");
		handler.setEnabled(false);
		calls = calls + 1;
		if(calls > 5) {
			throw new RuntimeException("Factory ran overrtime and its workers are now on strike! The union has shut down your factory until further notice");
		}
		return this;
	}
	
	public EnabledHandler get() {
		if(handler == null) {
			throw new RuntimeException("Handler was null so you can't get it actually");
		}
		calls = calls + 1;
		if(calls > 5) {
			throw new RuntimeException("Factory ran overrtime and its workers are now on strike! The union has shut down your factory until further notice");
		}
		return handler;
	}
	
}
