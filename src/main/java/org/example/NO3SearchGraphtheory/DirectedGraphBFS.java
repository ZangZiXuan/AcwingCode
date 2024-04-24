package org.example.NO3SearchGraphtheory;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class DirectedGraphBFS {
    static int N = 100010;
    static int[] h = new int[N];
    static int[] e = new int[N];
    static int[] ne = new int[N];
    static int[] q = new int[N];
    static int[] d = new int[N]; // Array to store in-degree of vertices
    static int idx;
    static int n, m;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        Arrays.fill(h, -1);
        Arrays.fill(d, 0); // Initialize in-degree array
        sc.nextLine();



        for (int i = 0; i < m; i++) {
            int a, b;
            a = sc.nextInt();
            b = sc.nextInt();
            add(a, b);
            d[b]++; // Increment in-degree of vertex b
        }
        if (topsort()) {
            for (int i = 0; i < n; i++) {
                System.out.print(q[i]);
                System.out.print(" ");
            }
        } else {
            System.out.println("-1");
        }
    }

    private static void add(int a, int b) {
        e[idx] = b;  // 将边b添加到e数组中，表示从顶点a到顶点b有一条有向边
        ne[idx] = h[a];  // 更新ne数组，将当前顶点a的邻接表头指针指向的下一个节点设为当前边的下一个节点
        h[a] = idx++;  // 更新顶点a的邻接表头指针，将其指向当前添加的边，并更新边的索引
    }

    private static boolean topsort() {
        int hh = 0, tt = -1;  // 初始化队列头尾指针
        for (int i = 1; i <= n; i++) {  // 遍历所有顶点
            if (d[i] == 0) {  // 若顶点i的入度为0，即没有入边
                q[++tt] = i;  // 将顶点i加入队列
            }
        }
        while (hh <= tt) {  // 当队列非空时进行循环
            int t = q[hh++];  // 取出队首元素
            for (int i = h[t]; i != -1; i = ne[i]) {  // 遍历以顶点t为起点的边
                int j = e[i];  // 取出当前边的终点j
                d[j]--;  // 更新顶点j的入度，因为以顶点t为起点的边已经被处理了一条
                if (d[j] == 0) {  // 若顶点j的入度为0
                    q[++tt] = j;  // 将顶点j加入队列
                }
            }
        }
        return tt == n - 1;  // 返回是否拓扑排序成功，即是否所有顶点都被加入了队列
    }
}
