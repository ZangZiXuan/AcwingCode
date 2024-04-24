package org.example.NO2dataStructure.ExerciseClass;

import java.util.AbstractMap;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * @Author Zang Xinrui
 * @Description TODO
 * @Date 2024/4/1 9:55
 * @Version 1.0
 */
public class SumRange {
    static final int N = 300010;
    static int[] a = new int[N];
    static int[] b = new int[N];
    static List<AbstractMap.SimpleEntry<Integer, Integer>> add = new ArrayList<>();
    static List<AbstractMap.SimpleEntry<Integer, Integer>> query = new ArrayList<>();
    static List<Integer> alls = new ArrayList<>();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        sc.nextLine();
        for(int i = 0;i<n;i++){
            int x = sc.nextInt();
            int c = sc.nextInt();
        }

        for(int i = 0;i<m;i++){
            int l = sc.nextInt();
            int r = sc.nextInt();

        }
    }
    public static int find(int x) {
        int l = 0, r = alls.size() - 1;
        while (l < r) {
            int mid = (l + r) >>> 1;
            if (alls.get(mid) >= x) {
                r = mid;
            } else {
                l = mid + 1;
            }
        }
        return r+1;
    }
}
