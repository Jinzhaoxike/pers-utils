package pers.wesley.util.validate;

/**
 * @Description : 邮箱地址格式验证
 * @Author : jinzhaoxike91@outlook.com
 * @Create : 2019/08/09 10:32
 */
public class EmailValidate extends AbstractValidate {

    final String PATTERN = "^([a-z0-9A-Z]+[-|\\.]?)+[a-z0-9A-Z]@([a-z0-9A-Z]+(-[a-z0-9A-Z]+)?\\.)+[a-zA-Z]{2,}$";

    @Override
    protected ValidateResult validate(String fieldName, String fieldValue, String name, String validateValue) {
        return regexValidate(fieldName, fieldValue, name, PATTERN);
    }
}
