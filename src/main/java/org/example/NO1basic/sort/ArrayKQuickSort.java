package org.example.NO1basic.sort;


import java.util.Scanner;

/**
 * @Author Zang Xinrui
 * @Description TODO
 * @Date 2024/3/19 10:21
 * @Version 1.0
 */
public class ArrayKQuickSort {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n =sc.nextInt();
        int k = sc.nextInt();
        int[] array = new int[n];
        for(int i =0;i<n;i++){
            array[i] = sc.nextInt();
        }
        int result = quicksort(array, 0, n - 1, k);
        System.out.println(result);
    }
    private static int quicksort(int[] array,int l,int r,int k){
        if(l==r){
            return array[l];
        }
        int x = array[l],i =l-1,j=r+1;
        while(i<j){
            while(array[++i] < x);
            while(array[--j]>x);
            if(i<j){
                int temp =array[i];
                array[i] = array[j];
                array[j] = temp;
            }
        }
        int s1 = j-l+1;
        if(k<=s1)
            return quicksort(array,l,j,k);
        return quicksort(array,j+1,r,k-s1);
    }
}
