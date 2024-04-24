package org.example.NO2dataStructure.day2;

import java.util.Scanner;

/**
 * @Author Zang Xinrui
 * @Description TODO
 * @Date 2024/3/29 10:22
 * @Version 1.0
 */
public class Heap {

    static int N = 100010;
    static int n,m,size;
    static int[] h = new int[N];

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        for(int i = 0;i <= n;i++){
            h[i]= sc.nextInt();
        }
        size = n;
//        从n/2开始down是因为最下面一层不用
        for(int i=(size-2)/2;i>=0;i--){
            down(i);
        }
        while(m-->0){
            System.out.println(h[1]);
            h[1] = h[size];
            size--;
            down(1);
        }

    }

//    public void creatHeap(int size){
//        for (int i=(size-2)/2;i>=0;i--){
//            justDown(size,i);
//        }
//    }
//
//    //对堆的根部进行向下调整
//    //结束调整的条件？  已经满足堆的结构，无需调整    当前结点已经是叶子结点，下边没有节点，无需调整
//    public void justDown(int size,int index){
//        int left=2*index+1;//判断左子树是否存在，如果没有左子树，必没有右子树（完全二叉树性质）
//        while (left<size){
//            int min=left+1<size&&h[left+1]<h[left]?left+1:left;//找出左右子树中的最小值
//            int largest=h[index]<=h[min]?index:min;//在根和最小值中再找出最小值
//            if (largest==index) break;//如果根就是最小值 堆结构已满足 退出循环
//            swap(index,min);  //不满足交换根和最小值，根等于最小值进行下一次调整
//            index=min;
//            left=index*2+1;
//        }
//    }


//----------------------------Acwing----------------------
    static private void swap(int index, int min) {
        int temp=h[index];
        h[index]=h[min];
        h[min]=temp;
    }
    static private void down(int u){
        int t = u;
        if(u*2<=size && h[u*2]<h[t]){
            t = u*2;
        }
        if(u*2+1<=size && h[u*2+1]<h[t]){
            t = u*2+1;
        }
        if(u != t){
            swap(h[t],h[u]);
            down(t);
        }
    }
    private void up(int u){
        while(u/2 !=0 && h[u/2]>h[u]){
            swap(h[u/2],h[u]);
            u /= 2;
        }
    }

}
