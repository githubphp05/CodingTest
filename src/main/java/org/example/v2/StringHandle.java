package org.example.v2;
import java.util.function.Consumer;
public class StringHandle {

    // Strategy 1: Delete consecutive characters directly
    private static final ProcessingStrategy REMOVE_STRATEGY = (current, start, end, output) -> {
        String newString = new StringBuilder(current).delete(start, end).toString();
        output.accept("-> " + newString);
        return new StrategyResult(newString, true);
    };

    // Strategy 2: Delete and then insert the previous character
    private static final ProcessingStrategy REPLACE_STRATEGY = (current, start, end, output) -> {
        StringBuilder sb = new StringBuilder(current);
        sb.delete(start, end);

        String replacement = (start > 0) ? String.valueOf(current.charAt(start - 1)) : "";
        if (!replacement.isEmpty()) {
            sb.insert(start, replacement);
        }

        String newString = sb.toString();
        String replacedSegment = current.substring(start, end);
        String replacementInfo = replacement.isEmpty() ? "nothing (removed)" : replacement;

        output.accept("-> " + newString + ", " + replacedSegment + " is replaced by " + replacementInfo);
        return new StrategyResult(newString, true);
    };

    // Main processing method
    public void process(String input, Consumer<String> output, int strategyType) {
        ProcessingStrategy strategy = (strategyType == 1) ? REMOVE_STRATEGY : REPLACE_STRATEGY;
        String current = input;
        output.accept("Input: " + current);
        boolean changed;

        do {
            changed = false;
            for (int i = 0; i < current.length(); ) {
                char c = current.charAt(i);
                int start = i;
                while (i < current.length() && current.charAt(i) == c) {
                    i++;
                }
                int length = i - start;

                if (length >= 3) {
                    StrategyResult result = strategy.processSegment(current, start, i, output);
                    current = result.newString();
                    changed = result.changed();
                    break; // Restart Scan
                }
            }
        } while (changed);
    }
}
