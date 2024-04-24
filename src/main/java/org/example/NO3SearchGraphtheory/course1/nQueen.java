package org.example.NO3SearchGraphtheory.course1;

import java.util.Scanner;

/**
 * @Author Zang Xinrui
 * @Description TODO
 * @Date 2024/4/24 13:29
 * @Version 1.0
 */
public class nQueen {

    static int N = 20;
    static int n;
    static char[][] g = new char[N][N];
    static boolean[] col =  new boolean[N];
    static boolean[] dg =  new boolean[N];
    static boolean[] udg =  new boolean[N];
//    方法2
    static boolean[] row =  new boolean[N];

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        for(int i = 0; i < n; i++){
            for(int j = 0; j < n ;j++){
                g[i][j] =  '`'; // 设置默认值
            }
        }
        dfs(0,0,0);
    }
    static void dfs(int u){
        if(u == n){
            for(int i = 0; i < n; i++){
                for(int j = 0; j < n;j++){
                    if(!String.valueOf(g[i][j]).equals("")){
                        System.out.print(g[i][j]);
                        System.out.print(" ");
                    }
                }
                System.out.println();
            }
            return;
        }
        for(int i = 0; i < n; i++){
            if(!col[i] && !dg[u + i] && !udg[n - u + i]){
                g[u][i] = 'Q';
                col[i] = dg[u + i] = udg[n - u + i] = true;
                dfs(u+1);
                col[i] = dg[u + i] = udg[n - u + i] = false;
                g[u][i] = '`';
            }
        }
    }

    static void dfs(int x,int y,int s){
        if(y == n){
            y = 0;
            x++;
        }

        if(x == n){
            if(s == n){
                for(int i = 0; i < n; i++){
                    for(int j = 0; j < n;j++){
                        if(!String.valueOf(g[i][j]).equals("")){
                            System.out.print(g[i][j]);
                            System.out.print(" ");
                        }
                    }
                    System.out.println();
                }
            }
            return;
        }
//      不放皇后
        dfs(x,y+1,s);

//      放皇后
        if(!row[x] && !col[y] && !dg[x+y] && !udg[x-y+n]){
            g[x][y] = 'Q';
            row[x] = col[y] = dg[x+y] = udg[x-y+n] = true;
            dfs(x,y+1,s+1);
            row[x] = col[y] = dg[x+y] = udg[x-y+n] = false;
            g[x][y] = '`';
        }
    }
}
