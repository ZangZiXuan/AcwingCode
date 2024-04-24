package org.example.NO2dataStructure.day3;

/**
 * @Author Zang Xinrui
 * @Description TODO
 * @Date 2024/3/30 10:41
 * @Version 1.0
 */

import java.util.Scanner;

public class HashMapDemozipper {

    static int N = 100003;
    static int[] h = new int[N];
    static int[] ne = new int[N];
    static int[] e = new int[N];
    static int idx;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        sc.nextLine();
        while(n-- > 0) {
            String[] s = sc.nextLine().split(" ");
            String op = s[0];
            int x = Integer.parseInt(s[1]);
            if (op.equals("I")) {
                insert(x);
            } else if(op.equals("Q")){
                if (find(x)) {
                    System.out.println("YES");
                } else {
                    System.out.println("NO");
                }
            }
        }
    }

    // Insert
    static private void insert(int x) {
        int k = (x % N + N) % N;
        e[idx] = x;
        ne[idx] = h[k];
        h[k] = idx++;
    }

    // Find
    static private boolean find(int x) {
        int k = (x % N + N) % N;
//        怎么表示到末尾了？
//        用这个i != ne[i]进行判断的时候,开头的第一个值不能为0
        for (int i = h[k]; i != ne[i]; i = ne[i]) {
            if (e[i] == x) {
                return true;
            }
        }
        return false;
    }
}
