package dev.kugge.kaiimoji.watcher;

import dev.kugge.kaiimoji.Kaiimoji;

import org.bukkit.Location;
import org.bukkit.Particle;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerToggleSneakEvent;

import static java.lang.Math.cos;
import static java.lang.Math.sin;

public class SneakWatcher implements Listener {
    @EventHandler
    public void onPlayerSneakToggle(PlayerToggleSneakEvent event) {
        if (!event.isSneaking()) return; // Only when sneaking!
        Player player = event.getPlayer();
        // No kaiimoji when flying/sleeping!
        if (player.isFlying() || player.isSleeping() || player.isGliding()) return;
        Long time = Kaiimoji.sneakDuration.getOrDefault(player, null);
        Kaiimoji.sneakDuration.put(player, System.currentTimeMillis());

        if (time == null) return; // Ignore the first sneaking event
        if ((System.currentTimeMillis() - time) >= 500) return; // Ignore sneaking events with duration more than 500ms

        if (player.hasPermission("kaiimoji.heart")) {
            Location pos = player.getLocation().add(0, 2, 0);
            player.getWorld().spawnParticle(Particle.HEART, pos, 1, 0, 0, 0, 0, null, true);
        }
        if (player.hasPermission("kaiimoji.purple")) {
            Location pos = player.getLocation();
            player.getWorld().spawnParticle(Particle.SPELL_WITCH, pos, 70, 0, 0, 0, 0.15, null, true);
        }
        if (player.hasPermission("kaiimoji.boom")) {
            Location pos = player.getLocation().add(0, 1.2, 0);
            player.getWorld().spawnParticle(Particle.TOTEM, pos, 50, 0, 0, 0, 0.4, null, true);
        }
        if (player.hasPermission("kaiimoji.fire")) {
            Location pos = player.getLocation().add(0, 1, 0);
            player.getWorld().spawnParticle(Particle.FLAME, pos, 100, 0.1, 0.3, 0.1, 0.03, null, true);
        }
        if (player.hasPermission("kaiimoji.note")) {
            Location pos = player.getLocation().add(0, 2.2, 0);
            player.getWorld().spawnParticle(Particle.NOTE, pos, 1, 0, 0,0, 1, null, true);
        }
        if (player.hasPermission("kaiimoji.portal")) {
            Location pos = player.getLocation().add(0, 1, 0);
            player.getWorld().spawnParticle(Particle.PORTAL, pos, 150, 0, 0.1, 0, 0.8, null, true);
        }
        if (player.hasPermission("kaiimoji.sonic")) {
            Location pos = player.getLocation().add(0, 1, 0);
            player.getWorld().spawnParticle(Particle.SONIC_BOOM, pos, 1, 0, 0, 0, 1, null, true);
        }
        if (player.hasPermission("kaiimoji.enchant")) {
            Location pos;
            Location playerPos = player.getLocation().add(0, 2.3, 0);
            for (double i = 0; i < 2 * Math.PI; i += .1) {
                pos = playerPos.clone().add(cos(i), 0, sin(i));
                player.getWorld().spawnParticle(Particle.ENCHANTMENT_TABLE, pos, 2, 0, 0, 0, 0, null, true);
            }
        }
        if (player.hasPermission("kaiimoji.scrape")) {
            Location pos;
            Location playerPos = player.getLocation().add(0, 2.2, 0);
            for (double i = 0; i < 2 * Math.PI; i += .2) {
                pos = playerPos.clone().add(.4*cos(i), 0, .4*sin(i));
                player.getWorld().spawnParticle(Particle.SCRAPE, pos, 1, 0, 0, 0, 0, null, true);
            }
        }
        if (player.hasPermission("kaiimoji.sound.bit")) {
            Location pos = player.getLocation();
            float rd = new float[]{0.25f, 0.5f, 0.75f, 1f, 1.25f, 1.5f, 1.75f, 2f}[(int) (Math.random() * 8)];
            player.getWorld().playSound(pos, Sound.BLOCK_NOTE_BLOCK_BIT, 1, rd);
        }
        if (player.hasPermission("kaiimoji.sound.guitar")) {
            Location pos = player.getLocation();
            float rd = new float[]{0.25f, 0.5f, 0.75f, 1f, 1.25f, 1.5f, 1.75f, 2f}[(int) (Math.random() * 8)];
            player.getWorld().playSound(pos, Sound.BLOCK_NOTE_BLOCK_GUITAR, 1, rd);
        }
        if (player.hasPermission("kaiimoji.sound.bell")) {
            Location pos = player.getLocation();
            float rd = new float[]{0.25f, 0.5f, 0.75f, 1f, 1.25f, 1.5f, 1.75f, 2f}[(int) (Math.random() * 8)];
            player.getWorld().playSound(pos, Sound.BLOCK_NOTE_BLOCK_BELL, 1, rd);
        }
        if (player.hasPermission("kaiimoji.sound.flute")) {
            Location pos = player.getLocation();
            float rd = new float[]{0.25f, 0.5f, 0.75f, 1f, 1.25f, 1.5f, 1.75f, 2f}[(int) (Math.random() * 8)];
            player.getWorld().playSound(pos, Sound.BLOCK_NOTE_BLOCK_FLUTE, 1, rd);
        }
        if (player.hasPermission("kaiimoji.sound.didgeridoo")) {
            Location pos = player.getLocation();
            float rd = new float[]{0.25f, 0.5f, 0.75f, 1f, 1.25f, 1.5f, 1.75f, 2f}[(int) (Math.random() * 8)];
            player.getWorld().playSound(pos, Sound.BLOCK_NOTE_BLOCK_DIDGERIDOO, 1, rd);
        }
        if (player.hasPermission("kaiimoji.sound.snare")) {
            Location pos = player.getLocation();
            float rd = new float[]{0.25f, 0.5f, 0.75f, 1f, 1.25f, 1.5f, 1.75f, 2f}[(int) (Math.random() * 8)];
            player.getWorld().playSound(pos, Sound.BLOCK_NOTE_BLOCK_SNARE, 1, rd);
        }
    }
}
