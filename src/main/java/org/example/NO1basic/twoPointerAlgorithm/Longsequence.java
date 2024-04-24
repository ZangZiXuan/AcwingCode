package org.example.NO1basic.twoPointerAlgorithm;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

import static java.lang.Math.max;

public class Longsequence {

    public static void main(String[] args) {
        int N=10010;
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] sequence = new int[n];
        for (int i = 0; i < n; i++) {
            sequence[i] = sc.nextInt();
        }
        int maxLength = findMaxLength(sequence);

        System.out.println(maxLength);
//        下面是更简便的方法，
//        j是距离i最远的不包含相同数字的指针
        int res = 0;
        int[] s = new int[N];
        for(int i =0,j=0;i<n;i++){
            s[sequence[i]]++;
            while(s[sequence[i]]>1){
                s[sequence[j]]--;
                j++;
            }
            res = max(res,i-j+1);
        }
        System.out.println(res);
    }

    static int findMaxLength(int[] sequence) {
        int maxLength = 0;
        Set<Integer> set = new HashSet<>();
        int j = 0;
        for (int i = 0; i < sequence.length; i++) {
            while (j < sequence.length && !set.contains(sequence[j])) {
                set.add(sequence[j]);
                maxLength = max(maxLength, j - i + 1);
                j++;
            }
            set.remove(sequence[i]);
        }
        return maxLength;
    }
}
