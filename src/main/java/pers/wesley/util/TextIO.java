package pers.wesley.util;

import java.nio.charset.Charset;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

/**
 * @Description :
 * @Author : jinzhaoxike91@outlook.com
 * @Create : 2019/07/26 14:16
 */
public class TextIO {

    private final static Charset DETAULT_CHARSET = Charset.forName("UTF-8");

    private TextIO() {}

    public static Read read() {
        return new TextRead1.Builder()
                .setFileType(FileType.AUTO)
                .setCharset(DETAULT_CHARSET)
                .build();
    }

    /**
     *
     */
    public abstract static class Read {

        abstract Charset getCharset();

        abstract String getFilePath();

        abstract String getRegex();

        abstract FileType getFileType();

        abstract Builder toBuilder();

        abstract static class Builder {

            abstract Builder setCharset(Charset charset);

            abstract Builder setFilePath(String filePath);

            abstract Builder setRegex(String regex);

            abstract Builder setFileType(FileType fileType);

            abstract Read build();
        }

        /**
         *
         * @param filePath
         * @return
         */
        public Read from(String filePath) {
            return toBuilder().setFilePath(filePath).build();
        }

        /**
         *
         * @param regex
         * @return
         */
        public Read withRegex(String regex) {
            return toBuilder().setRegex(regex).build();
        }

        /**
         *
         * @param fileType
         * @return
         */
        public Read withFileType(FileType fileType) {
            return toBuilder().setFileType(fileType).build();
        }

    }

    public abstract static class Write {

    }




    /**
     * 文件类型
     */
    public enum FileType {

        AUTO(""),
        RAR(".rar"),
        ZIP(".zip"),
        TXT(".txt", ".rsp")
        ;

        private List<String> suffixs;

        FileType(String... suffixs) {
            this.suffixs = Arrays.asList(suffixs);
        }

        public boolean matches(String filePath) {

            if (!Optional.ofNullable(filePath).isPresent()) {
                return false;
            }
            filePath = filePath .substring(filePath.lastIndexOf("."));
            for (String suffix : suffixs) {
                if (suffix.equalsIgnoreCase(filePath)) {
                    return true;
                }
            }
            return false;
        }
    }
}
