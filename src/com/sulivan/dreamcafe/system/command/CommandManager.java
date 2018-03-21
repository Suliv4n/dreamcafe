package com.sulivan.dreamcafe.system.command;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * This singleton class is designed to manage commands that can be executed.
 */
public class CommandManager {

	/**
	 * The unique instance of this class.
	 */
	private static CommandManager instance;
	
	/**
	 * Lists of all commands.
	 * Key : The command name used to call it
	 * Value : The command class name to be executed.
	 */
	private HashMap<String, String> commands;
	
	private CommandManager() {
		commands = new HashMap<String, String>();
	}

	/**
	 * Register a command in the manger.
	 * A command must be registered to be executed by the manger.
	 * 
	 * @param commandName
	 * 	The command name used to execute it.
	 * 
	 * @param commandClass
	 * 	The class full name of the command.
	 * 
	 * @throws CommandException
	 * 	If the command class name is not a subcass of com.sulivan.dreamcafe.system.command.Command, or if the class can't be loaded.
	 */
	public void register(String commandName, String commandClass) throws CommandException {
		
		try {
			
			Class<?> commandClassReflect = ClassLoader.getSystemClassLoader().loadClass(commandClass);
			
			if(!Command.class.isAssignableFrom(commandClassReflect)) {
				throw new CommandException(String.format("The class %s must be a subclass of %s", commandClass, Command.class.getName()));
			}
			
			commands.put(commandName, commandClass);

		} 
		catch (ClassNotFoundException e) {
			throw new CommandException(String.format("The class name %s can't be loaded.", commandClass));
		}
	}
	

	/**
	 * Run a command given by its name.
	 * 
	 * @param commandName
	 * 	The name of the command to run.
	 * 
	 * @throws CommandException
	 * 	If the command was not found.
	 */
	public void run(String commandName, ArrayList<String> parameters) throws CommandException{
		
		if(!commands.containsKey(commandName)) {
			throw new CommandException(String.format("The command named %s was not found. Did your register it ?", commandName));
		}
		
		String commandClass = commands.get(commandName);
		
		try {

			Class<?> commandClassReflect = ClassLoader.getSystemClassLoader().loadClass(commandClass);
			Command command = (Command) commandClassReflect.newInstance();

			command.injectParameters(parameters);
			
			command.run();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (InstantiationException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		}
	}
	
	public void run(String command) throws CommandException {
		
		ArrayList<String> parameters = parseParameters(command);

		String commandName = parameters.remove(0);
		
		run(commandName, parameters);
	}
	
	/**
	 * Parse a parameters string and return them into 
	 * an ArrayList. For example the string :
	 * parameter1 "a long string" "an other long \"string\""
	 * will return :
	 * ["parameter1", "a long string", "an other long "string""]
	 * 
	 * @param parametersString
	 * 	The parameters String to return.
	 * 
	 * @return an ArryList of parameters.
	 */
	private ArrayList<String> parseParameters (String parametersString) {

		ArrayList<String> parameters = new ArrayList<String>(); 
		String regex = "\"((?:[^\"]|(?<=\\\\)\")+)\"|([^\\s]+)";
		
		Pattern pattern = Pattern.compile(regex);
		
		Matcher matcher = pattern.matcher(parametersString);
		
		while(matcher.find()) {
			String parameter = matcher.group(1);
			
			if(parameter == null){
				parameter = matcher.group(2);
			}
			
			parameter = parameter.replaceAll("\\\\\"", "\"");
			
			parameters.add(parameter);
		}
		
		return parameters;
	}
	
	
	/**
	 * The unique instance of CommandManager.
	 * 
	 * @return the unique instance of Commandmanager.
	 */
	public static CommandManager getInstance() {
		
		if(instance == null){
			instance = new CommandManager();
		}
		
		return instance;
	}
}
