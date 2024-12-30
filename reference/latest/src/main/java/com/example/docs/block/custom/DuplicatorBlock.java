package com.example.docs.block.custom;

import com.example.docs.block.entity.ModBlockEntities;
import com.example.docs.block.entity.custom.DuplicatorBlockEntity;

import com.mojang.serialization.MapCodec;

import net.minecraft.block.BlockRenderType;
import net.minecraft.block.BlockState;
import net.minecraft.block.BlockWithEntity;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.block.entity.BlockEntityTicker;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Hand;
import net.minecraft.util.ItemActionResult;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.math.BlockPos;

import net.minecraft.world.World;

import org.jetbrains.annotations.Nullable;

// :::1
public class DuplicatorBlock extends BlockWithEntity {
	// :::1

	public DuplicatorBlock(Settings settings) {
		super(settings);
	}

	@Override
	protected MapCodec<? extends BlockWithEntity> getCodec() {
		return createCodec(DuplicatorBlock::new);
	}

	// :::1
	@Nullable
	@Override
	public BlockEntity createBlockEntity(BlockPos pos, BlockState state) {
		return new DuplicatorBlockEntity(pos, state);
	}

	// :::1

	@Override
	protected BlockRenderType getRenderType(BlockState state) {
		return BlockRenderType.MODEL;
	}

	// :::2
	@Override
	protected ItemActionResult onUseWithItem(ItemStack stack, BlockState state, World world, BlockPos pos, PlayerEntity player, Hand hand, BlockHitResult hit) {
		if (!(world.getBlockEntity(pos) instanceof DuplicatorBlockEntity duplicatorBlockEntity)) {
			return ItemActionResult.PASS_TO_DEFAULT_BLOCK_INTERACTION;
		}
		// :::2

		// :::3
		if (!duplicatorBlockEntity.canInsert(0, stack, hit.getSide())) {
			return ItemActionResult.PASS_TO_DEFAULT_BLOCK_INTERACTION;
		}
		// :::3

		// :::2
		if (!player.getStackInHand(hand).isEmpty() && duplicatorBlockEntity.isEmpty()) {
			duplicatorBlockEntity.setStack(0, player.getStackInHand(hand).copy());
			player.getStackInHand(hand).setCount(0);
		}

		return ItemActionResult.SUCCESS;
	}
	// :::2

	@Nullable
	@Override
	public <T extends BlockEntity> BlockEntityTicker<T> getTicker(World world, BlockState state, BlockEntityType<T> type) {
		return validateTicker(type, ModBlockEntities.DUPLICATOR_BLOCK_ENTITY, DuplicatorBlockEntity::tick);
	}

	// :::1
	// ...
}
// :::1