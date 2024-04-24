package org.example.NO1basic.Discrete;

import java.util.*;

public class IntervalSum {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt(); // 操作次数
        int m = scanner.nextInt(); // 询问次数

        TreeMap<Integer, Integer> map = new TreeMap<>();
        for (int i = 0; i < n; i++) {
            int x = scanner.nextInt();
            int c = scanner.nextInt();
//      先将所有的值假定为1，+c
            map.put(x, map.getOrDefault(x, 0) + c);
        }
//      计算前缀和
        long[] prefixSum = new long[map.size() + 1];
        int index = 1;
        for (int value : map.values()) {
            prefixSum[index] = prefixSum[index - 1] + value;
            index++;
        }
        for (int i = 0; i < m; i++) {
            int l = scanner.nextInt();
            int r = scanner.nextInt();
            long sum = query(prefixSum, l, r);
            System.out.println(sum);
        }
    }
//  查询
    private static long query(long[] prefixSum, int l, int r) {
        // 在前缀和数组中查找左边界
        int leftIndex = Arrays.binarySearch(prefixSum, l);
        // 在前缀和数组中查找右边界
        int rightIndex = Arrays.binarySearch(prefixSum, r);
//  1.找到的情况下：如果key在数组中，则返回搜索值的索引
//  2.找不到的情况下：
//      返回的是 -(插入点索引) - 1
        // 如果 左边界小于0，表示 l 不在数组中，找到 l 应该插入的位置
        if (leftIndex < 0) {
            leftIndex = -leftIndex - 1;
        }
//  在这种情况下，
//  -rightIndex - 2 的操作将找到 r 应该插入的位置，
//  因为从 0 开始进行，
//  并且减去 2 是为了确保将右边界向左移动一位，
//  以确保右边界是在数组中 r 右侧的最近位置。

        // 如果 右边界小于 0 ，表示 r 不在数组中，找到 r 应该插入的位置并向左移动一位
        if (rightIndex < 0) {
            rightIndex = -rightIndex - 2;
        }
        // 返回区间和，计算右边界的前缀和减去左边界的前缀和
        return prefixSum[rightIndex + 1] - prefixSum[leftIndex];
    }
//    -------------Acwing官方做法---------------------(better)
//    数组排序、去重
//    找到x对应的离散化后的位置
    private static int find(int x,int[] array) {
        int l=0,r= array.length - 1;
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
