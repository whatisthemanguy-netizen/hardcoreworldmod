package com.example.hardcoreworldmod;

import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.event.lifecycle.v1.ServerLifecycleEvents;
import net.minecraft.server.MinecraftServer;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.world.Difficulty;
import net.minecraft.world.border.WorldBorder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Forces every world on the server into a small, brutal survival experience:
 * Hard difficulty (locked so it can't be changed back in-game) and a
 * 2500x2500 world border centered on spawn.
 */
public class HardcoreWorldMod implements ModInitializer {
    public static final String MOD_ID = "hardcoreworldmod";
    public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

    // Border is specified as a full side length, so half-width extends 1250
    // blocks in each direction from the center.
    private static final double BORDER_SIZE = 2500.0;
    private static final double BORDER_CENTER_X = 0.0;
    private static final double BORDER_CENTER_Z = 0.0;

    @Override
    public void onInitialize() {
        ServerLifecycleEvents.SERVER_STARTED.register(this::applyHardcoreSettings);
    }

    private void applyHardcoreSettings(MinecraftServer server) {
        server.setDifficulty(Difficulty.HARD, true);
        server.setDifficultyLocked(true);

        for (ServerWorld world : server.getWorlds()) {
            WorldBorder border = world.getWorldBorder();
            border.setCenter(BORDER_CENTER_X, BORDER_CENTER_Z);
            border.setSize(BORDER_SIZE);
        }

        LOGGER.info("[{}] Applied hardcore settings: difficulty locked to HARD, world border set to {}x{} blocks centered at ({}, {}).",
                MOD_ID, BORDER_SIZE, BORDER_SIZE, BORDER_CENTER_X, BORDER_CENTER_Z);
    }
}
