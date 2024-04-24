package org.example.NO1basic.twoPointerAlgorithm;

import java.util.Scanner;

/**
 * @Author Zang Xinrui
 * @Description TODO
 * @Date 2024/3/17 16:42
 * @Version 1.0
 */
public class OutPrintString {
    public static void main(String[] args) {
        char[] str = new char[1000];
        Scanner sc = new Scanner(System.in);
        String[] s = sc.nextLine().split(" ");
        int n = s.length;
        for(int i =0;i<s.length;i++){
            int j=1;
            while( j<n && str[j] !=' '){
                j++;
            }
            for(int k =0;k<j;k++){
                System.out.println(s[k]);
            }
            i=j;
        }


    }
}
