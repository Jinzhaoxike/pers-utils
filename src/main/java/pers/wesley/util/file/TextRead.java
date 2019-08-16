package pers.wesley.util.file;

import java.nio.charset.Charset;

/**
 * @Description :
 * @Author : jinzhaoxike91@outlook.com
 * @Create : 2019/08/07 16:32
 */
public class TextRead extends Read {

    private String path;

    private Charset charset;

    public String getPath() {
        return this.path;
    }

    public Charset getCharset() {
        return this.charset;
    }

    private TextRead() {}

    private TextRead(String path, Charset charset) {
        this.path = path;
        this.charset = charset;
    }

    public static class Builder extends Read.Builder {

        private String path;
        private Charset charset;

        @Override
        public Builder setPath(String path) {
            this.path = path;
            return this;
        }

        @Override
        public Builder setCharset(Charset charset) {
            this.charset = charset;
            return this;
        }

        @Override
        public Read build() {
            return new TextRead(this.path, this.charset);
        }
    }

//    public static Builder newBuilder() {
//        return new Builder();
//    }


//    public static class Builder {
//
//        private String path;
//
//        private Charset charset;
//
//        private Builder() {}
//
//        public Builder setPath(String path) {
//            this.path = path;
//            return this;
//        }
//
//        public Builder setCharset(Charset charset) {
//            this.charset = charset;
//            return this;
//        }
//
//        public TextRead build() {
//            return new TextRead(this.path, this.charset);
//        }
//    }
}
