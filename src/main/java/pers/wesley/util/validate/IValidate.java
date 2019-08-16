package pers.wesley.util.validate;


/**
 * @Description : 参数验证
 * @Author : jinzhaoxike91@outlook.com
 * @Create : 2019/08/08 13:47
 */
public interface IValidate {

    /**
     * 验证参数
     * @param validateSchema
     * @return
     */
    ValidateResult validate(ValidateSchema validateSchema);

}
