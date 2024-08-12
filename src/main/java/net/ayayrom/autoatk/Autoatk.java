package net.ayayrom.autoatk;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.fabricmc.fabric.api.client.event.lifecycle.v1.ClientTickEvents;
import net.minecraft.util.Hand;

@Environment(value = EnvType.CLIENT)

public class Autoatk implements ClientModInitializer {
    // This logger is used to write text to the console and the log file.
    // It is considered best practice to use your mod id as the logger's name.
    // That way, it's clear which mod wrote info, warnings, and errors.
    public static final String MOD_ID = "autoatk";
    public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

    @Override
    public void onInitializeClient() {
        ClientTickEvents.END_CLIENT_TICK.register(client -> {
            if (client.options.attackKey.isPressed() &&
                    client.player != null &&
                    client.player.getAttackCooldownProgress(0.0f) >= 1.0f &&
                    !client.player.isUsingItem()) {
                client.player.swingHand(Hand.MAIN_HAND);
                client.player.resetLastAttackedTicks();
            }
        });
        LOGGER.info("autoatkatkatktk");
    }
}