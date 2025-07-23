package org.example.v1;

import java.util.function.Consumer;

public class IterativeStringProcessor implements StringProcessor {

    @Override
    public void process(String input, Consumer<String> output) {
        String current = input;
        output.accept("Input: " + current);
        boolean changed;

        do {
            changed = false;
            StringBuilder sb = new StringBuilder();

            for (int i = 0; i < current.length();) {
                char c = current.charAt(i);
                int start = i;

                // 计算连续相同字符的长度
                while (i < current.length() && current.charAt(i) == c) {
                    i++;
                }
                int length = i - start;

                // 处理连续字符
                if (length >= 3) {
                    changed = true;
                    String replacement = start== 0 ? "" : String.valueOf(current.charAt(start-1));
                    sb.append(replacement);

                    // 构建替换信息
                    String replacedSegment = new String(new char[length]).replace('\0', c);
                    String replacementInfo = replacement.isEmpty() ? "nothing (removed)" : replacement;
                    String newState = sb.toString() + current.substring(i);
                    output.accept("-> " + newState + ", " + replacedSegment + " is replaced by " + replacementInfo);

                    current = newState;
                    break; // 重新开始扫描
                } else {
                    sb.append(current, start, i);
                }
            }

            if (!changed) {
                current = sb.toString();
            }
        } while (changed);

    }

}
