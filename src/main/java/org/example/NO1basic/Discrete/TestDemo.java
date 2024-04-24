package org.example.NO1basic.Discrete;

import java.util.Arrays;

/**
 * @Author Zang Xinrui
 * @Description TODO
 * @Date 2024/3/18 20:50
 * @Version 1.0
 */
public class TestDemo {
    public static void main(String[] args)
    {
        int arr[] = new int[] {4,25,17,8,12};
        System.out.println("原数组为：");
        int i = 0;
        for(int x : arr) {
            i++;
            if(i == arr.length)
                System.out.println(x);
            else
                System.out.print(x + " ");
        }
        Arrays.sort(arr);
        System.out.println("排序后为：");
        i = 0;
        for(int x : arr) {
            i++;
            if(i == arr.length)
                System.out.println(x);
            else
                System.out.print(x + " ");
        }
        System.out.println("----------------------------------");
        int index = Arrays.binarySearch(arr, 8);
        System.out.println("关键字8的返回值为："+index);
        index=Arrays.binarySearch(arr, 2);
        System.out.println("关键字2的返回值为："+index);
        index=Arrays.binarySearch(arr, 5);
        System.out.println("关键字5的返回值为："+index);
        index=Arrays.binarySearch(arr, 27);
        System.out.println("关键字27的返回值为："+index);

        System.out.println("-----------------------------------");
        index=Arrays.binarySearch(arr, 0, 2, 8);
        System.out.println("关键字8在范围[0,2)的返回值为："+index);
        index=Arrays.binarySearch(arr, 0, 2, 2);
        System.out.println("关键字2在范围[0,2)的返回值为："+index);
        index=Arrays.binarySearch(arr, 0, 2, 5);
        System.out.println("关键字5在范围[0,2)的返回值为："+index);
        index=Arrays.binarySearch(arr, 0, 2, 12);
        System.out.println("关键字12在范围[0,2)的返回值为："+index);
    }
}
