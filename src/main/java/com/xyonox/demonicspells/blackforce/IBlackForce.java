package com.xyonox.demonicspells.blackforce;

import com.xyonox.demonicspells.demonic.DemonicType;

public interface IBlackForce {
    int getCurrent();
    int getMax();
    void setCurrent(int value);
    void setMax(int value);
    void add(int value);
    void subtract(int value);
    DemonicType getType();
    void setType(DemonicType type);
    boolean isTransformed();
    void setTransformed(boolean transformed);
}
