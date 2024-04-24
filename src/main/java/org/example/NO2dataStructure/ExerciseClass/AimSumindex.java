package org.example.NO2dataStructure.ExerciseClass;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @Author Zang Xinrui
 * @Description TODO
 * @Date 2024/4/1 9:11
 * @Version 1.0
 */
public class AimSumindex {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int x = sc.nextInt();
        sc.nextLine();
        String[] s = sc.nextLine().split(" ");
        int[] A = new int[s.length];
        for(int i = 0;i<s.length;i++){
            A[i] = Integer.parseInt(s[i]);
        }
        String[] s1 = sc.nextLine().split(" ");
        int[] B = new int[s1.length];
        for(int i = 0;i<s1.length;i++){
            B[i] = Integer.parseInt(s1[i]);
        }
        int[] findij = findijdemo(x, A, B);
        System.out.println(Arrays.toString(findij));
    }
    static int[] findij(int x,int[] A,int[] B){
        int[] result = new int[2];
        for(int i = 0;i<A.length;i++){
            for(int j = 0;j<B.length;j++){
                if(A[i]+B[j]==x){
                    System.out.println(i);
                    System.out.println(j);
                    result[0] = i+1;
                    result[1] = j-1;
                    return result;
                }
            }
        }
        return result;
    }
    static int[] findijdemo(int x,int[] A,int[] B){

        int[] result = new int[2];
//        单调性
        for(int i = 0,j = B.length-1;i<A.length;i++){
            while(j>=0 && A[i]+B[j]>x){
                j--;
            }
            if(A[i]+B[j]==x){
                result[0] = i+1;
                result[1] = j-1;
                break;
            }
        }
        return result;
    }
}
