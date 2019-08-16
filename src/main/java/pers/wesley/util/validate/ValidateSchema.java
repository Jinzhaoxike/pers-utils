package pers.wesley.util.validate;

/**
 * @Description :
 * @Author : jinzhaoxike91@outlook.com
 * @Create : 2019/08/08 13:35
 */
public class ValidateSchema {

    /**
     * 属性名称
     */
    private final String fieldName;

    /**
     * 属性值
     */
    private final String fieldValue;

    /**
     * 属性描述
     */
    private final String name;

    /**
     * 验证类型
     */
    private final ValidateType validateType;

    /**
     * 是否必须
     */
    private final boolean required;

    /**
     * 验证内容
     */
    private final String validateValue;


    private ValidateSchema(String fieldName,
                           String fieldValue,
                           String name,
                           ValidateType validateType,
                           boolean required,
                           String validateValue) {
        this.fieldName = fieldName;
        this.fieldValue = fieldValue;
        this.name = name;
        this.validateType = validateType;
        this.required = required;
        this.validateValue = validateValue;

    }

    public String getFieldName() {
        return fieldName;
    }

    public String getFieldValue() {
        return fieldValue;
    }

    public String getName() {
        return name;
    }

    public ValidateType getValidateType() {
        return validateType;
    }

    public boolean isRequired() {
        return required;
    }

    public String getValidateValue() {
        return validateValue;
    }

    public static Builder newBuilder () {
        return new Builder();
    }

    public static class Builder {

        /**
         * 属性名称
         */
        private String fieldName;

        /**
         * 属性值
         */
        private String fieldValue;

        /**
         * 属性描述
         */
        private String name;

        /**
         * 验证类型
         */
        private ValidateType validateType;

        /**
         * 是否必须
         */
        private boolean required;

        /**
         * 验证内容
         */
        private String validateValue;

        public Builder setFieldName(String fieldName) {
            this.fieldName = fieldName;
            return this;
        }

        public Builder setFieldValue(String fieldValue) {
            this.fieldValue = fieldValue;
            return this;
        }

        public Builder setName(String name) {
            this.name = name;
            return this;
        }

        public Builder setValidateType(ValidateType validateType) {
            this.validateType = validateType;
            return this;
        }

        public Builder setRequired(boolean required) {
            this.required = required;
            return this;
        }

        public Builder setValidateValue(String validateValue) {
            this.validateValue = validateValue;
            return this;
        }

        public ValidateSchema build() {
            return new ValidateSchema(this.fieldName, this.fieldValue, this.name, this.validateType, this.required, this.validateValue);
        }

    }
}
