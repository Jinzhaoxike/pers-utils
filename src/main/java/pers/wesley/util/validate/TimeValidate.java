package pers.wesley.util.validate;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

/**
 * @Description : 时间验证(时分秒)
 * @Author : jinzhaoxike91@outlook.com
 * @Create : 2019/08/12 15:12
 */
public class TimeValidate extends AbstractValidate {

    private final static String PATTERN = "HHmmss";

    @Override
    protected ValidateResult validate(String fieldName, String fieldValue, String name, String validateValue) {
        ValidateResult.Builder builder = ValidateResult.newBuilder();
        try {
            LocalTime.parse(fieldValue, DateTimeFormatter.ofPattern(getValue(validateValue, PATTERN)));
            builder.setValid(true)
                    .setMessage("匹配成功");
        } catch (Exception e) {
            builder.setValid(false)
                    .setMessage(String.format("字段[%s(%s)]格式不正确，正确格式：%s，实际内容：%s", name, fieldName, getValue(validateValue, PATTERN), fieldValue));
        }
        return builder.build();
    }
}
