package pers.wesley.util.file;


import java.nio.charset.Charset;

/**
 * @Description :
 * @Author : jinzhaoxike91@outlook.com
 * @Create : 2019/08/07 16:46
 */
public abstract class Read {

    /**
     * 获取文件路径
     * @return
     */
    public abstract String getPath();

    /**
     * 获取文件编码
     * @return
     */
    public abstract Charset getCharset();

    public abstract static class Builder {

        public abstract Builder setPath(String path);

        public abstract Builder setCharset(Charset charset);

        public abstract Read build();
    }
}
