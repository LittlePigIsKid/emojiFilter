package com.yeah;

import java.util.HashMap;

/**
 * Created by stove.shi on 2017/2/9.
 */
public class EmojiFilterImp implements EmojiFilter {

    //http://coolview.github.io/2016/05/27/UTF-8%E7%BC%96%E7%A0%81%E8%A7%84%E5%88%99/
    //the byte size of the utf-8, it is according to the previous url
    private static HashMap<String, Integer> map = new HashMap<String, Integer>();
    static {
        map.put("0", 1);
        map.put("1", 1);
        map.put("2", 1);
        map.put("3", 1);
        map.put("4", 1);
        map.put("5", 1);
        map.put("6", 1);
        map.put("7", 1);
        map.put("C", 2);
        map.put("D", 2);
        map.put("E", 3);
        map.put("F", 4);
    }

    public boolean isFourBytesEmojiExist(String hexStr) {
        int index = 0;
        for(; index<hexStr.length(); ){
            String sub = hexStr.substring(index, index+1);
            if("f".equals(sub)||"c".equals(sub)||"e".equals(sub)||"f".equals(sub)) {
                sub = sub.toUpperCase();
            }
            if("F".equals(sub)){
                return true;
            }else{
                if(map.containsKey(sub)) {
                    index += map.get(sub) * 2;
                }else{
                    System.out.println("map not contains the hex  "+sub);
                }
            }
        }
        return false;
    }

    public boolean isThreeBytesEmojiExist(String hexStr) {
        int index = 0;
        for(; index<hexStr.length(); ){
            String sub = hexStr.substring(index, index+1);
            if("f".equals(sub)||"c".equals(sub)||"e".equals(sub)||"f".equals(sub)) {
                sub = sub.toUpperCase();
            }
            if("E".equals(sub)){
                return true;
            }else{
                if(map.containsKey(sub)) {
                    index += map.get(sub) * 2;
                }else{
                    System.out.println("map not contains the hex  "+sub);
                }
            }
        }
        return false;
    }
}
