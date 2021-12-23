package com.reliquary.crow.invokes.slashcommands.help;

import com.reliquary.crow.managers.componentmanagers.selectionmenus.SelectResources;
import com.reliquary.crow.invokes.slashcommands.help.resources.HelpResources;
import com.reliquary.crow.managers.slashcommands.SlashContext;
import com.reliquary.crow.managers.slashcommands.SlashInterface;
import net.dv8tion.jda.api.interactions.components.selections.SelectionMenu;

/**
 * This class handles getting a list of commands and their description to provide a help menu
 *
 * @version 1.1 2021-23-12
 * @since 1.0
 */
public class Help implements SlashInterface {

	@Override
	public void handle(SlashContext ctx) {

		final String userId = ctx.getEvent().getUser().getId();

		SelectionMenu menu = SelectionMenu.create("menu:help")
			.setPlaceholder("View commands in category")
			.setRequiredRange(1, 1)
			.addOptions(SelectResources.createSelectOptions(userId, HelpResources.getSelectionMenuInterfaces()))
			.build();


		// Reply with selection menu
		ctx.getEvent().replyEmbeds(
			HelpResources.provideHelpHomeEmbed().build()
		).addActionRow(menu).queue();
	}

	@Override
	public String getInvoke() {
		return "help";
	}

	@Override
	public String getHelp() {
		return "A little help for the uninitiated";
	}

	@Override
	public String getCategory() {
		return "";
	}
}
