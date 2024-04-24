package org.example.NO1basic.PrefixSumandDifference;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @Author Zang Xinrui
 * @Description TODO
 * @Date 2024/3/25 10:39
 * @Version 1.0
 */
public class Difference2Ddemo {
    static int N =10000;
    static int[][] S = new int[N][N];
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        String[] s = bf.readLine().split(" ");
        int n = Integer.parseInt(s[0]);
        int m = Integer.parseInt(s[1]);
        int q =Integer.parseInt(s[2]);
        int[][] array = new int[N][N];
        for(int i =1;i<=n;i++){
            String[] s1 = bf.readLine().split(" ");
            for(int j=1;j<=m;j++){
                array[i][j] =Integer.parseInt(s1[j-1]);
                insertValueC(i,j,i,j,array[i][j]);
            }
        }
        for(int i =1;i<=q;i++){
            String[] s1 = bf.readLine().split(" ");
            insertValueC(Integer.parseInt(s1[0]), Integer.parseInt(s1[1]), Integer.parseInt(s1[2]), Integer.parseInt(s1[3]), Integer.parseInt(s1[4]));

        }
//       求原数组
        for(int i=1;i<=n;i++){
            for(int j =1;j<=m;j++){
                array[i][j] = array[i-1][j]+array[i][j-1]-array[i-1][j-1]+S[i][j];
                System.out.print(array[i][j]);
                System.out.print(" ");
            }
            System.out.println();
        }
    }
    static int[][] insertValueC(int x1,int y1,int x2,int y2,int c){
        S[x1][y1] += c;
        S[x1][y2+1] -=c;
        S[x2+1][y1] -=c;
        S[x2+1][y2+1] +=c;
        return S;
    }
}
