import com.yeah.EmojiFilter;
import com.yeah.EmojiFilterImp;
import com.yeah.GetEmojiUTF8;
import org.junit.Test;

/**
 * Created by 1111 on 2017/2/9.
 */
public class EmojiFilterTest {
    @Test
    public void testEmojiFiter(){
        //String
        GetEmojiUTF8 getEmojiUTF8 = new GetEmojiUTF8();
    }

    @Test
    public void testIsFourBytesEmoji(){
        GetEmojiUTF8 getEmojiUTF8 = new GetEmojiUTF8();
        EmojiFilter emojiFilter = new EmojiFilterImp();
        int i=0;
        for(String str : getEmojiUTF8.map.keySet()){
            System.out.println( (++i)+"  :"+emojiFilter.isFourBytesEmojiExist(str)+"  "+str );
        }
    }

    @Test
    public void testIsThreeBytesEmoji(){
        GetEmojiUTF8 getEmojiUTF8 = new GetEmojiUTF8();
        EmojiFilter emojiFilter = new EmojiFilterImp();
        int i=0;
        for(String str : getEmojiUTF8.map.keySet()){
            System.out.println( (++i)+"  :"+emojiFilter.isThreeBytesEmojiExist(str)+"   "+str);
        }
    }
}
