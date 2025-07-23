package org.example;


import java.util.function.Consumer;

public interface StringProcessor {
    void process(String input, Consumer<String> output);
}
