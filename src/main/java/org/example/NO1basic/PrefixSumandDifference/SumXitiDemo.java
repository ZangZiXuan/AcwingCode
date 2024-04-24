package org.example.NO1basic.PrefixSumandDifference;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @Author Zang Xinrui
 * @Description TODO
 * @Date 2024/3/24 21:39
 * @Version 1.0
 */
public class SumXitiDemo {
    static int N =100010;
    static int[] array = new int[N];
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        sc.nextLine();
        for(int i =0;i<n;i++){
            array[i] = sc.nextInt();
        }
        int[] prefix = new int[N];
        for(int i =1;i<=n;i++){
            prefix[i] =prefix[i-1]+array[i-1];
        }
        int l = sc.nextInt();
        int r = sc.nextInt();

        if(l>=r){
            System.out.println(0);
        }else{
            System.out.println(prefix[r] - prefix[l-1]);
        }

    }
}
// 输入样例
//10
//1 12 5 6 2 3 3 5 7 8 1 2
//输出样例
//13
