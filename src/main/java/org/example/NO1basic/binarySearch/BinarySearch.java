package org.example.NO1basic.binarySearch;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;



/**
 * @Author Zang Xinrui
 * @Description TODO
 * @Date 2024/3/14 15:16
 * @Version 1.0
 */
public class BinarySearch {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        String line = bf.readLine();
        String[] numbers = line.split(" ");
        // 创建一个整型数组来存储转换后的数值
        int[] array = new int[numbers.length];
        for (int i = 0; i < numbers.length; i++) {
            array[i] = Integer.parseInt(numbers[i]); // 将字符串转换为整数
        }
        String line1 = bf.readLine();
        int i = Integer.parseInt(line1);
        int a = binarySearch(array,i,0,array.length-1);
        System.out.println(a+1);
    }
    static int binarySearch(int[] array,int k,int left,int right){
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (array[mid] == k) {
                return mid;
            } else if (array[mid] < k) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return -1; // Element not found
    }
}
