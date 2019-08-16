package pers.wesley.util;

import java.nio.charset.Charset;

/**
 * @Description :
 * @Author : jinzhaoxike91@outlook.com
 * @Create : 2019/07/26 16:46
 */
public class TextRead1 extends TextIO.Read {

    private Charset charset;

    private String filePath;

    private TextIO.FileType fileType;

    private String regex;

    private TextRead1(Charset charset, String filePath, String regex, TextIO.FileType fileType) {
        this.charset = charset;
        this.filePath = filePath;
        this.regex = regex;
        this.fileType = fileType;
    }

    @Override
    Charset getCharset() {
        return charset;
    }

    @Override
    String getFilePath() {
        return filePath;
    }

    @Override
    String getRegex() {
        return regex;
    }

    @Override
    TextIO.FileType getFileType() {
        return fileType;
    }

    @Override
    Builder toBuilder() {
        return new Builder(this);
    }


    static final class Builder extends TextIO.Read.Builder {

        private Charset charset;

        private String filePath;

        private TextIO.FileType fileType;

        private String regex;

        Builder() {}

        private Builder(TextIO.Read read) {
            this.charset = read.getCharset();
            this.regex = read.getRegex();
            this.fileType = read.getFileType();
            this.filePath = read.getFilePath();
        }

        @Override
        TextIO.Read.Builder setCharset(Charset charset) {
            this.charset= charset;
            return this;
        }

        @Override
        TextIO.Read.Builder setFilePath(String filePath) {
            this.filePath = filePath;
            return this;
        }

        @Override
        TextIO.Read.Builder setRegex(String regex) {
            this.regex = regex;
            return this;
        }

        @Override
        TextIO.Read.Builder setFileType(TextIO.FileType fileType) {
            this.fileType = fileType;
            return this;
        }

        @Override
        TextIO.Read build() {
            return new TextRead1(this.charset, this.filePath, this.regex, this.fileType);
        }
    }
}
