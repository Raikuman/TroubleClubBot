package com.reliquary.crow.invokes.commands.dnd;

import com.reliquary.crow.invokes.slashcommands.dnd.DnD.DnD;
import com.reliquary.crow.managers.commands.CommandContext;
import com.reliquary.crow.managers.commands.CommandInterface;
import com.reliquary.crow.resources.dnd.CharacterFetchInfo;
import com.reliquary.crow.resources.dnd.CharacterManager;
import com.reliquary.crow.resources.jda.MessageResources;
import com.reliquary.crow.resources.other.RandomColor;
import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.entities.TextChannel;

import java.util.Arrays;
import java.util.List;

/**
 * This class lets the user select a character from their user profile directory
 *
 * @version 1.1 2021-31-12
 * @since 1.1
 */
public class SelectCharacter implements CommandInterface {

	@Override
	public void handle(CommandContext ctx) {

		final TextChannel textChannel = ctx.getChannel();
		final String userId = ctx.getMember().getId();

		if (!CharacterManager.hasProfile(userId)) {
			MessageResources.timedMessage(
				"You don't have any characters yet! Refer to `/" + new DnD().getInvoke() + "` for help",
				textChannel,
				10
			);
			return;
		}

		if (ctx.getArgs().size() != 1) {
			MessageResources.timedMessage(
				"Please provide a valid character number to select from your profile",
				textChannel,
				10
			);
			return;
		}

		int characterNum;
		try {
			characterNum = Integer.parseInt(ctx.getArgs().get(0));

			if (characterNum < 0)
				throw new NumberFormatException("Number must be greater than 0");

			if (characterNum > CharacterManager.getCharacterList(userId).size())
				throw new NumberFormatException("Number must be a number that exists on user's profile");
		} catch (NumberFormatException e) {
			MessageResources.timedMessage(
				"Please provide a valid character number to select from your profile",
				textChannel,
				10
			);
			return;
		}

		if (characterNum == 1) {
			MessageResources.timedMessage(
				"This character is already selected! Provide another character",
				textChannel,
				10
			);
			return;
		}

		if (!CharacterManager.switchCharacter(userId, characterNum)) {
			MessageResources.timedMessage(
				"An error occurred while selecting your character. Contact developer for help.",
				textChannel,
				10
			);
			return;
		}

		CharacterFetchInfo fetchInfo =
			new CharacterFetchInfo(CharacterManager.getSheetId(userId, 1));

		EmbedBuilder builder = new EmbedBuilder()
			.setAuthor(fetchInfo.name() + " has been selected as your current character!", null,
				ctx.getMember().getUser().getAvatarUrl())
			.setColor(RandomColor.getRandomColor());

		String characterPortrait = fetchInfo.portrait();
		if (!characterPortrait.isEmpty())
			builder.setImage(characterPortrait);

		ctx.getMessage().delete().queue();
		ctx.getChannel().sendMessageEmbeds(builder.build()).queue();
	}

	@Override
	public String getInvoke() {
		return "selectcharacter";
	}

	@Override
	public String getHelp() {
		return "Select a character from your profile to use as your current character";
	}

	@Override
	public String getUsage() {
		return "<# of your character>";
	}

	@Override
	public String getCategory() {
		return "dnd";
	}

	@Override
	public List<String> getAliases() {
		return Arrays.asList("selectchar", "selchar");
	}
}