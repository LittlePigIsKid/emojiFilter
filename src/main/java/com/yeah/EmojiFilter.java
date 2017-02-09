package com.yeah;

/**
 * Created by stove.shi on 2017/2/9.
 */
public interface EmojiFilter {
    public boolean isFourBytesEmojiExist(String hexStr);
    public boolean isThreeBytesEmojiExist(String hexStr);
}
