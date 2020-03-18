package dev.yukiho.cers.exception;

import java.util.function.Supplier;

public class BaseException extends RuntimeException implements Supplier<BaseException> {

    public BaseException(String message) {
        super(message);
    }

    @Override
    public BaseException get() {
        return this;
    }
}
