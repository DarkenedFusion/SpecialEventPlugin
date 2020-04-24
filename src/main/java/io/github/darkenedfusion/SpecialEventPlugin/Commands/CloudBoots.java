package io.github.darkenedfusion.SpecialEventPlugin.Commands;

import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.event.entity.ItemMergeEvent;
import org.bukkit.event.player.PlayerMoveEvent;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.ArrayList;
import java.util.List;

public class CloudBoots implements CommandExecutor {


    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        // Cloud Boots; detects if console uses the command and denies it!

        if(label.equalsIgnoreCase("cloudboots")){
            if (!(sender instanceof Player)){
                sender.sendMessage("Console can't do this!");
                return true;
            }
            Player player = (Player) sender;
            if (player.getInventory().firstEmpty() == -1){
                // inventory is full it drops item naturally in world
                Location loc = player.getLocation();
                World world = player.getWorld();

                world.dropItemNaturally(loc, getItem());

            }
            player.getInventory().addItem(getItem());
            return true;
        }
        return true;
    }

    public ItemStack getItem() {
        ItemStack boots = new ItemStack(Material.IRON_BOOTS);
        ItemMeta meta = boots.getItemMeta();

        meta.setDisplayName(ChatColor.WHITE + "" + ChatColor.BOLD + "Cloud Boots");
        List<String> lore = new ArrayList<String>();
        lore.add("");
        lore.add(ChatColor.GOLD + "Boots made of pure clouds!");
        meta.setLore(lore);

        meta.addEnchant(Enchantment.PROTECTION_FALL, 1, true);
        meta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
        meta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);

        boots.setItemMeta(meta);

        return boots;



    }









}