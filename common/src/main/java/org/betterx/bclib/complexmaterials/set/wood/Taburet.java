package org.betterx.bclib.complexmaterials.set.wood;

import org.betterx.bclib.complexmaterials.ComplexMaterial;
import org.betterx.bclib.complexmaterials.WoodenComplexMaterial;
import org.betterx.bclib.complexmaterials.entry.BlockEntry;
import org.betterx.bclib.complexmaterials.entry.SimpleMaterialSlot;
import org.betterx.bclib.furniture.block.BaseTaburet;
import org.betterx.bclib.recipes.BCLRecipeBuilder;

import net.minecraft.data.recipes.RecipeCategory;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.BlockTags;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockBehaviour;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public class Taburet extends SimpleMaterialSlot<WoodenComplexMaterial> {
    public Taburet() {
        super("taburet");
    }

    public static void makeTaburetRecipe(ResourceLocation id, Block taburet, Block planks) {
        BCLRecipeBuilder.crafting(id, taburet)
                        .setShape("##", "II")
                        .addMaterial('#', planks)
                        .addMaterial('I', Items.STICK)
                        .setGroup("taburet")
                        .setCategory(RecipeCategory.DECORATIONS)
                        .build();
    }

    @Override
    protected void modifyBlockEntry(WoodenComplexMaterial parentMaterial, @NotNull BlockEntry entry) {
        entry.setBlockTags(BlockTags.MINEABLE_WITH_AXE);
    }

    @Override
    protected @NotNull Block createBlock(
            WoodenComplexMaterial parentMaterial, BlockBehaviour.Properties settings
    ) {
        return new BaseTaburet.Wood(parentMaterial.getBlock(WoodSlots.SLAB));
    }

    @Override
    protected @Nullable void makeRecipe(ComplexMaterial parentMaterial, ResourceLocation id) {
        Taburet.makeTaburetRecipe(id, parentMaterial.getBlock(suffix), parentMaterial.getBlock(WoodSlots.SLAB));
    }
}
