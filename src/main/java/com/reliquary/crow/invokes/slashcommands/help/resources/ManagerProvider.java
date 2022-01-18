package com.reliquary.crow.invokes.slashcommands.help.resources;

import com.reliquary.crow.managers.commands.CommandManager;
import com.reliquary.crow.managers.reacts.ReactManager;
import com.reliquary.crow.managers.slashcommands.SlashManager;

/**
 * This class gets all invoke managers for use of the help command
 *
 * @version 1.0 2021-09-12
 * @since 1.0
 */
public class ManagerProvider {

	final private CommandManager commandManager;
	final private SlashManager slashManager;
	final private ReactManager reactManager;

	public ManagerProvider() {
		commandManager = new CommandManager();
		slashManager = new SlashManager();
		reactManager = new ReactManager();
	}

	/**
	 * This method returns the command manager
	 * @return Returns command manager
	 */
	public CommandManager getCommandManager() {
		return commandManager;
	}

	/**
	 * This method returns the slash manager
	 * @return Returns slash manager
	 */
	public SlashManager getSlashManager() {
		return slashManager;
	}

	/**
	 * This method returns the react manager
	 * @return Returns react manager
	 */
	public ReactManager getReactManager() {
		return reactManager;
	}
}