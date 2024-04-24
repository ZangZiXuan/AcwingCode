package org.example.NO1basic.PrefixSumandDifference;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Array2DDifference {
    static final int N = 1003;
    static int[][] b = new int[N][N]; // Initialize difference array

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        String[] s = bf.readLine().split(" "); // 读取数组的维数和查询次数
        int n = Integer.parseInt(s[0]); // 行
        int m = Integer.parseInt(s[1]); // 列
        int q = Integer.parseInt(s[2]); // 询问次数
        int[][] array = new int[n][m]; // 初始化输入数组

        for (int i = 0; i < n; i++) {
            String s2 = bf.readLine();
            String[] s1 = s2.split(" ");
            for (int j = 0; j < m; j++) {
                array[i][j] = Integer.parseInt(s1[j]);
            }
        }

        for (int i = 0; i < q; i++) {
            String[] query = bf.readLine().split(" ");
            int x1 = Integer.parseInt(query[0]);
            int y1 = Integer.parseInt(query[1]);
            int x2 = Integer.parseInt(query[2]);
            int y2 = Integer.parseInt(query[3]);
            int c = Integer.parseInt(query[4]);
            insert(x1, y1, x2, y2, c);
        }

//      将 b[i][j] 之前的所有行、所有列和的值加起来，即 b[i-1][j]、b[i][j-1] 和 b[i-1][j-1]。
//      由于在上述求和过程中，b[i-1][j-1] 被加了两次，所以我们需要减去一个 b[i-1][j-1]。
//        求b[i][j]的前缀和——
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                b[i][j] = b[i][j] + b[i - 1][j] + b[i][j - 1] - b[i - 1][j - 1];
            }
        }
//      遍历数组 array 中的每个元素，同时加上二维前缀和数组 b 中对应位置的值
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                System.out.print(array[i - 1][j - 1] + b[i][j] + " ");
            }
            System.out.println();
        }
//        输出的结果应该是原始数组的值加上差分数组的值
    }
//      相加的逻辑结构
    static void insert(int x1, int y1, int x2, int y2, int c) {
        b[x1][y1] += c; // 将 c 添加到子矩阵的左上角
        b[x2 + 1][y1] -= c; // 从子矩阵左下角的元素中减去 c
        b[x1][y2 + 1] -= c; // 从子矩阵右上角右边的元素中减去 c
        b[x2 + 1][y2 + 1] += c; // 将 c 添加到子矩阵的右下角
    }
}
//可以将a[][]当作全部为0，此时后续将数值插入进去
// (相当于对1*1的矩阵进行插入，和插入C的原理完全一致，所以也可以套用insert)
