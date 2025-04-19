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
//https://discord.com/channels/1129059589325852724/1129069842805301371/1362874847058989449
