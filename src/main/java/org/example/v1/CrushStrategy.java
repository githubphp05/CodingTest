package org.example.v1;

import java.util.function.Consumer;

public interface CrushStrategy {
    void process(String input, Consumer<String> outputConsumer);
}
