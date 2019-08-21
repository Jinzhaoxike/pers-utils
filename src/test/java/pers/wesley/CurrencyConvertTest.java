package pers.wesley;

import org.junit.Test;
import pers.wesley.util.currency.ChineseCurrentConvert;
import pers.wesley.util.currency.CurrencyConvert;

/**
 * @Description :
 * @Author : jinzhaoxike91@outlook.com
 * @Create : 2019/08/16 15:25
 */
public class CurrencyConvertTest {

    @Test
    public void testCurrencyConvert() {
        CurrencyConvert currencyConvert = new ChineseCurrentConvert();
        String convert = currencyConvert.convert(300L);
        System.out.println(convert);
    }
}
