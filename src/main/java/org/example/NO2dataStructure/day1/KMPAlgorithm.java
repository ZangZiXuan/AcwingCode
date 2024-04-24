package org.example.NO2dataStructure.day1;


import java.util.Arrays;
import java.util.Scanner;

public class KMPAlgorithm {
    static int N = 10010, M = 100010;
    static int n, m;
//    p 是长的那个数组
    static String[] p = new String[N];
//    s 是短的数组
    static String[] s = new String[M];
    static int[] next = new int[N];
//  kmp 算法习惯从 1 开始
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        sc.nextLine();
        String[] s1 = sc.nextLine().split(" ");
        for(int i = 1; i <= n; i++) {
            p[i] = s1[i - 1];
        }
        m = sc.nextInt();
        sc.nextLine();
        String[] s2 = sc.nextLine().split(" ");
        for(int i = 1; i <= m; i++) {
            s[i] = s2[i - 1];
        }
        //      移动位数 = 已匹配的字符数 - 对应的部分匹配值（最后一个匹配成功的字符对应的匹配值）

        // 求next过程
        for(int i = 2, j = 0; i <= n; i++) {
            while(j != 0 && !p[i].equals(p[j + 1])) {
                j = next[j];
            }
            if(p[i].equals(p[j + 1])) {
                j++;
            }
            next[i] = j;
        }

        // kmp匹配过程
        for(int i = 1, j = 0; i <= m; i++) {
            while(j != 0 && !s[i].equals(p[j + 1])) {
                j = next[j];
            }
            if(s[i].equals(p[j + 1])) {
                j++;
            }
            if(j == n) {
                // 匹配成功
                System.out.print(i - n + 1);
                System.out.print(" ");
                j = next[j];
            }
        }
    }
}

