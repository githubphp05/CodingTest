package org.example;

import java.util.function.Consumer;

public interface CrushStrategy {
    void process(String input, Consumer<String> outputConsumer);
}
