package com.ejs.mobmeater;

import com.ejs.mobmeater.registry.ModItems;

import net.fabricmc.api.ModInitializer;

public class MobMeat implements ModInitializer{
	public static final String MOD_ID = "mobmeater";
	@Override
	public void onInitialize() {
		ModItems.registerItems();
	}
}