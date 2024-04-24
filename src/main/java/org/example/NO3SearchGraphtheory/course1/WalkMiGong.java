package org.example.NO3SearchGraphtheory.course1;

import java.util.*;

/**
 * @Author Zang Xinrui
 * @Description TODO
 * @Date 2024/4/24 16:28
 * @Version 1.0
 */
//  Acwing 走迷宫 844
//    输入样例
//5 5
//0 1 0 0 0
//0 1 0 1 0
//0 0 0 0 0
//0 1 1 1 0
//0 0 0 1 0
//    输出样例
//    8
public class WalkMiGong {

    static int N = 110;
    static int n,m;
    static int[][] g = new int[N][N];
    static int[][] d = new int[N][N];

    static Pair[] q = new Pair[N*N];

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        for(int i = 0;i < n; i++){
            for(int j = 0;j < n; j++){
                g[i][j] = sc.nextInt();
            }
        }

    }
    static int bfs(){
        int hh = 0, tt = 0;
        q[0].a = 0;
        q[0].b = 0;
        memset(d,-1,d.length);

        d[0][0] = 0;

        int dx[] = {-1,0,1,0};
        int dy[] = {0,1,0,-1};

        while(hh <= tt){
            Pair pair = q[hh++];
            for(int i = 0; i < 4; i++){
                int x = pair.a + dx[i];
                int y = pair.b + dy[i];
                if(x >= 0 && x < n && y < m && g[x][y] == 0 && d[x][y] == -1){

                    d[x][y] = d[pair.a][pair.b] + 1;
                    q[++tt].a = x;
                    q[++tt].b = y;
                }
            }

        }
        return
    }
    class Pair{
        Integer a;
        Integer b;
        public Pair(int a,int b){
            this.a = a;
            this.b = b;
        }
    }
}
