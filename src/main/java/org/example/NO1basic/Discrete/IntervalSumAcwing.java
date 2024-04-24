package org.example.NO1basic.Discrete;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;
import java.util.TreeMap;

/**
 * @Author Zang Xinrui
 * @Description TODO
 * @Date 2024/3/18 21:42
 * @Version 1.0
 */
public class IntervalSumAcwing {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt(); // 操作次数
        int m = scanner.nextInt(); // 询问次数
        int x =0,c=0;
        int[] array = new int[n];
        TreeMap<Integer, Integer> map = new TreeMap<>();
        for(int i =0;i<n;i++){
            int a = scanner.nextInt();
            array[i] = a;
        }
        for(int i = 0;i<m;i++){
            String[] s = scanner.nextLine().split(" ");
            x = Integer.parseInt(s[0]);
            c = Integer.parseInt(s [1]);
            map.put(x,c);
        }
        int[] res = new int[map.size()];
        for(int i =0;i<n;i++){
            map.get(x);
            res[i] = find(map.get(x),array);
        }
        System.out.println(Arrays.toString(res));

    }
    //    -------------Acwing官方做法---------------------(better)
//    数组排序、去重
//    找到x对应的离散化后的位置
    private static int find(int x,int[] array) {
        int l = 0,r = array.length - 1;
        while(l<r){
//            Java和C++中的含义是一样的，都是计算 l 和 r 的平均值，通常用于二分查找算法
//            相当于将 l + r 的结果 右移一位
            int mid = l + r >> 1 ;
            if(array[mid] >= x){
                r = mid;
            }else{
                l = mid + 1;
            }
        }
        return r + 1;
    }
}
