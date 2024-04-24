package org.example.NO2dataStructure.day1;

import java.util.Scanner;

/**
 * @Author Zang Xinrui
 * @Description TODO
 * @Date 2024/3/26 11:07
 * @Version 1.0
 */
public class RaiseStack {
    static int N =10010;
    static int tt;
    static int[] stack = new int[N];
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        sc.nextLine();
        String[] s = sc.nextLine().split(" ");
        for(int i = 0;i<n;i++){
            int x = Integer.parseInt(s[i]);
            while(tt!=0 && stack[tt]>=x){
                tt--;
            }
            if(tt!=0){
                System.out.print(stack[tt]);
                System.out.print(" ");
            }else{
                System.out.print(-1);
                System.out.print(" ");
            }
            stack[++tt] = x;
        }
    }

}
