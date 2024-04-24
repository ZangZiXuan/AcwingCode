package org.example.NO1basic.binarySearch;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @Author Zang Xinrui
 * @Description TODO
 * @Date 2024/3/14 16:32
 * @Version 1.0
 */
public class FloatBinarySearch {

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int x = Integer.parseInt(bf.readLine());
        float l = 0;
        float r = x;
        while(r-l>1e-6){
            float mid = (l+r)/2;
            if(mid*mid>=x){
                r=mid;
            }else{
                l=mid;
            }
        }
        System.out.println(l);
        System.out.println(l*l);
    }

}
