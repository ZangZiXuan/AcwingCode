package org.example.NO2dataStructure.day3;

/**
 * @Author Zang Xinrui
 * @Description TODO
 * @Date 2024/3/31 20:44
 * @Version 1.0
 */


import java.util.Scanner;

public class HashMapString {
    static int N = 100010;
    static int P = 131;
    static char[] str = new char[N];

    static long[] h = new long[N];
    static long[] p = new long[N];

    public static void main(String[] args) {
        System.out.println("hello");
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        sc.nextLine(); // 读取并忽略行尾的换行符
        String input = sc.nextLine();
        str = input.toCharArray();

        p[0] = 1;
        for(int i = 1; i <= n; i++) {
            p[i] = p[i - 1] * P;
            h[i] = h[i - 1] * P + str[i - 1]; // 因为Java数组从0开始，所以这里是str[i-1]
        }
        while(m-- > 0) {
            int l1, r1, l2, r2;
            String[] s = sc.nextLine().split(" ");
            l1 = Integer.parseInt(s[0]);
            r1 = Integer.parseInt(s[1]);
            l2 = Integer.parseInt(s[2]);
            r2 = Integer.parseInt(s[3]);
            if(get(l1, r1) == get(l2, r2)) {
                System.out.println("YES");
            } else {
                System.out.println("NO");
            }
        }
    }

    static long get(int l, int r) {
        return h[r] - h[l - 1] * p[r - l + 1];
    }
}
