package pers.wesley.util.validate;

/**
 * @Description : 正则表达式验证
 * @Author : jinzhaoxike91@outlook.com
 * @Create : 2019/08/08 18:06
 */
public class RegexValidate extends AbstractValidate {

    @Override
    protected ValidateResult validate(String fieldName, String fieldValue, String name, String validateValue) {
        return regexValidate(fieldName, fieldValue, name, validateValue);
    }
}
