package pers.wesley.util.validate;

/**
 * @Description :
 * @Author : jinzhaoxike91@outlook.com
 * @Create : 2019/08/15 13:51
 */
public class ValidateUtils {

    /**
     * 验证长度范围
     * @param fileName
     * @param fileValue
     * @param name
     * @param minLength
     * @param maxLength
     * @return
     */
    public static ValidateResult isLengthRange(String fileName, String fileValue, String name, int minLength, int maxLength) {
        ValidateSchema.Builder builder = ValidateSchema
                .newBuilder()
                .setFieldName(fileName)
                .setFieldValue(fileValue)
                .setName(name)
                .setRequired(true)
                ;
        ValidateResult validateResult = ValidateFactory.validate(builder
                        .setValidateType(ValidateType.MIN_LENGTH)
                        .setValidateValue(String.valueOf(minLength))
                        .build(),
                builder.setValidateType(ValidateType.MAX_LENGTH)
                        .setValidateValue(String.valueOf(maxLength))
                        .build()
        );
        if (validateResult.isValid()) {
            return validateResult;
        }
        return ValidateResult.newBuilder()
                .setValid(false)
                .setMessage(String.format("字段[%s(%s)]长度不正确，最小长度：%d，最大长度：%d", name, fileName, minLength, maxLength))
                .build();
    }
}
