package com.reliquary.crow.managers.reacts;

/**
 * This class provides an interface for creating commands
 *
 * @version 1.3 2021-07-12
 * @since 1.0
 */
public interface ReactInterface {

	/**
	 * This method is where all functions of the command of adding a reaction should go
	 * @param ctx Uses the context of the reaction for usage
	 */
	void handleAdd(ReactContext ctx);

	/**
	 * This method is where all functions of the command of removing a reaction should go
	 * @param ctx Uses the context of the reaction for usage
	 */
	void handleRemove(ReactContext ctx);

	/**
	 * This method returns the invoke reaction
	 * @return Returns the invocation reaction
	 */
	String getInvoke();

	/**
	 * This method returns the emoji of the reaction
	 * @return Returns reaction emoji
	 */
	String getEmoji();

	/**
	 * This method returns the category of the command
	 * @return Returns the category string
	 */
	String getCategory();

	/**
	 * This method returns the name of this react
	 * @return Returns the react name string
	 */
	String getReactName();

	/**
	 * This method returns the help string of the react
	 * @return Returns the react help string
	 */
	String getHelp();
}