/*
 * Ant Group
 * Copyright (c) 2004-2021 All Rights Reserved.
 */

/**
 * @author jam
 * @version Offer15二进制中1的个数.java, v 0.1 2021年06月28日 21:58 jam
 */
public class Offer15二进制中1的个数 {
    public static int hammingWeight(int n) {
        int count = 0;
        int m = 0;
        for (int i = 0; i <= 32; i ++){
            m = n >>> i;
            if ((m & 1) != 0)
                count ++;
        }
        return count;
    }

    public static void main(String[] args) {
        int r = hammingWeight(11);
        System.out.println(r);
    }

}