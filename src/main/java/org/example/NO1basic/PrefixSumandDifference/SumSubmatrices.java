package org.example.NO1basic.PrefixSumandDifference;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @Author Zang Xinrui
 * @Description TODO
 * @Date 2024/3/15 17:21
 * @Version 1.0
 */
public class SumSubmatrices {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        // 输入n行，m列，q个询问（每个询问包含两对坐标，x1,x2,y1,y2）
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        int q = scanner.nextInt();
        int x1 = 0,x2 = 0,y1 = 0,y2 = 0;
        while (q>0){
            x1 = scanner.nextInt();
            x2 = scanner.nextInt();
            y1 = scanner.nextInt();
            y2 = scanner.nextInt();
        }
        // 换行
        scanner.nextLine();
        int[][] a = new int[n][m];
        for(int i =0; i < n; i++){
            String s = scanner.nextLine();
            String[] s1 = s.split(" ");
            for(int j = 0; j < m; j++){
                a[i][j] = Integer.parseInt(s1[j]);
            }
        }
        // 计算子矩阵的和
        int sum = SubmatriceAdd(a, x1, x2, y1, y2);
        System.out.println(sum); // 输出子矩阵的和
    }
    static int SubmatriceAdd(int[][] array, int x1, int x2, int y1, int y2) {
        int n = array.length;
        int m = array[0].length;

        // 计算原始矩阵的累积和(前缀和)
        int[][] prefixSum = new int[n + 1][m + 1];
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                prefixSum[i][j] = prefixSum[i - 1][j] + prefixSum[i][j - 1] - prefixSum[i - 1][j - 1] + array[i - 1][j - 1];
            }
        }
        // 计算子矩阵的和
        int sum = prefixSum[x2][y2] - prefixSum[x1 - 1][y2] - prefixSum[x2][y1 - 1] + prefixSum[x1 - 1][y1 - 1];
        return sum;
    }

}
