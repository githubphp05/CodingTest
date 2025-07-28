package org.example.v2;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import static org.junit.jupiter.api.Assertions.assertEquals;
public class StringProcessorTest {
    @Test
    void testRemoveStrategy() {
        StringHandle processor = new StringHandle();
        List<String> outputLines = new ArrayList<>();

        // Test 1: Empty string
        List<String> output1 = new ArrayList<>();
        processor.process("", output1::add, 1);
        assertEquals(Collections.singletonList("Input: "), output1);

        // Test 2: Single character
        List<String> output2 = new ArrayList<>();
        processor.process("a", output2::add, 1);
        assertEquals(Collections.singletonList("Input: a"), output2);

        // Test 3: Two characters
        List<String> output3 = new ArrayList<>();
        processor.process("aa", output3::add, 1);
        assertEquals(Collections.singletonList("Input: aa"), output3);

        // Test 4: Exactly 3 characters (should be removed)
        List<String> output4 = new ArrayList<>();
        processor.process("aaa", output4::add, 1);
        assertEquals(Arrays.asList("Input: aaa", "-> "), output4);

        // Test 5: Exactly 3 characters (should be removed)
        processor.process("aabcccbbad", s -> {
            outputLines.add(s);
            System.out.println(s);
        }, 1);


    }

    @Test
    void testReplaceStrategy() {
        StringHandle processor = new StringHandle();
        List<String> outputLines = new ArrayList<>();
        // Test 1: Empty string
        List<String> output1 = new ArrayList<>();
        processor.process("", output1::add, 2);
        assertEquals(Collections.singletonList("Input: "), output1);

        // Test 2: Exactly 3 characters (should be replaced)
        List<String> output3 = new ArrayList<>();
        processor.process("ccc", output3::add, 2);
        assertEquals(Arrays.asList(
                "Input: ccc",
                "-> , ccc is replaced by nothing (removed)"
        ), output3);

        processor.process("abcccbad", s -> {
            outputLines.add(s);
            System.out.println(s);
        }, 2);
    }
}
