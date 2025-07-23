package org.example;
import org.junit.jupiter.api.Test;
import java.util.function.Consumer;
public class StringProcessorTwoTest {

    @Test
    public void testTwoProcess() {
        // 准备测试数据
        StringBuilder output = new StringBuilder();
        Consumer<String> outputConsumer = s -> output.append(s).append("\n");

        // 创建处理器
        StringProcessor processor = new IterativeStringProcessor();

        // 执行处理
        processor.process("abvvvbad", outputConsumer);
        // 处理完成后打印收集的所有内容
        System.out.println(output.toString());
    }

}
