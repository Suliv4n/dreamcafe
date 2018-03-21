package com.sulivan.dreamcafe.system.command;

import java.util.ArrayList;

/**
 * 
 * This class describe a command.
 */
public abstract class Command {
	
	/**
	 * Parameters injected in the command.
	 */
	private ArrayList<String> parameters;
	
	/**
	 * Method to override. It contains the command logic.
	 */
	public abstract void run();

	/**
	 * Inject parameter in the command.
	 * 
	 * @param parameters
	 * 	The parameters to inject.
	 */
	public final void injectParameters(ArrayList<String> parameters) {
		this.parameters = parameters;
	}
	
	
	/**
	 * Return the parameters injected.
	 * 
	 * @return the parameters injected.
	 */
	public ArrayList<String> getParameters() {
		return parameters;
	}

}
