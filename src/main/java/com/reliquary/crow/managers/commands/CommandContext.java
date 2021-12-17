package com.reliquary.crow.managers.commands;

import me.duncte123.botcommons.commands.ICommandContext;
import net.dv8tion.jda.api.entities.Guild;
import net.dv8tion.jda.api.entities.TextChannel;
import net.dv8tion.jda.api.events.message.guild.GuildMessageReceivedEvent;

import java.util.List;

/**
 * This class provides needed information for commands in a single object without all the bloat from the
 * message event
 *
 * @version 2.0 2021-08-11
 * @since 1.0
 */
public class CommandContext implements ICommandContext {

	private final GuildMessageReceivedEvent event;
	private final List<String> args;

	public CommandContext(GuildMessageReceivedEvent event, List<String> args) {
		this.event = event;
		this.args = args;
	}

	@Override
	public Guild getGuild() {
		return this.getEvent().getGuild();
	}

	@Override
	public GuildMessageReceivedEvent getEvent() {
		return event;
	}

	@Override
	public TextChannel getChannel() {
		return event.getChannel();
	}

	public List<String> getArgs() {
		return this.args;
	}
}