package org.example.NO3SearchGraphtheory;

import javafx.util.Pair;

import java.util.*;

/**
 * @Author Zang Xinrui
 * @Description TODO
 * @Date 2024/4/2 10:15
 * @Version 1.0
 */
import java.util.ArrayDeque;
import java.util.Queue;

public class BFS {
    static final int N = 110; // 定义常量 N 为 110，表示地图的最大大小
    static final int[][] map = new int[N][N]; // 定义地图数组
    static final int[][] mark = new int[N][N]; // 定义标记数组
    static final int[] dx = {-1, 0, 1, 0}; // 定义四个方向的 x 坐标变化
    static final int[] dy = {0, 1, 0, -1}; // 定义四个方向的 y 坐标变化
    static int n, m; // 定义地图的行数和列数

    static class Pair {
        // 定义一个简单的 Pair 类来表示二维坐标
        int first, second;

        Pair(int first, int second) {
            this.first = first;
            this.second = second;
        }
    }

    static void bfs() {
        // 初始化标记数组为 -1，表示未访问过
        for (int[] row : mark) {
            for (int j = 0; j < mark[0].length; j++) {
                row[j] = -1;
            }
        }

//      无参构造函数，默认的底层数组大小为16.
        Queue<Pair> q = new ArrayDeque<>(); // 使用 ArrayDeque 作为队列

        q.add(new Pair(0, 0)); // 将起点加入队列
        mark[0][0] = 0; // 标记起点为步数 0

        while (!q.isEmpty()) { // 当队列不为空时循环
            Pair top = q.poll(); // 取出队首元素
            for (int i = 0; i < 4; i++) { // 遍历四个方向
                int nex = top.first + dx[i]; // 计算下一个位置的 x 坐标
                int ney = top.second + dy[i]; // 计算下一个位置的 y 坐标
                // 如果下一个位置在地图范围内，且未访问过且可通行
                if (nex >= 0 && nex < n && ney >= 0 && ney < m && mark[nex][ney] == -1 && map[nex][ney] == 0) {
                    mark[nex][ney] = mark[top.first][top.second] + 1; // 更新下一个位置的步数
                    q.add(new Pair(nex, ney)); // 将下一个位置加入队列
                }
            }
        }

        System.out.println(mark[n - 1][m - 1]); // 输出终点的步数
    }

    public static void main(String[] args) {
        java.util.Scanner scanner = new java.util.Scanner(System.in); // 创建 Scanner 对象用于输入

        n = scanner.nextInt(); // 读取地图的行数
        m = scanner.nextInt(); // 读取地图的列数
        for (int i = 0; i < n; i++) { // 遍历地图的每一行
            for (int j = 0; j < m; j++) { // 遍历地图的每一列
                map[i][j] = scanner.nextInt(); // 读取地图的元素
            }
        }
        bfs(); // 调用 bfs 函数进行搜索
    }
}

//5 5
//0 1 0 0 0
//0 1 0 1 0
//0 0 0 0 0
//0 1 1 1 0
//0 0 0 1 0
