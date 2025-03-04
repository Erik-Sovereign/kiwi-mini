package com.kiwimini.sharedmodels.model;

import java.util.NoSuchElementException;

public class Result<T, E> {
    private final T value;
    private final E error;

    private Result(T value, E error) {
        this.value = value;
        this.error = error;
    }

    public static <T, E> Result<T, E> success(T value) {
        return new Result<>(value, null);
    }

    public static <T, E> Result<T, E> failure(E error) {
        return new Result<>(null, error);
    }

    public static <E> Result<Void, E> success() {
        return new Result<>(null, null);
    }

    public boolean isSuccess() {
        if (this.error == null)
            return true;
        else
            return false;

    }

    public boolean isFailure() {
        return !isSuccess();
    }

    public T getValue() {
        if (!isSuccess()) {
            throw new NoSuchElementException("Cannot get value from a failure result");
        }
        return value;
    }

    public E getError() {
        if (isSuccess()) {
            throw new NoSuchElementException("Cannot get error from a success result");
        }
        return error;
    }

}