package org.example.NO1basic.bitOperation;

public class LowBit {
    public static void main(String[] args) {
        int x = 10; // 要检查的数
        // 调用方法找到最后一位1的位置
        int position = findLastSetBitPosition(x);
        // 输出结果
        System.out.println("最后一位1的位置是: " + position);
    }
//    找到最后一位1的位置的方法
//    这个！！！！！重要完全不知道这种方法
    public static int findLastSetBitPosition(int x) {
        // 如果x为0，则直接返回0
        if (x == 0) {
            return 0;
        }
        // 将x的二进制补码取反后加1
        int complement = ~x + 1;
        // 找到最后一位1的位置
        int position = 0;
        while ((complement & 1) == 0) {
            complement >>= 1; // 右移一位
            position++; // 位置加一
        }
        return position + 1; // 位置加一是因为我们从0开始计算位置，而题目从1开始计算位置
    }
}
