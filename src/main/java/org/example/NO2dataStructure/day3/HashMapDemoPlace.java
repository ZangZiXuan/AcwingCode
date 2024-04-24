package org.example.NO2dataStructure.day3;

import java.util.Scanner;

/**
 * @Author Zang Xinrui
 * @Description TODO
 * @Date 2024/3/30 11:12
 * @Version 1.0
 */
public class HashMapDemoPlace {
    static int N = 200003;
    static int[] h = new int[N];
//    空的标记
    static int kong = 0x3f3f3f3f;

    public static void main(String[] args) {
//        200003 质数
//        for(int i = N;;i++){
//            boolean flag = true;
//            for(int j=2;j*j<=i;j++){
//                if(i % j ==0){
//                    flag = false;
//                    break;
//                }
//            }
//            if(flag){
//                System.out.println(i);
//                break;
//            }
//        }
        for(int i =0;i<N;i++){
            h[i] =kong;
        }
        System.out.println(kong);
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        sc.nextLine();
        while(n-- > 0) {
            String[] s = sc.nextLine().split(" ");
            String op = s[0];
            int x = Integer.parseInt(s[1]);
            int k = find(x);
            if (op.equals("I")) {
                h[k] = x;
            } else if(op.equals("Q")){
                if(h[k]!=kong){
                    System.out.println("YES");
                }else{
                    System.out.println("NO");
                }
            }
        }
    }

    // Find
    static private int find(int x) {
        int k = (x % N + N) % N;
        while(h[k] != kong && h[k]!=x){
            k++;
            if(k == N){
                k=0;
            }
        }
        return k;
    }
}
