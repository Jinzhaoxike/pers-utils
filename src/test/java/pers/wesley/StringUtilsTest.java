package pers.wesley;

import org.junit.Assert;
import org.junit.Test;
import pers.wesley.util.StringUtils;

/**
 * @Description :
 * @Author : jinzhaoxike91@outlook.com
 * @Create : 2019/08/21 17:19
 */
public class StringUtilsTest {

    @Test
    public void testFirstLetterToUpperCase() {
        String word = StringUtils.firstLetterToUpperCase("Hello word");
        Assert.assertEquals("文本不一致", "Hello word", word);

        String word_2 = StringUtils.firstLetterToUpperCase("hello word");
        Assert.assertEquals("文本不一致", "Hello word", word_2);

        String word_3 = StringUtils.firstLetterToUpperCase("1hello word");
        Assert.assertEquals("文本不一致", "1hello word", word_3);
    }

    @Test
    public void testMistinessConvert() {

        String mistiness = StringUtils.mistinessConvert("375670355", 3, 3);
        Assert.assertEquals("文本不一致", "375***355", mistiness);

        String mistiness_2 = StringUtils.mistinessConvert("曾晓", 1, 0);
        Assert.assertEquals("文本不一致", "曾*", mistiness_2);

        String mistiness_3 = StringUtils.mistinessConvert("曾晓", 0, 1);
        Assert.assertEquals("文本不一致", "*晓", mistiness_3);

        String mistiness_4 = StringUtils.mistinessConvert("曾晓", 1, 1);
        Assert.assertEquals("文本不一致", "*晓", mistiness_4);
    }
}
