package org.example.NO3SearchGraphtheory;

import java.util.Scanner;

/**
 * @Author Zang Xinrui
 * @Description TODO
 * @Date 2024/4/1 15:51
 * @Version 1.0
 */
public class DFS {
    static int N = 10;
    static int[] path = new int[N];
    static boolean[] st = new boolean[N];

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        dfs(0,n);
    }
    private static void dfs(int u,int n){
        if(u==n){
            for(int i =0;i<n;i++){
                System.out.print(path[i]);
                System.out.print(" ");
            }
            System.out.println();
        }

        if(u<n){
            for(int i = 1;i<=n;i++){
                if(!st[i]){
                    path[u] = i;
                    st[i] = true;
//                    回溯操作
                    dfs(u+1,n);
//                    恢复原样
                    st[i] = false;
                }
            }
        }
    }
}
//3
//1 2 3
//1 3 2
//2 1 3
//2 3 1
//3 1 2
//3 2 1
