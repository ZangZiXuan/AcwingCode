package org.example.NO2dataStructure.day1;

/**
 * @Author Zang Xinrui
 * @Description TODO
 * @Date 2024/3/26 9:34
 * @Version 1.0
 */
public class DoubleLinkedList {
    static int N = 10010;
    static int[] l = new int[N];
    static int[] r = new int[N];
    static int[] e = new int[N];
    static int m,idx;
    static void init() {
//        0表示左端点，1表示右端点
        r[0] =1;
        l[1]=0;
        idx = 2;
    }
//    向下标是k的右侧插入一个点
    static void add(int k,int x){
        e[idx] =x;
        l[idx] =k;
        r[idx] =r[k];
        l[r[k]]= idx;
        r[k] =idx;
    }
//    删除第k个节点后的一个节点
    static void delete(int k){
        r[k] =r[r[k]];
        l[r[r[k]]]=l[r[k]];
//        r[l[k]] =r[k];
//        l[r[k]] = l[k];
    }
//    删除第k个节点
    static void deleteK(int k){
        r[l[k]] =r[k];
        l[r[k]] = l[k];
    }

    public static void main(String[] args) {

    }

}
