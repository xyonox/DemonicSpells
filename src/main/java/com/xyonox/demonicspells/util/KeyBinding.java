package com.xyonox.demonicspells.util;

import com.mojang.blaze3d.platform.InputConstants;
import com.xyonox.demonicspells.DemonicSpells;
import net.minecraft.client.KeyMapping;
import net.minecraftforge.client.settings.KeyConflictContext;
import org.lwjgl.glfw.GLFW;

public class KeyBinding {
    public static final String KEY_CATEGORY_TUTORIAL = "key.category."+ DemonicSpells.MOD_ID;
    public static final String KEY_TRANSFORM_S = "key."+ DemonicSpells.MOD_ID +".transform";

    public static final KeyMapping TRANSFORM_KEY = new KeyMapping(KEY_TRANSFORM_S, KeyConflictContext.IN_GAME,
            InputConstants.Type.KEYSYM, GLFW.GLFW_KEY_O, KEY_CATEGORY_TUTORIAL);
}