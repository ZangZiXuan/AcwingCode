package org.example.NO3SearchGraphtheory;

import java.util.Arrays;
import java.util.Scanner;

public class EightQueen {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        char[][] g = new char[n][n]; // 根据输入的棋盘大小创建棋盘数组
        for (int i = 0; i < n; i++) {
            Arrays.fill(g[i], '.');
        }
        boolean[] row = new boolean[n]; //行
        boolean[] col = new boolean[n]; //列
        boolean[] dg = new boolean[2 * n]; // 正对角线的个数是 2*n-1
        boolean[] udg = new boolean[2 * n]; // 反对角线的个数是 2*n-1

        dfs2(n,g,0,0,0,row,col,dg,udg);
    }
    //    method2:
    private static void dfs2(int n, char[][] g,int x,int y,int s,boolean[] row,boolean[] col, boolean[] dg, boolean[] udg) {
        if(y==n){
            y = 0;
            x++;
        }
        if(x == n){
            if(s==n){
                for(int i =0;i<n;i++){
                    System.out.println(g[i]);
                }
                System.out.println();
            }
            return; // Add return statement here to terminate the recursion
        }

//  不放皇后
        dfs2(n,g,x,y+1,s,row,col,dg,udg);
//  放皇后
        if(!row[x] && !col[y] && !dg[x+y] && !udg[x-y+n]){
            g[x][y] = 'Q';
            row[x] = col[y] =dg[x+y] = udg[x-y+n] = true;
            dfs2(n,g,x,y+1,s+1,row,col,dg,udg);
            row[x] = col[y] =dg[x+y] = udg[x-y+n] = false;
            g[x][y] = '.';
        }
    }
//  method1:
    private static void dfs(int u, int n, char[][] g, boolean[] col, boolean[] dg, boolean[] udg) {
        if (u == n) {
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    System.out.print(g[i][j] == 0 ? '.' : g[i][j]);
                }
                System.out.println(); // 每行结束后换行
            }
            System.out.println();
            return;
        }

        for (int i = 0; i < n; i++) {
// !col[i]: 表示第 i 列没有放置皇后。在八皇后问题中，皇后不能在同一列中，所以这个条件用于确保当前列没有放置皇后。
//
//!dg[u + i]: 表示正对角线上没有放置皇后。在八皇后问题中，皇后不能在同一条正对角线上，所以这个条件用于确保当前位置的正对角线上没有放置皇后。
//
//!udg[n - u + i]: 表示反对角线上没有放置皇后。在八皇后问题中，皇后不能在同一条反对角线上，所以这个条件用于确保当前位置的反对角线上没有放置皇后。
            if (!col[i] && !dg[u + i] && !udg[n - u + i]) {
                g[u][i] = 'Q';
                col[i] = dg[u + i] = udg[n - u + i] = true;
                dfs(u + 1, n, g, col, dg, udg);
//          将元素恢复为默认值，以便下一次遍历使用
                col[i] = dg[u + i] = udg[n - u + i] = false;
                g[u][i] = 0;
            }
        }
    }


}
