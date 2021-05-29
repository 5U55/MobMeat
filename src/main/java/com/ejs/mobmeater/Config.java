package com.ejs.mobmeater;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

import net.fabricmc.loader.api.FabricLoader;

public class Config {
	public static String BLAZE_LOOT;
	public static String ENDER_LOOT;
	public static String ELDER_LOOT;
	public static String GHAST_LOOT;
	public static String GUARDIAN_LOOT;
	public static String MAGMA_LOOT;
	public static String RAVAGER_LOOT;
	public static String SKELETON_LOOT;
	public static String SLIME_LOOT;
	public static String CREEPER_LOOT;
	public static String FLESH;
	static {
		@SuppressWarnings("deprecation")
		File configDir = new File(FabricLoader.getInstance().getConfigDirectory(), "fabric");

		if (!configDir.exists()) {
			if (!configDir.mkdir()) {
				System.out.println("Could not create configuration directory: " + configDir.getAbsolutePath());
			}
		}

		File configFile = new File(configDir, "hostile-mob-meat-config.properties");
		Properties properties = new Properties();

		if (configFile.exists()) {
			try (FileInputStream stream = new FileInputStream(configFile)) {
				properties.load(stream);
				BLAZE_LOOT = properties.getProperty("blaze_meat");
				ENDER_LOOT = properties.getProperty("ender_meat");
				ELDER_LOOT =properties.getProperty("elder_guardian_meat");
				GHAST_LOOT = properties.getProperty("ghast_meat");
				GUARDIAN_LOOT = properties.getProperty("guardian_meat");
				MAGMA_LOOT = properties.getProperty("magma_meat");
				RAVAGER_LOOT = properties.getProperty("magma_meat");
				SKELETON_LOOT = properties.getProperty("skeleton_meat");
				SLIME_LOOT = properties.getProperty("slime_meat");
				CREEPER_LOOT = properties.getProperty("creeper_meat");
				FLESH = properties.getProperty("flesh");
			} catch (IOException e) {
				System.out.println("Could not read property file '" + configFile.getAbsolutePath() + "'");
			}
		}

		BLAZE_LOOT = (String) properties.computeIfAbsent("blaze_meat", (a) -> "true");
		ENDER_LOOT = (String) properties.computeIfAbsent("ender_meat", (a) -> "true");
		ELDER_LOOT = (String) properties.computeIfAbsent("elder_guardian_meat", (a) -> "true");
		GHAST_LOOT = (String) properties.computeIfAbsent("ghast_meat", (a) -> "true");
		GUARDIAN_LOOT = (String) properties.computeIfAbsent("guardian_meat", (a) -> "true");
		MAGMA_LOOT = (String) properties.computeIfAbsent("magma_meat", (a) -> "true");
		RAVAGER_LOOT = (String) properties.computeIfAbsent("ravager_meat", (a) -> "true");
		SKELETON_LOOT = (String) properties.computeIfAbsent("skeleton_meat", (a) -> "true");
		SLIME_LOOT = (String) properties.computeIfAbsent("slime_meat", (a) -> "true");
		CREEPER_LOOT = (String) properties.computeIfAbsent("creeper_meat", (a) -> "true");
		FLESH = (String) properties.computeIfAbsent("flesh", (a) -> "true");
		
		try (FileOutputStream stream = new FileOutputStream(configFile)) {
			properties.store(stream, "Properties file");
		} catch (IOException e) {
			System.out.println("Could not store property file '" + configFile.getAbsolutePath() + "'");
		}
	}
}
