package org.example;

import java.util.Scanner;

public class TwoCodingTest {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Input: ");
        String input = scanner.nextLine();
        processString(input);
    }

    public static void processString(String input) {
        String current = input;
        System.out.println("Input: " + current);

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

                // 如果连续长度>=3，则替换为前一个字母
                if (length >= 3) {
                    changed = true;
                    char replacementChar = (c == 'a') ? '\0' : (char)(c - 1);
                    String replacement = (replacementChar == '\0') ? "" : String.valueOf(replacementChar);
                    sb.append(replacement);

                    // 构建替换信息并输出
                    String replacedSegment = new String(new char[length]).replace('\0', c);
                    String replacementInfo = replacement.isEmpty() ? "nothing (removed)" : replacement;
                    System.out.println("-> " + sb.toString() + current.substring(i) +
                            ", " + replacedSegment + " is replaced by " + replacementInfo);
                } else {
                    sb.append(current.substring(start, i));
                }
            }
            current = sb.toString();
        } while (changed);

        // 如果没有进一步替换但仍有字符，输出最终结果
        if (!current.isEmpty()) {
            System.out.println("Final result: " + current);
        }
    }

}
