package pers.wesley.util.validate;

/**
 * @Description : 最小长度验证
 * @Author : jinzhaoxike91@outlook.com
 * @Create : 2019/08/09 10:18
 */
public class MinLengthValidate extends AbstractValidate {

    @Override
    protected ValidateResult validate(String fieldName, String fieldValue, String name, String validateValue) {
        ValidateResult.Builder builder = ValidateResult.newBuilder();
        int length = getInteger(validateValue, 0);
        int valueLength = getBytesLength(fieldValue);
        boolean isMatched = length <= valueLength;
        builder.setValid(isMatched)
                .setMessage(isMatched ? "匹配成功" : String.format("字段[%s(%s)]长度不正确，最小长度：%d，实际长度：%d", name, fieldName, length, valueLength));
        return builder.build();
    }
}
