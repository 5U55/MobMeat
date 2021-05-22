package com.ejs.mobmeater.registry;

import com.ejs.mobmeater.MobMeat;

import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.item.FoodComponent;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class ModItems {
	public static final Item BLAZE_MEAT = new Item(new Item.Settings().group(ItemGroup.FOOD).food((new FoodComponent.Builder()).hunger(5).saturationModifier(8f).statusEffect(new StatusEffectInstance(StatusEffects.SLOW_FALLING, 100, 2), 1f).statusEffect(new StatusEffectInstance(StatusEffects.GLOWING, 100, 1), 1f).meat().build()));
	public static final Item ENDER_MEAT = new Item(new Item.Settings().group(ItemGroup.FOOD).food((new FoodComponent.Builder()).hunger(8).saturationModifier(12f).statusEffect(new StatusEffectInstance(StatusEffects.INVISIBILITY, 200, 1), 1f).meat().build()));
	public static final Item ELDER_MEAT = new Item(new Item.Settings().group(ItemGroup.FOOD).food((new FoodComponent.Builder()).hunger(8).saturationModifier(12f).statusEffect(new StatusEffectInstance(StatusEffects.HASTE, 100, 2), 1f).meat().build()));
	public static final Item GHAST_MEAT = new Item(new Item.Settings().group(ItemGroup.FOOD).food((new FoodComponent.Builder()).hunger(9).saturationModifier(6f).statusEffect(new StatusEffectInstance(StatusEffects.SLOWNESS, 100, 2), 1f).statusEffect(new StatusEffectInstance(StatusEffects.FIRE_RESISTANCE, 100, 2), 1f).meat().build()));
	public static final Item GUARDIAN_MEAT = new Item(new Item.Settings().group(ItemGroup.FOOD).food((new FoodComponent.Builder()).hunger(6).saturationModifier(7f).statusEffect(new StatusEffectInstance(StatusEffects.DOLPHINS_GRACE, 100, 1), 1f).meat().build()));
	public static final Item MAGMA_MEAT = new Item(new Item.Settings().group(ItemGroup.FOOD).food((new FoodComponent.Builder()).hunger(20).saturationModifier(15f).statusEffect(new StatusEffectInstance(StatusEffects.BLINDNESS, 100, 1), 1f).meat().build()));
	public static final Item RAVAGER_MEAT = new Item(new Item.Settings().group(ItemGroup.FOOD).food((new FoodComponent.Builder()).hunger(8).saturationModifier(9f).statusEffect(new StatusEffectInstance(StatusEffects.NAUSEA, 200, 2), 1f).statusEffect(new StatusEffectInstance(StatusEffects.LEVITATION, 100, 1), 1f).statusEffect(new StatusEffectInstance(StatusEffects.SPEED, 200, 3), 1f).meat().build()));
	public static final Item BONE_MARROW = new Item(new Item.Settings().group(ItemGroup.FOOD).food((new FoodComponent.Builder()).hunger(3).saturationModifier(4f).statusEffect(new StatusEffectInstance(StatusEffects.STRENGTH, 100, 1), 1f).meat().build()));
	public static final Item SLIME_MEAT = new Item(new Item.Settings().group(ItemGroup.FOOD).food((new FoodComponent.Builder()).hunger(6).saturationModifier(9f).statusEffect(new StatusEffectInstance(StatusEffects.JUMP_BOOST, 100, 3), 1f).meat().build()));
	public static final CreeperMeatItem CREEPER_MEAT = new CreeperMeatItem(new Item.Settings().group(ItemGroup.FOOD));
	public static final Item FLESH = new Item(new Item.Settings().group(ItemGroup.FOOD).food((new FoodComponent.Builder()).hunger(5).saturationModifier(10f).meat().build()));
	
	public static final Item BLOOD = new Item(new Item.Settings().group(ItemGroup.FOOD).food((new FoodComponent.Builder()).hunger(5).saturationModifier(10f).statusEffect(new StatusEffectInstance(StatusEffects.HEALTH_BOOST, 500, 1), 1f).alwaysEdible().build()));
	public static final Item ETERNAL_FLESH = new Item(new Item.Settings().group(ItemGroup.FOOD).food((new FoodComponent.Builder()).hunger(0).saturationModifier(15f).statusEffect(new StatusEffectInstance(StatusEffects.HEALTH_BOOST, 600000, 4), 1f).alwaysEdible().build()));
	
	public static void registerItems() {
		Registry.register(Registry.ITEM, new Identifier(MobMeat.MOD_ID, "blaze_meat"), BLAZE_MEAT);
		Registry.register(Registry.ITEM, new Identifier(MobMeat.MOD_ID, "ender_meat"), ENDER_MEAT);
		Registry.register(Registry.ITEM, new Identifier(MobMeat.MOD_ID, "elder_meat"), ELDER_MEAT);
		Registry.register(Registry.ITEM, new Identifier(MobMeat.MOD_ID, "ghast_meat"), GHAST_MEAT);
		Registry.register(Registry.ITEM, new Identifier(MobMeat.MOD_ID, "guardian_meat"), GUARDIAN_MEAT);
		Registry.register(Registry.ITEM, new Identifier(MobMeat.MOD_ID, "magma_meat"), MAGMA_MEAT);
		Registry.register(Registry.ITEM, new Identifier(MobMeat.MOD_ID, "ravager_meat"), RAVAGER_MEAT);
		Registry.register(Registry.ITEM, new Identifier(MobMeat.MOD_ID, "bone_marrow"), BONE_MARROW);
		Registry.register(Registry.ITEM, new Identifier(MobMeat.MOD_ID, "slime_meat"), SLIME_MEAT);
		Registry.register(Registry.ITEM, new Identifier(MobMeat.MOD_ID, "creeper_meat"), CREEPER_MEAT);
		
		Registry.register(Registry.ITEM, new Identifier(MobMeat.MOD_ID, "flesh"), FLESH);
		Registry.register(Registry.ITEM, new Identifier(MobMeat.MOD_ID, "blood"), BLOOD);
		Registry.register(Registry.ITEM, new Identifier(MobMeat.MOD_ID, "eternal_flesh"), ETERNAL_FLESH);
	}
}
