package com.ejs.mobmeater.registry;

import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.damage.DamageSource;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.Hand;
import net.minecraft.util.TypedActionResult;
import net.minecraft.util.UseAction;
import net.minecraft.world.World;
import net.minecraft.world.explosion.Explosion;

public class CreeperMeatItem extends Item {

	public CreeperMeatItem(Item.Settings settings) {
		super(settings);
	}
	
	public TypedActionResult<ItemStack> use(World world, PlayerEntity user, Hand hand) {
		ItemStack itemStack = user.getStackInHand(hand);
		user.setCurrentHand(hand);
		if (!(world instanceof ServerWorld)) {
			return TypedActionResult.success(itemStack);
		} else {
			if (!world.isClient) {
					user.world.createExplosion(user, user.getX(), user.getY(), user.getZ(), 4.0F, Explosion.DestructionType.BREAK);
					user.onDeath(DamageSource.explosion(user));
					user.setHealth(0);
				//	user.kill();
					world.playSoundFromEntity(user, user, SoundEvents.ENTITY_TNT_PRIMED, SoundCategory.BLOCKS, 1.0F, 1.0F);
			}
			return TypedActionResult.consume(itemStack);
		}
	}

	public ItemStack finishUsing(ItemStack stack, World world, LivingEntity user) {
		return user.eatFood(world, stack);
	}

	public UseAction getUseAction(ItemStack stack) {
		return UseAction.EAT;
	}
}
