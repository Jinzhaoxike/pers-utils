package pers.wesley.util.validate;

/**
 * @Description : 验证类型
 * @Author : jinzhaoxike91@outlook.com
 * @Create : 2019/08/08 13:38
 */
public enum ValidateType {

    /**
     * 数字
     */
    NUMBER,
    /**
     * 手机号码
     */
    PHONE,
    /**
     * 邮件地址
     */
    EMAIL,
    /**
     * 正则
     */
    REGEX,
    /**
     * 固定长度
     */
    FIXED_LENGTH,
    /**
     * 最小长度
     */
    MIN_LENGTH,
    /**
     * 最大长度
     */
    MAX_LENGTH,
    /**
     * 日期(年月日)
     */
    DATE,
    /**
     * 时间(时分秒)
     */
    TIME,
    /**
     * 日期+时间(年月日时分秒)
     */
    DATE_TIME,
    /**
     * 前缀
     */
    PREFIX,
    /**
     * 后缀
     */
    SUFFIX,
    /**
     * 布尔类型
     */
    BOOLEAN
}
