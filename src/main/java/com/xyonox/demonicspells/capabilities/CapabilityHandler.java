package com.xyonox.demonicspells.capabilities;

import com.xyonox.demonicspells.blackforce.IBlackForce;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.capabilities.CapabilityToken;

public class CapabilityHandler {
    public static final Capability<IBlackForce> BLACK_FORCE_CAPABILITY =
            net.minecraftforge.common.capabilities.CapabilityManager.get(new CapabilityToken<>() {});

}