/*
 * Ant Group
 * Copyright (c) 2004-2021 All Rights Reserved.
 */

/**
 * @author jam
 * @version Offer15��������1�ĸ���.java, v 0.1 2021��06��28�� 21:58 jam
 */
public class Offer15��������1�ĸ��� {
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