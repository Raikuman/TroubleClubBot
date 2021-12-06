package com.reliquary.crow.slashcommands.ButtonTest.buttons;

import com.reliquary.crow.buttons.ButtonContext;
import com.reliquary.crow.buttons.ButtonInterface;
import com.reliquary.crow.buttons.ButtonResources;
import com.reliquary.crow.resources.other.RandomColor;
import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.entities.Emoji;
import net.dv8tion.jda.api.requests.restaction.interactions.UpdateInteractionAction;

import java.util.ArrayList;

public class ButtonTestB implements ButtonInterface {

	@Override
	public void handle(ButtonContext ctx) {

		if (ctx.getEvent().getButton() == null)
			return;

		// 2nd test embed
		EmbedBuilder builder = new EmbedBuilder()
			.setTitle("Other page")
			.setColor(RandomColor.getRandomColor());
		StringBuilder descriptionBuilder = builder.getDescriptionBuilder();

		descriptionBuilder
			.append("Page B");

		UpdateInteractionAction updateAction = ctx.getEvent().deferEdit();
		updateAction = updateAction.setEmbeds(builder.build());

		updateAction = updateAction.setActionRows(ButtonResources.getActionRows(
			new ArrayList<>(ButtonResources.setCurrentButtonDisabled(
				ctx.getEvent().getMessage().getButtons(), getButtonId()
			))
		));

		updateAction.queue();
	}

	@Override
	public String getButtonId() {
		return "buttontestb";
	}

	@Override
	public Emoji getEmoji() {
		return null;
	}

	@Override
	public String getLabel() {
		return "B";
	}
}
