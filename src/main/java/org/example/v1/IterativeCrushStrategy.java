package org.example.v1;

import java.util.function.Consumer;

public class IterativeCrushStrategy implements CrushStrategy {

    @Override
    public void process(String input, Consumer<String> outputConsumer) {
        String s = input;
        outputConsumer.accept("Input: " + s);
        boolean changed;

        do {
            changed = false;
            for (int i = 0; i < s.length(); ) {
                char current = s.charAt(i);

                // 使用流式计算连续字符长度
                int end = i;
                while (end < s.length() && s.charAt(end) == current) {
                    end++;
                }

                int length = end - i;
                if (length >= 3) {
                    // 使用函数式方式构建新字符串
                    s = new StringBuilder(s)
                            .delete(i, end)
                            .toString();

                    changed = true;
                    outputConsumer.accept("-> " + s);
                    break;
                } else {
                    i = end;
                }
            }
        } while (changed);
    }

}
