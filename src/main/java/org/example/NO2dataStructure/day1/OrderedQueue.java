package org.example.NO2dataStructure.day1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Scanner;

/**
 * @Author Zang Xinrui
 * @Description TODO
 * @Date 2024/3/26 18:45
 * @Version 1.0
 */
//您只能在窗口中看到k个数字。每次滑动窗口向右移动一个位置。以下是一个例子:
//该数组为[13-1-35367]，k为3.
//    输入格式
//输入包含两行。
//第一行包含两个整数n和k，分别代表数组长度和滑动窗口的长度。
//第二行有n个整数，代表数组的具体数值。
//同行数据之间用空格隔开。

public class OrderedQueue {
    static int N = 1000010;
    static int[] a = new int[N];
    static int[] que = new int[N];
//    que队列中存的是原数组的下标
    static int n,k;
    public static void main(String[] args) throws IOException {

        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        String[] s = bf.readLine().split(" ");
        n = Integer.parseInt(s[0]);
        k = Integer.parseInt(s[1]);
        String[] s1 = bf.readLine().split(" ");
        for(int i = 0;i < n;i++){
            a[i] = Integer.parseInt(s1[i]);
        }
        //        ---------------------最小值----------------
//        定义队列头、尾指针
        int hh =0,tt=-1;
        for(int i =0;i<n;i++){
            //      判断队头是否滑出窗口
            if(hh <= tt && i-k+1 > que[hh]){
                hh++;
            }
        //  要不要进行队列尾部元素的删除
            while (hh<=tt && a[que[tt]]>=a[i]){
                tt--;
            }
            que[++tt] = i;
            if(i>=k-1){
                System.out.print(a[que[hh]]);
                System.out.print(" ");
            }
        }
        System.out.println();
//        ---------------------最大值----------------
        hh =0;
        tt=-1;
        for(int i =0;i<n;i++){
            //      判断队头是否滑出窗口
            if(hh <= tt && i-k+1 > que[hh]){
                hh++;
            }
            //  要不要进行队列尾部元素的删除
            while (hh<=tt && a[que[tt]]<=a[i]){
                tt--;
            }
            que[++tt] = i;
            if(i>=k-1){
                System.out.print(a[que[hh]]);
                System.out.print(" ");
            }
        }
    }
}
