package dev.hnweiland.minecraftutils;

import org.bukkit.Color;
import org.bukkit.DyeColor;
import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.inventory.meta.LeatherArmorMeta;
import org.bukkit.inventory.meta.SkullMeta;

import java.util.ArrayList;
import java.util.List;

/*
06.06.2022 / Mo.
@Project: MinecraftUtils 
@Author: Niklas, (NlKLAS#0001)...
*/
public class ItemBuilder {

	ItemStack itemStack;
	/**
	 * Create a new ItemBuilder
	 *
	 * @param material Material for itemStack
	 */
	public ItemBuilder(Material material) {
		itemStack = new ItemStack(material, 1);

	}

	/**
	 * Create ItemBuilder on an already existing ItemStack
	 * @param stack new itemStack
	 */
	public ItemBuilder(ItemStack stack){
		itemStack = stack;
	}
	/**
	 * Create a new ItemBuilder
	 *
	 * @param material Material for itemStack
	 * @param amount   amount of itemStack
	 */
	public ItemBuilder(Material material, int amount) {
		itemStack = new ItemStack(material, amount);
	}

	/**
	 * Set the name of the ItemStack
	 *
	 * @param name Name of the ItemStack
	 */
	public ItemBuilder setDisplayName(String name) {
		ItemMeta itemMeta = itemStack.getItemMeta();
		itemMeta.setDisplayName(name);
		itemStack.setItemMeta(itemMeta);

		return this;
	}

	/**
	 * Set the lore of the ItemStack
	 *
	 * @param lore The lore of the ItemStack
	 */
	public ItemBuilder setLore(List<String> lore) {
		ItemMeta itemMeta = itemStack.getItemMeta();
		itemMeta.setLore(lore);
		itemStack.setItemMeta(itemMeta);
		return this;
	}

	/**
	 * Set the Skull Owner of ItemStack, throws big Error when Material is not a skull
	 * @param playerName SkullOwner
	 */
	public ItemBuilder setOwner(String playerName){
		SkullMeta skullMeta = (SkullMeta)itemStack.getItemMeta();
		skullMeta.setOwner(playerName);
		itemStack.setItemMeta(skullMeta);
		return this;
	}

	/**
	 * Add a lore to the ItemStack
	 * @param lore lore to be added
	 */
	public ItemBuilder addLore(String lore) {
		ItemMeta itemMeta = itemStack.getItemMeta();
		List<String> currentLores = itemMeta.getLore() == null ? new ArrayList<>() : itemMeta.getLore();
		currentLores.add(lore);
		itemMeta.setLore(currentLores);
		itemStack.setItemMeta(itemMeta);
		return this;
	}

	/**
	 * Set the Amount of the ItemStack
	 *
	 * @param amount The amount of the ItemStack
	 */
	public ItemBuilder setAmount(int amount) {
		itemStack.setAmount(amount);
		return this;
	}

	/**
	 * Change DyeColor
	 * @param dyeColor set DyeColor to ItemStack by Durability
	 */
	public ItemBuilder setColor(DyeColor dyeColor){
		itemStack.setDurability(dyeColor.getDyeData());
		return this;
	}

	/**
	 * Add an Enchantment to the ItemStack
	 * @param enchantment enchantment
	 * @param level level of the Enchantment
	 */
	public ItemBuilder addEnchantment(Enchantment enchantment, int level){
		ItemMeta itemMeta = itemStack.getItemMeta();
		itemMeta.addEnchant(enchantment, level, true);
		itemStack.setItemMeta(itemMeta);
		return this;
	}

	/**
	 * Set Infinity Durability or not.
	 * @param maxDurability boolean to set or not
	 */
	public ItemBuilder setInfinityDurability(boolean maxDurability) {
		itemStack.setDurability(maxDurability ? Short.MAX_VALUE : 0);
		return this;
	}

	/**
	 * Set Leather Armor Color
	 * @param color Color of the Armor
	 */
	public ItemBuilder setLeatherColor(Color color) {
		LeatherArmorMeta leatherArmorMeta = (LeatherArmorMeta) itemStack.getItemMeta();
		leatherArmorMeta.setColor(color);
		itemStack.setItemMeta(leatherArmorMeta);

		return this;
	}

	/**
	 * Create the Item Stack
	 *
	 * @return itemStack
	 */
	public ItemStack getItemStack() {
		return itemStack;
	}

	/**
	 * Get the ItemMeta of the ItemStack
	 * @return ItemMeta of itemStack
	 */
	public ItemMeta getItemMeta() {
		return itemStack.getItemMeta();
	}

	/**
	 * set the ItemMeta of itemStack
	 * @param itemMeta new ItemMeta
	 */
	public ItemBuilder setItemMeta(ItemMeta itemMeta) {
		itemStack.setItemMeta(itemMeta);
		return this;
	}
}
