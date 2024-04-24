package org.example.NO3SearchGraphtheory.course1;

import java.util.Scanner;

/**
 * @Author Zang Xinrui
 * @Description TODO
 * @Date 2024/4/24 13:55
 * @Version 1.0
 */
//Acwing
public class QuanPaiLie {
    static int N = 10;
    static int[] path = new int[N];
    static boolean[] st = new boolean[N];
    static int n;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        dfs(0);
    }
    static void dfs(int u){
        if(u == n){
            for(int i = 0;i<n;i++){
                System.out.print(path[i]+" ");
            }
            System.out.println();
            return;
        }
        for(int i = 1;i<=n;i++){
            if(!st[i]){
                path[u] = i;
                st[i] = true;
                dfs(u+1);
                st[i] = false;
            }
        }
    }
}
