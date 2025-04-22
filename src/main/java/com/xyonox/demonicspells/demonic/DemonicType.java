package com.xyonox.demonicspells.demonic;

public enum DemonicType {
    // Type Class One
    DEAR("dear"), WOLF("wolf"), OWL("owl"),
    // Type Class Two
    ONI("oni"), DRAGON("dragon"),
    // None
    NONE("none");

    private final String modelName;

    DemonicType(String modelName) {
        this.modelName = modelName;
    }

    public String getModelName() {
        return modelName;
    }
}
