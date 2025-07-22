package org.example;
import org.junit.Test;

import java.util.Scanner;

public class OneCodingTest {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Input: ");
        String input = scanner.nextLine();
        processString(input);
    }

    public static void processString(String input) {
        String s = input;
        System.out.println("Input: " + s);
        boolean changed;

        do {
            changed = false;
            for (int i = 0; i < s.length(); ) {
                char current = s.charAt(i);
                int j = i;
                while (j < s.length() && s.charAt(j) == current) {
                    j++;
                }
                int length = j - i;
                if (length >= 3) {
                    s = s.substring(0, i) + s.substring(j);
                    changed = true;
                    System.out.println("-> " + s);
                    break;
                } else {
                    i = j;
                }
            }
        } while (changed);
    }
}
