package pers.wesley;

import org.junit.Test;
import pers.wesley.util.file.Read;
import pers.wesley.util.file.TextRead;
//import pers.wesley.util.TextIO;

import javax.security.auth.callback.CallbackHandler;
import java.nio.charset.Charset;
import java.util.regex.Pattern;

/**
 * @Description :
 * @Author : jinzhaoxike91@outlook.com
 * @Create : 2019/07/26 14:43
 */
public class TextIOTest {

    @Test
    public void testTextIO() {

//        for (TextIO.FileType fileType : TextIO.FileType.values()) {
//            boolean matches = fileType.matches("/Users/wesley/Documents/帝网/utp/清算分账20190726.rsp");
//            if (matches) {
//                System.out.println("type name = " + fileType.name());
//                return;
//            }
//        }

//        Charset charset = TextIO.builder()
//                .setCharset(Charset.forName("GBK"))
//                ;
//        System.out.println(charset.name());
//        TextIO.read().from("")
//                .withFileType(TextIO.FileType.RAR)
//                .withRegex("");
        Pattern EMAIL_PATTERN = Pattern.compile("^([a-zA-Z0-9_\\-\\.]+)@([a-zA-Z0-9_\\-\\.]+)\\.([a-zA-Z]{2,5})$");
    }

    public String getMessage(String name, int age) {
        return String.format("%s is %d years old.", name, age);
    }
}
