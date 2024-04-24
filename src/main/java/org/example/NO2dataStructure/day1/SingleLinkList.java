package org.example.NO2dataStructure.day1;

import java.util.Scanner;

/**
 * @Author Zang Xinrui
 * @Description TODO
 * @Date 2024/3/25 15:00
 * @Version 1.0
 */
public class SingleLinkList {
    static int N =10000;
    //    head 表示头节点下标
//    e[i]表示节点i的值
//    ne[i] 表示节点i的next指针是多少
//    index 表示当前用到的是哪个节点
    static int head;
    static int[] e = new int[N];
    static int[] ne = new int[N];
    static int index;

//    链表初始化
    static void init(){
        head = -1;
        index =0;
    }
//    将x插到头节点
    static void add_to_head(int x){
            e[index] = x;
            ne[index] = head;
            head = index;
            index++;
    }
//     将x插入节点k的后面
    static void add(int k,int x){
        e[index] =x;
        ne[index] = ne[k];
        ne[k] = index;
        index++;
    }
//    单链表删除操作
//    将下标是k的后面一个节点删掉
    static void delete(int k) {
        if (k == 0) { // 如果是删除头节点
            head = ne[head]; // 直接将头节点更新为下一个节点
        } else if (k > 0 && k < index) { // 确保k是有效索引
            int pre = findPreNode(k);
            if (pre != -1 && ne[k] != -1) {
                // 更新前一个节点的next指针，跳过当前节点
                ne[pre] = ne[ne[pre]];
            }
        }
    }
    // 查找节点k的前一个节点的索引
    static int findPreNode(int k) {
        for (int i = head; i != -1; i = ne[i]) {
            if (ne[i] == k) {
                return i;
            }
        }
        return -1; // 如果没有找到，返回-1
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int m = sc.nextInt();
        init();
        while (m-->0){
            String option = sc.next();
            if(option.equals("H")){
                int x = sc.nextInt();
                add_to_head(x);
            } else if (option.equals("D")) {
                int k = sc.nextInt();
                if(k==0){
                    head = ne[head];
                }
                delete(k-1);
            } else if (option.equals("I")){
                int k = sc.nextInt();
                int x = sc.nextInt();
                add(k-1,x);
            }
        }
        for (int i = head; i != -1; i = ne[i]) {
            System.out.print(e[i]);
            System.out.println(" ");
        }
    }
}
