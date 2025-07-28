package org.example.v2;

public class StrategyResult {
    private final String newString;
    private final boolean changed;

    public StrategyResult(String newString, boolean changed) {
        this.newString = newString;
        this.changed = changed;
    }

    public String newString() {
        return newString;
    }

    public boolean changed() {
        return changed;
    }
}
