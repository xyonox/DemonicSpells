package com.xyonox.demonicspells.demonic;

public enum DemonicType {
    DEAR("dear"), WOLF("wolf"), OWL("owl"),
    NONE("none");

    private final String modelName;

    DemonicType(String modelName) {
        this.modelName = modelName;
    }

    public String getModelName() {
        return modelName;
    }
}
