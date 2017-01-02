package com.vadimozarinskiy.Task3;

import java.util.Stack;

/**
 * Created by root on 29.12.16.
 */
public class ParserNumbers {
    public static void main(String[] args) {
        String input = "123_2*14ghfg003sad15/2dasdasd8.10";
        printNumbersFromString(input);
    }

    public static void printNumbersFromString(String str) {
        Stack<Integer> numbers = new Stack<>();

        for (int i = 0; i < str.length(); i++) {
            if (Character.isDigit(str.charAt(i))) {
                i = numberFromString(str, i, numbers);
                if (i < str.length() - 1)
                    i = mathOperations(str, i, numbers);
            }

        }
        for (Integer i :
                numbers) {
            System.out.println(i);
        }
        printMaxMin(numbers);
    }

    private static void printMaxMin(Stack<Integer> numbers) {
        int max = numbers.pop();
        int min = max;
        while (!numbers.empty()){
            int a = numbers.pop();
            if(max < a)
                max = a;
            if(min > a)
                min = a;
        }
        System.out.println("Max: " + max);
        System.out.println("Min: " + min);
    }

    public static int mathOperations(String str, int i, Stack<Integer> numbers) {
        switch (str.charAt(i)) {
            case '*':
                i++;
                if (Character.isDigit(str.charAt(i))) {
                    i = numberFromString(str, i, numbers);
                    numbers.push(numbers.pop() * numbers.pop());
                }
                break;
            case '/':
                i++;
                if (Character.isDigit(str.charAt(i))) {
                    i = numberFromString(str, i, numbers);
                    int a = numbers.pop();
                    int b = numbers.pop();
                    numbers.push(b / a);
                }
                break;
            case '+':
                i++;
                if (Character.isDigit(str.charAt(i))) {
                    i = numberFromString(str, i, numbers);
                    numbers.push(numbers.pop() + numbers.pop());
                }
                break;
            case '-':
                i++;
                if (Character.isDigit(str.charAt(i))) {
                    i = numberFromString(str, i, numbers);
                    int a = numbers.pop();
                    int b = numbers.pop();
                    numbers.push(b - a);
                }
                break;
        }
        return i;
    }

    public static int numberFromString(String str, int startIndex, Stack<Integer> stack) {
        int index = startIndex;
        StringBuilder sb = new StringBuilder();
        sb.append(str.charAt(startIndex));
        for (int i = startIndex + 1; i < str.length(); i++) {
            if (Character.isDigit(str.charAt(i))) {
                sb.append(str.charAt(i));
            } else {
                stack.push(Integer.parseInt(sb.toString()));
                return i;
            }
            index = i;
        }
        stack.push(Integer.parseInt(sb.toString()));
        return index;
    }
}
