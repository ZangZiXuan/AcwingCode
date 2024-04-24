package org.example.NO1basic.binarySearch;

import java.util.Scanner;

/**
 * @Author Zang Xinrui
 * @Description TODO
 * @Date 2024/3/24 16:39
 * @Version 1.0
 */
public class ThirdRoot {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();
//        float result = diverseThird(num, -10000, 10000);
//        System.out.println(result);
        double l =-10000,r=10000;

        double mid = 0;
        while (r - l > 1e-8) { // 修改条件为大于而非大于等于
            mid = (l + r) / 2;
            if (mid * mid * mid >= num) {
                r = mid;
            } else {
                l = mid;
            }
        }
        System.out.println(mid);
    }
}
