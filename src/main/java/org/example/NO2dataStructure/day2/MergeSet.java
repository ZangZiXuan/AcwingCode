package org.example.NO2dataStructure.day2;

import java.util.Scanner;

/**
 * @Author Zang Xinrui
 * @Description TODO
 * @Date 2024/3/28 14:54
 * @Version 1.0
 */
public class MergeSet {
    static int N = 100010;
    static int n,m;
    static int[] p  = new int[N];

    static int find(int x) {
        if(p[x] != x ){
            p[x]  =find(p[x]);
        }
        return p[x];
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        sc.nextLine();
        for(int i = 1; i<= MergeSet.n; i++){
            p[i] = i;
        }
        for(int i = 0;i < m;i++){
            String[] s = sc.nextLine().split(" ");
            char[] chars = s[0].toCharArray();
            int a  = Integer.parseInt(s[1]);
            int b  = Integer.parseInt(s[2]);
            if(chars[0]=='M'){
                p[find(a)] = find(b);
            }else if (chars[0]=='Q'){
                if(find(a)==find(b)){
                    System.out.println("YES");
                }else{
                    System.out.println("NO");
                }
            }

        }
    }

}
