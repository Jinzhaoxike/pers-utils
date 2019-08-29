package pers.wesley.util;

/**
 * @Description :
 * @Author : jinzhaoxike91@outlook.com
 * @Create : 2019/08/21 17:16
 */
public abstract class StringUtils {

    private static final char MISTINESS_PATTERN = '*';

    public static boolean isEmpty(String value) {
        if (null == value || value.isEmpty()) {
            return true;
        }
        return false;
    }

    /**
     * 首字母大写
     * 只有首字母是a-z的才会变转换
     * @param value
     * @return
     */
    public static String firstLetterToUpperCase(String value) {
        if (isEmpty(value)) {
            return null;
        }
        char[] chars = value.toCharArray();
        char c = chars[0];
        if ((char) 97 <= c &&  c <= (char) 122) {
            chars[0] -= 32;
            return new String(chars);
        }
        return value;
    }

    /**
     * 脱敏转换(*号代替)
     * 如果明文长度大于文本长度,则首个字符脱敏
     * @param value 明文
     * @param prefixLen 前缀明文长度
     * @param suffixLen 后缀明文长度
     * @return
     */
    public static String mistinessConvert(String value, int prefixLen, int suffixLen) {
        if (prefixLen < 0) {
            throw new RuntimeException("prefixLen不能小于零");
        }
        if (suffixLen < 0) {
            throw new RuntimeException("suffixLen不能小于零");
        }
        int minLen = prefixLen + suffixLen;
        if (isEmpty(value)) {
            return value;
        }
        final char[] valueChars = value.toCharArray();
        if (minLen >= value.length()) {
            valueChars[0] = MISTINESS_PATTERN;
            return new String(valueChars);
        }
        final char[] chars = new char[value.length() - minLen];
        final StringBuffer sb = new StringBuffer();
        for (int i = 0; i < chars.length; i ++) {
            chars[i] = MISTINESS_PATTERN;
        }
        sb.append(new String(valueChars, 0, prefixLen))
                .append(chars)
                .append(new String(valueChars, value.length() - suffixLen, suffixLen));
        return sb.toString();
    }
}
