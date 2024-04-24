package org.example.NO1basic.sort;

public class QuickSort {
    static void quickSort(int[] array, int low, int high) {
        if (low < high) {
            // 分区操作，将数组分为两部分
            int pivotIndex = partition(array, low, high);
            // 对左子数组递归排序
            quickSort(array, low, pivotIndex - 1);
            // 对右子数组递归排序
            quickSort(array, pivotIndex + 1, high);
//            pivotIndex： 枢轴元素
        }
    }

    static int partition(int[] array, int low, int high) {
        int pivot = array[high];
        int i = (low - 1); // 较小元素的索引
        for (int j = low; j < high; j++) {
            // 当前元素小于或等于枢轴
            if (array[j] <= pivot) {
                i++;
                // 交换 array[i] 和 array[j]
                int temp = array[i];
                array[i] = array[j];
                array[j] = temp;
            }
        }
        // 交换 array[i+1] 和 array[high]（或枢轴）
        int temp = array[i + 1];
        array[i + 1] = array[high];
        array[high] = temp;
        return i+1;
//        int x = array[array.length / 2];
//        System.out.println(x);
//        int a = 0;
//        for (int i = 0; i <= (array.length / 2); i++) {
//            for (int j = array.length - 1; j >= i; j--) {
//                if (array[i] >= x && array[j] <= x) {
//                    int temp = array[i];
//                    array[i] = array[j];
//                    array[j] = temp;
//                    a = i;
//                }
//            }
//        }
//        return a + 1;
    }

    public static void main(String args[]) {
        int[] array = {10, 7, 8, 9, 1, 5};
        int n = array.length;
        quickSort(array, 0, n - 1);
        System.out.println("Sorted array: ");
        for (int i = 0; i < n; i++) {
            System.out.print(array[i] + " ");
        }
    }
}
