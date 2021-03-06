package ca.teamdman.zensummoning.common.summoning;

import ca.teamdman.zensummoning.ZenSummoning;
import crafttweaker.annotations.ZenRegister;
import stanhebben.zenscript.annotations.ZenClass;
import stanhebben.zenscript.annotations.ZenMethod;

import java.util.ArrayList;
import java.util.List;

@ZenRegister
@ZenClass(ZenSummoning.ZEN_PACKAGE + ".SummoningDirector")
public class SummoningDirector {
	private static final List<SummoningInfo> summonings = new ArrayList<>();
	private static       int                 stackLimit = 0;

	public static int getStackLimit() {
		return stackLimit;
	}

	public static List<SummoningInfo> getSummonInfos() {
		return summonings;
	}

	@ZenMethod
	public static void addSummonInfo(SummoningInfo info) {
		summonings.add(info);
		stackLimit = Math.max(info.getReagents().size(), stackLimit);
		ZenSummoning.log("addSummonInfo");
	}

	@SuppressWarnings("unused")
	@ZenMethod
	public static void enableDebugging() {
		ZenSummoning.debug = true;
	}

}
