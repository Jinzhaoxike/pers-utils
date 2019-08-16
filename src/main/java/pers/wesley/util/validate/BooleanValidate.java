package pers.wesley.util.validate;

/**
 * @Description :
 * @Author : jinzhaoxike91@outlook.com
 * @Create : 2019/08/15 14:11
 */
public class BooleanValidate extends AbstractValidate {

    @Override
    protected ValidateResult validate(String fieldName, String fieldValue, String name, String validateValue) {

        ValidateResult.Builder builder = ValidateResult.newBuilder();

        boolean isValid = "TRUE".equals(fieldValue)
                || "true".equals(fieldValue)
                || "FALSE".equals(fieldValue)
                || "false".equals(fieldValue) ? true : false;


        return builder.setValid(isValid)
                .setMessage(isValid ? "匹配成功" : String.format("字段[%s(%s)]格式不正确", name, fieldName))
                .build();
    }
}
