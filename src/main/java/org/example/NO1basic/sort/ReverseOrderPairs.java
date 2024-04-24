package org.example.NO1basic.sort;

import java.util.Scanner;

/**
 * @Author Zang Xinrui
 * @Description TODO
 * @Date 2024/3/19 10:38
 * @Version 1.0
 */
public class ReverseOrderPairs {
    long ll;
    static int N = 10010;
    static int[] array = new int[N];
    static int[] temp = new int[N];
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        for(int i =0;i<n;i++){
            array[i] = sc.nextInt();
        }
        System.out.println(merge_sort(0,n-1));
    }
    static long merge_sort(int l,int r ){
        if(l>=r){
            return 0;
        }

        int mid = l+r >>1;
        long res = merge_sort(l,mid)+merge_sort(mid+1,r);
//        归并排序的过程
        int k=0,i=l,j=mid+1;
        while(i<=mid &&j<=r){
            if(array[i]<=array[j]){
                temp[k++] = array[i++];
            }else{
                temp[k++] = array[j++];
                res +=mid-i+1;

            }
        }
//        扫尾,对于多出来的那部分长度的数组直接放入temp存储空间中
        while(i<=mid){
            temp[k++] =array[i++];
        }
        while(j<=r){
            temp[k++] =array[j++];
        }
//        物归原主
        for(int a = l,b=0;a<=r;a++,b++){
            array[a] =temp[b];
        }
        return res;
    }
}
