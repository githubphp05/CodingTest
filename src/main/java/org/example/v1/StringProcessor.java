package org.example.v1;


import java.util.function.Consumer;

public interface StringProcessor {
    void process(String input, Consumer<String> output);
}
