package org.example.NO3SearchGraphtheory;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @Author Zang Xinrui
 * @Description TODO
 * @Date 2024/4/3 9:25
 * @Version 1.0
 */
public class UndirectedGraphDFS {

    static final int N = 100010;
    static int[] h = new int[N]; // 存储图的邻接表的头指针数组
    static int[] e = new int[N]; // 存储边的目标节点
    static int[] ne = new int[N]; // 存储边的下一个节点
    static int idx; // 存储当前边的下标
    static int n; // 树的节点数
    static int[] size = new int[N]; // 存储每个节点的子树大小
    static int[] ans = new int[N]; // 存储每个节点的最大子树大小

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        n = scanner.nextInt(); // 读取树的节点数

        // 初始化
        idx = 0;
        Arrays.fill(h, -1); // 初始化邻接表头指针数组为-1

        // 读入边
        for (int i = 0; i < n - 1; i++) {
            int a = scanner.nextInt(); // 读取边的起点
            int b = scanner.nextInt(); // 读取边的终点
            add(a, b); // 添加边
            add(b, a); // 无向图，需将边添加两次
        }

        dfs(1, -1); // 从根节点开始深度优先搜索
        System.out.println(Arrays.stream(ans).max().getAsInt()); // 输出结果，找出所有节点的最大子树大小
    }

    static void dfs(int u, int fa) {
        size[u] = 1; // 初始化当前节点的子树大小为1
        for (int i = h[u]; i != -1; i = ne[i]) {
            int j = e[i]; // 获取当前边的目标节点
            if (j == fa) continue; // 如果目标节点是父节点，则跳过,避免成环,进入死循环
            dfs(j, u); // 递归遍历目标节点的子树
            size[u] += size[j]; // 更新当前节点的子树大小
            ans[u] = Math.max(ans[u], size[j]); // 更新当前节点的最大子树大小
        }
        ans[u] = Math.max(ans[u], n - size[u]); // 更新当前节点的最大子树大小（考虑将当前节点作为重心时的情况）
    }

    static void add(int a, int b) {
        e[idx] = b; // 添加边的目标节点
        ne[idx] = h[a]; // 将边的下一个节点指向当前头指针指向的节点
        h[a] = idx++; // 更新头指针指向新的边
    }
}
