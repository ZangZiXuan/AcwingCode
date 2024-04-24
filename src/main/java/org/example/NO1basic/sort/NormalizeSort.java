package org.example.NO1basic.sort;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

/**
 * @Author Zang Xinrui
 * @Description TODO
 * @Date 2024/3/13 15:41
 * @Version 1.0
 */
//  归并排序
public class NormalizeSort {
    //初始时间

    public static void main(String[] args) throws IOException {
        long startTime = System.currentTimeMillis();
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        String line = bf.readLine(); // 读取一行数据
        // 假设输入的数据是用空格分隔的
        String[] numbers = line.split(" ");
        // 创建一个整型数组来存储转换后的数值
        int[] array = new int[numbers.length];
        for (int i = 0; i < numbers.length; i++) {
            array[i] = Integer.parseInt(numbers[i]); // 将字符串转换为整数
        }
        sort(array,0, array.length-1);
        System.out.println(Arrays.toString(array));
        //结束时间
        long endTime = System.currentTimeMillis();
//打印
        System.out.println("程序运行时间：" + (endTime - startTime) + "ms");
    }
    static void sort(int[] array,int left,int right){
        if(left<right){
            int mid = left+(right-left)/2;
            sort(array,left,mid);
            sort(array,mid+1,right);
            merge(array,left,mid,right);
        }
    }
    static void merge(int[] arr,int left,int mid,int right){
        int n1 = mid-left+1;
        int n2 = right-mid;
        int[] L = new int[n1];
        int[] R= new int[n2];
        System.arraycopy(arr,left,L,0,n1);
        System.arraycopy(arr,mid+1,R,0,n2);
        int i=0,j=0;
        int k = left;
        while (i<n1&&j<n2) {
            if(L[i]<=R[j]) {
                arr[k] = L[i];
                i++;
            }else{
                arr[k] = R[j];
                j++;
            }
            k++;
        }
        while (i < n1){
            arr[k] = L[i];
            i++;
            k++;
        }
        while(j<n2){
            arr[k]=R[j];
            j++;
            k++;
        }

    }

}
