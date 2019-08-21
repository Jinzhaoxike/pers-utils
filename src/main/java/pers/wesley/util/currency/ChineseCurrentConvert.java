package pers.wesley.util.currency;

/**
 * @Description :
 * @Author : jinzhaoxike91@outlook.com
 * @Create : 2019/08/16 13:50
 */
public class ChineseCurrentConvert implements CurrencyConvert {

    private static final String[] NUMBER_UPPER = {"零", "壹", "贰", "叁", "肆", "伍", "陆", "柒", "捌", "玖"};

    private static final String[] UNIT_1_UPPER = {"", "拾", "佰", "仟"};

    private static final String[] UNIT_2_UPPER = {"", "万", "亿", "万亿"};

    private static final String[] UNIT_3_UPPER = {"角", "分"};

    private static final String RMB_UNIT = "元";

    @Override
    public String convert(long money) {
        StringBuffer sb = new StringBuffer();
        String intPart = convertIntPart(getIntPart(money));
        String decimalPart = convertDecimalPart(getDecimalPart(money));
        return sb.append(intPart).append(decimalPart).toString();
    }

    /**
     * 转换整数部分
     * @param moneyIntPart
     */
    private String convertIntPart(String moneyIntPart) {
        if (Integer.valueOf(moneyIntPart).compareTo(0) == 0) {
            return "";
        }
        StringBuffer sb = new StringBuffer();
        boolean isAppendUnit = false;
        for (int i = 0; i < moneyIntPart.length(); i++) {
            char charAt = moneyIntPart.charAt(i);
            int index = Integer.parseInt(String.valueOf(charAt));
            int intPart = (moneyIntPart.length() - 1 - i) / 4;
            int mod = (moneyIntPart.length() - 1 - i) % 4;
            if (index == 0) {
                if (mod == 0 && isAppendUnit) {
                    sb.append(UNIT_2_UPPER[intPart]);
                    isAppendUnit = false;
                }
                continue;
            }
            isAppendUnit = true;
            sb.append(NUMBER_UPPER[index]);
            if (mod > 0) {
                sb.append(UNIT_1_UPPER[mod]);
            } else {
                sb.append(UNIT_2_UPPER[intPart]);
                isAppendUnit = false;
            }
        }
        return sb.append(RMB_UNIT).toString();
    }

    /**
     * 转换小数部分
     * @param moneyDecimalPart
     */
    private String convertDecimalPart(String moneyDecimalPart) {
        if (Integer.valueOf(moneyDecimalPart).compareTo(0) == 0) {
            return "整";
        }
        StringBuffer sb = new StringBuffer();
        moneyDecimalPart = String.format("%02d", Integer.valueOf(moneyDecimalPart));
        char[] chars = moneyDecimalPart.toCharArray();
        for(int i = moneyDecimalPart.length() - 1; i >= 0; i --) {
            if (chars[i] == (char) 48) {
                continue;
            }
            int l = Integer.parseInt(String.valueOf(chars[i]));
            sb.append(UNIT_3_UPPER[i]).append(NUMBER_UPPER[l]);
        }
        return sb.reverse().toString();
    }

    /**
     * 获取整数部分
     * @param money
     * @return
     */
    private String getIntPart(long money) {
        if (money >= 99) {
            return String.valueOf(money / 100);
        }
        return String.valueOf(0);
    }

    /**
     * 获取小数部分
     * @param money
     * @return
     */
    private String getDecimalPart(long money) {
        if (money < 100) {
            return String.valueOf(money);
        }
        return String.valueOf(money % 100);
    }
}
