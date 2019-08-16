package pers.wesley.util.validate;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

/**
 * @Description : 日期验证（年月日）
 * @Author : jinzhaoxike91@outlook.com
 * @Create : 2019/08/09 17:39
 */
public class DateValidate extends AbstractValidate {

    private final static String PATTERN = "yyyyMMdd";

    @Override
    protected ValidateResult validate(String fieldName, String fieldValue, String name, String validateValue) {
        ValidateResult.Builder builder = ValidateResult.newBuilder();
        try {
            LocalDate.parse(fieldValue, DateTimeFormatter.ofPattern(getValue(validateValue, PATTERN)));
            builder.setValid(true)
                    .setMessage("匹配成功");
        } catch (Exception e) {
            builder.setValid(false)
                    .setMessage(String.format("字段[%s(%s)]格式不正确，正确格式：%s，实际内容：%s", name, fieldName, getValue(validateValue, PATTERN), fieldValue));
        }
        return builder.build();
    }
}
