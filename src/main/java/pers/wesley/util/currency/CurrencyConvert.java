package pers.wesley.util.currency;

/**
 * @Description : 货币单位转换
 * @Author : jinzhaoxike91@outlook.com
 * @Create : 2019/08/16 13:46
 */
public interface CurrencyConvert {

    /**
     * 货币单位转换
     * @param money 单位分
     * @return
     */
    String convert(long money);
}
