package org.example.NO2dataStructure.day2;

import java.util.Scanner;

/**
 * @Author Zang Xinrui
 * @Description TODO
 * @Date 2024/3/28 9:10
 * @Version 1.0
 */
public class TrieCount {
    static int N = 100010;
//    当前节点最多连多少个其他的子节点（26个英文字母）
    static int[][] son  =new int[N][26];
//    以当前节点结束的字符串个数
    static int[] cnt = new int[N];
//    当前用到哪个下标
    static int idx;
//      下标是0的点，既是根节点，也是空节点
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        sc.nextLine();
        for(int i =0;i<n;i++){
            String[] s = sc.nextLine().split(" ");
            char[] str = s[1].toCharArray();
            if(s[0].equals("I")){
                insert(str);
            }else if(s[0].equals("Q")){
                int query = query(str);
                System.out.println(query);
            }
        }
    }
    static void insert(char str[]){
        int p  =0;
        for(int i = 0;i<str.length;i++){
            int u = str[i] - 'a';
            if(son[p][u] == 0){
                son[p][u] = ++idx;
            }
            p = son[p][u];
        }
        cnt[p]++;
    }

    static int query(char str[]){
        int p=0;
        for(int i=0;i< str.length;i++){
            int u = str[i] - 'a';
            if(son[p][u]==0){
                return 0;
            }
            p= son[p][u];
        }
        return cnt[p];
    }
}
