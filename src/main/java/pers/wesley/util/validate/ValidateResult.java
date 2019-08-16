package pers.wesley.util.validate;

import org.apache.beam.sdk.repackaged.org.apache.commons.lang3.builder.ReflectionToStringBuilder;
import org.apache.beam.sdk.repackaged.org.apache.commons.lang3.builder.ToStringStyle;

/**
 * @Description :
 * @Author : jinzhaoxike91@outlook.com
 * @Create : 2019/08/08 13:49
 */
public class ValidateResult {

    private final boolean valid;

    private final String message;

    private ValidateResult(boolean valid, String message) {
        this.valid = valid;
        this.message = message;
    }

    public boolean isValid() {
        return valid;
    }

    public String getMessage() {
        return message;
    }

    @Override
    public String toString() {
        return ReflectionToStringBuilder.toString(this, ToStringStyle.JSON_STYLE);
    }

    public static class Builder {

        private boolean valid;

        private String message;

        public Builder setValid(boolean valid) {
            this.valid = valid;
            return this;
        }

        public Builder setMessage(String message) {
            this.message = message;
            return this;
        }

        public ValidateResult build() {
            return new ValidateResult(this.valid, this.message);
        }

    }

    public static Builder newBuilder() {
        return new Builder();
    }
}
