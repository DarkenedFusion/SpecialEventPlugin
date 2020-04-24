package io.github.darkenedfusion.SpecialEventPlugin.Listeners;

import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.event.player.PlayerMoveEvent;

public class bootListener implements Listener {

    @EventHandler
    public void onJump(PlayerMoveEvent event){
        Player player = event.getPlayer();

        // First line cancels the onJump effect if player isn't wearing boots
        // Second line detects if the boots their wearing are named Cloud Boots
        // Third line detects if players Cloud Boots have the same lore as the actual ones
        // Fourth and Fifth line detects if the player is jumping from a block
        if (player.getInventory().getBoots() != null)
            if (player.getInventory().getBoots().getItemMeta().getDisplayName().contains("Cloud Boots"))
                if (player.getInventory().getBoots().getItemMeta().hasLore())
                    if (event.getFrom().getY() < event.getTo().getY() &&
                    player.getLocation().subtract(0, 1, 0).getBlock().getType() != Material.AIR) {
                        player.setVelocity(player.getLocation().getDirection().multiply(2).setY(2));

                    }


    }

    @EventHandler
    public void onFall(EntityDamageEvent event) {
        if (event.getEntity() instanceof Player){
            Player player = (Player) event.getEntity();
            if (event.getCause() == EntityDamageEvent.DamageCause.FALL){
                if (player.getInventory().getBoots() != null)
                    if (player.getInventory().getBoots().getItemMeta().getDisplayName().contains("Cloud Boots"))
                        if (player.getInventory().getBoots().getItemMeta().hasLore()) {
                            event.setCancelled(true);
                        }
            }
        }
    }








}
