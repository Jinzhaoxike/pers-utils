package pers.wesley.util.validate;

/**
 * @Description : 后缀验证
 * @Author : jinzhaoxike91@outlook.com
 * @Create : 2019/08/14 15:52
 */
public class SuffixValidate extends AbstractValidate {
    @Override
    protected ValidateResult validate(String fieldName, String fieldValue, String name, String validateValue) {
        ValidateResult.Builder builder = ValidateResult.newBuilder();
        boolean isValid = fieldValue.startsWith(validateValue);
        builder.setValid(isValid)
                .setMessage(isValid ? "匹配成功" : String.format("字段[%s(%s)]格式不正确，正确格式以[%s]为后缀", name, fieldName, validateValue));
        return builder.build();
    }
}
