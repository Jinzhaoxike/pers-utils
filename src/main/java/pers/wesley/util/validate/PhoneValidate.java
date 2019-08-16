package pers.wesley.util.validate;

/**
 * @Description : 手机号码格式验证
 * @Author : jinzhaoxike91@outlook.com
 * @Create : 2019/08/09 10:34
 */
public class PhoneValidate extends AbstractValidate {

    final String PATTERN = "^((10[0-9])|(11[0-9])|(12[0-9])|(13[0-9])|(14[0-9])|(15[0-9])|(16[0-9])|(17[0-9])|(18[0-9])|(19[0-9]))\\d{8}$";
    @Override
    protected ValidateResult validate(String fieldName, String fieldValue, String name, String validateValue) {
        return regexValidate(fieldName, fieldValue, name, PATTERN);
    }
}
