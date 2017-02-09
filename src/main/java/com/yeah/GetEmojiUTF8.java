package com.yeah;

import com.vdurmont.emoji.Emoji;
import com.vdurmont.emoji.EmojiManager;
import com.vdurmont.emoji.EmojiParser;
import org.apache.commons.logging.LogFactory;
import org.apache.http.HttpEntity;
import org.apache.http.HttpRequest;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by stove.shi on 2017/2/9.
 */
public class GetEmojiUTF8 {
    //private static Logger LOG = LoggerFactory.getLogger(GetEmojiUTF8.class);
    public static final HashMap<String, Emoji> map = new HashMap<String, Emoji>();
    static {
        /*HttpClient httpClient = HttpClients.createDefault();
        HttpGet get = new HttpGet("http://apps.timwhitlock.info/emoji/tables/unicode");
        String responseBody = null;
        try {
            HttpResponse response = httpClient.execute(get);
            responseBody = EntityUtils.toString(response.getEntity());
            System.out.println(responseBody);
        } catch (IOException e) {
            e.printStackTrace();
      //      LOG.error("get the emoji utf-8 failed");
            System.exit(1);
        }*/
        for(Emoji emoji : EmojiManager.getAll()) {
            //System.out.println(emoji);
            String unicodeStr = emoji.getUnicode();
            try {
                //convert from unicode to utf-8
                byte[] bytes = unicodeStr.getBytes("utf-8");
                //convert from utf=8 to unicode
                String utf8Str = new String(bytes, "utf-8");
                String hex = utf8ToHex(bytes);
                map.put(hex, emoji);
                //System.out.println();
            } catch (UnsupportedEncodingException e) {
                e.printStackTrace();
            }
        }
    }
    private static String utf8ToHex(byte[] bytes){
        StringBuilder builder = new StringBuilder();
        int value = 0;
        for(int i=0; i<bytes.length; i++){
            value = bytes[i]&0xFF;
            builder.append(Integer.toHexString(value));
        }
        return builder.toString();
    }
}
