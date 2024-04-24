package org.example.NO1basic.bitOperation;

import java.util.Scanner;

/**
 * @Author Zang Xinrui
 * @Description TODO
 * @Date 2024/3/18 8:55
 * @Version 1.0
 */
public class Pickn {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int decimalNumber = scanner.nextInt(); // 要转换的十进制数
        // 调用方法进行转换
        String binaryNumber = decimalToBinary(decimalNumber);
        char[] chars = binaryNumber.toCharArray();
        for(int i = 0;i<binaryNumber.length();i++){
            System.out.print(chars[i]);
        }
    }

    // 将十进制数转换为二进制数的方法
    public static String decimalToBinary(int decimalNumber) {
        // 如果是0直接返回0
        if (decimalNumber == 0) {
            return "0";
        }
        StringBuilder binary = new StringBuilder();
        // 不断地取模并存储余数直到商为0
        while (decimalNumber > 0) {
            int remainder = decimalNumber % 2; // 取余数
            binary.insert(0, remainder); // 在二进制数的最前面插入余数
            decimalNumber = decimalNumber / 2; // 更新商
        }
        return binary.toString(); // 返回转换后的二进制数
    }
}
