package pers.wesley;

import org.junit.Test;
import pers.wesley.util.validate.*;

import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.time.temporal.TemporalUnit;
import java.util.Arrays;
import java.util.Date;

/**
 * @Description :
 * @Author : jinzhaoxike91@outlook.com
 * @Create : 2019/08/08 17:19
 */
public class ValidateTest {

    @Test
    public void testValidate() {

//        ValidateSchema v = ValidateSchema.newBuilder()
//                .setFieldName("time")
//                .setFieldValue("23:59:59")
//                .setName("时间")
//                .setRequired(true)
//                .setValidateType(ValidateType.TIME)
//                .setValidateValue("HH:mm:ss")
//                .build();
//
//        ValidateSchema v2 = ValidateSchema.newBuilder()
//                .setFieldName("date")
//                .setFieldValue("20190809")
//                .setName("日期")
//                .setRequired(true)
//                .setValidateType(ValidateType.DATE)
//                .build();
//
//        ValidateSchema v3 = ValidateSchema.newBuilder()
//                .setFieldName("serviceTransId")
//                .setFieldValue("123u43u46652")
//                .setName("服务端流水号")
//                .setRequired(true)
//                .setValidateType(ValidateType.SUFFIX)
//                .setValidateValue("20190814")
//                .build();
//        ValidateResult validateResult3 = ValidateFactory.validate(Arrays.asList(v3));
//        System.out.println("result=" + validateResult3.isValid() + ", message=" + validateResult3.getMessage());
//        System.out.println(LocalDate.now().getDayOfWeek());
//        System.out.println( Duration.of(2, ChronoUnit.DAYS).toMinutes());

//        ValidateResult result = ValidateUtils.isLengthRange("serviceTransId", "201898", "服务端流水号", 5, 18);
//        System.out.println("result=" + result.isValid() + ", message=" + result.getMessage());
        ValidateResult result = ValidateFactory.validate(ValidateSchema.newBuilder()
                .setName("标识")
                .setRequired(true)
                .setFieldName("flag")
                .setFieldValue("hhh")
                .setValidateType(ValidateType.BOOLEAN)
                .build());
        System.out.println(result);
    }
}
