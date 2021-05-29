package com.ejs.mobmeater.registry;

import com.ejs.mobmeater.Config;

import net.fabricmc.fabric.api.loot.v1.FabricLootPoolBuilder;
import net.fabricmc.fabric.api.loot.v1.event.LootTableLoadingCallback;
import net.minecraft.item.Item;
import net.minecraft.loot.UniformLootTableRange;
import net.minecraft.loot.entry.ItemEntry;
import net.minecraft.util.Identifier;

public class Loot {
	private static final Identifier BLAZE_LOOT = new Identifier("minecraft", "entities/blaze");
	private static final Identifier ENDER_LOOT = new Identifier("minecraft", "entities/enderman");
	private static final Identifier ELDER_LOOT = new Identifier("minecraft", "entities/elder_guardian");
	private static final Identifier GHAST_LOOT = new Identifier("minecraft", "entities/ghast");
	private static final Identifier GUARDIAN_LOOT = new Identifier("minecraft", "entities/guardian");
	private static final Identifier MAGMA_LOOT = new Identifier("minecraft", "entities/magma");
	private static final Identifier RAVAGER_LOOT = new Identifier("minecraft", "entities/ravager");
	private static final Identifier SKELETON_LOOT = new Identifier("minecraft", "entities/skeleton");
	private static final Identifier SLIME_LOOT = new Identifier("minecraft", "entities/slime");
	private static final Identifier CREEPER_LOOT = new Identifier("minecraft", "entities/creeper");

	private static final Identifier VILLAGER = new Identifier("minecraft", "entities/villager");
	private static final Identifier PILLAGER = new Identifier("minecraft", "entities/pillager");
	private static final Identifier EVOKER = new Identifier("minecraft", "entities/evoker");
	private static final Identifier VINDICATOR = new Identifier("minecraft", "entities/vindicator");
	private static final Identifier WITCH = new Identifier("minecraft", "entities/witch");

	private static final Identifier[] LOOT_TABLES = { BLAZE_LOOT, ENDER_LOOT, ELDER_LOOT, GHAST_LOOT, GUARDIAN_LOOT,
			MAGMA_LOOT, RAVAGER_LOOT, SKELETON_LOOT, SLIME_LOOT, CREEPER_LOOT };
	private static final Item[] DROPS = { ModItems.BLAZE_MEAT, ModItems.ENDER_MEAT, ModItems.ELDER_MEAT,
			ModItems.GHAST_MEAT, ModItems.GUARDIAN_MEAT, ModItems.MAGMA_MEAT, ModItems.RAVAGER_MEAT,
			ModItems.BONE_MARROW, ModItems.SLIME_MEAT, ModItems.CREEPER_MEAT };
	private static final String[] CONFIG_LABELS = {
			Config.BLAZE_LOOT, Config.ENDER_LOOT, Config.ELDER_LOOT, Config.GHAST_LOOT, Config.GUARDIAN_LOOT, 
			Config.MAGMA_LOOT,	Config.RAVAGER_LOOT, Config.SKELETON_LOOT, Config.SLIME_LOOT, Config.CREEPER_LOOT
	};
	public static void init() {
		for (int i = 0; i < LOOT_TABLES.length; i++) {
			final int j = i;
			if(CONFIG_LABELS[j].equals("true")) {
			LootTableLoadingCallback.EVENT.register((resourceManager, lootManager, id, supplier, setter) -> {
				if (LOOT_TABLES[j].equals(id)) {
					FabricLootPoolBuilder RawPoolBuilder = FabricLootPoolBuilder.builder()
							.rolls(UniformLootTableRange.between(1, 2)).withEntry(ItemEntry.builder(DROPS[j]).build());

					supplier.pool(RawPoolBuilder);
				}
			});}
		}
		if (Config.FLESH.equals("true")) {
			LootTableLoadingCallback.EVENT.register((resourceManager, lootManager, id, supplier, setter) -> {
				if (VILLAGER.equals(id) || PILLAGER.equals(id) || EVOKER.equals(id) || VINDICATOR.equals(id)
						|| WITCH.equals(id)) {
					FabricLootPoolBuilder poolBuilder = FabricLootPoolBuilder.builder()
							.rolls(UniformLootTableRange.between(0, 2))
							.withEntry(ItemEntry.builder(ModItems.FLESH).build());

					supplier.pool(poolBuilder);
				}
			});
		}
	}
}
