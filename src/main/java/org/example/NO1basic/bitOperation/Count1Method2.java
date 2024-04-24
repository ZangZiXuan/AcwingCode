package org.example.NO1basic.bitOperation;

import java.util.Scanner;

/**
 * @Author Zang Xinrui
 * @Description TODO
 * @Date 2024/3/18 10:13
 * @Version 1.0
 */
public class Count1Method2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] array = new int[n];
        for (int i = 0; i < n; i++) {
            int x = sc.nextInt();
            array[i] = x;
        }
        for (int i = 0; i < n; i++) {
            int result = 0; // 重置结果值
            while (array[i] > 0) {
                array[i] -= lowbit(array[i]);
                result++;
            }
            System.out.println(result); // 打印最终结果
        }
    }
    private static int lowbit(int x) {
        return x & -x; // 修正low bit方法实现
    }
}
