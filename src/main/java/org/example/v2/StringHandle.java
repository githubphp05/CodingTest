package org.example.v2;
import java.util.function.Consumer;
public class StringHandle {

    // 定义策略结果记录类
    private static class StrategyResult {
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

    // 策略接口
    @FunctionalInterface
    private interface ProcessingStrategy {
        StrategyResult processSegment(String current, int start, int end, Consumer<String> output);
    }


    // 策略1: 直接删除连续字符
    private static final ProcessingStrategy REMOVE_STRATEGY = (current, start, end, output) -> {
        String newString = new StringBuilder(current).delete(start, end).toString();
        output.accept("-> " + newString);
        return new StrategyResult(newString, true);
    };

    // 策略2: 删除后插入前一个字符
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

    // 主处理方法
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
                    break; // 重新开始扫描
                }
            }
        } while (changed);
    }
}
