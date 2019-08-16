package pers.wesley.util.validate;

import java.nio.charset.Charset;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @Description : 参数验证抽象处理
 * @Author : jinzhaoxike91@outlook.com
 * @Create : 2019/08/08 17:25
 */
public abstract class AbstractValidate implements IValidate {

    @Override
    public ValidateResult validate(ValidateSchema validateSchema) {
        if (validateSchema.isRequired() && isEmpty(validateSchema.getFieldValue())) {
            return ValidateResult.newBuilder()
                    .setValid(false)
                    .setMessage(String.format("字段[%s(%s)]不能为空", validateSchema.getName(), validateSchema.getFieldName()))
                    .build();
        }
        if (!validateSchema.isRequired() && isEmpty(validateSchema.getFieldValue())) {
            return ValidateResult.newBuilder()
                    .setValid(true)
                    .setMessage("匹配成功")
                    .build();
        }
        return validate(validateSchema.getFieldName(),
                validateSchema.getFieldValue(),
                validateSchema.getName(),
                validateSchema.getValidateValue());
    }

    /**
     * 验证处理
     * @param fieldName
     * @param fieldValue
     * @param name
     * @param validateValue
     * @return
     */
    protected abstract ValidateResult validate(String fieldName, String fieldValue, String name, String validateValue);

    /**
     * 正则验证
     * @param fieldName
     * @param fieldValue
     * @param name
     * @param validateValue
     * @return
     */
    protected ValidateResult regexValidate(String fieldName, String fieldValue, String name, String validateValue) {
        ValidateResult.Builder builder = ValidateResult.newBuilder();
        if (isEmpty(validateValue)) {
            builder.setValid(false)
                    .setMessage("正则表达式不为空");
            return builder.build();
        }
        Pattern regex = Pattern.compile(validateValue);
        Matcher matcher = regex.matcher(getValue(fieldValue, ""));
        boolean isMatched = matcher.matches();
        builder.setValid(isMatched)
                .setMessage(isMatched ? "匹配成功" : String.format("字段[%s(%s)]格式不正确", name, fieldName));
        return builder.build();
    }

    /**
     * 获取默认值
     * @param value
     * @param defaultValue
     * @return
     */
    protected String getValue(String value, String defaultValue) {
        if (isEmpty(value)) {
            return defaultValue;
        }
        return value;
    }

    /**
     * 获取默认值
     * @param value
     * @param defaultValue
     * @return
     */
    protected int getInteger(String value, int defaultValue) {
        if (isEmpty(value)) {
            return defaultValue;
        }
        return Integer.valueOf(value);
    }

    /**
     * 获取字符串字节长度
     * @param value
     * @return
     */
    protected int getBytesLength(String value) {
        return getBytesLength(value, null);
    }

    /**
     * 获取字符串字节长度
     * @param value
     * @param charset
     * @return
     */
    protected int getBytesLength(String value, Charset charset) {
        if (null == charset) {
            charset = Charset.defaultCharset();
        }
        return value.getBytes(charset).length;
    }

    /**
     * 判断字符串是否为空
     * @param value
     * @return
     */
    protected boolean isEmpty(String value) {
        if (null == value || value.length() == 0) {
            return true;
        }
        return false;
    }
}
