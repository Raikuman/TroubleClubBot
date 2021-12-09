package com.reliquary.crow.slashcommands.help.selectionmenus;

import com.reliquary.crow.componentmanagers.selectionmenus.SelectContext;
import com.reliquary.crow.componentmanagers.selectionmenus.SelectInterface;
import com.reliquary.crow.slashcommands.help.resources.HelpResources;

/**
 * This class provides the SelectInterface for basic commands in the help command
 *
 * @version 1.0 2021-09-12
 * @since 1.0
 */
public class HelpBasic implements SelectInterface {

	@Override
	public void handle(SelectContext ctx) {

		ctx.getEvent().editMessageEmbeds(
			HelpResources.provideHelpEmbed(getLabel()).build()
		).queue();
	}

	@Override
	public String getMenuValue() {
		return "helpbasic";
	}

	@Override
	public String getLabel() {
		return "Basic";
	}
}
