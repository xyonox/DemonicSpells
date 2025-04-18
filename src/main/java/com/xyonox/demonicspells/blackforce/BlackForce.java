package com.xyonox.demonicspells.blackforce;

import com.xyonox.demonicspells.demonic.DemonicType;

// BlackForce.java
public class BlackForce implements IBlackForce {
    private int current = 100;
    private int max = 100;
    private DemonicType currentType = DemonicType.NONE;
    private boolean transformed = false;

    @Override
    public int getCurrent() { return current; }

    @Override
    public int getMax() { return max; }

    @Override
    public void setCurrent(int value) { current = Math.min(value, max); }

    @Override
    public void setMax(int value) { max = value; }

    @Override
    public void add(int value) {
        current = Math.min(current + value, max);
    }

    public void subtract(int value) {
        current = Math.max(current - value, 0);
    }

    @Override
    public DemonicType getType() {
        return this.currentType;
    }

    @Override
    public void setType(DemonicType type) {
        this.currentType = type;
    }

    @Override
    public boolean isTransformed() {
        return this.transformed;
    }

    @Override
    public void setTransformed(boolean transformed) {
        this.transformed = transformed;
    }
}
