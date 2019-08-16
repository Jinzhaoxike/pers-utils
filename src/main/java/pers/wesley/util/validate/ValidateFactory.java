package pers.wesley.util.validate;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Description :
 * @Author : jinzhaoxike91@outlook.com
 * @Create : 2019/08/09 17:50
 */
public class ValidateFactory {

    private static Map<Integer, IValidate> validates = new HashMap<>(16);

    static {
        validates.put(ValidateType.NUMBER.ordinal(), new NumberValidate());
        validates.put(ValidateType.PHONE.ordinal(), new PhoneValidate());
        validates.put(ValidateType.EMAIL.ordinal(), new EmailValidate());
        validates.put(ValidateType.REGEX.ordinal(), new RegexValidate());
        validates.put(ValidateType.FIXED_LENGTH.ordinal(), new FixedLengthValidate());
        validates.put(ValidateType.MIN_LENGTH.ordinal(), new MinLengthValidate());
        validates.put(ValidateType.MAX_LENGTH.ordinal(), new MaxLengthValidate());
        validates.put(ValidateType.DATE.ordinal(), new DateValidate());
        validates.put(ValidateType.TIME.ordinal(), new TimeValidate());
        validates.put(ValidateType.DATE_TIME.ordinal(), new DateTimeValidate());
        validates.put(ValidateType.PREFIX.ordinal(), new PrefixValidate());
        validates.put(ValidateType.SUFFIX.ordinal(), new SuffixValidate());
        validates.put(ValidateType.BOOLEAN.ordinal(), new BooleanValidate());
    }

    public static ValidateResult validate(ValidateSchema validateSchema) {

        if (null == validateSchema.getValidateType()) {
            return ValidateResult.newBuilder()
                    .setValid(false)
                    .setMessage("验证类型不能为空")
                    .build();
        }
        IValidate validate = validates.get(validateSchema.getValidateType().ordinal());
        if (null != validate) {
            return validate.validate(validateSchema);
        }
        return ValidateResult.newBuilder()
                .setValid(false)
                .setMessage(String.format("不支持的验证类型[%s]", validateSchema.getValidateType().name()))
                .build();
    }

    public static ValidateResult validate(ValidateSchema ...validateSchemas) {
        if (null == validateSchemas || validateSchemas.length == 0) {
            return ValidateResult.newBuilder()
                    .setValid(false)
                    .setMessage("validateSchemas不为空！")
                    .build();
        }
        for (int i = 0; i < validateSchemas.length; i ++) {
            ValidateResult result = validate(validateSchemas[i]);
            if (!result.isValid()) {
                return result;
            }
        }
        return ValidateResult.newBuilder()
                .setValid(true)
                .setMessage("匹配成功")
                .build();
    }

    public static ValidateResult validate(List<ValidateSchema> validateSchemas) {
        if (null == validateSchemas || validateSchemas.isEmpty()) {
            return ValidateResult.newBuilder()
                    .setValid(false)
                    .setMessage("validateSchemas不为空！")
                    .build();
        }
        return validate(validateSchemas.toArray(new ValidateSchema[validateSchemas.size()]));
    }
}
