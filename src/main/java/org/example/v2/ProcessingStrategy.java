package org.example.v2;

import java.util.function.Consumer;

/**
 * Strategy Interface
 */
@FunctionalInterface
public interface ProcessingStrategy {
    StrategyResult processSegment(String current, int start, int end, Consumer<String> output);
}
