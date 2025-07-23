需求:
1. 结构良好的 Maven 项目
2. 适当的单元测试，具有较高的测试覆盖率
3. 考虑采用适当的设计模式
5. 使用 Java8 或更高版本的一些新功能

# 题目1：

      For a given string that only contains alphabet characters a-z, if 3 or more consecutive
      characters are identical, remove them from the string. Repeat this process until
      there is no more than 3 identical characters sitting besides each other.
      Example:
      Input: aabcccbbad
      Output:
      -> aabbbad
      -> aaad
      -> d

StringProcessorOneTest.testOneProcess #题目一解法


#题目二
    Instead of removing the consecutively identical characters, replace them with a
    single character that comes before it alphabetically.
    Example:
    ccc -> b
    bbb -> a
    Input: abcccbad
    Output:
    -> abbbad, ccc is replaced by b
    -> aaad, bbb is replaced by a
    -> d
    
 StringProcessorTwoTest.testTwoProcess #题目二解法