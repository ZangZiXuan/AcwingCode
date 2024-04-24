package org.example.NO2dataStructure.day2;

import java.util.Scanner;

public class ConnectedBlock {
    static int N = 100010;
    static int n,m;
    static int[] p = new int[N];
    static int[] size = new int[N];

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        sc.nextLine(); // 添加这一行来消费掉nextInt()后的换行符

        for(int i = 1; i <= n; i++){
            p[i] = i;
            size[i] = 1;
        }

        for(int i = 0; i < m; i++){
            String line = sc.nextLine(); // 读取整行输入
            String[] s = line.split(" ");
            int a, b;
            switch (s[0]) {
                case "C":
                    a = Integer.parseInt(s[1]);
                    b = Integer.parseInt(s[2]);
                    if(find(a) != find(b)){
                        size[find(b)] += size[find(a)];
                        p[find(a)] = find(b);
                    }
                    break;
                case "Q1":
                    a = Integer.parseInt(s[1]);
                    b = Integer.parseInt(s[2]);
                    System.out.println(find(a) == find(b) ? "YES" : "NO");
                    break;
                case "Q2":
                    a = Integer.parseInt(s[1]);
                    System.out.println(size[find(a)]);
                    break;
            }
        }
    }

    static int find(int x) {
        if(p[x] != x ){
            p[x] = find(p[x]);
        }
        return p[x];
    }
}
