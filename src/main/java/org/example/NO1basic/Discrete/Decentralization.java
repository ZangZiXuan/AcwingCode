package org.example.NO1basic.Discrete;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashSet;

public class Decentralization {

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        String[] s = bf.readLine().split(" ");
        int[] array = new int[s.length];
        for (int i = 0; i < array.length; i++) {
            array[i] = Integer.parseInt(s[i]);
        }
        Arrays.sort(array);
        array = unique(array); // Assign back the unique array
        for (int i = 0; i < array.length; i++) {
            int x = array[i];
            int result = find(x, array);

            System.out.println(result);
        }
    }

    private static int[] unique(int[] array) {
        HashSet<Integer> set = new HashSet<>();
        for (int i = 0; i < array.length; i++) {
            set.add(array[i]);
        }
        int[] uniqueArray = new int[set.size()];
        int index = 0;
        for (Integer num : set) {
            uniqueArray[index++] = num;
        }
        return uniqueArray;
    }

    private static int find(int x, int[] array) {
        int l = 0, r = array.length - 1;
        while (l < r) {
            int mid = (l + r) / 2;
            if (array[mid] >= x) {
                r = mid;
            } else {
                l = mid + 1;
            }
        }
        return r + 1;
    }
}
