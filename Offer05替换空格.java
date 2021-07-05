/*
 * Ant Group
 * Copyright (c) 2004-2021 All Rights Reserved.
 */

/**
 * @author jam
 * @version Offer05�滻�ո�.java, v 0.1 2021��06��28�� 21:50 jam
 */
public class Offer05�滻�ո� {
    public String replaceSpace(String s) {
        return replaceSpaceWith(s, "%20");
    }

    private String replaceSpaceWith(String s, String pattern){
        StringBuffer sb = new StringBuffer();
        for (char c : s.toCharArray()){
            if (c == ' '){
                sb.append(pattern);
            }
            else{
                sb.append(c);
            }
        }
        return sb.toString();
    }
}