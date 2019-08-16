package pers.wesley.util.validate;

/**
 * @Description : 纯数字验证
 * @Author : jinzhaoxike91@outlook.com
 * @Create : 2019/08/08 16:56
 */
public class NumberValidate extends AbstractValidate {

    private final static String PATTERN = "^\\d+$";

    @Override
    protected ValidateResult validate(String fieldName, String fieldValue, String name, String validateValue) {
        return regexValidate(fieldName, fieldValue, name, PATTERN);
    }
}
