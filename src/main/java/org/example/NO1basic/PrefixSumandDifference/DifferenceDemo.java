package org.example.NO1basic.PrefixSumandDifference;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @Author Zang Xinrui
 * @Description TODO
 * @Date 2024/3/25 9:28
 * @Version 1.0
 */
public class DifferenceDemo {
    static int N =10010;
    static int[] array = new int[N];
    static int[] b = new int[N];
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        sc.nextLine();
        String[] s = sc.nextLine().split(" ");
        for(int i= 1;i<=s.length;i++){
            array[i] = Integer.parseInt(s[i-1]);
            differenceTest(i,i,array[i]);
        }
        int l,r,c;
        for(int i =1;i<=m;i++){
            String[] s1 = sc.nextLine().split(" ");
            l = Integer.parseInt(s1[0]);
            r = Integer.parseInt(s1[1]);
            c = Integer.parseInt(s1[2]);
            differenceTest(l,r,c);
        }
        for(int i=1;i<=n;i++){
            array[i] = array[i-1]+b[i];
        }
        for(int i =1;i<=n;i++){
            System.out.println(array[i]);
        }

    }
    static int[] differenceTest(int l,int r ,int c ){
        b[l] +=c;
        b[r+1] -=c;
        return b;
    }
}
