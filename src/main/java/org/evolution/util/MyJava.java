package org.evolution.util;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Arrays;

public class MyJava {


    public static void main(String[] args) throws Exception {
//        for (int i = 1 ; i < 10; i++) {
//            System.out.println(MyJava.diGui(i));
//        }

        System.out.println(Arrays.toString(MyJava.twoSum(new int[]{1, 8, 2, 3, 2}, 9)));

    }

    /*1. 两数之和*/
    public static int[] twoSum(int[] nums, int target) {
        /* */
        for (int i = 0 ; i < nums.length; i ++) {
            for (int j = i + 1 ; j > i; j ++) {
                if (nums[i] + nums[j] == target) {
                    return new int[]{i,j};
                }
            }
        }
//        return twoSum(nums);
        return null;
    }

    /*递归  斐波那契数列求解 */
    public static int diGui(int n) {
        /*终止条件*/
        if (n <= 2) {
            return 1;
        }
        return diGui(n-1) + diGui(n-2);
    }

    /*向目标文件写入文字*/
    public static void writeFileTarget() throws Exception {
        OutputStream ops = new FileOutputStream("1.txt");
        byte[] bytes = new byte[] {'a','b','c','d'};
        ops.write(bytes);
        ops.close();
        InputStream ips = new FileInputStream("1.txt");
    }
}
