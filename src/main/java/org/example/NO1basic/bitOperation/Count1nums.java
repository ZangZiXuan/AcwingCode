package org.example.NO1basic.bitOperation;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @Author Zang Xinrui
 * @Description TODO
 * @Date 2024/3/18 9:50
 * @Version 1.0
 */
public class Count1nums {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        sc.nextLine();
        String[] s = sc.nextLine().split(" ");
        Integer[] result = new Integer[n];
        for(int i = 0;i<s.length;i++){
            int num = Integer.parseInt(s[i]);
            int i1 = count1(num);
            result[i] = i1;
        }
        System.out.println(Arrays.toString(result));
    }
    static int count1(int num) {
        if(num == 0){
            return 0;
        }
        StringBuilder stringBuilder = new StringBuilder();
        while(num>0){
            int remainder = num % 2;
            stringBuilder.insert(0,remainder);
            num = num / 2;
        }
        char[] chars = stringBuilder.toString().toCharArray();
        int count =0;
        for(int i = 0;i<chars.length;i++){
            if(chars[i] =='1'){
                count++;
            }
        }
        return count;
    }
}
