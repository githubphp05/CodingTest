package org.example.v2;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

public class StringProcessorTest {
    @Test
    void testRemoveStrategy() {
        StringHandle processor = new StringHandle();
        List<String> outputLines = new ArrayList<>();

        // 执行策略1 (直接删除)
        processor.process("aabcccbbad", s -> {
            outputLines.add(s);
            System.out.println(s);
        }, 1);
        System.out.println(outputLines.toString());

    }

    @Test
    void testReplaceStrategy() {
        StringHandle processor = new StringHandle();
        List<String> outputLines = new ArrayList<>();

        // 执行策略2 (替换前一个字符)
        processor.process("abcccbad", s -> {
            outputLines.add(s);
            System.out.println(s);
        }, 2);
    }
}
