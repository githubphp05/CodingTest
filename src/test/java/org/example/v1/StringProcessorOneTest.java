package org.example.v1;

import org.example.v1.CrushStrategy;
import org.example.v1.IterativeCrushStrategy;
import org.junit.jupiter.api.Test;

import java.util.function.Consumer;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class StringProcessorOneTest {

    @Test
    public void testOneProcess() {
        // 准备测试数据
        StringBuilder output = new StringBuilder();
        Consumer<String> outputConsumer = s -> output.append(s).append("\n");

        // 创建处理器
        CrushStrategy crushStrategy = new IterativeCrushStrategy();

        // 执行处理
        crushStrategy.process("abcccbad", outputConsumer);
        // 处理完成后打印收集的所有内容
        System.out.println(output.toString());
    }
}
